package model.pool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static ConnectionPool instance;
    private static ReentrantLock lock = new ReentrantLock();
    private final int POOL_SIZE = Integer.parseInt(ConnectionCreator.poolSize);
    private BlockingQueue<ProxyConnection> pool;

    private ConnectionPool() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pool = new ArrayBlockingQueue<>(POOL_SIZE);

            for (int i = 0; i < POOL_SIZE; i++) {

                ProxyConnection connection =
                        new ProxyConnection(ConnectionCreator.createConnection());
                pool.put(connection);
            }
        } catch (SQLException | InterruptedException exc) {
            ;
            throw new RuntimeException();
        }
    }

    private ConnectionPool(int poolSize) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            System.out.println("SQLException" + e);
        }
        try {
            pool = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                ProxyConnection connection =
                        new ProxyConnection(ConnectionCreator.createConnection());
                pool.put(connection);
            }
        } catch (SQLException | InterruptedException exc) {

            throw new RuntimeException();
        }
    }

    private ConnectionPool(String database, String user, String password, int poolSize) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {

        }
        try {

            pool = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                ProxyConnection connection =
                        new ProxyConnection(DriverManager.getConnection(database, user, password));
                pool.put(connection);
            }
        } catch (SQLException | InterruptedException exc) {

            throw new RuntimeException();
        }
    }

    public static ConnectionPool getInstance(String database, String user, String password, int poolSize) {

        lock.lock();
        try {
            if (instance == null) {
                instance = new ConnectionPool(database, user, password, poolSize);
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public static ConnectionPool getInstance(int poolSize) {
        lock.lock();
        try {
            if (instance == null) {
                instance = new ConnectionPool(poolSize);
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public static ConnectionPool getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new ConnectionPool();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public int poolSize() {
        return pool.size();
    }

    public ProxyConnection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = pool.take();
        } catch (InterruptedException exc) {

        }
        return connection;
    }

    public void releaseConnection(ProxyConnection connection) {
        try {
            pool.put(connection);
        } catch (InterruptedException exc) {
            exc.getStackTrace();
        }
    }

    public void closeConnection(ProxyConnection connection) {
        pool.offer(connection);
        try {
            connection.closeConnection();
        } catch (SQLException exc) {

        }
    }

    public void closeConnections() {
        try {
            for (Connection connection : pool) {
                ProxyConnection proxyConnection = (ProxyConnection) connection;
                proxyConnection.closeConnection();
            }
            pool = new ArrayBlockingQueue<>(POOL_SIZE);
        } catch (SQLException e) {

        }
    }
}
package model.dao.impl;

import model.dao.ProductDAO;
import model.entity.Product;
import model.entity.User;
import model.pool.ConnectionPool;
import model.pool.ProxyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements ProductDAO {
    private static final String FIND_ALL_PRODUCTS_SQL = "SELECT `id_product`,`name`,`price` FROM `product` ;";

    private static final String CREATE_PRODUCT_SQL = "INSERT INTO `product` (`name`,'price' )" +
            " VALUES (?, ?);";

    private static final String FIND_PRODUCT_BY_ID_SQL2 = "SELECT * FROM product  WHERE id_product = ? ;";

    private static final String FIND_PRODUCT_BY_ID_SQL = "SELECT `product`.`id_product`, `product`.`name`, `product`.`price WHERE `product`.`id_product` = ?;";

    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM `product` WHERE `id_product`=?";

    @Override
    public void create(Product product) {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT_SQL)) {


            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeQuery(FIND_ALL_PRODUCTS_SQL);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                products.add(createProductFromRezaltSet(resultSet));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;

    }

    @Override
    public Product findProductById(int id) {
        Product product = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_PRODUCT_BY_ID_SQL2)) {
            System.out.println("findProductById  " + id);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                product = createProductFromRezaltSet(resultSet);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    private Product createProductFromRezaltSet(ResultSet resultSet) {
        Product product = null;

        try {
            product = new Product(resultSet.getInt("id_product"), resultSet.getString("name"), resultSet.getInt("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return product;
    }

    @Override
    public void deleteProduct(int id) {
        try (ProxyConnection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE_PRODUCT_BY_ID")) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {

        }
    }
}

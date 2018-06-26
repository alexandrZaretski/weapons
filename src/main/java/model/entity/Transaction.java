package model.entity;

import java.util.Date;

public class Transaction {
    private int id_transaction;
    private int summ;
    private int id_of_product;
    private int id_of_user;
    private Date date;

    public Transaction(int summ, int id_of_product, int id_of_user, Date date) {
        this.summ = summ;
        this.id_of_product = id_of_product;
        this.id_of_user = id_of_user;
        this.date = date;
    }

    public Transaction(int id_transaction, int summ, int id_of_product, int id_of_user, Date date) {
        this.id_transaction = id_transaction;
        this.summ = summ;
        this.id_of_product = id_of_product;
        this.id_of_user = id_of_user;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tranzaction{" +
                "id_transaction=" + id_transaction +
                ", summ=" + summ +
                ", id_of_product=" + id_of_product +
                ", id_of_user=" + id_of_user +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (id_transaction != that.id_transaction) return false;
        if (summ != that.summ) return false;
        if (id_of_product != that.id_of_product) return false;
        if (id_of_user != that.id_of_user) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = id_transaction;
        result = 31 * result + summ;
        result = 31 * result + id_of_product;
        result = 31 * result + id_of_user;
        result = 31 * result + date.hashCode();
        return result;
    }

    public int getId_transaction() {
        return id_transaction;
    }

    public void setId_transaction(int id_transaction) {
        this.id_transaction = id_transaction;
    }

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public int getId_of_product() {
        return id_of_product;
    }

    public void setId_of_product(int id_of_product) {
        this.id_of_product = id_of_product;
    }

    public int getId_of_user() {
        return id_of_user;
    }

    public void setId_of_user(int id_of_user) {
        this.id_of_user = id_of_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

package model.entity;

import java.util.Date;

public class TransactionForPage {
    private int id_transaction;
    private int summ;
    private Product product;
    private User user;
    private Date date;

    public TransactionForPage(int id_transaction, int summ, Product product, User user, Date date) {
        this.id_transaction = id_transaction;
        this.summ = summ;
        this.product = product;
        this.user = user;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id_transaction=" + id_transaction +
                ", summ=" + summ +
                ", product=" + product +
                ", user=" + user +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionForPage that = (TransactionForPage) o;

        if (id_transaction != that.id_transaction) return false;
        if (summ != that.summ) return false;
        if (!product.equals(that.product)) return false;
        if (!user.equals(that.user)) return false;
        return date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = id_transaction;
        result = 31 * result + summ;
        result = 31 * result + product.hashCode();
        result = 31 * result + user.hashCode();
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

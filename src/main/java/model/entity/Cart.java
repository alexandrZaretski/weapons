package model.entity;

import java.util.Iterator;
import java.util.List;

public class Cart {
    private List<Product> list;
    private int priceSumm;

    public Cart(List<Product> list) {
        this.list = list;
        priceSumm = sum(list);
    }

    private int sum(List<Product> list) {
        int sum = 0;
        Iterator<Product> it = list.iterator();
        while (it.hasNext()) {
            sum += it.next().getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "list=" + list +
                ", priceSumm=" + priceSumm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (priceSumm != cart.priceSumm) return false;
        return list.equals(cart.list);
    }

    @Override
    public int hashCode() {
        int result = list.hashCode();
        result = 31 * result + priceSumm;
        return result;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public int getPriceSumm() {
        return priceSumm;
    }

    public void setPriceSumm(int priceSumm) {
        this.priceSumm = priceSumm;
    }
}

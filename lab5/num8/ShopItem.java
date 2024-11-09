package lab5.num8;

import java.util.Objects;

public class ShopItem {

    private final String name;
    private final double price;
    private final int quantity;

    public ShopItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ShopItem{" +
                "название='" + name + '\'' +
                ", цена=" + price +
                ", кол-во=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopItem shopItem = (ShopItem) o;
        return Double.compare(shopItem.price, price) == 0 && quantity == shopItem.quantity && Objects.equals(name, shopItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }
}

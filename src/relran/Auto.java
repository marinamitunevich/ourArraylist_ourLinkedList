package relran;

import java.util.Objects;

//TODO create comparator comparing the price
//TODO test list for sort, max ,min operations with Auto objects using comparatorByPrice
public class Auto {
    private  String make;
    private  String color;
    private  long price;

    public Auto(String make, String color, long price) {
        this.make = make;
        this.color = color;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return price == auto.price && Objects.equals(make, auto.make) && Objects.equals(color, auto.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, color, price);
    }
}

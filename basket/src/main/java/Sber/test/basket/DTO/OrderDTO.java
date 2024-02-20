package Sber.test.basket.DTO;

import Sber.test.basket.models.Order;

import java.util.Objects;

public class OrderDTO {
    private String name;

    private String price;
    public OrderDTO() {

    }

    public OrderDTO(Order order){
        this.name = order.getName();
        this.price = order.getPrice();
    }

    public  Order replace(Order order){
        order.setPrice(this.getPrice());
        order.setName(this.getName());
        return order;
    }
    public OrderDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO orderDTO)) return false;
        return Objects.equals(getName(), orderDTO.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

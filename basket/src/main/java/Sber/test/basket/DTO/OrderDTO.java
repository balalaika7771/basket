package Sber.test.basket.DTO;

import Sber.test.basket.models.Order;

import java.util.Objects;

public class OrderDTO {

    private Long id;
    private String name;

    private String price;
    public OrderDTO() {

    }

    public OrderDTO(Order order){
        this.name = order.getName();
        this.price = order.getPrice();
        this.id = order.getId();
    }

    public  Order replace(Order order){
        order.setPrice(this.getPrice());
        order.setName(this.getName());
        order.setId(this.getId());
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

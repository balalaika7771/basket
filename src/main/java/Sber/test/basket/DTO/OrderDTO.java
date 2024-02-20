package Sber.test.basket.DTO;

import Sber.test.basket.models.Order;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) для представления заказа.
 * Используется для передачи данных о заказе между контроллером и представлением.
 */
public class OrderDTO extends Throwable {

    private Long id;
    private String name;

    private String price;
    public OrderDTO() {

    }
    /**
     * Конструктор для создания DTO из сущности заказа.
     *
     * @param order сущность заказа
     */
    public OrderDTO(Order order){
        this.name = order.getName();
        this.price = order.getPrice();
        this.id = order.getId();
    }

    /**
     * Заменить данные текущего DTO на данные из другого заказа.
     *
     * @param order данные заказа для замены
     * @return текущий DTO с обновленными данными
     */
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO orderDTO)) return false;
        return Objects.equals(getName(), orderDTO.getName());
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

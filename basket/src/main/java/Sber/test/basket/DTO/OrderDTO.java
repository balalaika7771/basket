package Sber.test.basket.DTO;

import java.util.Objects;

public class OrderDTO {
    private String name;
    public OrderDTO() {

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

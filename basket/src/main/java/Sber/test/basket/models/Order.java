package Sber.test.basket.models;


import jakarta.persistence.*;
/**
 * Сущность, представляющая заказ.
 */
@Entity
@Table(name = "orders")
public class Order {

    /** Идентификатор заказа. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Имя заказа. */
    @Column(unique = true) // Это поле должно быть уникальным
    private String name;

    /** Стоимость заказа. */
    private String price;

    /**
     * Получить идентификатор заказа.
     *
     * @return идентификатор заказа
     */
    public Long getId() {
        return id;
    }

    /**
     * Установить идентификатор заказа.
     *
     * @param id идентификатор заказа
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Получить имя заказа.
     *
     * @return имя заказа
     */
    public String getName() {
        return name;
    }

    /**
     * Установить имя заказа.
     *
     * @param name имя заказа
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Получить стоимость заказа.
     *
     * @return стоимость заказа
     */
    public String getPrice() {
        return price;
    }

    /**
     * Установить стоимость заказа.
     *
     * @param price стоимость заказа
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Конструктор по умолчанию.
     */
    public Order() {
    }
}


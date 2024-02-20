package Sber.test.basket.repositories;

import Sber.test.basket.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Репозиторий для доступа к сущностям заказов в базе данных.
 * Интерфейс расширяет JpaRepository, предоставляя базовые методы для работы с данными.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

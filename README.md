[![Java CI/CD](https://github.com/balalaika7771/basket/actions/workflows/build.yml/badge.svg)](https://github.com/balalaika7771/basket/actions/workflows/build.yml)

# Пример CRUD приложения на Java с использованием Spring Boot

Привет! Это простое CRUD (Create, Read, Update, Delete) веб-приложение, написанное на Java с использованием Spring Boot. Приложение позволяет управлять заказами: создавать, просматривать, обновлять и удалять заказы.

## Требования

Для запуска приложения вам понадобится следующее:

- Java Development Kit (JDK) версии 8 или выше
- Apache Maven для сборки проекта

## Запуск приложения

1. Клонируйте репозиторий на ваш компьютер:

```
git clone https://github.com/balalaika7771/basket.git
```

2. Перейдите в директорию проекта:

```
cd basket
```

3. Соберите проект с помощью Maven:

```
mvn clean package
```

4. Запустите приложение:

```
java -jar target/basket.jar
```

После этого приложение будет доступно по адресу [http://localhost:8080](http://localhost:8080).

## Использование

После запуска приложения вы сможете:

- Просматривать список всех заказов.
- Добавлять новые заказы.
- Редактировать существующие заказы.
- Удалять заказы.

## Технологии

Это приложение написано на Java с использованием следующих технологий:

- Spring Boot
- Spring MVC
- Spring Data JPA
- Thymeleaf
- H2 Database (для хранения данных во время работы)
- log4j (для логирования)
- maven javadoc

## Вклад

Если вы хотите внести свой вклад в это приложение, пожалуйста, отправьте pull request. Мы приветствуем любые улучшения и исправления ошибок!

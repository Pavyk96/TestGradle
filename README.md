# Spring Boot Test Project

## Автор  Мезев Даниил Олегович  
---
## Преподаватель: Никита Иванов  
---

## О `@SpringBootApplication`
Аннотация `@SpringBootApplication` включает в себя:  
- `@SpringBootConfiguration` – помечает класс как конфигурационный.
 Говорит Spring, что этот класс — конфигурационный.
Аналогична @Configuration.
- `@EnableAutoConfiguration` – включает автоматическую настройку Spring Boot. Автоматически настраивает Spring Boot, чтобы он сам добавил нужные бины.
Например, если в classpath есть Spring Web, он поднимет встроенный сервер.
- `@ComponentScan` – сканирует компоненты в текущем пакете и подпакетах. Сканирует текущий пакет и его подпакеты на наличие компонентов (@Component, @Service, @Repository, @Controller и т. д.).
Это позволяет автоматически регистрировать бины в контексте.

### Параметры:
- `exclude` – исключает автонастройки, например, DataSourceAutoConfiguration.

- `excludeName` – указывает имена классов конфигурации, которые нужно исключить.

- `proxyBeanMethods` – управляет проксированием бинов в контексте Spring.

- `scanBasePackages` – указывает, какие пакеты сканировать.

- `scanBasePackageClasses` – указывает классы, принадлежащие нужному пакету.

- `nameGenerator` – задает стратегию именования компонентов в контексте Spring.

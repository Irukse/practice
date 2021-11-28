CREATE TABLE IF NOT EXISTS Dictionary (
   id        BIGINT        NOT NULL PRIMARY KEY AUTO_INCREMENT,
   name      VARCHAR(10)   NOT NULL COMMENT 'Тип документа',
   code      VARCHAR(2)    NOT NULL COMMENT 'Код документа',
   version   INTEGER       NOT NULL COMMENT 'Служебное поле Hibernate'
);


CREATE TABLE IF NOT EXISTS Country (
    id        INTEGER       NOT NULL PRIMARY KEY AUTO_INCREMENT ,
    name      VARCHAR(25)   NOT NULL COMMENT 'Название страны',
    code      VARCHAR(3)   NOT NULL COMMENT 'Код страны',
    version   INTEGER       NOT NULL COMMENT 'Служебное поле Hibernate'
);




CREATE TABLE IF NOT EXISTS Organization (
    id          BIGINT        NOT NULL PRIMARY KEY AUTO_INCREMENT ,
    name        VARCHAR(50)            NOT NULL COMMENT 'Имя организации',
    full_name   VARCHAR(50)     NOT NULL  COMMENT 'Полное имя организации' ,
    inn         VARCHAR(10)                                NOT NULL   ,
    kpp         VARCHAR(9)                               NOT NULL   ,
    address     VARCHAR(50)          NOT NULL COMMENT 'Адрес организации',
    phone       VARCHAR(11)       COMMENT 'Телефон организации' ,
    is_active   BOOLEAN     ,
    version   INTEGER       NOT NULL COMMENT 'Служебное поле Hibernate'

);


CREATE TABLE IF NOT EXISTS Office (
    id        BIGINT       NOT NULL       PRIMARY KEY AUTO_INCREMENT ,
    org_id    BIGINT        COMMENT 'Идентификатор связанный с идентификатором (id) в таблице организаций',
    name      VARCHAR(50)                  NOT NULL   COMMENT 'Название офиса' ,
    address   VARCHAR(50)                      NOT NULL COMMENT 'Адрес офиса',
    phone     VARCHAR(11)         COMMENT 'Телефонный номер офиса',
    FOREIGN KEY (org_id) REFERENCES Organization (id),
    is_active BOOLEAN     ,
    version   INTEGER       NOT NULL COMMENT 'Служебное поле Hibernate'
);


CREATE TABLE IF NOT EXISTS Employee (
    id              BIGINT                           NOT NULL       PRIMARY KEY AUTO_INCREMENT ,
    first_name      VARCHAR(50)                                     NOT NULL COMMENT 'Имя пользователя',
    second_name     VARCHAR(50) COMMENT 'Фамилия пользователя',
    last_name       VARCHAR(50) COMMENT 'Второе имя/Отчество пользователя',
    position        VARCHAR(50)                               NOT NULL COMMENT 'Должность пользователя',
    phone           VARCHAR(11)                                 COMMENT 'Телефон пользователя',
    citizenship_id  BIGINT         COMMENT 'Идентификатор, связывающий работника с его страной',
    FOREIGN KEY (citizenship_id) REFERENCES Country(id),
    is_identified   BOOLEAN      COMMENT '',
    version   INTEGER       NOT NULL COMMENT 'Служебное поле Hibernate'
);


CREATE TABLE IF NOT EXISTS Office_Employee (
    office_id       BIGINT    COMMENT 'Уникальный идентификатор офиса',
    employee_id     BIGINT    COMMENT 'Уникальный идентификатор работника',

    PRIMARY KEY (office_id, employee_id),

    FOREIGN KEY (office_id) REFERENCES Office(id),
    FOREIGN KEY (employee_id) REFERENCES Employee(id)

);


CREATE TABLE IF NOT EXISTS Doc_employee (
    id          BIGINT                         NOT NULL         PRIMARY KEY AUTO_INCREMENT ,
    emp_id     BIGINT                               COMMENT 'Связь документа с работником',
    FOREIGN KEY (emp_id)   REFERENCES Employee(id),
    doc_number  BIGINT                                   COMMENT 'Номер документа работника',
    doc_date    VARCHAR(50)                              COMMENT 'Дата выдачи документа работника',
    type_id     BIGINT      COMMENT 'Идентификатор, связывающий документ с типом документа',
    FOREIGN KEY (type_id) REFERENCES Dictionary(id),
    version     INTEGER    NOT NULL COMMENT 'Служебное поле Hibernate'
);


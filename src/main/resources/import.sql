-- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
-- IN THIS FILE WE CAN WRITE AN SQL SCRIPT CONTAINING:
-- SCHEMA, TABLE AND DATA MANIPULATION QUERIES
-- TO BE EXECUTED AUTOMATICALLY DURING THE INITIALIZATION OF THE APPLICATION
-- AND AFTER THE CREATION OF SCHEMA AND TABLES BY Hibernate
-- IF spring.jpa.hibernate.ddl-auto IS SET TO create OR create-drop
-- IT IS A Hibernate feature (nothing to do with Spring)

-- INSERT INTO USER (id, firstname, lastname, email, username, password, role) VALUES ('123', 'John', 'Doe', 'john@mail.com', 'johnD', 'pass1234', 'ROLE_USER');
-- INSERT INTO USER (id, firstname, lastname, email, username, password, role) VALUES ('124', 'Jane', 'Doe', 'jane@mail.com', 'janeD', 'pass1234', 'ROLE_ADMIN');

INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type) VALUES ('1234567891', 'Tolstoy@mail.com');
INSERT INTO OWNER (owner_AFM, owner_email) VALUES ('1234567892', 'Steinbeck@mail.com');
INSERT INTO OWNER (owner_AFM, owner_email) VALUES ('1234567893', 'Papadiamantis@mail.com');
INSERT INTO OWNER (owner_AFM, owner_email) VALUES ('1234567894', 'Kazantzakis@mail.com');
INSERT INTO OWNER (owner_AFM, owner_email) VALUES ('12345678915', 'Terzakis@mail.com');

INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567891', 'fname', 'lname', 'address', 'phone', '@mail.com', 'password', 'type', 'role');



-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('fbe25e54-645f-4ede-829b-d28f3a29b2dc','War and Peace','1867','1','LITERARY_REALISM');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('a6fe1574-04de-44d6-ae2c-9f43fc2f42f1','The Grapes of Wrath','1939','2','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('2cfc4209-c32e-4a76-8b38-36b8ce5b3ef5','The Murderess','1903','3','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('534d9f04-1c29-4b68-91a1-902b75c982b4','Captain Michalis','1950','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('d7e7b6ed-fdae-424e-abc5-1718d82b64b8','Report to Greco','1965','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('23b20325-fc09-43c0-b69b-64c47f73988d','The Last Temptation','1960','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('6d002b7e-f985-477b-8320-b71ad7d7713a','Christ Recrucified','1954','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('ba1ba1f3-bbdc-46a5-b279-3a013a4f5ec7','Princess Isambo','1945','5','DRAMA');
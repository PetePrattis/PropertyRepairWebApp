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

-- INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type) VALUES ('1234567891', 'Tolstoy@mail.com');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567891', 'fname1', 'lname1', 'address1', '6955555555', 'user1@mail.com', '$2a$10$5PK0V1TJeR3OKxbEcE7deuSaBz74YjcY/l9sgi4YyrVY8mhjMTyHq', 'MAISONETTE', 'ADMIN');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567892', 'fname2', 'lname2', 'address2', '6955555555', 'user2@mail.com', 'password2', 'MAISONETTE', 'OWNER');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567893', 'fname3', 'lname3', 'address3', '6955555555', 'user3@mail.com', 'password3', 'APARTMENT', 'OWNER');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567894', 'fname4', 'lname4', 'address4', '6955555555', 'user4@mail.com', 'password4', 'APARTMENT', 'OWNER');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567895', 'fname5', 'lname5', 'address5', '6955555555', 'user5@mail.com', 'password5', 'HOUSE', 'OWNER');
-- INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567891', 'fname', 'lname', 'address', 'phone', '@mail.com', 'password', 'type', 'role');
-- INSERT INTO REPAIR (repair_cost, owner_id) VALUES ('100', '1');
-- INSERT INTO REPAIR (repair_cost, owner_id) VALUES ('123', '2');
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address 1',2000.14,'2021-01-11','Extra info 1','INPROGRESS','INSULATION',1)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address 2',200021.14,'2021-02-11','Extra info 2','INPROGRESS','PAINTING',2)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address 3',20100.14,'2021-01-11','Extra info 3','INPROGRESS','PLUMBING',3)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address 4',20300.14,'2021-01-11','Extra info 4','INPROGRESS','PLUMBING',1)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address 5',21300.14,'2021-11-11','Extra info 5','PENDING','PLUMBING',1)

INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('PROPERTY1','Address 1', 2021,'HOUSE',1)

-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('fbe25e54-645f-4ede-829b-d28f3a29b2dc','War and Peace','1867','1','LITERARY_REALISM');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('a6fe1574-04de-44d6-ae2c-9f43fc2f42f1','The Grapes of Wrath','1939','2','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('2cfc4209-c32e-4a76-8b38-36b8ce5b3ef5','The Murderess','1903','3','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('534d9f04-1c29-4b68-91a1-902b75c982b4','Captain Michalis','1950','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('d7e7b6ed-fdae-424e-abc5-1718d82b64b8','Report to Greco','1965','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('23b20325-fc09-43c0-b69b-64c47f73988d','The Last Temptation','1960','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('6d002b7e-f985-477b-8320-b71ad7d7713a','Christ Recrucified','1954','4','DRAMA');
-- insert into BOOK(book_id, book_title,publication_year,author_id,book_category) values ('ba1ba1f3-bbdc-46a5-b279-3a013a4f5ec7','Princess Isambo','1945','5','DRAMA');
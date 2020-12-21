-- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
-- IN THIS FILE WE CAN WRITE AN SQL SCRIPT CONTAINING:
-- SCHEMA, TABLE AND DATA MANIPULATION QUERIES
-- TO BE EXECUTED AUTOMATICALLY DURING THE INITIALIZATION OF THE APPLICATION
-- AND AFTER THE CREATION OF SCHEMA AND TABLES BY Hibernate
-- IF spring.jpa.hibernate.ddl-auto IS SET TO create OR create-drop
-- IT IS A Hibernate feature (nothing to do with Spring)

INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('123456789', 'fname1', 'lname1', 'address1', '6955555555', 'user1@mail.com', '$2a$10$N51rsKkgg6s6lyyKVPB06eTUvO9ai/gH5ePlfxrCBZCY/D94xeIWO', 'MAISONETTE', 'ADMIN');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567892', 'fname2', 'lname2', 'address2', '6955555555', 'user2@mail.com', '$2a$10$ZzFSkHwHv5F0ZSrSKYS27uW0UkteLLZbfirlVVwrn/Nayka6H05eS', 'MAISONETTE', 'OWNER');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567893', 'fname3', 'lname3', 'address3', '6955555555', 'user3@mail.com', '$2a$10$7nnF2Xif4E0VYUZcOnr56.sPjKFgdUnqLT9Cu3Gf5yhpCFLQmnkle', 'APARTMENT', 'OWNER');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567894', 'fname4', 'lname4', 'address4', '6955555555', 'user4@mail.com', '$2a$10$yKOD4XAn/nMmZUpMtX/WFeTAy4Eo61qjMxH6H0YHsgGKbsgzo9aO2', 'APARTMENT', 'OWNER');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, property_type, user_role) VALUES ('1234567895', 'fname5', 'lname5', 'address5', '6955555555', 'user5@mail.com', '$2a$10$pWhq35HYCshVF9gzT0AnEuZ.lVqZLrUV7q4QdJPW22TyEZi8XNMhW', 'HOUSE', 'OWNER');

INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('PROPERTY1','Address 1', 2021,'HOUSE',1)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('PROPERTY2','Address 2', 2021,'HOUSE',1)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('PROPERTY3','Address 3', 2021,'HOUSE',2)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('PROPERTY4','Address 4', 2021,'MAISONETTE',2)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('PROPERTY5','Address 5', 2021,'MAISONETTE',3)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('PROPERTY6','Address 6', 2021,'APARTMENT',2)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('PROPERTY7','Address 7', 2021,'HOUSE',4)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('PROPERTY8','Address 8', 2021,'HOUSE',5)

INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address 1',2000.14,'2021-01-11','Extra info 1','INPROGRESS','INSULATION',1)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address 2',200021.14,'2021-02-11','Extra info 2','INPROGRESS','PAINTING',2)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address 3',20100.14,'2021-01-11','Extra info 3','INPROGRESS','PLUMBING',3)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address 4',20300.14,'2021-01-11','Extra info 4','INPROGRESS','PLUMBING',1)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address 5',21300.14,'2021-11-11','Extra info 5','PENDING','PLUMBING',1)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Address test',200,'2021-11-10','Extra info test','PENDING','PLUMBING',2)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,owner_id) VALUES ('Add  ress test1',2130,'2021-11-12','Extra info test1','INPROGRESS','PLUMBING',2)
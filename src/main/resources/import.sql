-- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-sql.html
-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
-- IN THIS FILE WE CAN WRITE AN SQL SCRIPT CONTAINING:
-- SCHEMA, TABLE AND DATA MANIPULATION QUERIES
-- TO BE EXECUTED AUTOMATICALLY DURING THE INITIALIZATION OF THE APPLICATION
-- AND AFTER THE CREATION OF SCHEMA AND TABLES BY Hibernate
-- IF spring.jpa.hibernate.ddl-auto IS SET TO create OR create-drop
-- IT IS A Hibernate feature (nothing to do with Spring)

INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, user_role) VALUES ('123456789', 'Admin', 'Admin', 'Admin Address', '6955555555', 'admin@mail.com', '$2a$10$N51rsKkgg6s6lyyKVPB06eTUvO9ai/gH5ePlfxrCBZCY/D94xeIWO', 'ADMIN');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, user_role) VALUES ('123456780', 'Christos', 'Petridis', 'Code Hub 1', '6954545454', 'petridis@mail.com', '$2a$10$ZzFSkHwHv5F0ZSrSKYS27uW0UkteLLZbfirlVVwrn/Nayka6H05eS', 'OWNER');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, user_role) VALUES ('123456781', 'Christos', 'Panos', 'Regeneration 2', '6978022548', 'panos@mail.com', '$2a$10$7nnF2Xif4E0VYUZcOnr56.sPjKFgdUnqLT9Cu3Gf5yhpCFLQmnkle', 'OWNER');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, user_role) VALUES ('123456782', 'Panagiotis', 'Prattis', 'Project Future 1', '6958881742', 'prattis@mail.com', '$2a$10$yKOD4XAn/nMmZUpMtX/WFeTAy4Eo61qjMxH6H0YHsgGKbsgzo9aO2', 'OWNER');
INSERT INTO OWNER (owner_AFM, firstname, lastname, owner_address, owner_telephone, owner_email, owner_password, user_role) VALUES ('123456783', 'Michael', 'Panagiotou', 'Project Future 2', '6942334158', 'panagiotou@mail.com', '$2a$10$pWhq35HYCshVF9gzT0AnEuZ.lVqZLrUV7q4QdJPW22TyEZi8XNMhW', 'OWNER');

INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('122321','EOK 2', 2010,'HOUSE',1)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('Ab213d','Peiraiws 23', 1991,'HOUSE',1)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('Prop.21','Venizelou 12', 2020,'APARTMENT',2)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('123312','Panepistimiou 11', 2000,'MAISONETTE',2)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('223312341','Dimokratias 5', 1999,'MAISONETTE',3)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('744110288','Palama 112a', 1998,'APARTMENT',2)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('asc478dsa','Agias Paraskevis 29', 2020,'HOUSE',4)
INSERT INTO PROPERTY (property_code,property_address,property_constructionYear,property_type,owner_id) VALUES ('ldsaikdw8','Salaminas 19', 2014,'HOUSE',5)

INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,property_id) VALUES ('EOK 2',20000,'2021-01-11','Extra info 1','INPROGRESS','INSULATION',1)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,property_id) VALUES ('Peiraiws 23',2001.14,'2021-02-11','Extra info 2','INPROGRESS','PAINTING',1)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,property_id) VALUES ('Venizelou 12',40100.14,'2021-01-11','Extra info 3','COMPLETED','PLUMBING',1)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,property_id) VALUES ('Panepistimiou 11',300.14,'2021-01-11','Extra info 4','INPROGRESS','FRAMES',3)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,property_id) VALUES ('Dimokratias 5',9900.14,'2021-11-11','Extra info 5','PENDING','ELECTRICAL',4)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,property_id) VALUES ('Palama 112a',4230,'2021-11-10','Extra info test 6','INPROGRESS','PLUMBING',5)
INSERT INTO REPAIR (repair_address,repair_cost,repair_date,extra_info,repair_status,repair_type,property_id) VALUES ('Salaminas 19',7888,'2021-11-12','Extra info 7','INPROGRESS','FRAMES',2)
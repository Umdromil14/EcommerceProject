set @@global.time_zone = '+00:00';
set @@session.time_zone = '+00:00';
set @schema = 'siteecommerce';

DROP TABLE IF EXISTS `transaction_detail`;
DROP TABLE IF EXISTS `translation`;
DROP TABLE IF EXISTS `reduction`;
DROP TABLE IF EXISTS `product`;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `language`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `voucher`;
DROP TABLE IF EXISTS `category`;

CREATE TABLE `USER` (
    Username VARCHAR(50) NOT NULL,
    Lastname VARCHAR(50),
    Firstname VARCHAR(50),
    IsEmployee boolean NOT NULL default false,
    RegistrationDate date NOT NULL default (current_date),
    Password varchar(60) NOT NULL,
    Address varchar(255) NOT NULL,
    Email varchar(255) NOT NULL,
    PhoneNumber varchar(20) NOT NULL,
    Authorities varchar(255) NOT NULL DEFAULT 'ROLE_USER',
    NonExpired bit NOT NULL default true,
    NonLocked bit NOT NULL default true,
    CredentialsNonExpired bit NOT NULL default true,
    IsEnabled bit NOT NULL default true,
    primary key (Username)
) charset = UTF8MB4, engine = InnoDB;

CREATE TABLE `ORDER` (
    ID INT NOT NULL auto_increment,
    Username VARCHAR(255) NOT NULL,
    `Date` DATE NOT NULL default (current_date),
    isPayed BOOLEAN NOT NULL default false,
    primary key (ID),
    foreign key (Username) references USER(Username)
) charset = UTF8MB4, engine = InnoDB;

CREATE TABLE `LANGUAGE` (
    LanguageCode VARCHAR(255) NOT NULL,
    primary key (LanguageCode)
) charset = UTF8MB4, engine = InnoDB;

CREATE TABLE CATEGORY (
    Code VARCHAR (255) NOT NULL,
    primary key (Code)
) charset = UTF8MB4, engine = InnoDB;

CREATE TABLE TRANSLATION(
    ID INT NOT NULL auto_increment,
    Label VARCHAR(255) NOT NULL,
    Language VARCHAR(255) NOT NULL,
    Category VARCHAR (255) NOT NULL,
    primary key (ID),
    foreign key (Language) references `LANGUAGE` (LanguageCode),
    foreign key (Category) references CATEGORY (Code)
) charset = UTF8MB4, engine = InnoDB;

CREATE TABLE PRODUCT (
    ID INT NOT NULL auto_increment,
    ActualUnitPrice decimal(6, 2) NOT NULL check(actualUnitPrice > 0.0),
    Description VARCHAR(255) NOT NULL,
    CodeCategory VARCHAR(255) NOT NULL,
    Name varchar(255) NOT NULL,
    primary key (id),
    foreign key (CodeCategory) references CATEGORY (Code)
) charset = UTF8MB4, engine = InnoDB;

CREATE TABLE VOUCHER (
    Code VARCHAR(255) NOT NULL,
    Reason VARCHAR(255),
    Percentage decimal(2, 2) NOT NULL check(Percentage > 0.0),
    StartDate DATE ,
    EndDate DATE ,
    CodeCategory VARCHAR (255),
    primary key (Code),
    foreign key (CodeCategory) references CATEGORY (Code)
) charset = UTF8MB4, engine = InnoDB;

CREATE TABLE TRANSACTION_DETAIL (
    ID INT NOT NULL auto_increment,
    Quantity INT NOT NULL check (quantity > 0),
    TransactionPrice decimal(10, 2) NOT NULL check (TransactionPrice > 0.0),
    ProductId INT NOT NULL,
    OrderId INT NOT NULL,
    primary key (ID),
    foreign key (ProductId) references PRODUCT (ID),
    foreign key (OrderId) references `ORDER`(ID)
) charset = UTF8MB4, engine = InnoDB;

CREATE TABLE REDUCTION(
    OrderId INT NOT NULL,
    VoucherCode VARCHAR(255) NOT NULL,
    primary key(OrderId, VoucherCode),
    foreign key (OrderId) references `ORDER`(ID),
    foreign key (VoucherCode) references VOUCHER(code)
) charset = UTF8MB4, engine = InnoDB;

INSERT INTO `USER` (Username,Lastname, Firstname, IsEmployee, RegistrationDate, Password, Address, Email,PhoneNumber, Authorities, NonExpired, NonLocked, CredentialsNonExpired,IsEnabled)
VALUES 
('Umdromil','Baras', 'Cyril', true, DEFAULT, '$2a$10$P8mjs2.O4m5b4Kag3RrJreaFc0TLqw9PSKR07v6/ofdwyYvZ5gnaq', 'Rue de la motte 35, 1390 Grez-Doiceau', 'satisfactory.not@finished.be' ,'0485410020','ROLE_ADMIN', true, true, true,true), -- Password
('SkyVeo','Therasse', 'Nathan', true, DEFAULT, '$2a$10$4qrKEXYdN3f1isst80Rwhea5iRv2py.zZ3wS2Ck0elkmIpM/Qpq1m', 'Rue d''Elden Ring, 150 Tarnished', 'malenia.ez@norage.com','0470065616','ROLE_ADMIN', true, true, true,true), -- Bidondon
('CptnRam','Marton', 'Cédric', true, DEFAULT, '$2a$10$ZLXHXmROfgAFUvYINHPTKuL88pXgxL5M8NR3SOVyh07A8tQ6S2TkS', 'Rue The Finals, 5020 Champion', 'the.finals.are.back.baby@finals.steam','0470365845','ROLE_ADMIN', true, true, true,true),-- GrosBidou
('Mov','Maque', 'Margaux', false, DEFAULT,'$2a$10$VvevVCBdx8Eq5BOTgajAtuFNs5r1qMbOSuHw1tqyORxDeb8vZOSpa', 'Rue de la médecine, 1140 Evere', 'je.disseque@cadavre.be','0468306958','ROLE_USER', true, true, true,true), -- cadavre ou Cadavre
('Garou','Glesner', 'Marguerite',false,DEFAULT,'$2a$10$W3jo5moTQgHJ36ufJsg32uZxAi5JTfBZiQRIoa9usKIzAvU1jsoo.','Rue de la copine à Cédric, 5020 Champion', 'a.test.fortnite@pas.ouf','0465359858','ROLE_USER', true, true, true,true), -- LoveCat
('Anywhere','Still', 'Searching', true, DEFAULT,'$2a$10$QKW7Tzr/eEufubQlZekgRu0TjYDsMDF7YeoW5w5hdayBdbGx3z9HO','Rue de l''hésisation, 404 Unknown', 'find.soon@please.be','0000000000','ROLE_USER', true, true, true,true); -- Where

INSERT INTO `Order` (Username, `Date`, isPayed) 
VALUES 
('Umdromil', DEFAULT, true),
('SkyVeo', DEFAULT, true),
('CptnRam', DEFAULT, true);

INSERT INTO `LANGUAGE` (LanguageCode) VALUES ('EN'), ('NL'), ('DE');

INSERT INTO CATEGORY (Code) 
VALUES 
('Beverages'),
('Office automation'), 
('Snacks'), 
('Construction'), 
('Furniture');

INSERT INTO `TRANSLATION` (Label, Language, Category) VALUES
('Beverages', 'EN', 'Beverages'),
('Dranken', 'NL', 'Beverages'),
('Getränke', 'DE', 'Beverages'),
('Office automation', 'EN', 'Office automation'),
('Kantoorautomatisering', 'NL', 'Office automation'),
('Büroautomation', 'DE', 'Office automation'),
('Snacks', 'EN', 'Snacks'),
('Snacks', 'NL', 'Snacks'),
('Snacks', 'DE', 'Snacks'),
('Construction', 'EN', 'Construction'),
('Constructie', 'NL', 'Construction'),
('Bau', 'DE', 'Construction'),
('Furniture', 'EN', 'Furniture'),
('Meubilair', 'NL', 'Furniture'),
('Möbel', 'DE', 'Furniture');

INSERT INTO PRODUCT (ActualUnitPrice, Name, CodeCategory, Description) 
VALUES 
(1.5, 'Spa reine', 'Beverages', 'Still water, 1L'),
(1, 'Normal Coca Cola', 'Beverages', 'Coca Cola, 33cl'),
(1, 'Coca Cola Zero', 'Beverages', 'Coca Cola Zero, 33cl'),
(1, 'Fanta', 'Beverages', 'Fanta, 33cl'),
(1, 'Sprite', 'Beverages', 'Sprite, 33cl'),
(2, 'Minute Maid Orange', 'Beverages', 'Minute Maid, 33 cl'),
(2, 'Nalu drink', 'Beverages', 'Energetic Nalu drink, 33cl'),
(3, 'Chocolate waffle', 'Snacks', 'Chocolate waffle'),
(4.99, 'Madeleine', 'Snacks', 'chocolate filled madeleine'),
(4.99, 'M&Ms', 'Snacks','M&Ms'),
(14.99, 'School chair', 'Furniture','School chair for students'),
(19.99, 'School table', 'Furniture','School table for students'),
(3000, 'Distributor', 'Furniture','Distributor for the school'),
(499.99, 'Dashboard', 'Furniture','Dashboard for the school'),
(299.99, 'Dashboard projector', 'Furniture','Dashboard projector for the school'),
(0.79, 'Brick', 'Construction', 'Brick for the school to finish these walls, 1m²'),
(8359.99, 'Scaffolding', 'Construction','Scaffolding for the school to finish these walls, 30m'),
(129.99, 'Ladder', 'Construction', 'Ladder for the school to finish these walls, 3m'),
(299.99, 'Henallux logo', 'Construction', 'Henallux logo'),
(41.69, 'Roof tile', 'Construction', 'Roof tile for the school to finish these roofs, 1m²'),
(13.69, 'Alimentation Cable', 'Office automation', 'Alimentation cable for the school PC, 2m'),
(34.99, 'PC screen', 'Office automation', 'PC screen for the school, 24"'),
(299.99, 'PC', 'Office automation', 'PC for the school, 8GB RAM, 500GB HDD, i5'),
(4.99, 'Black HDMI cable', 'Office automation', 'Black HDMI PC, 2m'),
(999.99, 'Projector', 'Office automation', 'Projector, 1080p, 4K, 3D, 5000 lumens'),
(8.99, 'Black RJ45', 'Office automation', 'Black RJ45 cable PC, 2m'),
(8.99, 'White RJ45', 'Office automation', 'White RJ45 cable, 2m'),
(8.99, 'Blue RJ45', 'Office automation', 'Blue RJ45 cable, 2m'),
(8.99, 'Green RJ45', 'Office automation', 'Green RJ45 cable PC, 2m'),
(8.99, 'Yellow RJ45', 'Office automation', 'Yellow RJ45 cable PC, 2m'),
(4800.99, 'Switch 48P', 'Office automation', 'Switch, 48 ports, 10Gbps'),
(750.99, 'Switch 24P', 'Office automation', 'Switch, 24 ports, 10Gbps'),
(49.99,'Power strip tower', 'Office automation', 'Power strip tower, 8 plugs');


INSERT INTO VOUCHER (Code, Reason, Percentage, StartDate, EndDate, CodeCategory) 
VALUES 
('Toothless', 'Dragon dance successfull', 0.25, '2019-01-30', DEFAULT, 'Beverages'),
('Renovation', 'Need to help the school to finish those repair', 0.75, '2022-01-01', '2030-01-01', 'Construction'),
('Cedric Lunch', 'Snack time', 0.10, '2022-01-01', '2024-02-01', 'Snacks');

INSERT INTO TRANSACTION_DETAIL (Quantity, TransactionPrice, ProductId, OrderId)
VALUES
(10, 8, 2, 1),
(5, 59.96, 11, 1),
(4, 4559.85, 19, 2),
(4, 26751.97, 17, 2),
(3, 39.92, 10, 3),
(1, 2.4, 8, 3);

INSERT INTO REDUCTION (OrderId, VoucherCode)
VALUES
(1, 'Toothless'),
(2, 'Renovation'),
(3, 'Cedric Lunch');

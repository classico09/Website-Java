DROP DATABASE IF EXISTS YouthDataHibernate;
CREATE DATABASE YouthDataHibernate;
USE YouthDataHibernate;


DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email					VARCHAR(100) NOT NULL UNIQUE KEY,
    FullName				VARCHAR(100) NOT NULL,
    `Password`				VARCHAR(100)
);

DROP TABLE IF EXISTS Product;
CREATE TABLE Product(
	ProductID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`					VARCHAR(100) NOT NULL UNIQUE KEY,
 	Price					DOUBLE,
	Image					VARCHAR(500),
	Detail					VARCHAR(500)
);


DROP TABLE IF EXISTS Cart;
CREATE TABLE Cart(
	CartID					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`					VARCHAR(100) NOT NULL UNIQUE KEY,
 	Price					DOUBLE,
	Image					VARCHAR(500),
	Detail					VARCHAR(500),
    AccountID				INT UNSIGNED,
    ProductID				INT UNSIGNED,
	FOREIGN KEY (AccountID) REFERENCES `Account` (AccountID)
	);


INSERT INTO `Account` (`AccountID`, `Email`, `FullName`, `Password`) 
VALUES ('1', 'Account1@gmail.com', 'Account1', 'A123458'),
		('2', 'Account2@gmail.com', 'Account2', 'A123459');
        
        
INSERT INTO `Product` (`ProductID`, `Name`, `Price`, `Image`, `Detail`) 
VALUES ('1', 'sp1', '50000', 'image1', 'detal1'),
		('2', 'sp2', '60000', 'image2', 'detal2');
        
        
INSERT INTO `Cart` (`CartID`, `Name`, `Price`, `Image`, `Detail`, `AccountID`, `ProductID`)
VALUES ('1', 'sp1', '50000', 'image1', 'detail1', 1, 2),
		('2', 'sp2', '60000', 'image2', 'detail', 2, 1);


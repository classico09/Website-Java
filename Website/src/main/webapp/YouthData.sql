DROP DATABASE IF EXISTS YouthData;
CREATE DATABASE YouthData;
USE YouthData;


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
	FOREIGN KEY (AccountID) REFERENCES `Account` (AccountID),
	FOREIGN KEY (ProductID) REFERENCES Product (ProductID)
);

INSERT INTO `YouthData`.`Account` (`AccountID`, `Email`, `FullName`, `Password`) 
VALUES ('1', 'linh1@gmail.com', 'linh1', 'A123456'),
		('2', 'linh2@gmail.com', 'linh2', 'B123456');



        
        
INSERT INTO `YouthData`.`Product` (`ProductID`, `Name`, `Price`, `Image`, `Detail`) 
VALUES ('1', 'sp1', '50.000', 'image1', 'detal1'),
		('2', 'sp2', '80.000', 'image2', 'detal2'),
        ('3', 'sp3', '70.000', 'image3', 'detal3'),
        ('4', 'sp4', '60.000', 'image4', 'detal4'),
        ('5', 'sp5', '100.000', 'image5', 'detal5');
        
        
INSERT INTO `YouthData`.`Cart` (`CartID`, `Name`, `Price`, `Image`, `Detail`, `AccountID`, `ProductID`)
VALUES ('1', 'sp1', '50000', 'image1', 'detail1', 1, 2),
		('2', 'sp2', '60000', 'image2', 'detail', 2, 1);


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


DROP TABLE IF EXISTS Card;
CREATE TABLE Card(
	CardID					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Name`					VARCHAR(100) NOT NULL UNIQUE KEY,
 	Price					DOUBLE,
	Image					VARCHAR(500),
	Detail					VARCHAR(500)
);


INSERT INTO `youthdata`.`account` (`AccountID`, `Email`, `FullName`, `Password`) 
VALUES ('1', 'selenalinh@gmail.com', 'selenalinh', 'A123458'),
		('2', 'selenalinh2@gmail.com', 'selenalinh2', 'A123459');
        
        
INSERT INTO `youthdata`.`product` (`ProductID`, `Name`, `Price`, `Image`, `Detail`) 
VALUES ('1', 'sp1', '50000', 'image1', 'detal1'),
		('2', 'sp2', '60000', 'image2', 'detal2');
        
        
INSERT INTO `youthdata`.`card` (`CardID`, `Name`, `Price`, `Image`, `Detail`)
VALUES ('1', 'sp1', '50000', 'image1', 'detail1'),
		('2', 'sp2', '60000', 'image2', 'detail');


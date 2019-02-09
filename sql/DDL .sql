CREATE DATABASE IF NOT EXISTS `humanoo_test`;

USE `humanoo_test`;

CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `product` (`id`, `name`, `type`) VALUES
	(1, 'Emad', 'Toka'),
	(2, 'Mayert, Maggio and Altenwerth', 'Voluptas veritatis sequi ab dolore temporibus. Lib'),
	(3, 'Weimann, Ortiz and Bernhard', 'Commodi tenetur doloremque voluptatem sint consequ'),
	(4, 'Sauer Inc', 'Voluptas possimus tempora quia et assumenda. Volup'),
	(5, 'Zemlak, Hettinger and Goldner', 'Reiciendis voluptatem quos voluptatem dolores amet'),
	(6, 'Ryan-Dare', 'Voluptatem ipsa quia rerum voluptas. Voluptatem nu'),
	(7, 'Daniel Inc', 'Est aspernatur est molestiae sit provident. Esse f'),
	(8, 'Terry, Weber and Emard', 'Qui nobis molestiae quia quo qui eveniet excepturi'),
	(9, 'Daugherty, Quigley and Koepp', 'Omnis quam accusantium fuga sit illo. Voluptatem o'),
	(10, 'Kreiger Group', 'Voluptatem est autem iusto vel et officiis iusto p'),
	(11, 'Treutel-Hudson', 'Dolores possimus aut molestias. Vero impedit ducim'),
	(12, 'Bashirian, Schneider and Wisoky', 'Ut optio saepe incidunt quibusdam. Magnam similiqu'),
	(13, 'Grant, Adams and Homenick', 'Accusamus magnam ut delectus. Tempore iste enim an'),
	(14, 'Mayert-Bashirian', 'Maxime et ut similique nam. Doloremque ut nisi et '),
	(15, 'Strosin-Walter', 'Veniam architecto nam sit aliquam eos omnis volupt'),
	(16, 'Schoen-Paucek', 'A asperiores eveniet nesciunt explicabo laboriosam');


CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `age` tinyint(4) NOT NULL,
  `blocked` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `user` (`id`, `name`, `firstName`, `age`, `blocked`) VALUES
	(1, 'Robel', 'Bobby', 7, b'1'),
	(2, 'Reinger', 'Kaylah', 16, b'1'),
	(3, 'Dooley', 'Lonzo', 20, b'1');


CREATE TABLE IF NOT EXISTS `user_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `USER_FK` (`userId`),
  KEY `PRODUCT_FK` (`productId`),
  CONSTRAINT `PRODUCT_FK` FOREIGN KEY (`productId`) REFERENCES `product` (`id`),
  CONSTRAINT `USER_FK` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
);



INSERT INTO `user_product` (`id`, `userId`, `productId`) VALUES
	(1, 1, 2),
	(2, 1, 3),
	(3, 1, 4),
	(4, 1, 5),
	(5, 1, 6),
	(6, 1, 7),
	(7, 1, 8),
	(8, 2, 9),
	(9, 2, 10),
	(10, 2, 11),
	(11, 2, 12),
	(12, 3, 13),
	(13, 3, 14),
	(14, 3, 15),
	(15, 3, 16),
	(16, 1, 2),
	(17, 1, 3),
	(18, 1, 4),
	(20, 1, 9),
	(21, 1, 13);

##########################################################################################

#Creating Views to be used in the queries 
CREATE OR REPLACE VIEW CustomersCount AS
SELECT COUNT(*) userProductsCount, u.id AS userID, u.firstName, u.NAME, u.age
				FROM user_product AS pu
				JOIN product AS p ON p.id = pu.productId
				JOIN user AS u ON u.id = pu.userId
				GROUP BY pu.userId
				ORDER BY userProductsCount DESC;
				
				
#############################################################################################

#how many product is used by each user
SELECT u.id userId, u.firstName , u.NAME lastName, COUNT(*) AS procutsByUsercCount
FROM user_product AS pu
JOIN user AS u ON u.id = pu.userId
JOIN product AS p ON p.id = pu.productId
GROUP BY pu.userId;


#Which user to which product is related
SELECT  u.id UserID, u.firstName , u.NAME UserLastName, p.id AS productId, p.NAME ProductName, p.`type` ProductType
FROM user_product AS pu
JOIN user AS u ON u.id = pu.userId
JOIN product AS p ON p.id = pu.productId;

SELECT * FROM CustomersCount as cc WHERE cc.userProductsCount = (SELECT max(userProductsCount) FROM CustomersCount);
SELECT * FROM CustomersCount as cc WHERE cc.userProductsCount = (SELECT min(userProductsCount) FROM CustomersCount);
				
				
				
	

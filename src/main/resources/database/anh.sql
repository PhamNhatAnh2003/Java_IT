CREATE TABLE `bill` (
   `bid` varchar(10) NOT NULL,
   `sid` varchar(10) DEFAULT NULL,
   `statsys_configus` varchar(50) DEFAULT NULL,
   `creating_date` date DEFAULT NULL,
   `product_quantity` int DEFAULT NULL,
   PRIMARY KEY (`bid`)
 )
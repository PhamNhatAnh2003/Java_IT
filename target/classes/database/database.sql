-- bill table
drop table if exists bill;

CREATE TABLE `bill` (
   `bid` varchar(10) NOT NULL,
   `sid` varchar(10) DEFAULT NULL,
   `status` varchar(50) DEFAULT NULL,
   `creating_date` date DEFAULT NULL,
   `product_quantity` int DEFAULT NULL,
   PRIMARY KEY (`bid`)
 );

 INSERT INTO bill (bid, sid, status, creating_date, product_quantity) VALUES
 ('b01', 's01', 'pending', '2024-05-15', 3),
 ('b02', 's02', 'approved', '2024-05-14', 2),
 ('b03', 's01', 'rejected', '2024-05-13', 1),
 ('b04', 's04', 'pending', '2024-05-12', 4),
 ('b05', 's05', 'approved', '2024-05-11', 2),
 ('b06', 's01', 'pending', '2024-05-10', 3),
 ('b07', 's07', 'rejected', '2024-05-09', 1),
 ('b08', 's01', 'approved', '2024-05-08', 4),
 ('b09', 's01', 'pending', '2024-05-07', 2),
 ('b10', 's10', 'rejected', '2024-05-06', 3);


-- site table
drop table if exists site;

CREATE TABLE `site` (
   `sid` varchar(10) NOT NULL,
   `sname` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`sid`)
 );

 INSERT INTO site (sid, sname) VALUES
 ('s01', 'Site 01'),
 ('s02', 'Site 02'),
 ('s03', 'Site 03'),
 ('s04', 'Site 04');


 -- merchandise table
 drop table if exists merchandise;

 CREATE TABLE `merchandise` (
    `mid` varchar(10) NOT NULL,
    `mname` varchar(50) DEFAULT NULL,
    `unit` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`mid`)
  );

  INSERT INTO merchandise (mid, mname, unit) VALUES
  ('m01', 'Product A', 'Piece'),
  ('m02', 'Product B', 'Kilogram'),
  ('m03', 'Product C', 'Box'),
  ('m04', 'Product D', 'Liter'),
  ('m05', 'Product E', 'Ton');


  -- site_product (products that are being sold & their instock quantity in each site)
  drop table if exists site_product;

  CREATE TABLE `site_product` (
     `sid` varchar(10) DEFAULT NULL,
     `mid` varchar(10) DEFAULT NULL,
     `instock_quantity` int DEFAULT NULL,
     `unit` varchar(20) DEFAULT NULL,
     KEY `sid` (`sid`),
     KEY `mid` (`mid`),
     CONSTRAINT `site_product_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `site` (`sid`),
     CONSTRAINT `site_product_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `merchandise` (`mid`)
   );

   INSERT INTO site_product (sid, mid, instock_quantity, unit) VALUES
   ('s01', 'm01', 50, 'Piece'),
   ('s01', 'm02', 100, 'Kilogram'),
   ('s01', 'm03', 30, 'Box'),
   ('s02', 'm01', 70, 'Piece'),
   ('s02', 'm04', 20, 'Liter'),
   ('s03', 'm02', 80, 'Kilogram'),
   ('s03', 'm03', 40, 'Box'),
   ('s03', 'm05', 60, 'Ton');


-- bill_detail table
drop table if exists bill_detail;

CREATE TABLE `bill_detail` (
   `bid` varchar(10) DEFAULT NULL,
   `mid` varchar(10) DEFAULT NULL,
   `quantity` int DEFAULT NULL,
   `unit` varchar(20) DEFAULT NULL,
   `delivery` varchar(50) DEFAULT NULL,
   KEY `bid` (`bid`),
   KEY `mid` (`mid`),
   CONSTRAINT `bill_detail_ibfk_1` FOREIGN KEY (`bid`) REFERENCES `bill` (`bid`),
   CONSTRAINT `bill_detail_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `merchandise` (`mid`)
 );

 INSERT INTO bill_detail (bid, mid, quantity, unit, delivery) VALUES
 ('b01', 'm01', 25, 'Piece', 'air delivery'),
 ('b01', 'm02', 30, 'Kilogram', 'ship delivery'),
 ('b02', 'm03', 20, 'Box', 'air delivery'),
 ('b02', 'm04', 15, 'Liter', 'ship delivery'),
 ('b03', 'm05', 10, 'Ton', 'ship delivery'),
 ('b04', 'm01', 40, 'Piece', 'air delivery'),
 ('b04', 'm02', 50, 'Kilogram', 'ship delivery'),
 ('b05', 'm03', 25, 'Box', 'air delivery'),
 ('b05', 'm04', 18, 'Liter', 'ship delivery'),
 ('b06', 'm05', 35, 'Ton', 'air delivery'),
 ('b07', 'm01', 22, 'Piece', 'ship delivery'),
 ('b08', 'm02', 28, 'Kilogram', 'ship delivery'),
 ('b09', 'm03', 33, 'Box', 'air delivery'),
 ('b10', 'm04', 15, 'Liter', 'ship delivery');






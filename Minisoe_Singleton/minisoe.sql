-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2022 at 09:59 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `minisoe`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` char(5) NOT NULL,
  `CustomerName` varchar(255) NOT NULL,
  `CustomerGender` varchar(255) NOT NULL,
  `CustomerAddress` varchar(255) NOT NULL,
  `CustomerEmail` varchar(255) NOT NULL,
  `CustomerAge` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `CustomerName`, `CustomerGender`, `CustomerAddress`, `CustomerEmail`, `CustomerAge`) VALUES
('CU001', 'Dirk Titterell', 'Male', '74 Melvin Point', 'dtitterell0@yellowpages.com', 21),
('CU002', 'Dukey Diano', 'Male', '92 Sugar Alley', 'ddiano1@state.com', 39),
('CU003', 'Alex Meekins', 'Male', '577 Dovetail Park', 'ameekins2@blogs.com', 15),
('CU004', 'Cherice Jermey', 'Female', '811 Debs Street', 'cjermey3@guardian.com', 17),
('CU005', 'Ingamar Carlin', 'Male', '389 Surrey Pass', 'icarlin4@shareasale.com', 17),
('CU006', 'Pooh McCutcheon', 'Male', '7 Melby Trail', 'pmccutcheon5@salon.com', 14),
('CU007', 'Silvain Jozsa', 'Female', '19269 Maryland Hill', 'sjozsa6@omniture.com', 24),
('CU008', 'Javier Drewson', 'Female', '8 Moulton Point', 'jdrewson7@home.com', 20),
('CU009', 'Wilbur Francino', 'Female', '21840 Golden Leaf Avenue', 'wfrancino8@wunderground.com', 16),
('CU010', 'Sadie Snow', 'Female', '70 Eagle Crest Hill', 'ssnow9@github.com', 25),
('CU011', 'Sofie Carmen', 'Female', '20196 Springview Plaza', 'scarmena@gov.com', 20),
('CU012', 'Amy Grenkov', 'Male', '2263 Weeping Birch Center', 'agrenkovb@aol.com', 22),
('CU013', 'Gabriela Scarf', 'Female', '920 Bobwhite Trail', 'gscarfc@skype.com', 23),
('CU014', 'Westley Boram', 'Female', '47 Darwin Terrace', 'wboramd@sun.com', 29),
('CU015', 'Hadleigh Playfoot', 'Female', '49 6th Junction', 'hplayfoote@msu.com', 24);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductID` char(5) NOT NULL,
  `ProductTypeID` char(5) NOT NULL,
  `ProductName` varchar(255) NOT NULL,
  `Price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductID`, `ProductTypeID`, `ProductName`, `Price`) VALUES
('PR001', 'PT003', 'Reeboq Shoes', 449000),
('PR002', 'PT003', 'Adides Shoes', 599000),
('PR003', 'PT003', 'Nike Shoes', 789000),
('PR004', 'PT001', 'Poloe T-Shirts', 369000),
('PR005', 'PT001', 'Giordano Shirts', 289000),
('PR006', 'PT001', 'Hush Kitten Shirts', 229000),
('PR007', 'PT002', 'Police Demim Pants', 199600),
('PR008', 'PT002', 'Carvill Pants', 157000),
('PR009', 'PT002', 'Bathing Ape Pants', 229000),
('PR010', 'PT004', 'Adides Webbing Waist Bag', 430000),
('PR011', 'PT004', 'Ward Cross Body Bag', 206000),
('PR012', 'PT005', 'Tommy Hilfiger Watches ', 2559000),
('PR013', 'PT006', 'Norf Gun Fortniti Edition ', 350000);

-- --------------------------------------------------------

--
-- Table structure for table `producttype`
--

CREATE TABLE `producttype` (
  `ProductTypeID` char(5) NOT NULL,
  `ProductTypeName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `producttype`
--

INSERT INTO `producttype` (`ProductTypeID`, `ProductTypeName`) VALUES
('PT001', 'Shirt'),
('PT002', 'Pant'),
('PT003', 'Shoe'),
('PT004', 'Bag'),
('PT005', 'Luxury'),
('PT006', 'Toy');

-- --------------------------------------------------------

--
-- Table structure for table `shipping`
--

CREATE TABLE `shipping` (
  `ShippingID` char(5) NOT NULL,
  `ShippingName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shipping`
--

INSERT INTO `shipping` (`ShippingID`, `ShippingName`) VALUES
('SH001', 'Minisoe_Express'),
('SH002', 'JNE'),
('SH003', 'JNT'),
('SH004', 'TIKI');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `TransactionID` char(5) NOT NULL,
  `CustomerID` char(5) NOT NULL,
  `ProductID` char(5) NOT NULL,
  `ShippingID` char(5) NOT NULL,
  `Quantity` int(4) NOT NULL,
  `TransactionDate` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`TransactionID`, `CustomerID`, `ProductID`, `ShippingID`, `Quantity`, `TransactionDate`) VALUES
('TR001', 'CU003', 'PR008', 'SH001', 3, '2022-06-06'),
('TR003', 'cu001', 'PR002', 'SH002', 1, '2022-06-19'),
('TR004', 'CU009', 'PR005', 'SH002', 2, '2022-06-19');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`),
  ADD KEY `ProductTypeID` (`ProductTypeID`);

--
-- Indexes for table `producttype`
--
ALTER TABLE `producttype`
  ADD PRIMARY KEY (`ProductTypeID`);

--
-- Indexes for table `shipping`
--
ALTER TABLE `shipping`
  ADD PRIMARY KEY (`ShippingID`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`TransactionID`),
  ADD KEY `CustomerID` (`CustomerID`),
  ADD KEY `ShippingID` (`ShippingID`),
  ADD KEY `ProductID` (`ProductID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`ProductTypeID`) REFERENCES `producttype` (`ProductTypeID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaction_ibfk_3` FOREIGN KEY (`ShippingID`) REFERENCES `shipping` (`ShippingID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaction_ibfk_4` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ProductID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

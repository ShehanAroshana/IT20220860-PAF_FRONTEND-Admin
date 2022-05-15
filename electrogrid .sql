-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220423.6d54ac471a
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 07:56 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `notices`
--

CREATE TABLE `notices` (
  `nid` int(4) NOT NULL,
  `ncontent` varchar(300) NOT NULL,
  `issuedate` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notices`
--

INSERT INTO `notices` (`nid`, `ncontent`, `issuedate`) VALUES
(6, 'Be informed about the progress and activities of the Ceylon Electricity Board in the journey of enriching the lives of Sri Lankans with power while illuminating the motherland.', '2022-04-23 19:32:47'),
(9, 'Power will be down for all the zones from 8 a.m. to 1.00 p.m. on 29/04', '2022-04-25 00:03:36'),
(10, 'Power will be down for all the zones from 8 a.m. to 5.00 p.m. for Technical Repairs on 01/05', '2022-04-25 16:05:12'),
(11, 'There will be no power cuts during Vesak Day', '2022-04-26 01:45:50'),
(12, 'Solar Panel promoting program will be held in Viharamahadevi Park on 12th May from 8.00 am onwards ', '2022-04-26 01:49:00'),
(13, 'Consumers using less than 90 units will have discounts for the next month starting from next month(May)', '2022-04-26 01:51:49');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notices`
--
ALTER TABLE `notices`
  ADD PRIMARY KEY (`nid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notices`
--
ALTER TABLE `notices`
  MODIFY `nid` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;




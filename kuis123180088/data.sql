-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2020 at 12:32 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data`
--

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE `anggota` (
  `NIM` varchar(9) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `TTL` date NOT NULL,
  `jeniskel` varchar(30) NOT NULL,
  `agama` varchar(30) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `tanggal` date NOT NULL,
  `berlaku` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`NIM`, `nama`, `TTL`, `jeniskel`, `agama`, `kelas`, `tanggal`, `berlaku`) VALUES
('123180088', 'isnaniar', '2011-09-00', 'Perempaun', 'Islam', 'B', '2011-01-19', '2011-01-20'),
('123180011', 'samuel', '2014-09-00', 'Laki-laki', 'Kristen', 'C', '2013-08-13', '2014-08-14'),
('123180123', 'sunny', '2003-03-01', 'Perempaun', 'Hindu', 'A', '2004-05-13', '2004-05-16');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `kode` varchar(9) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `pengarang` varchar(100) NOT NULL,
  `penerbit` varchar(100) NOT NULL,
  `tahun` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`kode`, `judul`, `pengarang`, `penerbit`, `tahun`) VALUES
('1222', 'you got it', 'daniel', 'konnect', '2011'),
('1234', 'like always', 'sunny', 'gramedia', '2020');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `NIK` varchar(9) NOT NULL,
  `namakar` varchar(100) NOT NULL,
  `jeniskelamin` varchar(50) NOT NULL,
  `golongan` varchar(5) NOT NULL,
  `jabatan` varchar(30) NOT NULL,
  `tunjangan` int(20) NOT NULL,
  `gaji` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`NIK`, `namakar`, `jeniskelamin`, `golongan`, `jabatan`, `tunjangan`, `gaji`) VALUES
('123110011', 'susan', 'Perempaun', 'staff', '1', 4000000, 10000000);

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `nomor` varchar(9) NOT NULL,
  `NIM` varchar(9) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `kelas` varchar(5) NOT NULL,
  `kode` varchar(5) NOT NULL,
  `judul` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_kembali` date NOT NULL,
  `lama_pinjam` int(10) NOT NULL,
  `denda` int(20) NOT NULL,
  `NIK` varchar(9) NOT NULL,
  `namakar` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`nomor`, `NIM`, `nama`, `kelas`, `kode`, `judul`, `penerbit`, `tgl_pinjam`, `tgl_kembali`, `lama_pinjam`, `denda`, `NIK`, `namakar`) VALUES
('12', '123180011', 'daniel', 'A', '1212', 'like always', 'konnect', '2001-01-19', '2001-01-20', 365, 365000, '123110011', 'susan');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

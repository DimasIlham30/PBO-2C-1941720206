-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 25 Des 2020 pada 07.00
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.4.10

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbrentalmobil`
--
CREATE DATABASE IF NOT EXISTS `dbrentalmobil` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dbrentalmobil`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `jenismobil`
--
-- Pembuatan: 12 Des 2020 pada 13.35
-- Pembaruan terakhir: 24 Des 2020 pada 04.42
--

DROP TABLE IF EXISTS `jenismobil`;
CREATE TABLE `jenismobil` (
  `idjenis` int(11) NOT NULL,
  `jenis` varchar(255) NOT NULL,
  `hargaSewa` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `jenismobil`:
--

--
-- Potong tabel sebelum dimasukkan `jenismobil`
--

TRUNCATE TABLE `jenismobil`;
--
-- Dumping data untuk tabel `jenismobil`
--

INSERT INTO `jenismobil` (`idjenis`, `jenis`, `hargaSewa`) VALUES
(11, 'Mobil Keluarga', 1500000),
(12, 'Mobil PickUp', 1200000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobilkeluarga`
--
-- Pembuatan: 12 Des 2020 pada 13.43
-- Pembaruan terakhir: 24 Des 2020 pada 04.43
--

DROP TABLE IF EXISTS `mobilkeluarga`;
CREATE TABLE `mobilkeluarga` (
  `idmobil` int(11) NOT NULL,
  `idjenis` int(11) NOT NULL,
  `nopolisimobil` varchar(25) NOT NULL,
  `merkmobil` varchar(25) NOT NULL,
  `warnamobil` varchar(25) NOT NULL,
  `namamobil` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `mobilkeluarga`:
--   `idjenis`
--       `jenismobil` -> `idjenis`
--

--
-- Potong tabel sebelum dimasukkan `mobilkeluarga`
--

TRUNCATE TABLE `mobilkeluarga`;
--
-- Dumping data untuk tabel `mobilkeluarga`
--

INSERT INTO `mobilkeluarga` (`idmobil`, `idjenis`, `nopolisimobil`, `merkmobil`, `warnamobil`, `namamobil`) VALUES
(28, 11, 'S 1954 D', 'Honda', 'Merah', 'Jazz');

-- --------------------------------------------------------

--
-- Struktur dari tabel `mobilpickup`
--
-- Pembuatan: 12 Des 2020 pada 13.43
-- Pembaruan terakhir: 24 Des 2020 pada 05.09
--

DROP TABLE IF EXISTS `mobilpickup`;
CREATE TABLE `mobilpickup` (
  `idpickup` int(11) NOT NULL,
  `idjenis` int(11) NOT NULL,
  `nopolisipickup` varchar(25) NOT NULL,
  `merkpickup` varchar(25) NOT NULL,
  `warnapickup` varchar(25) NOT NULL,
  `namapickup` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `mobilpickup`:
--   `idjenis`
--       `jenismobil` -> `idjenis`
--

--
-- Potong tabel sebelum dimasukkan `mobilpickup`
--

TRUNCATE TABLE `mobilpickup`;
--
-- Dumping data untuk tabel `mobilpickup`
--

INSERT INTO `mobilpickup` (`idpickup`, `idjenis`, `nopolisipickup`, `merkpickup`, `warnapickup`, `namapickup`) VALUES
(11, 12, 'S 6741 AA', 'Daihatsu', 'Hitam', 'Grandmax');

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--
-- Pembuatan: 20 Des 2020 pada 06.57
--

DROP TABLE IF EXISTS `peminjaman`;
CREATE TABLE `peminjaman` (
  `idpeminjaman` int(11) NOT NULL,
  `idpenyewa` int(11) NOT NULL,
  `idjenis` int(11) NOT NULL,
  `idmobil` int(11) NOT NULL,
  `tanggalpinjam` datetime NOT NULL,
  `tanggalkembali` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `peminjaman`:
--   `idpenyewa`
--       `penyewa` -> `idpenyewa`
--   `idjenis`
--       `jenismobil` -> `idjenis`
--   `idmobil`
--       `mobilkeluarga` -> `idmobil`
--   `idmobil`
--       `mobilpickup` -> `idpickup`
--

--
-- Potong tabel sebelum dimasukkan `peminjaman`
--

TRUNCATE TABLE `peminjaman`;
-- --------------------------------------------------------

--
-- Struktur dari tabel `penyewa`
--
-- Pembuatan: 20 Des 2020 pada 06.20
-- Pembaruan terakhir: 24 Des 2020 pada 19.34
--

DROP TABLE IF EXISTS `penyewa`;
CREATE TABLE `penyewa` (
  `idpenyewa` int(11) NOT NULL,
  `noktp` int(20) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `notelp` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELATIONSHIPS FOR TABLE `penyewa`:
--

--
-- Potong tabel sebelum dimasukkan `penyewa`
--

TRUNCATE TABLE `penyewa`;
--
-- Dumping data untuk tabel `penyewa`
--

INSERT INTO `penyewa` (`idpenyewa`, `noktp`, `nama`, `alamat`, `notelp`) VALUES
(1, 4646, 'Yack', 'Mojokerto', '082334');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `jenismobil`
--
ALTER TABLE `jenismobil`
  ADD PRIMARY KEY (`idjenis`);

--
-- Indeks untuk tabel `mobilkeluarga`
--
ALTER TABLE `mobilkeluarga`
  ADD PRIMARY KEY (`idmobil`),
  ADD KEY `idjenis` (`idjenis`);

--
-- Indeks untuk tabel `mobilpickup`
--
ALTER TABLE `mobilpickup`
  ADD PRIMARY KEY (`idpickup`),
  ADD KEY `idjenis` (`idjenis`);

--
-- Indeks untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`idpeminjaman`),
  ADD KEY `idpenyewa` (`idpenyewa`),
  ADD KEY `idjenis` (`idjenis`),
  ADD KEY `idmobil` (`idmobil`);

--
-- Indeks untuk tabel `penyewa`
--
ALTER TABLE `penyewa`
  ADD PRIMARY KEY (`idpenyewa`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `jenismobil`
--
ALTER TABLE `jenismobil`
  MODIFY `idjenis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT untuk tabel `mobilkeluarga`
--
ALTER TABLE `mobilkeluarga`
  MODIFY `idmobil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT untuk tabel `mobilpickup`
--
ALTER TABLE `mobilpickup`
  MODIFY `idpickup` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `idpeminjaman` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `penyewa`
--
ALTER TABLE `penyewa`
  MODIFY `idpenyewa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `mobilkeluarga`
--
ALTER TABLE `mobilkeluarga`
  ADD CONSTRAINT `mobilkeluarga_ibfk_1` FOREIGN KEY (`idjenis`) REFERENCES `jenismobil` (`idjenis`);

--
-- Ketidakleluasaan untuk tabel `mobilpickup`
--
ALTER TABLE `mobilpickup`
  ADD CONSTRAINT `mobilpickup_ibfk_1` FOREIGN KEY (`idjenis`) REFERENCES `jenismobil` (`idjenis`);

--
-- Ketidakleluasaan untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`idpenyewa`) REFERENCES `penyewa` (`idpenyewa`),
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`idjenis`) REFERENCES `jenismobil` (`idjenis`),
  ADD CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`idmobil`) REFERENCES `mobilkeluarga` (`idmobil`),
  ADD CONSTRAINT `peminjaman_ibfk_4` FOREIGN KEY (`idmobil`) REFERENCES `mobilpickup` (`idpickup`);


--
-- Metadata
--
USE `phpmyadmin`;

--
-- Metadata untuk tabel jenismobil
--

--
-- Potong tabel sebelum dimasukkan `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Potong tabel sebelum dimasukkan `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Potong tabel sebelum dimasukkan `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata untuk tabel mobilkeluarga
--

--
-- Potong tabel sebelum dimasukkan `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Potong tabel sebelum dimasukkan `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Potong tabel sebelum dimasukkan `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata untuk tabel mobilpickup
--

--
-- Potong tabel sebelum dimasukkan `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Potong tabel sebelum dimasukkan `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Potong tabel sebelum dimasukkan `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata untuk tabel peminjaman
--

--
-- Potong tabel sebelum dimasukkan `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Potong tabel sebelum dimasukkan `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Potong tabel sebelum dimasukkan `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata untuk tabel penyewa
--

--
-- Potong tabel sebelum dimasukkan `pma__column_info`
--

TRUNCATE TABLE `pma__column_info`;
--
-- Potong tabel sebelum dimasukkan `pma__table_uiprefs`
--

TRUNCATE TABLE `pma__table_uiprefs`;
--
-- Potong tabel sebelum dimasukkan `pma__tracking`
--

TRUNCATE TABLE `pma__tracking`;
--
-- Metadata untuk database dbrentalmobil
--

--
-- Potong tabel sebelum dimasukkan `pma__bookmark`
--

TRUNCATE TABLE `pma__bookmark`;
--
-- Potong tabel sebelum dimasukkan `pma__relation`
--

TRUNCATE TABLE `pma__relation`;
--
-- Potong tabel sebelum dimasukkan `pma__savedsearches`
--

TRUNCATE TABLE `pma__savedsearches`;
--
-- Potong tabel sebelum dimasukkan `pma__central_columns`
--

TRUNCATE TABLE `pma__central_columns`;SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

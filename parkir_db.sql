-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Bulan Mei 2024 pada 16.16
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parkir_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `parkir`
--

CREATE TABLE `parkir` (
  `id_parkir` int(11) NOT NULL,
  `no_plat` varchar(255) NOT NULL,
  `merk_kendaraan` varchar(255) NOT NULL,
  `jenis_kendaraan` varchar(255) NOT NULL,
  `jam_masuk` datetime NOT NULL DEFAULT current_timestamp(),
  `lama_parkir` int(11) DEFAULT NULL,
  `biaya_parkir` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `parkir`
--

INSERT INTO `parkir` (`id_parkir`, `no_plat`, `merk_kendaraan`, `jenis_kendaraan`, `jam_masuk`, `lama_parkir`, `biaya_parkir`) VALUES
(1, 'p', 'p', 'p', '2024-05-28 20:31:33', 3, 6000),
(4, '1', '1', 'motor', '2024-05-28 20:31:11', 4, 8000),
(5, 'av', 'ab', 'mobil', '2024-05-28 20:31:36', 4, 20000),
(6, '1', '1', 'motor', '2024-05-28 21:15:25', NULL, NULL),
(7, '3', 'Yamaha', 'mobil', '2024-05-28 21:15:34', 5, 25000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES
(1, '123220079', '123220079', 'admin'),
(2, '123220089', '123220089', 'petugas'),
(3, 'tes', 'tes', 'petugas');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `parkir`
--
ALTER TABLE `parkir`
  ADD PRIMARY KEY (`id_parkir`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `parkir`
--
ALTER TABLE `parkir`
  MODIFY `id_parkir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 05 Bulan Mei 2018 pada 16.16
-- Versi server: 10.1.30-MariaDB
-- Versi PHP: 5.6.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `siperpus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `literatur`
--

CREATE TABLE `literatur` (
  `id` int(11) NOT NULL,
  `judul` varchar(25) NOT NULL,
  `penulis` varchar(25) NOT NULL,
  `penerbit` varchar(25) NOT NULL,
  `jenis_literatur` enum('Jurnal','Buku Referensi','Publikasi','Tugas Akhir','Skripsi','Tesis','Disertasi') NOT NULL,
  `jumlah` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `literatur`
--

INSERT INTO `literatur` (`id`, `judul`, `penulis`, `penerbit`, `jenis_literatur`, `jumlah`, `status`) VALUES
(2, 'Riyadhus shalihin', 'Imam Nawawi', 'Erlangga', 'Buku Referensi', 10, 1),
(3, 'Best apps in the world', 'Hendi', 'Erlangga', 'Publikasi', 10, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman_literatur`
--

CREATE TABLE `peminjaman_literatur` (
  `id` int(11) NOT NULL,
  `id_literatur` int(11) NOT NULL,
  `username_peminjaman` varchar(255) NOT NULL,
  `tanggal_peminjaman` date NOT NULL,
  `tanggal_pengembalian` date NOT NULL,
  `status_peminjaman` enum('Belum diproses','Disetujui','Ditolak','Sudah diambil','Sudah dikembalikan','Belum dikembalikan','Overdue') NOT NULL,
  `id_surat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengadaan_literatur`
--

CREATE TABLE `pengadaan_literatur` (
  `id` int(11) NOT NULL,
  `username_requester` varchar(255) NOT NULL,
  `judul` varchar(25) NOT NULL,
  `penulis` varchar(25) NOT NULL,
  `penerbit` varchar(25) NOT NULL,
  `status` enum('Belum diproses','Distujui','Ditolak','Sudah diambil','Belum dikembalikan','Sudah dikembalikan','Overdue') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user_account`
--

CREATE TABLE `user_account` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user_account`
--

INSERT INTO `user_account` (`username`, `password`, `role`) VALUES
('1290578781', 'password', 'ROLE_DOSEN'),
('1290578783', 'password', 'ROLE_DOSEN'),
('1290578785', 'password', 'ROLE_DOSEN'),
('1290578787', 'password', 'ROLE_DOSEN'),
('1290578789', 'password', 'ROLE_DOSEN'),
('1290578791', 'password', 'ROLE_DOSEN'),
('1290578793', 'password', 'ROLE_DOSEN'),
('1290578795', 'password', 'ROLE_DOSEN'),
('1290578797', 'password', 'ROLE_DOSEN'),
('1290578799', 'password', 'ROLE_DOSEN'),
('1290578801', 'password', 'ROLE_DOSEN'),
('1290578803', 'password', 'ROLE_DOSEN'),
('1290578805', 'password', 'ROLE_DOSEN'),
('1290578807', 'password', 'ROLE_DOSEN'),
('1290578809', 'password', 'ROLE_DOSEN'),
('1290578811', 'password', 'ROLE_DOSEN'),
('1290578813', 'password', 'ROLE_DOSEN'),
('1290578815', 'password', 'ROLE_DOSEN'),
('1290578817', 'password', 'ROLE_DOSEN'),
('1290578819', 'password', 'ROLE_DOSEN'),
('1290578821', 'password', 'ROLE_DOSEN'),
('1290578823', 'password', 'ROLE_DOSEN'),
('1290578825', 'password', 'ROLE_DOSEN'),
('1290578827', 'password', 'ROLE_DOSEN'),
('1290578829', 'password', 'ROLE_DOSEN'),
('1290578831', 'password', 'ROLE_DOSEN'),
('1290578833', 'password', 'ROLE_DOSEN'),
('1290578835', 'password', 'ROLE_DOSEN'),
('1290578837', 'password', 'ROLE_DOSEN'),
('1290578839', 'password', 'ROLE_DOSEN'),
('1290578841', 'password', 'ROLE_DOSEN'),
('1290578843', 'password', 'ROLE_DOSEN'),
('1290578845', 'password', 'ROLE_DOSEN'),
('1290578897', 'password', 'ROLE_DOSEN'),
('1406575815', 'password', 'ROLE_STAF'),
('1506689692', 'password', 'ROLE_STAF'),
('1506721756', 'password', 'ROLE_MAHASISWA'),
('1506721762', 'password', 'ROLE_MAHASISWA'),
('1506721775', 'password', 'ROLE_MAHASISWA'),
('1506721781', 'password', 'ROLE_MAHASISWA'),
('1506721794', 'password', 'ROLE_MAHASISWA'),
('1506721806', 'password', 'ROLE_MAHASISWA'),
('1506721812', 'password', 'ROLE_MAHASISWA'),
('1506721825', 'password', 'ROLE_MAHASISWA'),
('1506721831', 'password', 'ROLE_MAHASISWA'),
('1506721844', 'password', 'ROLE_MAHASISWA'),
('1506721863', 'password', 'ROLE_MAHASISWA'),
('1506721876', 'password', 'ROLE_MAHASISWA'),
('1506721882', 'password', 'ROLE_MAHASISWA'),
('1506721895', 'password', 'ROLE_MAHASISWA'),
('1506721900', 'password', 'ROLE_MAHASISWA'),
('1506723231', 'password', 'ROLE_STAF'),
('1506737823', 'password', 'ROLE_STAF'),
('1506757642', 'password', 'ROLE_MAHASISWA'),
('1506757655', 'password', 'ROLE_MAHASISWA'),
('1506757661', 'password', 'ROLE_MAHASISWA'),
('1506757680', 'password', 'ROLE_MAHASISWA'),
('1506757693', 'password', 'ROLE_MAHASISWA');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `literatur`
--
ALTER TABLE `literatur`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `peminjaman_literatur`
--
ALTER TABLE `peminjaman_literatur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_peminjaman_user` (`username_peminjaman`),
  ADD KEY `fk_peminjaman_literatur` (`id_literatur`);

--
-- Indeks untuk tabel `pengadaan_literatur`
--
ALTER TABLE `pengadaan_literatur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pengadaan_user` (`username_requester`);

--
-- Indeks untuk tabel `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `literatur`
--
ALTER TABLE `literatur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `peminjaman_literatur`
--
ALTER TABLE `peminjaman_literatur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `pengadaan_literatur`
--
ALTER TABLE `pengadaan_literatur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `peminjaman_literatur`
--
ALTER TABLE `peminjaman_literatur`
  ADD CONSTRAINT `fk_peminjaman_literatur` FOREIGN KEY (`id_literatur`) REFERENCES `literatur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_peminjaman_user` FOREIGN KEY (`username_peminjaman`) REFERENCES `user_account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengadaan_literatur`
--
ALTER TABLE `pengadaan_literatur`
  ADD CONSTRAINT `fk_pengadaan_user` FOREIGN KEY (`username_requester`) REFERENCES `user_account` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

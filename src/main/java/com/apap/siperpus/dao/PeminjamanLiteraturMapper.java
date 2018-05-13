package com.apap.siperpus.dao;

import java.util.List;

import com.apap.siperpus.model.LiteraturModel;
import com.apap.siperpus.model.PengadaanLiteraturModel;
import org.apache.ibatis.annotations.*;

import com.apap.siperpus.model.PeminjamanLiteraturModel;

@Mapper
public interface PeminjamanLiteraturMapper {
	
	@Select("SELECT * FROM peminjaman_literatur WHERE id=#{id}")
	@Results({
		@Result(property="id_literatur", column="id_literatur"),
		@Result(property="username_peminjam", column="username_peminjam"),
		@Result(property="tanggal_peminjaman", column="tanggal_peminjaman"),
		@Result(property="tanggal_pengembalian", column="tanggal_pengembalian"),
		@Result(property="status_peminjaman", column="status_peminjaman"),
		@Result(property="is_surat", column="is_surat")
	})
	PeminjamanLiteraturModel selectPeminjamanLiteraturByIdLiteratur(int id);

	@Select("SELECT count(*) as jumlah_peminjaman FROM peminjaman_literatur WHERE id=#{id} group by id ")
	@Results({
			@Result(property="id_literatur", column="id_literatur"),
			@Result(property="jumlah_peminjaman", column="jumlah_peminjaman")
	})
	PeminjamanLiteraturModel selectJumlahPeminjaman(int id);
	
	@Select("SELECT * FROM peminjaman_literatur")
	@Results({
		@Result(property="id_literatur", column="id_literatur"),
		@Result(property="username_peminjam", column="username_peminjam"),
		@Result(property="tanggal_peminjaman", column="tanggal_peminjaman"),
		@Result(property="tanggal_pengembalian", column="tanggal_pengembalian"),
		@Result(property="status_peminjaman", column="status_peminjaman"),
		@Result(property="id_surat", column="id_surat")
	})
	List<PeminjamanLiteraturModel> selectAllPeminjamanLiteratur();
	
	@Insert("INSERT INTO peminjaman_literatur VALUES '("
			+ "#{id_literatur},"
			+ "#{username_peminjaman},"
			+ "#{tanggal_peminjaman}"
			+ "#{tanggal_pengembalian}"
			+ "#{status_peminjaman}"
			+ "#{id_surat}"
			+ ")")
	void insertPeminjamanLiteratur(PeminjamanLiteraturModel peminjamanLiteratur);
	
	@Update("UPDATE peminjaman_literatur SET "
			+ "id_literatur=#{id_literatur},"
			+ "username_peminjam=#{username_peminjaman},"
			+ "tanggal_peminjaman=#{tanggal_peminjaman}, "
			+ "tanggal_pengembalian=#{tanggal_pengembalian}, "
			+ "status_peminjaman=#{status_peminjaman}, "
			+ "id_surat=#{id_surat} "
			+ "where id =#{id_literatur}")
	void updatePeminjamanLiteraturByIdLiteratur(int idPeminajamanLiteratur);

	@Select("SELECT * FROM peminjaman_literatur where id = #{id_literatur}")
	PeminjamanLiteraturModel selectPeminjamanLiteraturById(@Param("id_literatur") String id_literatur);
	
	@Select("SELECT * FROM peminjaman_literatur where username_peminjaman = #{username}")
	List<PeminjamanLiteraturModel> selectPeminjamanLiteraturByUsername(String username);

	@Update("Update peminjaman_literatur set id_literatur  = #{peminjaman.id_literatur}," +
			"username_peminjaman = #{peminjaman.username_peminjaman}," +
			"tanggal_peminjaman = #{peminjaman.tanggal_peminjaman}," +
			"tanggal_pengembalian = #{peminjaman.tanggal_pengembalian}," +
			"status_peminjaman = #{peminjaman.status_peminjaman}," +
			"id_surat = #{peminjaman.id_surat}" +
			"where id = #{peminjaman.id}")
	void ubahPeminjaman(@Param("peminjaman") PeminjamanLiteraturModel peminjaman);
}

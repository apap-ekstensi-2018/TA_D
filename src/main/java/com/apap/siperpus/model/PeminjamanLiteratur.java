package com.apap.siperpus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeminjamanLiteratur {
	private int id;
	private int idLiteratur;
	private String usernamePeminjaman;
	private String tanggalPeminjaman;
	private String tanggalPengembalian;
	private String statusPeminjaman;
	private String idSurat;
}

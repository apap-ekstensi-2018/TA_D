package com.apap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PengadaanLiteratur {
	private int id;
	private String usernameRequester;
	private String judul;
	private String penulis;
	private String penerbit;
	private String status;
}

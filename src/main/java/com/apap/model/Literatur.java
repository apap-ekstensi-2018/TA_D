package com.apap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Literatur {
	private int id;
	private String judul;
	private String penulis;
	private String penerbit;
	private String jenisLiteratur;
	private String jumlah;
}

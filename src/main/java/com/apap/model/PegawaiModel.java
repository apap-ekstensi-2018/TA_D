package com.apap.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PegawaiModel {
	private int id;
	private String nip;
	private String username;
	private String nama;
	private boolean isStaf;
}

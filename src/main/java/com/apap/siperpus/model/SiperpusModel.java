package com.apap.siperpus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiperpusModel {
    private int id;
    private String judul;
    private String penulis;
    private String penerbit;
    private String jenis_literatur;
    private int jumlah;
    private int status;


}

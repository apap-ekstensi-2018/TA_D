package com.apap.siperpus.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiteraturModel {
    private int id;
    private String judul;
    private String penulis;
    private String penerbit;
    private String jenis_literatur;
    private int jumlah;
    private int status;
}

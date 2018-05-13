package com.apap.siperpus.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuratModel {
    @JsonProperty("id_mahasiswa")
    private int id_mahasiswa;

    @JsonProperty("jenis_surat")
    private String jenis_surat;

    @JsonProperty("keterangan_surat")
    private String keterangan_surat;

    @JsonProperty("status_surat")
    private String status_surat;
}

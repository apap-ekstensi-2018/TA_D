package com.apap.siperpus.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuratReturnModel {
    @JsonProperty("Status")
    private String Status;

    @JsonProperty("Message")
    private String Message;

    @JsonProperty("Data Surat")
    private List<SuratModel> Data_Surat;
}

package com.webservice.soap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class sampleservicers {
    @JsonProperty(value = "error_code")
    public String errorCode;
    @JsonProperty(value = "error_msg")
    public String errorMsg;
    @JsonProperty(value = "trx_id")
    public String trxId;
}

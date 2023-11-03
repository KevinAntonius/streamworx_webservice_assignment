package com.webservice.soap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class sampleservicerq {
    @JsonProperty(value = "service_id")
    public String serviceId;
    @JsonProperty(value = "order_type")
    public String orderType;
    @JsonProperty(value = "type")
    public String type;
    @JsonProperty(value = "trx_id")
    public String trxId;
}

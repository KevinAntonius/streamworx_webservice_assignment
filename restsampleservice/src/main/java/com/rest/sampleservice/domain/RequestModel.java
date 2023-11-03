package com.rest.sampleservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonRootName(value="sampleservicers")
public class RequestModel {
    @JsonProperty("service_id")
    private String serviceId;
    @JsonProperty("order_type")
    private String orderType;
    @JsonProperty("type")
    private String type;
    @JsonProperty("trx_id")
    private String trxId;
}

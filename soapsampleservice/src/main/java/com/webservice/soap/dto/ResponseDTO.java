package com.webservice.soap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDTO {
    @JsonProperty(value = "sampleservicers")
    public sampleservicers restResponse;
}

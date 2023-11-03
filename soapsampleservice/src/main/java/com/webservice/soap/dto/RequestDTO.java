package com.webservice.soap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDTO {
    @JsonProperty(value = "sampleservicerq")
    public sampleservicerq restRequest;
}

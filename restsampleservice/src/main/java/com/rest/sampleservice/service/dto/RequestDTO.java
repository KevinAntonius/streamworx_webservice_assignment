package com.rest.sampleservice.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rest.sampleservice.domain.RequestModel;

public class RequestDTO {
    @JsonProperty(value = "sampleservicerq")
    public RequestModel serviceRequest;
}

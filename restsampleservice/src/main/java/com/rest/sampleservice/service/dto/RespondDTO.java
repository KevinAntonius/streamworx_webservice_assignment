package com.rest.sampleservice.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rest.sampleservice.domain.RespondModel;

public class RespondDTO {
    @JsonProperty(value = "sampleservicers")
    public RespondModel serviceRespond;
}

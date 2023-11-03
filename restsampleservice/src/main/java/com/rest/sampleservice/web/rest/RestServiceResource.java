package com.rest.sampleservice.web.rest;

import com.rest.sampleservice.service.RestService;
import com.rest.sampleservice.service.dto.RequestDTO;
import com.rest.sampleservice.service.dto.RespondDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/external/services/rest", produces = "application/json")
public class RestServiceResource {

    private final RestService restService;

    public RestServiceResource(RestService restService) {
        this.restService = restService;
    }

    @PostMapping("/sample-service")
    public ResponseEntity<RespondDTO> getRespond(@RequestBody RequestDTO requestDTO){
        System.out.println("REST "+requestDTO.toString());
        RespondDTO respondDTO = restService.getRespond(requestDTO);
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<RespondDTO> response
                = new ResponseEntity<>(respondDTO, headers, HttpStatus.OK);
        return response;
    }
}

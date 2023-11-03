package com.webservice.soap.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.oracle.external.services.sampleservice.request.v1.GetRequest;
import com.oracle.external.services.sampleservice.request.v1.GetResponse;
import com.webservice.soap.dto.RequestDTO;
import com.webservice.soap.dto.ResponseDTO;
import com.webservice.soap.dto.sampleservicerq;
import com.webservice.soap.dto.sampleservicers;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ResponseEndpoint {
    RestTemplate rest = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    private static final String NAMESPACE_URI = "http://www.oracle.com/external/services/sampleservice/request/v1.0";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sampleservicerq")
    @ResponsePayload
    public GetResponse getResponse(@RequestPayload GetRequest request) throws JsonProcessingException {
        RequestDTO requestDTO = new RequestDTO();

        sampleservicerq restRequest = new sampleservicerq();
        restRequest.setServiceId(request.getServiceId());
        restRequest.setOrderType(request.getOrderType());
        restRequest.setType(request.getType());
        restRequest.setTrxId(request.getTrxId());
        requestDTO.restRequest = restRequest;

        ResponseDTO responseDTO = getRestRespond(requestDTO);
        sampleservicers restResponse = responseDTO.restResponse;
        GetResponse response = new GetResponse();
        response.setErrorCode(restResponse.getErrorCode());
        response.setErrorMsg(restResponse.getErrorMsg());
        response.setTrxId(restResponse.getTrxId());
//        response.setErrorCode("0000");
//        response.setErrorMsg("Success");
//        response.setTrxId(request.getTrxId());
        return response;
    }

    public ResponseDTO getRestRespond(RequestDTO requestDTO) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(requestDTO);

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(requestJson, headers);

        ResponseEntity<ResponseDTO> response =
                rest.postForEntity("http://localhost:8081/external/services/rest/sample-service", request, ResponseDTO.class);
        return response.getBody();
    }
}

package com.rest.sampleservice.service;

import com.rest.sampleservice.domain.RespondModel;
import com.rest.sampleservice.service.dto.RequestDTO;
import com.rest.sampleservice.service.dto.RespondDTO;
import org.springframework.stereotype.Service;

@Service
public class RestService {

    public RespondDTO getRespond(RequestDTO request){
        String trx_id = request.serviceRequest.getTrxId();

        RespondDTO respond = new RespondDTO();

        RespondModel serviceRespond = new RespondModel();
        serviceRespond.setErrorCode("0000");
        serviceRespond.setErrorMsg("Success");
        serviceRespond.setTrxId(trx_id);

        respond.serviceRespond = serviceRespond;

        return respond;
    }
}

package com.ftd.product.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftd.product.api.request.ServiceRequest;
import com.ftd.product.api.response.ServiceResponse;
import com.ftd.product.bl.MyService;

import io.swagger.annotations.Api;

@RestController
@RefreshScope
@RequestMapping("/apis")
@Api(value = "Product Service API", description = "To get Product for given pid")
public class ServiceResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceResource.class);

    @Autowired
    private MyService myService;

//    @Autowired
//    private ProductsRepository productRepository;

    @PostMapping(value = "/v1/getproduct", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    @Cacheable(cacheNames = "product")
    public ResponseEntity<ServiceResponse> getProductV1(@RequestBody ServiceRequest request) {
        ServiceResponse serviceResponse = null;
        LOGGER.info("Called getproduct method.... ");
        if (request.getPid() != null) {
            serviceResponse = myService.getResponse(request.getPid());
        } else {
            serviceResponse = new ServiceResponse();
            serviceResponse.setStatus("Invlid input data");
        }

        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

//    @PostMapping(value = "/addproduct", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
//            MediaType.APPLICATION_JSON_VALUE })
//    @Cacheable(cacheNames = "addproduct")
//    public ResponseEntity<String> addAcls(@RequestBody Product request) {
//        String jsonResponse;
//        LOGGER.info("Called add acls method with all values.... ");
//        try {
//            if (request.getPid() != null
//                && request.getName() != null
//                && request.getPrice() != null
//                && request.getSku() != null
//                && request.getStatus() != null
//                && request.getCode() {
//                Product acl = new Product(request.getId(), request.getPid(),
//                                     request.getFormName(),
//                                     request.getAttrName(),
//                                     request.getRole(),
//                                     request.getActionType());
//                aclsRepository.save(acl);
//                jsonResponse = "{status: success}";
//            } else {
//                jsonResponse = "{status: error, error: Invlid input data " + request.getSiteId() + "-"
//                        + request.getFormName() + "-" + request.getAttrName() + "-" + request.getRole() + "-"
//                        + request.getActionType() + "}";
//            }
//        } catch (Exception e) {
//            jsonResponse = "{status: error}";
//            LOGGER.error("ERROR: " + e.getMessage());
//        }
//
//        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
//    }


    public ResponseEntity<String> sendResponse(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonResponse;
        try {
            jsonResponse = mapper.writeValueAsString(obj);
            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            jsonResponse = "{status : \"Unexpected error\"}";
            return new ResponseEntity<>(jsonResponse, HttpStatus.BAD_REQUEST);
        }
    }

}

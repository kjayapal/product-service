package com.ftd.product.bl.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.ftd.product.api.response.ServiceResponse;
import com.ftd.product.bl.MyService;
import com.ftd.product.config.MyConfigurationProperties;
import com.ftd.product.data.Product;
import com.ftd.product.data.ProductsRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.services.micro.commons.logging.annotation.LogExecutionTime;

@Service(value = "MyService")
@EnableConfigurationProperties(MyConfigurationProperties.class)
public class MyServiceImpl implements MyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyServiceImpl.class);

    @Autowired
    private ProductsRepository productRepo;

//    @Override
//    @Timed
//    @ExceptionMetered
//    @HystrixCommand(groupKey = "hystrixGroup", commandKey = "helloCommandKey",
//                                               threadPoolKey = "helloThreadPoolKey",
//                                               fallbackMethod = "fallbackHello")
//    @Cacheable(cacheNames = "default")
//    @LogExecutionTime
//    public ServiceResponse getResponse() {
//        LOGGER.info("getResponse called ");
//        List<Product> productList = productRepo.findAll();
//        return new ServiceResponse(productList);
//    }

    @Override
    @Timed
    @ExceptionMetered
    @HystrixCommand(groupKey = "hystrixGroup", commandKey = "helloCommandKey",
                                               threadPoolKey = "helloThreadPoolKey",
                                               fallbackMethod = "fallbackHello")
    @Cacheable(cacheNames = "default")
    @LogExecutionTime
    public ServiceResponse getResponse(String pid) {
        LOGGER.info("getResponse called with pid: " + pid);
        Product product = productRepo.findByPid(pid);
        return new ServiceResponse(product);
    }

    public ServiceResponse fallbackHello() {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setStatus("error (This is Hello from fallback)");
        return serviceResponse;
    }

    public ServiceResponse fallbackHello(String pid) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setStatus("error (This is Hello from fallback)");
        return serviceResponse;
    }

}

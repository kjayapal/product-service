package com.ftd.product.api.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class ServiceRequest {

    @NotNull(message = "{error.siteid.notnull}")
    @ApiModelProperty(notes = "Product ID", required = true)
    private String pid;


    public String getPid() {
        return pid;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    @Override
    public String toString() {
        return "ServiceRequest [pid=" + pid + "]";
    }

}

package com.ftd.product.api.response;

import java.io.Serializable;
import com.ftd.product.data.Product;

public class ServiceResponse implements Serializable {
    private static final long serialVersionUID = -3228807230740133965L;
    private Product product;
    private String status;

    public ServiceResponse() {
        this.product = null;
        this.status = "error";
    }

    public ServiceResponse(Product product) {
        this.product = product;
        this.status = "success";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServiceResponse [product=" + product + ", status=" + status + "]";
    }


}

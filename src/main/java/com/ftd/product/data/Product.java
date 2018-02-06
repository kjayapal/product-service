package com.ftd.product.data;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiParam;

@Document(collection = "PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = -5037544901973298544L;

    @Id
    private String id;
    @ApiParam ("Product Name")
    private String name;
    @ApiParam ("Product ID")
    private String pid;
    @ApiParam ("Product Price")
    private String price;
    @ApiParam ("Product SKU")
    private String sku;
    @ApiParam ("Product Status")
    private String status;
    @ApiParam ("Product Code")
    private String code;
    @ApiParam ("Product Description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", pid=" + pid + ", price=" + price + ", sku=" + sku
                + ", status=" + status + ", code=" + code + ", description=" + description + "]";
    }

}

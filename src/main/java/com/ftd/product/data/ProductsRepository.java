package com.ftd.product.data;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductsRepository extends MongoRepository<Product, String> {

    Product findById(String id);
    Product findByPid(String pid);
//    Product findBySiteId(String siteId);
//    Product findBySiteIdAndFormNameAndAttrNameAndRoleAllIgnoreCase(
//                  String siteId, String formName, String attrName, String role);
//    List<Product> findBySiteIdAndFormNameAndRoleAllIgnoreCase(
//            String siteId, String formName, String role);
//
//    List<AclData> findAttrNameAndActionTypeBySiteIdAndFormNameAndRoleAllIgnoreCase(
//            String siteId, String formName, String role);
    // public List<Product> findByPrice(float price);

}

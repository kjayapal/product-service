package com.ftd.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ftd.product.data.Product;
import com.ftd.product.data.ProductsRepository;


@Controller
public class DataViewController {

//    @Autowired
//    private Acls acls;

    @Autowired
    private ProductsRepository aclsRepo;

    @GetMapping("/data")
    public String getData(Model model) {
        List<Product> productsList = aclsRepo.findAll();
        model.addAttribute("productsList", productsList);
        return "data";
    }
}
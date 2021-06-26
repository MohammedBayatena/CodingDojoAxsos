package com.example.productsandcategories.controllers;


import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductService prodserv;

    public ProductController(ProductService prodserv) {
        this.prodserv = prodserv;
    }

    @RequestMapping("/products/new")
    public String renderNew(@ModelAttribute(name = "product") Product product) {
        return "newProduct.jsp";
    }

    @RequestMapping(value = "products/new", method = RequestMethod.POST)
    public String addNew(@ModelAttribute(name = "product") Product product) {
        //Do Logic Here
        prodserv.createProduct(product);
        return "redirect:/products/new";
    }

    @RequestMapping("/products/{id}")
    public String renderinfo(@PathVariable(name = "id") Long id, Model model) {
        Product product = prodserv.getProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            model.addAttribute("categorieslist", prodserv.getCategoriesNotIn(id));
            return "productinfo.jsp";
        }
        return "redirect:/products/new";
    }

    @RequestMapping("/products/{id}/addcat")
    public String addProdToCat(@RequestParam("category") Long categoryid, @PathVariable("id") Long prodid) {

        prodserv.addcat(categoryid, prodid);
        return "redirect:/products/" + prodid;
    }


}

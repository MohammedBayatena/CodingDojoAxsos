package com.example.productsandcategories.controllers;

import com.example.productsandcategories.models.Category;
import com.example.productsandcategories.models.Product;
import com.example.productsandcategories.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {

    private final CategoryService catserv;

    public CategoryController(CategoryService catserv) {
        this.catserv = catserv;
    }

    @RequestMapping("/categories/new")
    public String renderNew(@ModelAttribute(name = "category") Category category) {
        return "newCategory.jsp";
    }

    @RequestMapping(value = "/categories/new", method = RequestMethod.POST)
    public String addNew(@ModelAttribute(name = "category") Category category) {
        //Do Logic Here
        catserv.createCategory(category);
        return "redirect:/categories/new";
    }

    @RequestMapping("categories/{id}")
    public String renderinfo(@PathVariable(name = "id") Long id, Model model) {
        Category category = catserv.getCategoryById(id);
        if (category != null) {
            model.addAttribute("category", category);
            model.addAttribute("prdouctslist", catserv.getPrdocutsNotIn(id));
            return "categoryinfo.jsp";
        }
        return "redirect:/categories/new";
    }

    @RequestMapping("/categories/{id}/addprod")
    public String addProdToCat(@RequestParam("product") Long product, @PathVariable("id") Long id) {
        catserv.addprod(product, id);
        return "redirect:/categories/" + id;
    }


}

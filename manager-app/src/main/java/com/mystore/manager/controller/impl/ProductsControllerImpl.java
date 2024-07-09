package com.mystore.manager.controller.impl;

import com.mystore.manager.controller.ProductsController;
import com.mystore.manager.controller.impl.payload.NewProductPayload;
import com.mystore.manager.entity.Product;
import com.mystore.manager.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Controller
@RequiredArgsConstructor
public class ProductsControllerImpl implements ProductsController {

    private final ProductService productService;

    public String getProductsList(Model model) {
        model.addAttribute("products", this.productService.findAllProducts());
        return "catalogue/products/list";
    }

    @Override
    public String getProductCreatePage(Model model) {
        return "catalogue/products/create";
    }

    @Override
    public String createProduct(@Valid NewProductPayload payload,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("payload", payload);
            model.addAttribute("errors", bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .toList());
            return "catalogue/products/create";
        } else {
            Product product = this.productService.createProduct(payload.title(), payload.details());
            return "redirect:/catalogue/products/%d".formatted(product.getId());
        }
    }
}

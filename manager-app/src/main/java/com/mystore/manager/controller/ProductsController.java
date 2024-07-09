package com.mystore.manager.controller;

import com.mystore.manager.controller.impl.payload.NewProductPayload;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер для списка товаров
 */
@RequestMapping("catalogue/products")
public interface ProductsController {

    /**
     * Получение страницы списка товаров
     *
     * @param model модель
     * @return шаблон списка товаров
     */
    @GetMapping(value = "list")
    String getProductsList(Model model);

    /**
     * Получение страницы добавления товара
     *
     * @param model модель
     * @return шаблон добавления товара
     */
    @GetMapping(value = "create")
    String getProductCreatePage(Model model);

    /**
     * Добавление товара
     *
     * @param payload       данные для добавления товара
     * @param bindingResult результаты привязки формы и валидации(проверка наличия ошибок)
     * @param model         модель
     * @return шаблон добавления/товара
     */
    @PostMapping(value = "create")
    String createProduct(@Valid NewProductPayload payload, BindingResult bindingResult,
                         Model model);
}

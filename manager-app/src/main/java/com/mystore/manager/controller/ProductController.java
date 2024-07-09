package com.mystore.manager.controller;

import com.mystore.manager.controller.impl.payload.UpdateProductPayload;
import com.mystore.manager.entity.Product;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.NoSuchElementException;

/**
 * Контроллер для конкретного товара
 */
@RequestMapping("catalogue/products/{productId:\\d+}")
public interface ProductController {

    /**
     * Получение товара по id
     *
     * @param productId id товара
     * @return объект товара
     * @throws NoSuchElementException если товар не найден
     */
    @ModelAttribute("product")
    Product product(@PathVariable("productId") int productId);

    /**
     * Получение страницы товара
     *
     * @return шаблон товара
     */
    @GetMapping()
    String getProductPage();

    /**
     * Получение страницы изменения товара
     *
     * @return шаблон обновления
     */
    @GetMapping("update")
    String getProductUpdatePage();

    /**
     * Изменить товар
     *
     * @param product       товар
     * @param payload       данные для изменения товара
     * @param bindingResult результаты привязки формы и валидации(проверка наличия ошибок)
     * @param model         модель
     * @return шаблон обновления/товара
     */
    @PostMapping("update")
    String updateProduct(@ModelAttribute(value = "product", binding = false) Product product,
                         @Valid UpdateProductPayload payload,
                         BindingResult bindingResult,
                         Model model);

    /**
     * Удалить товар
     *
     * @param product товар
     * @return шаблон списка товаров
     */
    @PostMapping("delete")
    String deleteProduct(@ModelAttribute("product") Product product);

    /**
     * Обработчик ошибок
     *
     * @param exception эксепшен
     * @param model     модель
     * @param response  ответ для клиента
     * @param locale    языковой регион клиента
     * @return шаблон ошибки
     */
    @ExceptionHandler(NoSuchElementException.class)
    String handleNoSuchElementException(NoSuchElementException exception, Model model,
                                        HttpServletResponse response, Locale locale);
}

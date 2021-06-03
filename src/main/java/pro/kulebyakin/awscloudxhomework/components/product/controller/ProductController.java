package pro.kulebyakin.awscloudxhomework.components.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pro.kulebyakin.awscloudxhomework.components.product.dto.ProductDto;
import pro.kulebyakin.awscloudxhomework.components.product.model.Product;
import pro.kulebyakin.awscloudxhomework.components.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public Product getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @RequestMapping(value = {"/add"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody ProductDto product) {
        return productService.addProduct(product);
    }
}

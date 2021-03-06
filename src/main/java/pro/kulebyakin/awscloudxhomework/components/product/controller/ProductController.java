package pro.kulebyakin.awscloudxhomework.components.product.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pro.kulebyakin.awscloudxhomework.components.product.dto.ProductDto;
import pro.kulebyakin.awscloudxhomework.components.product.model.Product;
import pro.kulebyakin.awscloudxhomework.components.product.service.ProductService;

@RestController
@RequestMapping({"/product", "/products"})
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

    @RequestMapping(value = {"/create", "/register"}, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Product createNewProduct(@RequestBody ProductDto product) {
        return productService.createNewProduct(product);
    }

    @RequestMapping(value = "/{id}/add", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Product addProductById(@PathVariable Long id, @RequestParam Integer quantity) {
        return productService.addProductById(id, quantity);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String sayHello() {
        return "Hello from aws-homework app";
    }
}

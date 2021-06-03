package pro.kulebyakin.awscloudxhomework.components.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pro.kulebyakin.awscloudxhomework.components.product.dto.ProductDto;
import pro.kulebyakin.awscloudxhomework.components.product.model.Product;
import pro.kulebyakin.awscloudxhomework.components.product.repo.ProductRepository;
import pro.kulebyakin.awscloudxhomework.core.service.CrudService;

@Service
@RequiredArgsConstructor
public class ProductService extends CrudService<Product> {

    private final ProductRepository productRepository;

    @Override
    public JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

    public Product getById(Long productId) {
        return get(productId);
    }

    public Product createNewProduct(ProductDto productDto) {
        Product product = new Product()
                .setName(productDto.getName())
                .setPrice(productDto.getPrice())
                .setBalance(0);
        return save(product);
    }

    public Product addProductById(Long id, Integer addQuantity) {
        Product product = get(id);
        Integer currentBalance = product.getBalance();
        Integer newBalance = currentBalance + addQuantity;
        product.setBalance(newBalance);
        return save(product);
    }
}

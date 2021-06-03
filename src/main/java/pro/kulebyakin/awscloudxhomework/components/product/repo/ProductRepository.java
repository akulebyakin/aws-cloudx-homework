package pro.kulebyakin.awscloudxhomework.components.product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.kulebyakin.awscloudxhomework.components.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

package am.smarket.smarket.repository;

import am.smarket.smarket.model.Category;
import am.smarket.smarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByCategory(Category category);
}

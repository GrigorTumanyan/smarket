package am.smarket.smarket.repository;

import am.smarket.smarket.model.Category;
import am.smarket.smarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findAllByParent(Integer id);
    List<Category> findAllById(Integer id);


}

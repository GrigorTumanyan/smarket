package am.smarket.smarket.repository;

import am.smarket.smarket.model.SecondSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondSubCategoryRepository extends JpaRepository<SecondSubCategory, Integer> {

}

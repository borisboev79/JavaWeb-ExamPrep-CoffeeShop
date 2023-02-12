package examprep.coffeeshop.repositories;

import examprep.coffeeshop.domain.entities.Category;
import examprep.coffeeshop.domain.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryType type);
}

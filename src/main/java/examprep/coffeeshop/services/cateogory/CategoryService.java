package examprep.coffeeshop.services.cateogory;

import examprep.coffeeshop.domain.entities.Category;
import examprep.coffeeshop.domain.enums.CategoryType;

public interface CategoryService {

    void dbInit();

    boolean isDbInit();

    Category findByType(CategoryType type);


}

package examprep.coffeeshop.services.cateogory;

import examprep.coffeeshop.domain.entities.Category;
import examprep.coffeeshop.domain.enums.CategoryType;
import examprep.coffeeshop.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    @Override
    public void dbInit() {
        if(!isDbInit()){
            List<Category> categories = new ArrayList<>();
            categories.add(Category.builder().name(CategoryType.Cake).neededTime(10).build());
            categories.add(Category.builder().name(CategoryType.Coffee).neededTime(2).build());
            categories.add(Category.builder().name(CategoryType.Drink).neededTime(1).build());
            categories.add(Category.builder().name(CategoryType.Other).neededTime(5).build());

            this.categoryRepository.saveAllAndFlush(categories);
        }
    }

    @Override
    public boolean isDbInit() {
        return this.categoryRepository.count() > 0;
    }

    @Override
    public Category findByType(CategoryType type) {
        return this.categoryRepository.findByName(type).orElseThrow();
    }


}

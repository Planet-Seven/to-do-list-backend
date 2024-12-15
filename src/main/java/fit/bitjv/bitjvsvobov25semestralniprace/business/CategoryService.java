package fit.bitjv.bitjvsvobov25semestralniprace.business;

import fit.bitjv.bitjvsvobov25semestralniprace.dto.CategoryResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateCategoryRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.entity.Category;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public CategoryResponse createCategory(CreateCategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        categoryRepository.save(category);
        return mapper.map(category, CategoryResponse.class);
    }
}

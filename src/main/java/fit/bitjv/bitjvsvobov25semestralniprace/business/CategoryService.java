package fit.bitjv.bitjvsvobov25semestralniprace.business;

import fit.bitjv.bitjvsvobov25semestralniprace.dto.CategoryResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateCategoryRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.UpdateCategoryRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.entity.Category;
import fit.bitjv.bitjvsvobov25semestralniprace.exceptions.CategoryNotFound;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public CategoryResponse updateCategory(UpdateCategoryRequest request) {
        Category category = mapper.map(request, Category.class);
        categoryRepository
                .findById(request.getId())
                .orElseThrow(() ->new CategoryNotFound(""));
        categoryRepository.save(category);
        return mapper.map(category, CategoryResponse.class);
    }

    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map((Category category) -> mapper.map(category, CategoryResponse.class))
                .collect(Collectors.toList());
    }

    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() ->new CategoryNotFound(""));
        return mapper.map(category, CategoryResponse.class);
    }

    public void deleteCategory(Long id) {
        categoryRepository
                .findById(id)
                .orElseThrow(() ->new CategoryNotFound(""));
        categoryRepository.deleteById(id);
    }
}

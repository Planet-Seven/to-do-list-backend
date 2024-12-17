package fit.bitjv.bitjvsvobov25semestralniprace.controllers;

import fit.bitjv.bitjvsvobov25semestralniprace.business.CategoryService;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CategoryResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CategoryRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponse createCategory(@RequestBody CategoryRequest request){
        System.out.println(request.getName());
        return categoryService.createCategory(request);
    }

    @PutMapping("/{categoryId}")
    public CategoryResponse updateCategory(@RequestBody CategoryRequest request, @PathVariable Long categoryId) {
        return categoryService.updateCategory(request, categoryId);
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{categoryId}")
    public CategoryResponse getCategoryById(@PathVariable Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}

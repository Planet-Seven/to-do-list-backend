package fit.bitjv.bitjvsvobov25semestralniprace.controllers;

import fit.bitjv.bitjvsvobov25semestralniprace.business.CategoryService;
import fit.bitjv.bitjvsvobov25semestralniprace.business.TagService;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CategoryResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateCategoryRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateTagRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TagResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController {
    private final CategoryService categoryService;

    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponse createTask(CreateCategoryRequest request){
        return categoryService.createCategory(request);
    }
}

package com.data.elearning_api.controller;

import com.data.elearning_api.dto.CategoryCreateDTO;
import com.data.elearning_api.dto.CategoryDTO;
import com.data.elearning_api.dto.CategoryUpdateDTO;
import com.data.elearning_api.entity.Category;
import com.data.elearning_api.repository.CategoryRepository;
import com.data.elearning_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        List<Category> categories = categoryService.gettAll();

        List<CategoryDTO> categoryDTOS = new ArrayList<>();

        for (Category category : categories) {
            CategoryDTO dto = new CategoryDTO();
            dto.setId(category.getId());
            dto.setName(category.getName());

            categoryDTOS.add(dto);
        }
        return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CategoryCreateDTO dto) {
        Category created = categoryService.create(dto);

        CategoryDTO response = new CategoryDTO();
        response.setId(created.getId());
        response.setName(created.getName());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestBody CategoryUpdateDTO dto) {
        Category category = categoryService.update(id, dto);

        if (category == null) {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Update success", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean deleted = categoryService.delete(id);

        if (!deleted) {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }


}
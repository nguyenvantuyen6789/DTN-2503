package com.data.elearning_api.service;

import com.data.elearning_api.dto.CategoryCreateDTO;
import com.data.elearning_api.dto.CategoryUpdateDTO;
import com.data.elearning_api.entity.Category;
import com.data.elearning_api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<Category> gettAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getById(Integer id) {
        Category category = categoryRepo.findById(id).orElse(null);
        return category;
    }

    @Override
    public Category create(CategoryCreateDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return categoryRepo.save(category);
    }

    @Override
    public Category update(int id, CategoryUpdateDTO categoryUpdateDTO) {
        Category category = getById(id);

        if(category != null) {
            category.setName(categoryUpdateDTO.getName());
            return categoryRepo.save(category);
        }

        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Category category = getById(id);

        if(category != null) {
            categoryRepo.delete(category);
            return true;
        }

        return false;
    }
}

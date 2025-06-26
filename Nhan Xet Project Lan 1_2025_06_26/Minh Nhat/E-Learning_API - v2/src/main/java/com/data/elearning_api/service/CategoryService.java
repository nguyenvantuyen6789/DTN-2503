package com.data.elearning_api.service;

import com.data.elearning_api.dto.CategoryCreateDTO;
import com.data.elearning_api.dto.CategoryDTO;
import com.data.elearning_api.dto.CategoryUpdateDTO;
import com.data.elearning_api.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> gettAll();
    Category getById(Integer id);
    Category create(CategoryCreateDTO dto);
    Category update(int id, CategoryUpdateDTO categoryUpdateDTO);
    boolean delete(Integer id);
}

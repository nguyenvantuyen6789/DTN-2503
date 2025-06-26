package com.example.elearning.demo_elearning_api.service;

import com.example.elearning.demo_elearning_api.dto.CategoryDTO;
import com.example.elearning.demo_elearning_api.entity.Category;
import com.example.elearning.demo_elearning_api.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<CategoryDTO> getAll() {
        return repo.findAll().stream()
                .map(c -> new CategoryDTO(c.getId(), c.getName()))
                .collect(Collectors.toList());
    }

    public CategoryDTO create(CategoryDTO dto) {
        Category c = new Category(null, dto.getName());
        c = repo.save(c);
        return new CategoryDTO(c.getId(), c.getName());
    }

    public CategoryDTO update(Long id, CategoryDTO dto) {
        Category c = repo.findById(id).orElseThrow();
        c.setName(dto.getName());
        c = repo.save(c);
        return new CategoryDTO(c.getId(), c.getName());
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

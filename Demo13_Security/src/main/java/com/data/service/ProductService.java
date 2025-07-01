package com.data.service;

import com.data.entity.Product;
import com.data.repository.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductRepository productRepo;

    public List<Product> getAll() {
        List<Product> products = productRepo.findAll();

        return products;
    }
}

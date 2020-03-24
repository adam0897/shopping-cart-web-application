package com.example.usermanagementrestapi.service;

import com.example.usermanagementrestapi.entity.Category;
import com.example.usermanagementrestapi.model.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<CategoryDto> getListCategory();

    //Test api
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(int categoryId);

    CategoryDto updateCategory(CategoryDto categoryDto, int categoryId);

    void deleteCategory(int categoryId);

    Category getOne(int categoryId);

    Page<Category> getListCategoryByCategoryNameContaining(Pageable pageable, String categoryName);
}

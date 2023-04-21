package gov.iti.APIs.soap;

import java.util.ArrayList;
import java.util.List;

import gov.iti.APIs.Exception.ResourceNotFoundException;
import gov.iti.models.dtos.CategoryDto;
import gov.iti.models.dtos.SakilaDtos;
import gov.iti.services.CrudServices;
import jakarta.jws.WebService;

@WebService
public class CategoryService {
    
    private CrudServices<CategoryDto> categoryService;
    
    public CategoryService() {
        categoryService = new CrudServices<>(CategoryDto.class);
    }
    
    public CategoryDto getCategoryById(Integer id) {
        CategoryDto categoryDto=(CategoryDto) categoryService.getdtoById(id);
        if (categoryDto== null)
        throw new ResourceNotFoundException("Category with ID:" + id + " Not Found");
            return categoryDto;
    }
    
    public void deleteCategory(Integer id) {
        categoryService.delete(id);
    }
    
    public void updateCategory(CategoryDto categoryDto) {
        categoryService.update(categoryDto);
    }
    
    public void addCategory(CategoryDto categoryDto) {
        categoryService.add(categoryDto);
    }
    
    public List<CategoryDto> findAllCategories() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (SakilaDtos sakilaDto : categoryService.findAll()) {
            CategoryDto categoryDto = (CategoryDto) sakilaDto;
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }
}

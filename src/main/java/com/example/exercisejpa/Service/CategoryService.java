package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllcategory()
    {
        return categoryRepository.findAll();
    }

    public void addcategory(Category category)
    {
        categoryRepository.save(category);
    }

    public Boolean updatecategory( Integer id,Category category){
        Category c=categoryRepository.getById(id);
        if (c==null){
            return false;
        }
        c.setName(category.getName());
        return true;
    }
    public Boolean Deletecategory(Integer id){
        Category c=categoryRepository.getById(id);
        if (c ==null){
            return false;
        }
        categoryRepository.delete(c);
        return true;
    }
}

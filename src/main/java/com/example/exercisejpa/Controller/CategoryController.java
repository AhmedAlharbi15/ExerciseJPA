package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Api.Api;
import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity getAllCoffees()
    {
        return ResponseEntity.status(200).body(categoryService.getAllcategory());
    }
    @PostMapping("/add")
    public ResponseEntity addcategory(@RequestBody @Valid Category category , Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();

        }categoryService.addcategory(category);
        return ResponseEntity.status(200).body(new Api("coffee added"));
    }
    @PutMapping("/up")
    public ResponseEntity updatecategory(@PathVariable Integer id, @RequestBody @Valid Category category,Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("Up");
        }
        Boolean isUpdate=categoryService.updatecategory(id,category);
        if (isUpdate){
            return ResponseEntity.status(200).body(new Api("category Updated"));
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletecategory(@PathVariable Integer id){
        Boolean isDelete=categoryService.Deletecategory(id);
        if (isDelete){
            return ResponseEntity.status(200).body(new Api("delete"));
        }
        return ResponseEntity.status(400).body("Wrong id");
    }
}

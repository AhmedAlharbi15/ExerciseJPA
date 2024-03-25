package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Api.Api;
import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Model.Product;
import com.example.exercisejpa.Service.CategoryService;
import com.example.exercisejpa.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/get")
    public ResponseEntity getAllpro()
    {
        return ResponseEntity.status(200).body(productService.getAllpro());
    }
    @PostMapping("/add")
    public ResponseEntity addpro(@RequestBody @Valid Product product , Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();

        }productService.addpro(product);
        return ResponseEntity.status(200).body(new Api(" added"));
    }
    @PutMapping("/up")
    public ResponseEntity updatepro(@PathVariable Integer id, @RequestBody @Valid Product product,Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("Up");
        }
        Boolean isUpdate=productService.updatepro(id,product);
        if (isUpdate){
            return ResponseEntity.status(200).body(new Api(" Updated"));
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletepro(@PathVariable Integer id){
        Boolean isDelete=productService.Deletepro(id);
        if (isDelete){
            return ResponseEntity.status(200).body(new Api("delete"));
        }
        return ResponseEntity.status(400).body("Wrong id");
    }
}

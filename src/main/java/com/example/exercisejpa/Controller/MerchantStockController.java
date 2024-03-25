package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Api.Api;
import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Model.MerchantStock;
import com.example.exercisejpa.Service.CategoryService;
import com.example.exercisejpa.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchantstock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getAllMS()
    {
        return ResponseEntity.status(200).body(merchantStockService.getAllMS());
    }
    @PostMapping("/add")
    public ResponseEntity addMS(@RequestBody @Valid MerchantStock merchantStock , Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();

        }merchantStockService.addMS(merchantStock);
        return ResponseEntity.status(200).body(new Api(" added"));
    }
    @PutMapping("/up")
    public ResponseEntity updateMS(@PathVariable Integer id, @RequestBody @Valid MerchantStock merchantStock,Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("Up");
        }
        Boolean isUpdate=merchantStockService.updateMS(id,merchantStock);
        if (isUpdate){
            return ResponseEntity.status(200).body(new Api(" Updated"));
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMS(@PathVariable Integer id){
        Boolean isDelete=merchantStockService.DeleteMS(id);
        if (isDelete){
            return ResponseEntity.status(200).body(new Api("delete"));
        }
        return ResponseEntity.status(400).body("Wrong id");
    }
}
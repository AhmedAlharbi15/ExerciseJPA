package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Api.Api;
import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Model.Merchant;
import com.example.exercisejpa.Service.CategoryService;
import com.example.exercisejpa.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getAllm()
    {
        return ResponseEntity.status(200).body(merchantService.getm());
    }
    @PostMapping("/add")
    public ResponseEntity addm(@RequestBody @Valid Merchant merchant , Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();

        }merchantService.addm(merchant);
        return ResponseEntity.status(200).body(new Api(" added"));
    }
    @PutMapping("/up")
    public ResponseEntity updatem(@PathVariable Integer id, @RequestBody @Valid Merchant merchant,Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("Up");
        }
        Boolean isUpdate=merchantService.updatem(id,merchant);
        if (isUpdate){
            return ResponseEntity.status(200).body(new Api(" Updated"));
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletem(@PathVariable Integer id){
        Boolean isDelete=merchantService.Deletem(id);
        if (isDelete){
            return ResponseEntity.status(200).body(new Api("delete"));
        }
        return ResponseEntity.status(400).body("Wrong id");
    }
}

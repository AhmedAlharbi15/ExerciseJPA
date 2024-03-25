package com.example.exercisejpa.Controller;

import com.example.exercisejpa.Api.Api;
import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Model.User;
import com.example.exercisejpa.Service.CategoryService;
import com.example.exercisejpa.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAlluser()
    {
        return ResponseEntity.status(200).body(userService.getAlluser());
    }
    @PostMapping("/add")
    public ResponseEntity adduser(@RequestBody @Valid User user , Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();

        }userService.adduser(user);
        return ResponseEntity.status(200).body(new Api(" added"));
    }
    @PutMapping("/up")
    public ResponseEntity updateuser(@PathVariable Integer id, @RequestBody @Valid User user,Errors errors){
        if (errors.hasErrors()){
            String massage=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("Up");
        }
        Boolean isUpdate=userService.updateuser(id,user);
        if (isUpdate){
            return ResponseEntity.status(200).body(new Api(" Updated"));
        }
        return ResponseEntity.status(400).body("Wrong ID");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteuser(@PathVariable Integer id){
        Boolean isDelete=userService.Deleteuser(id);
        if (isDelete){
            return ResponseEntity.status(200).body(new Api("delete"));
        }
        return ResponseEntity.status(400).body("Wrong id");
    }
}

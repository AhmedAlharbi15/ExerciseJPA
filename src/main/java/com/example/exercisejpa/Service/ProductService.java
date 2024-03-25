package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Model.Product;
import com.example.exercisejpa.Repository.CategoryRepository;
import com.example.exercisejpa.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllpro()
    {
        return productRepository.findAll();
    }

    public void addpro(Product product)
    {
        productRepository.save(product);
    }

    public Boolean updatepro( Integer id,Product product){
        Product p=productRepository.getById(id);
        if (p==null){
            return false;
        }
        p.setName(product.getName());
        p.setCategoryID(product.getCategoryID());
        p.setPrice(product.getPrice());
        return true;
    }
    public Boolean Deletepro(Integer id){
        Product p=productRepository.getById(id);
        if (p ==null){
            return false;
        }
        productRepository.delete(p);
        return true;
    }
}

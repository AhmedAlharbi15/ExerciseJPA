package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Model.Merchant;
import com.example.exercisejpa.Repository.CategoryRepository;
import com.example.exercisejpa.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantService {
    private final MerchantRepository merchantRepository;

    public List<Merchant> getm()
    {
        return merchantRepository.findAll();
    }

    public void addm(Merchant merchant)
    {
        merchantRepository.save(merchant);
    }

    public Boolean updatem( Integer id,Merchant merchant){
        Merchant m=merchantRepository.getById(id);
        if (m==null){
            return false;
        }
        m.setName(merchant.getName());
        return true;
    }
    public Boolean Deletem(Integer id){
        Merchant m=merchantRepository.getById(id);
        if (m ==null){
            return false;
        }
        merchantRepository.delete(m);
        return true;
    }

}

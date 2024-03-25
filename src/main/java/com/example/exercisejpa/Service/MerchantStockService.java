package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.Category;
import com.example.exercisejpa.Model.MerchantStock;
import com.example.exercisejpa.Repository.CategoryRepository;
import com.example.exercisejpa.Repository.MerchantStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final MerchantStockRepository merchantStockRepository;

    public List<MerchantStock> getAllMS()
    {
        return merchantStockRepository.findAll();
    }

    public void addMS(MerchantStock merchantStock)
    {
        merchantStockRepository.save(merchantStock);
    }

    public Boolean updateMS( Integer id,MerchantStock merchantStock){
        MerchantStock MS=merchantStockRepository.getById(id);
        if (MS==null){
            return false;
        }
        MS.setProductid(merchantStock.getProductid());
        MS.setMerchantid(merchantStock.getMerchantid());
        MS.setStock(merchantStock.getStock());
        return true;
    }
    public Boolean DeleteMS(Integer id){
        MerchantStock MS=merchantStockRepository.getById(id);
        if (MS ==null){
            return false;
        }
        merchantStockRepository.delete(MS);
        return true;
    }
}

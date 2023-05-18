package com.docsstorage.docsstorage.Services;

import com.docsstorage.docsstorage.Exceptions.DealNotFoundException;
import com.docsstorage.docsstorage.Models.Deal;
import com.docsstorage.docsstorage.Repos.DealRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DealService {
    @Autowired
    private DealRepo dealRepo;

    public List<Deal> getAllDeals() {
        return dealRepo.findAll();
    }

    public Deal saveDeal(Deal deal){
        return dealRepo.save(deal);
    }

    public Deal getDealById(Integer id){
        return dealRepo.findById(id).orElseThrow(() -> new DealNotFoundException(id));
    }

    public void deleteDeal(Integer id){
        Deal deal = getDealById(id);
        dealRepo.delete(deal);
    }
}

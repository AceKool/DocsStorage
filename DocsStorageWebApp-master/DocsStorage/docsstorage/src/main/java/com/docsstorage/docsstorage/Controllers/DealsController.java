package com.docsstorage.docsstorage.Controllers;

import com.docsstorage.docsstorage.Exceptions.CustomNotFoundException;
import com.docsstorage.docsstorage.Exceptions.DealNotFoundException;
import com.docsstorage.docsstorage.Models.Deal;
import com.docsstorage.docsstorage.Services.DealService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/deals")
public class DealController {
    @Autowired
    private DealService dealService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Deal deal){
        dealService.saveDeal(deal);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<Deal> getAll(){
        return dealService.getAllDeals();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        dealService.deleteDeal(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            Deal deal =dealService.getDealById(id);
            return ResponseEntity.ok(deal);
        }
        catch(DealNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that deal with ID: " + id + " doesn't exist...");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Deal deal, @PathVariable Integer id){
        try{
            Deal _deal = dealService.getDealById(id);
            _deal.updateDeal(deal);
            dealService.saveDeal(_deal);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (DealNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that deal with ID: " + id + " doesn't exist...");
        }
    }
}
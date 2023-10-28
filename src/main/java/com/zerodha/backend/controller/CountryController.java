package com.zerodha.backend.controller;

import java.util.List;

import com.zerodha.backend.persistence.constants.GlobalConstants;
import com.zerodha.backend.persistence.entity.CountryEntity;
import com.zerodha.backend.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GlobalConstants.API_VERSION+"/country")
public class CountryController
{
    @Autowired
    private CountryService countryService;

    @PostMapping
    public CountryEntity create(@RequestBody CountryEntity countryEntity){
        return countryService.create(countryEntity);
    }

    @GetMapping("/{id}")
    public CountryEntity findOne(@PathVariable Integer id){
        return countryService.findOne(id);
    }

    @PatchMapping("/{id}")
    public CountryEntity update(@PathVariable Integer id, @RequestBody CountryEntity countryEntity){
        return countryService.update(id, countryEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        countryService.delete(id);
    }

    @GetMapping
    public List<CountryEntity> findAll(){
        return countryService.findAll();
    }
}

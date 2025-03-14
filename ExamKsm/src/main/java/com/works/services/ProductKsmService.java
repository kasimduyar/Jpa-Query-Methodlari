package com.works.services;


import com.works.entities.ProductKsm;
import com.works.repositories.ProductKsmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductKsmService {

    final ProductKsmRepository productKsmRepository;

    public ProductKsm save (ProductKsm productKsm) {
        productKsmRepository.save(productKsm);
        return productKsm;
    }

    public List<ProductKsm> all () {
        List<ProductKsm> ls = productKsmRepository.findAll();
        return ls;
    }


    public List<ProductKsm> like (String title) {
        return productKsmRepository.findByTitleLikeIgnoreCase("%" + title + "%");

    }

    public List<ProductKsm> notlike (String title) {
        return productKsmRepository.findByTitleNotLikeIgnoreCase("%" + title + "%");
    }

    public List<ProductKsm> starwith (String prefix) {
        return productKsmRepository.findByDescriptionStartsWithIgnoreCase(prefix);
    }

    public List<ProductKsm> notstarwith (String suffix) {
        return productKsmRepository.findByDescriptionEndsWithIgnoreCase(suffix);
    }

    public List<ProductKsm> beetwen (BigDecimal minPrice, BigDecimal maxPrice) {
        return productKsmRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<ProductKsm> tittleandbeetwen(String title, BigDecimal minPrice, BigDecimal maxPrice) {
        return productKsmRepository.findByTitleIgnoreCaseAndPriceBetween(title, minPrice, maxPrice);
    }

    public List<ProductKsm> lessthan(BigDecimal price) {
        return productKsmRepository.findByPriceLessThan(price);
    }

    public List<ProductKsm> greaterthan(BigDecimal price) {
        return productKsmRepository.findByPriceGreaterThan(price);
    }

    public List<ProductKsm> titless(Collection<String> titles) {
        return productKsmRepository.findByTitleInIgnoreCase(titles);

    }

    public List<ProductKsm> notin(Collection<Long> pid) {
        return productKsmRepository.findByPidNotIn(pid);
    }

    public List<ProductKsm> cnull(){
        return productKsmRepository.findByColorNull();
    }



}

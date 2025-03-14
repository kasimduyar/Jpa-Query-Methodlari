package com.works.restcontrollers;


import com.works.entities.ProductKsm;
import com.works.services.ProductKsmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("productksm")
public class ProductKsmRestController {

    final ProductKsmService productKsmService;

    @PostMapping("save")
    public ProductKsm save(@RequestBody ProductKsm productKsm) {
        return productKsmService.save(productKsm);
    }

    @GetMapping("list")
    public List<ProductKsm> list() {
        return productKsmService.all();
    }

    @GetMapping("search")
    public List<ProductKsm> getProductsByTitleLike(@RequestParam String title) {
        return productKsmService.like(title);
    }

    @GetMapping("exclude")
    public List<ProductKsm> getProductsByTitleNotLike(@RequestParam String title) {
        return productKsmService.notlike(title);
    }

    @GetMapping("start")
    public List<ProductKsm> getProductsByDescriptionStartingWith(@RequestParam String prefix) {
        return productKsmService.starwith(prefix);
    }

    @GetMapping("nstart")
    public List<ProductKsm> getProductsByDescriptionEndingWith(@RequestParam String suffix) {
        return productKsmService.notstarwith(suffix);
    }

    @GetMapping("minmax")
    public List<ProductKsm> getProductsByPriceBetween(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
        return productKsmService.beetwen(minPrice, maxPrice);
    }

    @GetMapping("filter")
    public List<ProductKsm> getProductsByTitleAndPriceRangeIgnoreCase(@RequestParam String title,
                                                                      @RequestParam BigDecimal minPrice,
                                                                      @RequestParam BigDecimal maxPrice) {
        return productKsmService.tittleandbeetwen(title, minPrice, maxPrice);
    }

    @GetMapping("inexpensive")
    public List<ProductKsm> getProductsByPriceLessThan(@RequestParam BigDecimal price) {
        return productKsmService.lessthan(price);
    }

    @GetMapping("expensive")
    public List<ProductKsm> getProductsByPriceGreaterThan(@RequestParam BigDecimal price) {
        return productKsmService.greaterthan(price);
    }

    @GetMapping("titles")
    public List<ProductKsm> getProductsByTitles(@RequestParam Collection<String> titles) {
        return productKsmService.titless(titles);
    }

    @GetMapping("pid")
    public List<ProductKsm> getProductsPidNotIn(@RequestParam Collection<Long> pid) {
        return productKsmService.notin(pid);
    }


    @GetMapping("cnull")
    public List<ProductKsm> getProductsWithNullPrice() {
        return productKsmService.cnull();
    }

}

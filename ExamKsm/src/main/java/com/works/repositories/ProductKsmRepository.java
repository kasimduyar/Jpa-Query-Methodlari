package com.works.repositories;

import com.works.entities.ProductKsm;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface ProductKsmRepository extends JpaRepository<ProductKsm, Long> {


    List<ProductKsm> findByTitleLikeIgnoreCase(String title);

    List<ProductKsm> findByTitleNotLikeIgnoreCase(String title);

    List<ProductKsm> findByDescriptionStartsWithIgnoreCase(String description);

    List<ProductKsm> findByDescriptionEndsWithIgnoreCase(String description);

    List<ProductKsm> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<ProductKsm> findByTitleIgnoreCaseAndPriceBetween(String title, BigDecimal minPrice, BigDecimal maxPrice);

    List<ProductKsm> findByPriceLessThan(BigDecimal price);

    List<ProductKsm> findByPriceGreaterThan(BigDecimal price);

    List<ProductKsm> findByTitleInIgnoreCase(Collection<String> titles);

    List<ProductKsm> findByPidNotIn(Collection<Long> pid);

    List<ProductKsm> findByColorNull();







}

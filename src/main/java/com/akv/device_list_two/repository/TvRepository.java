package com.akv.device_list_two.repository;

import com.akv.device_list_two.entity.models.Tv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiConsumer;

public interface TvRepository extends JpaRepository<Tv, Integer>, BaseParamRepository<Tv> {

    @Override
    List<Tv> findAllByNameIgnoreCase(String name);

    @Override
    List<Tv> findAllBySerialIgnoreCase(String serial);

    @Override
    List<Tv> findAllByColorIgnoreCase(String color);

    @Override
    List<Tv> findAllBySize(BigDecimal size);

    @Override
    List<Tv> findAllByPriceBetween(BigDecimal x, BigDecimal y);

    @Override
    List<Tv> findAllByAvailability(boolean availability);

    List<Tv> findAllByCategoryIgnoreCase(String category);

    List<Tv> findAllByTechnologyIgnoreCase(String technology);

    @Override
    List<Tv> findAllByOrderByPriceAsc();

    @Override
    List<Tv> findAllByOrderByPriceDesc();

    @Override
    List<Tv> findAllByOrderByName();
}

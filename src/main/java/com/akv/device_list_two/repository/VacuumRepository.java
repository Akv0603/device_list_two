package com.akv.device_list_two.repository;

import com.akv.device_list_two.entity.models.Vacuum;
import com.akv.device_list_two.services.BaseParamService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface VacuumRepository extends JpaRepository<Vacuum, Integer>, BaseParamRepository<Vacuum> {

    @Override
    List<Vacuum> findAllByNameIgnoreCase(String name);

    @Override
    List<Vacuum> findAllBySerialIgnoreCase(String serial);

    @Override
    List<Vacuum> findAllByColorIgnoreCase(String color);

    @Override
    List<Vacuum> findAllBySize(BigDecimal size);

    @Override
    List<Vacuum> findAllByPriceBetween(BigDecimal x, BigDecimal y);

    @Override
    List<Vacuum> findAllByAvailability(boolean b);

    List<Vacuum> findByCapacity(BigDecimal capacity);

    List<Vacuum> findByMode(Integer mode);

    @Override
    List<Vacuum> findAllByOrderByPriceAsc();

    @Override
    List<Vacuum> findAllByOrderByPriceDesc();

    @Override
    List<Vacuum> findAllByOrderByName();
}

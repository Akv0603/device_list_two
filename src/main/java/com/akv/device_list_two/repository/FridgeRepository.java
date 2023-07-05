package com.akv.device_list_two.repository;

import com.akv.device_list_two.entity.models.Fridge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface FridgeRepository extends JpaRepository<Fridge, Integer>, BaseParamRepository<Fridge> {

    @Override
    List<Fridge> findAllByNameIgnoreCase(String name);

    @Override
    List<Fridge> findAllBySerialIgnoreCase(String serial);

    @Override
    List<Fridge> findAllByColorIgnoreCase(String color);

    @Override
    List<Fridge> findAllBySize(BigDecimal size);

    @Override
    List<Fridge> findAllByPriceBetween(BigDecimal x, BigDecimal y);

    @Override
    List<Fridge> findAllByAvailability(boolean b);

    List<Fridge> findAllByDoorCount(Integer door);

    List<Fridge> findAllByCompressorIgnoreCase(String compressor);

    @Override
    List<Fridge> findAllByOrderByPriceAsc();

    @Override
    List<Fridge> findAllByOrderByPriceDesc();

    @Override
    List<Fridge> findAllByOrderByName();
}

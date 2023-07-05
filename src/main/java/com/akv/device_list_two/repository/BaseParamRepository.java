package com.akv.device_list_two.repository;

import com.akv.device_list_two.entity.models.BaseParam;

import java.math.BigDecimal;
import java.util.List;

public interface BaseParamRepository<T extends BaseParam>{
    List<T> findAllByNameIgnoreCase(String name);

    List<T> findAllBySerialIgnoreCase(String serial);

    List<T> findAllByColorIgnoreCase(String color);

    List<T> findAllBySize(BigDecimal size);

    List<T> findAllByPriceBetween(BigDecimal x, BigDecimal y);

    List<T> findAllByAvailability(boolean b);

    List<T> findAllByOrderByPriceAsc();

    List<T> findAllByOrderByPriceDesc();

    List<T> findAllByOrderByName();

}

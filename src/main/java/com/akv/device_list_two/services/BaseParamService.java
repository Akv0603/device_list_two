package com.akv.device_list_two.services;

import com.akv.device_list_two.entity.models.BaseParam;

import java.math.BigDecimal;
import java.util.List;

public interface BaseParamService<T extends BaseParam> {

    List<T> getByNameIgnoreCase(String name);

    List<T> getBySerialIgnoreCase(String serial);

    List<T> getByColorIgnoreCase(String color);

    List<T> getBySize(BigDecimal size);

    List<T> getByPriceBetween(BigDecimal x, BigDecimal y);

    List<T> getByAvailability(boolean b);

    List<T> SortedByPriceAsc();

    List<T> SortedByPriceDesc();

    List<T> SortedByName();
}

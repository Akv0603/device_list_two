package com.akv.device_list_two.repository;

import com.akv.device_list_two.entity.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Integer>, BaseParamRepository<Phone> {

    @Override
    List<Phone> findAllByNameIgnoreCase(String name);

    @Override
    List<Phone> findAllBySerialIgnoreCase(String serial);

    @Override
    List<Phone> findAllByColorIgnoreCase(String color);

    @Override
    List<Phone> findAllBySize(BigDecimal size);

    @Override
    List<Phone> findAllByPriceBetween(BigDecimal x, BigDecimal y);

    @Override
    List<Phone> findAllByAvailability(boolean b);

    List<Phone> findAllByMemory(Integer memory);

    List<Phone> findAllByCamera(Integer camera);

    @Override
    List<Phone> findAllByOrderByPriceAsc();

    @Override
    List<Phone> findAllByOrderByPriceDesc();

    @Override
    List<Phone> findAllByOrderByName();
}

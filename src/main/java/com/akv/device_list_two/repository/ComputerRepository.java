package com.akv.device_list_two.repository;

import com.akv.device_list_two.entity.models.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Integer>, BaseParamRepository<Computer> {

    @Override
    List<Computer> findAllByNameIgnoreCase(String name);

    @Override
    List<Computer> findAllBySerialIgnoreCase(String serial);

    @Override
    List<Computer> findAllByColorIgnoreCase(String color);

    @Override
    List<Computer> findAllBySize(BigDecimal size);

    @Override
    List<Computer> findAllByPriceBetween(BigDecimal x, BigDecimal y);

    @Override
    List<Computer> findAllByAvailability(boolean b);

    List<Computer> findAllByCategoryIgnoreCase(String category);

    List<Computer> findAllByProcessorIgnoreCase(String processor);

    @Override
    List<Computer> findAllByOrderByPriceAsc();

    @Override
    List<Computer> findAllByOrderByPriceDesc();

    @Override
    List<Computer> findAllByOrderByName();
}

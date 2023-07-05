package com.akv.device_list_two.repository;

import com.akv.device_list_two.entity.Device;
import com.akv.device_list_two.entity.models.BaseParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    List<Device> findByNameIgnoreCase(String name);

    List<Device> findByCountryIgnoreCase(String country);

    List<Device> findByManufacturerIgnoreCase(String manufacturer);

    List<Device> findByOnlineOrder(Boolean b);

    List<Device> findByInstallment(Boolean b);


    List<Device> findAllByOrderByNameAsc();

}

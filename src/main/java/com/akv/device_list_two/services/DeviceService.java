package com.akv.device_list_two.services;

import com.akv.device_list_two.entity.Device;
import com.akv.device_list_two.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;


    public List<Device> getAll(){
        return deviceRepository.findAll();
    }

    public void saveDevice(Device device){
        deviceRepository.save(device);
    }

    public void deleteDevice(Integer deviceId){
        deviceRepository.deleteById(deviceId);
    }

    public List<Device> getByName(String name){
        return deviceRepository.findByNameIgnoreCase(name);
    }

    public List<Device> getByCountry(String country){
        return deviceRepository.findByCountryIgnoreCase(country);
    }

    public List<Device> getByManufacturer(String manufacturer){
        return deviceRepository.findByManufacturerIgnoreCase(manufacturer);
    }

    public List<Device> getByOnlineOrder(Boolean b){
        return deviceRepository.findByOnlineOrder(b);
    }

    public List<Device> getByInstallment(Boolean b){
        return deviceRepository.findByInstallment(b);
    }

    public List<Device> sortName(){
        return deviceRepository.findAllByOrderByNameAsc();
    }

}

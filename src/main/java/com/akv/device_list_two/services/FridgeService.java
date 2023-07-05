package com.akv.device_list_two.services;

import com.akv.device_list_two.entity.Device;
import com.akv.device_list_two.entity.models.Fridge;
import com.akv.device_list_two.exceptions.DeviceNotFoundException;
import com.akv.device_list_two.repository.DeviceRepository;
import com.akv.device_list_two.repository.FridgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FridgeService implements BaseParamService<Fridge> {

    @Autowired
    private FridgeRepository fridgeRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Fridge> getAll(){
        return fridgeRepository.findAll();
    }

    public Fridge saveFridge(Integer deviceId, Fridge fridge){
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new DeviceNotFoundException(deviceId));
        fridge.setDevice(device);
        return fridgeRepository.save(fridge);
    }

    public void deleteFridge(Integer fridgeId){
        fridgeRepository.deleteById(fridgeId);
    }

    @Override
    public List<Fridge> getByNameIgnoreCase(String name) {
        return fridgeRepository.findAllByNameIgnoreCase(name);
    }

    @Override
    public List<Fridge> getBySerialIgnoreCase(String serial) {
        return fridgeRepository.findAllBySerialIgnoreCase(serial);
    }

    @Override
    public List<Fridge> getByColorIgnoreCase(String color) {
        return fridgeRepository.findAllByColorIgnoreCase(color);
    }

    @Override
    public List<Fridge> getBySize(BigDecimal size) {
        return fridgeRepository.findAllBySize(size);
    }

    @Override
    public List<Fridge> getByPriceBetween(BigDecimal x, BigDecimal y) {
        return fridgeRepository.findAllByPriceBetween(x, y);
    }

    @Override
    public List<Fridge> getByAvailability(boolean b) {
        return fridgeRepository.findAllByAvailability(b);
    }

    public List<Fridge> getByDoorCount(Integer doorCount) {
        return fridgeRepository.findAllByDoorCount(doorCount);
    }

    public List<Fridge> getByCompressorIgnoreCase(String compressor) {
        return fridgeRepository.findAllByCompressorIgnoreCase(compressor);
    }

    @Override
    public List<Fridge> SortedByPriceAsc() {
        return fridgeRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Fridge> SortedByPriceDesc() {
        return fridgeRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Fridge> SortedByName() {
        return fridgeRepository.findAllByOrderByName();
    }
}

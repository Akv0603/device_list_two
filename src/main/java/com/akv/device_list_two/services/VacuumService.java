package com.akv.device_list_two.services;

import com.akv.device_list_two.entity.Device;
import com.akv.device_list_two.entity.models.Vacuum;
import com.akv.device_list_two.exceptions.DeviceNotFoundException;
import com.akv.device_list_two.repository.DeviceRepository;
import com.akv.device_list_two.repository.VacuumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class VacuumService implements BaseParamService<Vacuum> {

    @Autowired
    private VacuumRepository vacuumRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public Vacuum saveVacuum(Integer deviceId, Vacuum vacuum){
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new DeviceNotFoundException(deviceId));
        vacuum.setDevice(device);
        return vacuumRepository.save(vacuum);
    }

    public void deleteVacuum(Integer vacuumId){
        vacuumRepository.deleteById(vacuumId);
    }

    public List<Vacuum> getAll(){
        return vacuumRepository.findAll();
    }

    @Override
    public List<Vacuum> getByNameIgnoreCase(String name) {
        return vacuumRepository.findAllByNameIgnoreCase(name);
    }

    @Override
    public List<Vacuum> getBySerialIgnoreCase(String serial) {
        return vacuumRepository.findAllBySerialIgnoreCase(serial);
    }

    @Override
    public List<Vacuum> getByColorIgnoreCase(String color) {
        return vacuumRepository.findAllByColorIgnoreCase(color);
    }

    @Override
    public List<Vacuum> getBySize(BigDecimal size) {
        return vacuumRepository.findAllBySize(size);
    }

    @Override
    public List<Vacuum> getByPriceBetween(BigDecimal x, BigDecimal y) {
        return vacuumRepository.findAllByPriceBetween(x, y);
    }

    @Override
    public List<Vacuum> getByAvailability(boolean b) {
        return vacuumRepository.findAllByAvailability(b);
    }

    public List<Vacuum> getByCapacity(BigDecimal capacity) {
        return vacuumRepository.findByCapacity(capacity);
    }

    public List<Vacuum> getByMode(Integer mode) {
        return vacuumRepository.findByMode(mode);
    }

    @Override
    public List<Vacuum> SortedByPriceAsc() {
        return vacuumRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Vacuum> SortedByPriceDesc() {
        return vacuumRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Vacuum> SortedByName() {
        return vacuumRepository.findAllByOrderByName();
    }
}

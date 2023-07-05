package com.akv.device_list_two.services;

import com.akv.device_list_two.entity.Device;
import com.akv.device_list_two.entity.models.Phone;
import com.akv.device_list_two.exceptions.DeviceNotFoundException;
import com.akv.device_list_two.repository.DeviceRepository;
import com.akv.device_list_two.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PhoneService implements BaseParamService<Phone> {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Phone> getAll(){
        return phoneRepository.findAll();
    }

    public Phone savePhone(Integer deviceId, Phone phone){
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new DeviceNotFoundException(deviceId));
        phone.setDevice(device);
        return phoneRepository.save(phone);
    }

    public void deletePhone(Integer phoneId){
        phoneRepository.deleteById(phoneId);
    }

    @Override
    public List<Phone> getByNameIgnoreCase(String name) {
        return phoneRepository.findAllByNameIgnoreCase(name);
    }

    @Override
    public List<Phone> getBySerialIgnoreCase(String serial) {
        return phoneRepository.findAllBySerialIgnoreCase(serial);
    }

    @Override
    public List<Phone> getByColorIgnoreCase(String color) {
        return phoneRepository.findAllByColorIgnoreCase(color);
    }

    @Override
    public List<Phone> getBySize(BigDecimal size) {
        return phoneRepository.findAllBySize(size);
    }

    @Override
    public List<Phone> getByPriceBetween(BigDecimal x, BigDecimal y) {
        return phoneRepository.findAllByPriceBetween(x, y);
    }

    @Override
    public List<Phone> getByAvailability(boolean b) {
        return phoneRepository.findAllByAvailability(b);
    }

    public List<Phone> getByMemory(Integer memory) {
        return phoneRepository.findAllByMemory(memory);
    }

    public List<Phone> getByCamera(Integer camera) {
        return phoneRepository.findAllByCamera(camera);
    }

    @Override
    public List<Phone> SortedByPriceAsc() {
        return phoneRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Phone> SortedByPriceDesc() {
        return phoneRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Phone> SortedByName() {
        return phoneRepository.findAllByOrderByName();
    }
}

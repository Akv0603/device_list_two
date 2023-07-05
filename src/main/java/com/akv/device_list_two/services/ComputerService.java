package com.akv.device_list_two.services;

import com.akv.device_list_two.entity.Device;
import com.akv.device_list_two.entity.models.Computer;
import com.akv.device_list_two.exceptions.DeviceNotFoundException;
import com.akv.device_list_two.repository.ComputerRepository;
import com.akv.device_list_two.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ComputerService implements BaseParamService<Computer> {

    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Computer> getAll(){
        return computerRepository.findAll();
    }

    public Computer saveComputer(Integer deviceId, Computer computer){
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new DeviceNotFoundException(deviceId));
        computer.setDevice(device);
        return computerRepository.save(computer);
    }

    public void deleteComputer(Integer computerId){
        computerRepository.deleteById(computerId);
    }

    @Override
    public List<Computer> getByNameIgnoreCase(String name) {
        return computerRepository.findAllByNameIgnoreCase(name);
    }

    @Override
    public List<Computer> getBySerialIgnoreCase(String serial) {
        return computerRepository.findAllBySerialIgnoreCase(serial);
    }

    @Override
    public List<Computer> getByColorIgnoreCase(String color) {
        return computerRepository.findAllByColorIgnoreCase(color);
    }

    @Override
    public List<Computer> getBySize(BigDecimal size) {
        return computerRepository.findAllBySize(size);
    }

    @Override
    public List<Computer> getByPriceBetween(BigDecimal x, BigDecimal y) {
        return computerRepository.findAllByPriceBetween(x, y);
    }

    @Override
    public List<Computer> getByAvailability(boolean b) {
        return computerRepository.findAllByAvailability(b);
    }


    public List<Computer> getByCategoryIgnoreCase(String category) {
        return computerRepository.findAllByCategoryIgnoreCase(category);
    }

    public List<Computer> getByProcessorIgnoreCase(String processor) {
        return computerRepository.findAllByProcessorIgnoreCase(processor);
    }

    @Override
    public List<Computer> SortedByPriceAsc() {
        return computerRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Computer> SortedByPriceDesc() {
        return computerRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Computer> SortedByName() {
        return computerRepository.findAllByOrderByName();
    }
}

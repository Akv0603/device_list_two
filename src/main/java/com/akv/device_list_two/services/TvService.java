package com.akv.device_list_two.services;

import com.akv.device_list_two.entity.Device;
import com.akv.device_list_two.entity.models.Tv;
import com.akv.device_list_two.exceptions.DeviceNotFoundException;
import com.akv.device_list_two.repository.DeviceRepository;
import com.akv.device_list_two.repository.TvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TvService implements BaseParamService<Tv> {

    @Autowired
    private TvRepository tvRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Tv> getAll(){
        return tvRepository.findAll();
    }

    public void saveTv(Integer deviceId, Tv tv){
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new DeviceNotFoundException(deviceId));
        tv.setDevice(device);
        tvRepository.save(tv);
    }

    public void deleteTv(Integer tvId){
        tvRepository.deleteById(tvId);
    }

    public List<Tv> getTvCategory(String category){
        return tvRepository.findAllByCategoryIgnoreCase(category);
    }

    public List<Tv> getTvTechnology(String technology){
        return tvRepository.findAllByTechnologyIgnoreCase(technology);
    }

    @Override
    public List<Tv> getByNameIgnoreCase(String name) {
        return tvRepository.findAllByNameIgnoreCase(name);
    }

    @Override
    public List<Tv> getBySerialIgnoreCase(String serial) {
        return tvRepository.findAllBySerialIgnoreCase(serial);
    }

    @Override
    public List<Tv> getByColorIgnoreCase(String color) {
        return tvRepository.findAllByColorIgnoreCase(color);
    }

    @Override
    public List<Tv> getBySize(BigDecimal size) {
        return tvRepository.findAllBySize(size);
    }

    @Override
    public List<Tv> getByPriceBetween(BigDecimal x, BigDecimal y) {
        return tvRepository.findAllByPriceBetween(x, y);
    }

    @Override
    public List<Tv> getByAvailability(boolean b) {
        return tvRepository.findAllByAvailability(b);
    }

    @Override
    public List<Tv> SortedByPriceAsc() {
        return tvRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Tv> SortedByPriceDesc() {
        return tvRepository.findAllByOrderByPriceDesc();
    }

    @Override
    public List<Tv> SortedByName() {
        return tvRepository.findAllByOrderByName();
    }
}

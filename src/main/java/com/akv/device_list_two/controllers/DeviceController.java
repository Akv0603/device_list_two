package com.akv.device_list_two.controllers;

import com.akv.device_list_two.entity.Device;
import com.akv.device_list_two.entity.models.BaseParam;
import com.akv.device_list_two.services.DeviceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/device")
@Tag(name = "Устройства", description = "Общий контроллер")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    @Operation(summary = "Показать все устройства")
    public List<Device> showAll(){
        List<Device> allDevice = deviceService.getAll();
        return allDevice;
    }

    @PostMapping
    @Operation(summary = "Добавить новое устройство. Тело запроса без указания id устройства. например:" +
            "{\n" +
            "    \"name\": \"Телевизор\",\n" +
            "    \"country\": \"Япония\",\n" +
            "    \"manufacturer\": \"Sony\",\n" +
            "    \"onlineOrder\": true,\n" +
            "    \"installment\": false\n" +
            "}")

    public Device addNewDevice(@RequestBody Device device){
        deviceService.saveDevice(device);
        return device;
    }

    @PutMapping
    @Operation(summary = "Изменить устройство. Тело запроса с указанием Id устройства, которое нужно изменить например:" +
            "{\n" +
            "    \"id\": 16,\n" +
            "    \"name\": \"Телевизор\",\n" +
            "    \"country\": \"Япония\",\n" +
            "    \"manufacturer\": \"Sony\",\n" +
            "    \"onlineOrder\": true,\n" +
            "    \"installment\": false\n" +
            "}")
    public Device UpdateDevice(@RequestBody Device device){
        deviceService.saveDevice(device);
        return device;
    }

    @DeleteMapping("/{deviceId}")
    @Operation(summary = "Удалить устройство по id")
    public String DeleteDevice(@PathVariable Integer deviceId){
        deviceService.deleteDevice(deviceId);
        return "Устройство под номером " + deviceId + " удалено.";
    }


    @GetMapping("/filter")
    @Operation(summary = "Фильтр: тип устройств, страна, производитель, онлайн заказ(да/нет), рассрочка(да/нет)")
    public List<Device> filteredDevice(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "country", required = false) String country,
                                       @RequestParam(value = "manufacturer", required = false) String manufacturer,
                                       @RequestParam(value = "onlineOrder", required = false) Boolean onlineOrder,
                                       @RequestParam(value = "installment", required = false) Boolean installment){

        if(name != null){
            return deviceService.getByName(name);
        }
        if(country != null){
            return deviceService.getByCountry(country);
        }

        if(manufacturer != null){
            return deviceService.getByManufacturer(manufacturer);
        }

        if(onlineOrder != null){
            return deviceService.getByOnlineOrder(onlineOrder);
        }

        if(installment != null){
            return deviceService.getByInstallment(installment);
        }
        return deviceService.getAll();
    }

    @GetMapping("/sort")
    @Operation(summary = "Сортировка типов устройств по алфавиту")
    public List<Device> sortPrice(){
        return deviceService.sortName();
    }

}


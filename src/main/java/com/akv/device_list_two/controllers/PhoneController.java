package com.akv.device_list_two.controllers;

import com.akv.device_list_two.entity.models.Phone;
import com.akv.device_list_two.services.PhoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/phone")
@Tag(name = "Смартфоны", description = "Контроллер для смартфонов")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping("/{deviceId}")
    @Operation(summary = "Добавить новый Смартфон(не указывая id в теле)")
    public Phone addNewPhone(@RequestBody Phone phone, @PathVariable Integer deviceId){
        phoneService.savePhone(deviceId, phone);
        return phone;
    }

    @PutMapping("/{deviceId}")
    @Operation(summary = "Изменить Смартфон")
    public Phone updatePhone(@PathVariable Integer deviceId, @RequestBody Phone phone){
        phoneService.savePhone(deviceId, phone);
        return phone;
    }

    @DeleteMapping("/{phoneId}")
    @Operation(summary = "Удалить Смартфон по id")
    public String deletePhone(@PathVariable Integer phoneId){
        phoneService.deletePhone(phoneId);
        return "Смартфон удален.";
    }

    @GetMapping("/filter")
    @Operation(summary = "Фильтр: Название(name), cерийный номер(serial), цвет(color), размер(size), цена(от p1/до p2)(price), наличие(true/false)(availability)," +
            " память(memory), кол-во камер(camera). Иначе возвращается пустой массив(либо весь список(закомментирован))")
    public List<Phone> filterPhoneByAllParams(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String serial,
            @RequestParam(required = false) BigDecimal size,
            @RequestParam(required = false) BigDecimal p1, @RequestParam(required = false) BigDecimal p2,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Boolean availability,
            @RequestParam(required = false) Integer memory,
            @RequestParam(required = false) Integer camera) {


        if(name != null){
            return phoneService.getByNameIgnoreCase(name);
        }
        if(serial != null){
            return phoneService.getBySerialIgnoreCase(serial);
        }

        if(size != null){
            return phoneService.getBySize(size);
        }

        if(p1 != null && p2 != null){
            return phoneService.getByPriceBetween(p1, p2);
        }

        if(color != null){
            return phoneService.getByColorIgnoreCase(color);
        }

        if(availability != null){
            return phoneService.getByAvailability(availability);
        }

        if(memory != null){
            return phoneService.getByMemory(memory);
        }
        if(camera != null){
            return phoneService.getByCamera(camera);
        }
//        return phoneService.getAll();
        return new ArrayList<>(0);
    }

    @GetMapping("/sorted/asc")
    @Operation(summary = "Сортировка по возрастанию цены")
    public List<Phone> sortedByPriceAsc(){
        return phoneService.SortedByPriceAsc();
    }

    @GetMapping("/sorted/desc")
    @Operation(summary = "Сортировка по убыванию цены")
    public List<Phone> sortedByPriceDesc(){
        return phoneService.SortedByPriceDesc();
    }

    @GetMapping("/sorted/name")
    @Operation(summary = "Сортировка названий по алфавиту")
    public List<Phone> sortedByName(){
        return phoneService.SortedByName();
    }
}

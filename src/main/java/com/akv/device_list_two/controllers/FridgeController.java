package com.akv.device_list_two.controllers;

import com.akv.device_list_two.entity.models.Fridge;
import com.akv.device_list_two.services.FridgeService;
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
@RequestMapping("/fridge")
@Tag(name = "Холодильники", description = "Контроллер для холодильников")
public class FridgeController {

    @Autowired
    private FridgeService fridgeService;

    @PostMapping("/{deviceId}")
    @Operation(summary = "Добавить новый холодильник(не указывая id в теле)")
    public Fridge addNewFridge(@RequestBody Fridge fridge, @PathVariable Integer deviceId){
        fridgeService.saveFridge(deviceId, fridge);
        return fridge;
    }

    @PutMapping("/{deviceId}")
    @Operation(summary = "Изменить холодильник")
    public Fridge updateFridge(@PathVariable Integer deviceId, @RequestBody Fridge fridge){
        fridgeService.saveFridge(deviceId, fridge);
        return fridge;
    }

    @DeleteMapping("/{fridgeId}")
    @Operation(summary = "Удалить холодильник по id")
    public String deleteFridge(@PathVariable Integer fridgeId){
        fridgeService.deleteFridge(fridgeId);
        return "Холодильник удален.";
    }

    @GetMapping("/filter")
    @Operation(summary = "Фильтр: Название(name), cерийный номер(serial), цвет(color), объем камеры(size), цена(от p1/до p2)(price), наличие(true/false)(availability)," +
            " кол-во дверей(doorCount), тип компрессора(compressor). Иначе возвращается пустой массив(либо весь список(закомментирован))")
    public List<Fridge> filterFridgeByAllParams(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String serial,
            @RequestParam(required = false) BigDecimal size,
            @RequestParam(required = false) BigDecimal p1, @RequestParam(required = false) BigDecimal p2,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Boolean availability,
            @RequestParam(required = false) Integer doorCount,
            @RequestParam(required = false) String compressor) {


        if(name != null){
            return fridgeService.getByNameIgnoreCase(name);
        }
        if(serial != null){
            return fridgeService.getBySerialIgnoreCase(serial);
        }

        if(size != null){
            return fridgeService.getBySize(size);
        }

        if(p1 != null && p2 != null){
            return fridgeService.getByPriceBetween(p1, p2);
        }

        if(color != null){
            return fridgeService.getByColorIgnoreCase(color);
        }

        if(availability != null){
            return fridgeService.getByAvailability(availability);
        }

        if(doorCount != null){
            return fridgeService.getByDoorCount(doorCount);
        }
        if(compressor != null){
            return fridgeService.getByCompressorIgnoreCase(compressor);
        }
//        return fridgeService.getAll();
        return new ArrayList<>(0);
    }

    @GetMapping("/sorted/asc")
    @Operation(summary = "Сортировка по возрастанию цены")
    public List<Fridge> sortedByPriceAsc(){
        return fridgeService.SortedByPriceAsc();
    }

    @GetMapping("/sorted/desc")
    @Operation(summary = "Сортировка по убыванию цены")
    public List<Fridge> sortedByPriceDesc(){
        return fridgeService.SortedByPriceDesc();
    }

    @GetMapping("/sorted/name")
    @Operation(summary = "Сортировка названий по алфавиту")
    public List<Fridge> sortedByName(){
        return fridgeService.SortedByName();
    }
}

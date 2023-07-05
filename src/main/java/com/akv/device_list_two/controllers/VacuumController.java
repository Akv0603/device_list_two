package com.akv.device_list_two.controllers;

import com.akv.device_list_two.entity.models.Vacuum;
import com.akv.device_list_two.services.VacuumService;
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
@RequestMapping("/vacuum")
@Tag(name = "Пылесосы", description = "Контроллер для пылесосов")
public class VacuumController {

    @Autowired
    private VacuumService vacuumService;

    @PostMapping("/{deviceId}")
    @Operation(summary = "Добавить новый пылесос(не указывая id в теле)")
    public Vacuum addNewVacuum(@RequestBody Vacuum vacuum, @PathVariable Integer deviceId){
        vacuumService.saveVacuum(deviceId, vacuum);
        return vacuum;
    }

    @PutMapping("/{deviceId}")
    @Operation(summary = "Изменить пылесос")
    public Vacuum updateVacuum(@PathVariable Integer deviceId, @RequestBody Vacuum vacuum){
        vacuumService.saveVacuum(deviceId, vacuum);
        return vacuum;
    }

    @DeleteMapping("/{vacuumId}")
    @Operation(summary = "Удалить пылесос по id")
    public String deleteVacuum(@PathVariable Integer vacuumId){
        vacuumService.deleteVacuum(vacuumId);
        return "Пылесос удален.";
    }

    @GetMapping("/filter")
    @Operation(summary = "Фильтр: Название(name), cерийный номер(serial), цвет(color), вес(size), цена(от p1/до p2)(price), наличие(true/false)(availability)," +
            " объем мешка(capacity), режимы(mode). Иначе возвращается пустой массив(либо весь список(закомментировано))")
    public List<Vacuum> filterVacuumByAllParams(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String serial,
            @RequestParam(required = false) BigDecimal size,
            @RequestParam(required = false) BigDecimal p1, @RequestParam(required = false) BigDecimal p2,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Boolean availability,
            @RequestParam(required = false) BigDecimal capacity,
            @RequestParam(required = false) Integer mode) {


        if(name != null){
            return vacuumService.getByNameIgnoreCase(name);
        }
        if(serial != null){
            return vacuumService.getBySerialIgnoreCase(serial);
        }

        if(size != null){
            return vacuumService.getBySize(size);
        }

        if(p1 != null && p2 != null){
            return vacuumService.getByPriceBetween(p1, p2);
        }

        if(color != null){
            return vacuumService.getByColorIgnoreCase(color);
        }

        if(availability != null){
            return vacuumService.getByAvailability(availability);
        }

        if(capacity != null){
            return vacuumService.getByCapacity(capacity);
        }
        if(mode != null){
            return vacuumService.getByMode(mode);
        }
//        return vacuumService.getAll();
        return new ArrayList<>(0);
    }

    @GetMapping("/sorted/asc")
    @Operation(summary = "Сортировка по возрастанию цены")
    public List<Vacuum> sortedByPriceAsc(){
        return vacuumService.SortedByPriceAsc();
    }

    @GetMapping("/sorted/desc")
    @Operation(summary = "Сортировка по убыванию цены")
    public List<Vacuum> sortedByPriceDesc(){
        return vacuumService.SortedByPriceDesc();
    }

    @GetMapping("/sorted/name")
    @Operation(summary = "Сортировка названий по алфавиту")
    public List<Vacuum> sortedByName(){
        return vacuumService.SortedByName();
    }
}

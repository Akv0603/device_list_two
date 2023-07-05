package com.akv.device_list_two.controllers;

import com.akv.device_list_two.entity.models.Tv;
import com.akv.device_list_two.services.TvService;
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
@RequestMapping("/tv")
@Tag(name = "Телевизоры", description = "Контроллер для телевизоров")
public class TvController {

    @Autowired
    private TvService tvService;


    @PostMapping("/{deviceId}")
    @Operation(summary = "Добавить новый телевизор(не указывая id в теле)")
    public Tv addNewTv(@RequestBody Tv tv, @PathVariable Integer deviceId){
        tvService.saveTv(deviceId, tv);
        return tv;
    }

    @PutMapping("/{deviceId}")
    @Operation(summary = "Изменить телевизор")
    public Tv updateTv(@PathVariable Integer deviceId, @RequestBody Tv tv){
        tvService.saveTv(deviceId, tv);
        return tv;
    }

    @DeleteMapping("/{tvId}")
    @Operation(summary = "Удалить телевизор по id")
    public String deleteTv(@PathVariable Integer tvId){
        tvService.deleteTv(tvId);
        return "Телевизор удален.";
    }

    @GetMapping("/filter")
    @Operation(summary = "Фильтр: Название(name), cерийный номер(serial), цвет(color), размер(size)," +
            " цена(от p1/до p2)(price), наличие(true/false)(availability)," +
            " категория(category), технология(technology). Иначе возвращается пустой массив(либо весь список tv(закомментирован))")
    public List<Tv> filterTvByAllParams(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String serial,
            @RequestParam(required = false) BigDecimal size,
            @RequestParam(required = false) BigDecimal p1, @RequestParam(required = false) BigDecimal p2,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Boolean availability,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String technology) {


        if(name != null){
            return tvService.getByNameIgnoreCase(name);
        }
        if(serial != null){
            return tvService.getBySerialIgnoreCase(serial);
        }

        if(size != null){
            return tvService.getBySize(size);
        }

        if(p1 != null && p2 != null){
            return tvService.getByPriceBetween(p1, p2);
        }

        if(color != null){
            return tvService.getByColorIgnoreCase(color);
        }

        if(availability != null){
            return tvService.getByAvailability(availability);
        }

        if(category != null){
            return tvService.getTvCategory(category);
        }
        if(technology != null){
            return tvService.getTvTechnology(technology);
        }
//        return tvService.getAll();
        return new ArrayList<>(0);
    }

    @GetMapping("/sorted/asc")
    @Operation(summary = "Сортировка по возрастанию цены")
    public List<Tv> sortedByPriceAsc(){
        return tvService.SortedByPriceAsc();
    }

    @GetMapping("/sorted/desc")
    @Operation(summary = "Сортировка по убыванию цены")
    public List<Tv> sortedByPriceDesc(){
        return tvService.SortedByPriceDesc();
    }

    @GetMapping("/sorted/name")
    @Operation(summary = "Сортировка названий по алфавиту")
    public List<Tv> sortedByName(){
        return tvService.SortedByName();
    }
}

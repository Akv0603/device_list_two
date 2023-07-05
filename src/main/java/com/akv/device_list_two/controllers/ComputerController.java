package com.akv.device_list_two.controllers;

import com.akv.device_list_two.entity.models.Computer;
import com.akv.device_list_two.services.ComputerService;
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
@RequestMapping("/computer")
@Tag(name = "Компьютеры", description = "Контроллер для компьютеров")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @PostMapping("/{deviceId}")
    @Operation(summary = "Добавить новый компьютер (не указывая id в теле)")
    public Computer addNewTv(@RequestBody Computer computer, @PathVariable Integer deviceId){
        computerService.saveComputer(deviceId, computer);
        return computer;
    }

    @PutMapping("/{deviceId}")
    @Operation(summary = "Изменить компьютер")
    public Computer updateTv(@PathVariable Integer deviceId, @RequestBody Computer computer){
        computerService.saveComputer(deviceId, computer);
        return computer;
    }

    @DeleteMapping("/{computerId}")
    @Operation(summary = "Удалить компьютер по id")
    public String deleteTv(@PathVariable Integer computerId){
        computerService.deleteComputer(computerId);
        return "Компьютер удален.";
    }

    @GetMapping("/filter")
    @Operation(summary = "Фильтр: Название(name), cерийный номер(serial), цвет(color), объем оперативки(size), цена(от p1/до p2)(price), наличие(true/false)(availability)," +
            " категория(category), процессор(processor). Иначе возвращается пустой массив(либо весь список(закомментирован))")
    public List<Computer> filterComputerByCAllParams(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String serial,
            @RequestParam(required = false) BigDecimal size,
            @RequestParam(required = false) BigDecimal p1, @RequestParam(required = false) BigDecimal p2,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Boolean availability,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String processor) {


        if(name != null){
            return computerService.getByNameIgnoreCase(name);
        }
        if(serial != null){
            return computerService.getBySerialIgnoreCase(serial);
        }

        if(size != null){
            return computerService.getBySize(size);
        }

        if(p1 != null && p2 != null){
            return computerService.getByPriceBetween(p1, p2);
        }

        if(color != null){
            return computerService.getByColorIgnoreCase(color);
        }

        if(availability != null){
            return computerService.getByAvailability(availability);
        }

        if(category != null){
            return computerService.getByCategoryIgnoreCase(category);
        }
        if(processor != null){
            return computerService.getByProcessorIgnoreCase(processor);
        }
//        return computerService.getAll();
        return new ArrayList<>(0);
    }

    @GetMapping("/sorted/asc")
    @Operation(summary = "Сортировка по возрастанию цены")
    public List<Computer> sortedByPriceAsc(){
        return computerService.SortedByPriceAsc();
    }

    @GetMapping("/sorted/desc")
    @Operation(summary = "Сортировка по убыванию цены")
    public List<Computer> sortedByPriceDesc(){
        return computerService.SortedByPriceDesc();
    }

    @GetMapping("/sorted/name")
    @Operation(summary = "Сортировка названий по алфавиту")
    public List<Computer> sortedByName(){
        return computerService.SortedByName();
    }
}

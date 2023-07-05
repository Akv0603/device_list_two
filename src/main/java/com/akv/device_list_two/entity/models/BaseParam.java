package com.akv.device_list_two.entity.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String serial;

    private String color;

    private BigDecimal size;

    private BigDecimal price;

    private boolean availability;
}

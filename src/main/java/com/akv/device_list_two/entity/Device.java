package com.akv.device_list_two.entity;

import com.akv.device_list_two.entity.models.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    private String manufacturer;

    @Column(name = "online_order")
    private boolean onlineOrder;

    private boolean installment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<Tv> tvs;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<Vacuum> vacuums;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<Phone> phones;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<Fridge> fridges;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "device")
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private List<Computer> computers;
}

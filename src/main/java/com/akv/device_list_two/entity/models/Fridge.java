package com.akv.device_list_two.entity.models;

import com.akv.device_list_two.entity.Device;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "fridge")
public class Fridge extends BaseParam {

    @Column(name = "door_count")
    private Integer doorCount;

    private String compressor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "device_id", nullable = false)
    @JsonIgnore
    private Device device;

}

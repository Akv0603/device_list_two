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
@Table(name = "phone")
public class Phone extends BaseParam {

    private Integer memory;

    private Integer camera;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "device_id", nullable = false)
    @JsonIgnore
    private Device device;

}

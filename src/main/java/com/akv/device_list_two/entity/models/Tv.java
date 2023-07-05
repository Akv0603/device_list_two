package com.akv.device_list_two.entity.models;

import com.akv.device_list_two.entity.Device;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@Table(name = "tv")
public class Tv extends BaseParam {

    private String category;

    private String technology;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "device_id", nullable = false)
    @JsonIgnore
    private Device device;

}

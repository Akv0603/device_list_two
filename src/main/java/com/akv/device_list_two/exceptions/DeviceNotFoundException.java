package com.akv.device_list_two.exceptions;

public class DeviceNotFoundException extends RuntimeException {

    public DeviceNotFoundException(Integer id){
        super(String.format("Устройство %d не найдено", id));
    }
}

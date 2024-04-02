package com.vistal.tech.service;

import java.util.List;

import com.vistal.tech.dto.VehicleDTO;

public interface VehicleService {

	void saveData(VehicleDTO vehicleDTO);

	List<VehicleDTO> findAllJava8();

}

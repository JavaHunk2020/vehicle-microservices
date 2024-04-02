package com.vistal.tech.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vistal.tech.dto.SignupDTO;
import com.vistal.tech.dto.VehicleDTO;
import com.vistal.tech.entity.Vehicle;
import com.vistal.tech.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements  VehicleService{

	@Autowired
	private VehicleRepository vehicleRepository;
	

	@Override
	public void saveData(VehicleDTO vehicleDTO ) {
		Vehicle vehicle = new Vehicle();
		BeanUtils.copyProperties(vehicleDTO, vehicle);
		vehicleRepository.save(vehicle);
	}
	
	@Override
	public List<VehicleDTO> findAllJava8() {
		return vehicleRepository.findAll().stream().map(s -> {
			VehicleDTO dto = new VehicleDTO();
			BeanUtils.copyProperties(s, dto);
			return dto;
		}).collect(Collectors.toList());
	}
	
	
}

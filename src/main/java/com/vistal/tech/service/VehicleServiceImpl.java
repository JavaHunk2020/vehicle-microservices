package com.vistal.tech.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vistal.tech.dto.PatchDTO;
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

	@Override
	@Transactional
	public void updateVehicle(PatchDTO patchDTO) {
		Optional<Vehicle> optional=vehicleRepository.findById(Integer.parseInt(patchDTO.getKey()));
		if(optional.isPresent()) {
			Vehicle vehicle=optional.get();
			if("vendor".equalsIgnoreCase(patchDTO.getAttributeName())) {
				vehicle.setVendor(patchDTO.getValue());
			}else if("color".equalsIgnoreCase(patchDTO.getAttributeName())) {
				vehicle.setColor(patchDTO.getValue());
			}else if("price".equalsIgnoreCase(patchDTO.getAttributeName())) {
				vehicle.setPrice(Long.parseLong(patchDTO.getValue()));
			}
		}else {
			throw new RuntimeException("Sorry record does not exist to update");
		}
	}

	@Override
	public VehicleDTO findByVid(int vid) {
		Vehicle vehicle = vehicleRepository.findById(vid).get();
		VehicleDTO vehicleDTO=new VehicleDTO();
		BeanUtils.copyProperties(vehicle, vehicleDTO);
		return vehicleDTO;
	}
	
	@Override
	public void deleteByVid(int vid) {
		vehicleRepository.deleteById(vid);
	}
	
	
}

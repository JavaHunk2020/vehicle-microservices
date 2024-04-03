package com.vistal.tech.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vistal.tech.dto.ApplicationMessageDTO;
import com.vistal.tech.dto.PatchDTO;
import com.vistal.tech.dto.VehicleDTO;
import com.vistal.tech.service.VehicleService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v5")
@Api(value = "API Description VehicleController") // it description of api at top
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	// {} JSON=> @RequestBody ->>> java object
	@PostMapping("/vehicles")
	public ApplicationMessageDTO createVehicle(@RequestBody VehicleDTO vehicleDTO) {
		vehicleService.saveData(vehicleDTO);
		ApplicationMessageDTO applicationMessageDTO = new ApplicationMessageDTO("C0194", "resource is created");
		return applicationMessageDTO;
	}
	
	@GetMapping("/vehicles/{vid}")
	public VehicleDTO getVehicle(@PathVariable int vid) {
		return vehicleService.findByVid(vid);
	}
	
	@DeleteMapping("/vehicles/{vid}")
	public ApplicationMessageDTO deleteVehicle(@PathVariable int vid) {
		 vehicleService.deleteByVid(vid);
		 ApplicationMessageDTO applicationMessageDTO = new ApplicationMessageDTO("C0196",
					"resource is deleted successfully.");
			return applicationMessageDTO;
	}

	@GetMapping("/vehicles")
	public List<VehicleDTO> getVehicles() {
		return vehicleService.findAllJava8();
	}

	@PatchMapping("/vehicles")
	public ApplicationMessageDTO updateSignup(@RequestBody PatchDTO patchDTO) {
		vehicleService.updateVehicle(patchDTO);
		ApplicationMessageDTO applicationMessageDTO = new ApplicationMessageDTO("C0195",
				"resource is updated successfully.");
		return applicationMessageDTO;
	}

}

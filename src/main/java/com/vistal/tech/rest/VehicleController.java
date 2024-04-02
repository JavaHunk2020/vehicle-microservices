package com.vistal.tech.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vistal.tech.dto.ApplicationMessageDTO;
import com.vistal.tech.dto.SignupDTO;
import com.vistal.tech.dto.VehicleDTO;
import com.vistal.tech.service.VehicleService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v5")
@Api(value = "API Description VehicleController") // it description of api at top
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
   
	//{} JSON=> @RequestBody ->>> java object
	@PostMapping("/vehicles")
	public ApplicationMessageDTO createSignup(@RequestBody VehicleDTO vehicleDTO) {
		vehicleService.saveData(vehicleDTO);
        ApplicationMessageDTO applicationMessageDTO=new ApplicationMessageDTO("C0194","resource is created");
 		return applicationMessageDTO;
	}
	
	@GetMapping("/vehicles")
	public List<VehicleDTO> updateSignup(@RequestBody SignupDTO signupDTO) {
       return vehicleService.findAllJava8();
	}
	
}

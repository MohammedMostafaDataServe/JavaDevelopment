package com.mondia.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.mondia.app.bus.BusinessException;
import com.mondia.app.entity.Service;
import com.mondia.app.service.IServiceService;

/**
 * Operator Controller class to handle any service request
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
@Controller
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ServiceController {

	@Autowired
	IServiceService serviceService;

	@GetMapping("service/{id}")
	public ResponseEntity<Service> getServiceById(@PathVariable("id") Integer id) {
		Service service = serviceService.getServiceById(id);
		return new ResponseEntity<Service>(service, HttpStatus.OK);
	}

	@GetMapping("service/product/{id}")
	public ResponseEntity<List<Service>> getServiceByProductId(@PathVariable("id") Integer productId) {
		List<Service> list = serviceService.getServicesByProductId(productId);
		return new ResponseEntity<List<Service>>(list, HttpStatus.OK);
	}

	@GetMapping("service/operator/{id}")
	public ResponseEntity<List<Service>> getServiceByOperatorId(@PathVariable("id") Integer operatorId) {
		List<Service> list = serviceService.getServicesByOperatorId(operatorId);
		return new ResponseEntity<List<Service>>(list, HttpStatus.OK);
	}

	@GetMapping("services")
	public ResponseEntity<List<Service>> getAllServices() {
		List<Service> list = serviceService.getAllServices();
		return new ResponseEntity<List<Service>>(list, HttpStatus.OK);
	}

	@PostMapping("service")
	public ResponseEntity<Void> addService(@RequestBody Service service, UriComponentsBuilder builder) {
		try {
			serviceService.addService(service);
		} catch (BusinessException e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/service/{id}").buildAndExpand(service.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("service")
	public ResponseEntity<Service> updateService(@RequestBody Service service) {
		serviceService.updateService(service);
		return new ResponseEntity<Service>(service, HttpStatus.OK);
	}

	@DeleteMapping("service/{id}")
	public ResponseEntity<Void> deleteOperator(@PathVariable("id") Integer id) {
		serviceService.deleteService(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}

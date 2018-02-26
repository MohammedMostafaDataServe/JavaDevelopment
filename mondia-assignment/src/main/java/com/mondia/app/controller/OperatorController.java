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

import com.mondia.app.entity.Operator;
import com.mondia.app.service.IOperatorService;

/**
 * Operator Controller class to handle any operator request
 *
 * @author Mohammed Mostafa
 * @version 1.00
 */
@Controller
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class OperatorController {

	@Autowired
	private IOperatorService operatorService;

	@GetMapping("operator/{id}")
	public ResponseEntity<Operator> getOperatorById(@PathVariable("id") Integer id) {
		Operator operator = operatorService.getOperatorById(id);
		return new ResponseEntity<Operator>(operator, HttpStatus.OK);
	}

	@GetMapping("operators")
	public ResponseEntity<List<Operator>> getAllOperators() {
		List<Operator> list = operatorService.getAllOperators();
		return new ResponseEntity<List<Operator>>(list, HttpStatus.OK);
	}

	@PostMapping("operator")
	public ResponseEntity<Void> addOperator(@RequestBody Operator operator, UriComponentsBuilder builder) {
		boolean flag = operatorService.addOperator(operator);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/operator/{id}").buildAndExpand(operator.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("operator")
	public ResponseEntity<Operator> updateOperator(@RequestBody Operator operator) {
		operatorService.updateOperator(operator);
		return new ResponseEntity<Operator>(operator, HttpStatus.OK);
	}

	@DeleteMapping("operator/{id}")
	public ResponseEntity<Void> deleteOperator(@PathVariable("id") Integer id) {
		operatorService.deleteOperator(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Variable;
import com.example.demo.service.VariablesService;


@RestController
@RequestMapping("/variables")
public class VariablesController {
	
	@Autowired
	private VariablesService variableService;
	
	@CrossOrigin
	@GetMapping("/")
	public List<Variable> callVariables(){
		return variableService.valorVariablesEntorno();
	}
	
	@GetMapping("/parametros")
	public List<String> callParametros(){
		return variableService.parametros();
	}

}

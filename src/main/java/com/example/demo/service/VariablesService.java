package com.example.demo.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.example.demo.Variable;


@Service
public class VariablesService implements IVariablesService {

	@Value("${com.bancodebogota.ptdo.parametro.canal}")
	private String canal;
	
	@Value("${name.person}")
	private String name;
	
	@Value("${otra.variable}")
	private String otra;
	

	public List<Variable> valorVariablesEntorno() {
		
		System.out.println("Prueba VariablesService");
		System.out.println("Valor canal: "+ this.canal);
		System.out.println("Valor name: "+ this.name);
		System.out.println("Valor otra: "+ this.otra);
		
		List<Variable> valores = new ArrayList<Variable>();
		Properties p = new Properties();
		String pathProperties = System.getenv().get("PATH_CONFIGURACION");

		String myVar = System.getenv().get("PWD");
		
		valores.add(new Variable("PATH_CONFIGURACION", pathProperties.toString()));
		valores.add(new Variable("PWD:", myVar));
		return valores;

	}

	@Override
	public List<String> parametros() {
		List<String> valores = new ArrayList<String>();
		Properties p = new Properties();
		String pathProperties = System.getenv().get("PATH_CONFIGURACION");
		try {
			p.load(new FileReader(pathProperties + "/app.properties"));
			Enumeration<Object> keys = p.keys();

			while (keys.hasMoreElements()){
			   Object key = keys.nextElement();
			   valores.add(key + " = "+ p.get(key));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return valores;
	}

}

package com.example.demo.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;


@Service
public class VariablesService implements IVariablesService {



	private void ejemploProperties() {
		Properties p = new Properties();
		String pathProperties = System.getenv().get("PATH_CONF");
		try {
			p.load(new FileReader(pathProperties + "/app.properties"));
			System.out.println("[OZEA] valor3=" + p.getProperty("valor3"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String myVar = System.getenv().get("USER");
		System.out.println("[OZEA] USER=" + myVar);
		System.out.println("[OZEA] USER=${USER}");
		System.out.println("[OZEA] PATH_CONF=${PATH_CONF}");

	}

	public List<String> valorVariablesEntorno() {

		List<String> valores = new ArrayList<String>();
		Properties p = new Properties();
		String pathProperties = System.getenv().get("PATH_CONF");

		String myVar = System.getenv().get("PWD");

		valores.add("PATH_CONF:" + pathProperties);
		valores.add("PWD:" + myVar);
		return valores;

	}

	@Override
	public List<String> parametros() {
		List<String> valores = new ArrayList<String>();
		Properties p = new Properties();
		String pathProperties = System.getenv().get("PATH_CONF");
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

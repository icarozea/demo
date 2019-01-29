package com.example.demo;

public class Variable {
	private String nombre;
	private String valor;
	
	
	public Variable(String nombre, String valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getValor() {
		return valor;
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		return "Variable [nombre=" + nombre + ", valor=" + valor + "]";
	}
	
	
	
}

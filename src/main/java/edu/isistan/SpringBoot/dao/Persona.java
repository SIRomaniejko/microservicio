package edu.isistan.SpringBoot.dao;
import javax.persistence.*;

@Entity
public class Persona {
	@Id
	@GeneratedValue
	int dni;
	@Column
	String nombre;
	public Persona() {
		
	}
	public Persona(int dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}

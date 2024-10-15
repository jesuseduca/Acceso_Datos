package ejercicio6;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Persona_v2 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;
	private StringBuilder nombre;
	private StringBuilder apellido1;
	private StringBuilder apellido2;
	private int edad;

	public Persona_v2() {
		super();
	}
	
	public Persona_v2(StringBuilder nombre, StringBuilder apellido1, StringBuilder apellido2, Date nacimiento) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
	}
	@Override
	public String toString() {
		return apellido1 + " " + apellido2 + " , " + nombre + " ( " + edad + " ) " + "años" ;
	}
	public StringBuilder getNombre() {
		return nombre;
	}
	public void setNombre(StringBuilder nombre) {
		this.nombre = nombre;
	}
	public StringBuilder getApellido1() {
		return apellido1;
	}
	public void setApellido1(StringBuilder apellido1) {
		this.apellido1 = apellido1;
	}
	public StringBuilder getApellido2() {
		return apellido2;
	}
	public void setApellido2(StringBuilder apellido2) {
		this.apellido2 = apellido2;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	


}


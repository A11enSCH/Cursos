package Logica;

public class Cursos {
	private int id;
	private String nombre;
	private int creditos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public Cursos(int id, String nombre, int creditos) {
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
	}
	
	@Override
	public String toString() {
		return this.id + "\t" + this.nombre + "\t" + this.creditos;
	}

	
}
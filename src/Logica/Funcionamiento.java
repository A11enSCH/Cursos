package Logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Persistencia.Imprimir;

public class Funcionamiento implements Serializable{
	private HashMap<Integer, Cursos>cursos;

	public HashMap<Integer, Cursos> getCursos() {
		return cursos;
	}
	public Funcionamiento() {
		this.cursos = new HashMap<Integer, Cursos>();
	}

	public void crearCurso(int id, String nombre, int creditos) throws Exception{
		if(this.cursos.containsKey(id)) {
			throw new Exception("Curso existente");
		}else {
			Cursos cursos = new Cursos(id, nombre, creditos);
			this.cursos.put(id, cursos);
		}
	}
	public void actualizarCursos() {
		// TODO Auto-generated method stub

	}

	public void almacenarCursos() throws FileNotFoundException, IOException {
		ArrayList<String> lineasCursos = new ArrayList<String>();
		for(Integer id : this.cursos.keySet()) {
			Cursos curso = this.cursos.get(id);
			lineasCursos.add(curso.getId() + ";" + curso.getNombre() + ";" + curso.getCreditos());
		}
		Imprimir.almacenar("cursos.cvs", lineasCursos);
	}
	public void cargarCursos() throws Exception {
		ArrayList<String> lineasCursos = Imprimir.cargar("cursos.cvs");
		for(String linea: lineasCursos) {
			String datos[] = linea.split(";");
			this.crearCurso(Integer.parseInt(datos[0]), datos[1], Integer.parseInt(datos[2]));
		}
	}


}

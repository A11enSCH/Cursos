package Presentacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import Logica.Funcionamiento;


public class Menu {
	private Funcionamiento cursos;

	public Menu() {
		this.cursos = new Funcionamiento();
		this.presentacion();
	}
	public static void main(String[] args) {
		new Menu();
	}
	
	private void presentacion() {
		Scanner sc = new Scanner(System.in);
		int op=0;
		do {
			try {
				System.out.println("Seleccione:");
				System.out.println("0. Salir");
				System.out.println("1. Crear Curso");
				System.out.println("2. Consultar Cursos");
				System.out.println("3. Actualizar Curso");
				System.out.println("4. Almacenar a archivo serializable");
				System.out.println("5. Cargar desde archivo serializable");
				op = sc.nextInt();
				if(op == 1) {
					this.crearCurso(sc);				
				}else if(op == 2) {
					this.consultarCurso();
				}else if(op == 3) {
					this.actualizarCurso(sc);
				}else if(op == 4) {
					this.almacenarCurso();
				}else if(op == 5) {
					this.cargarCurso();
				}
			}catch (Exception e) {
				e.getMessage();
			}
		}while(op != 0);
		sc.close();
	}
	private void almacenarCurso() throws FileNotFoundException, IOException {
		this.cursos.almacenarCursos();		
	}
	
	private void cargarCurso() throws Exception {
		this.cursos.cargarCursos();
	}
	
	private void actualizarCurso(Scanner sc){
		this.cursos.actualizarCursos();
	}
	private void consultarCurso() {
		System.out.println("id\tNombre\tCreditos");
		for(Integer idCurso : this.cursos.getCursos().keySet()) {
			System.out.println(this.cursos.getCursos().get(idCurso));
		}
		
	}
	private void crearCurso(Scanner sc) throws Exception  {
		System.out.println("Id:");
		int id = sc.nextInt();
		System.out.println("nombre:");
		String nombre = sc.next();
		System.out.println("creditos:");
		int creditos = sc.nextInt();
		this.cursos.crearCurso(id, nombre, creditos);
	}
}

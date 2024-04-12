package testing.dao;

import modelo.dao.Empresa;
import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;
import modelo.javabeans.Localidad;
import modelo.javabeans.Trabajo;


public class Principal {
	
	private static Empresa rdao;
	
	static {
		rdao = new Empresa();
	}


	public static void main(String[] args) {
		
		pais();
		//trabajo();
		//departamento();
		//masaSal();
		//uno();
		//sexo();
		//modificar();
		//eliminar();
		//alta();
		//buscarTodos();
	}
	
	public static void pais() {
		for (Empleado e: rdao.buscarPorPais("España"))
			System.out.println(e);
		
	}
	
	public static void trabajo() {
		for (Empleado e: rdao.buscarPorTrabajo("3000"))
			System.out.println(e);
		
	}
	
	public static void departamento() {
		for (Empleado e: rdao.buscarPorDepartamento(79))
			System.out.println(e);
		
	}
	
	public static void masaSal() {
		System.out.println(rdao.masaSalarial());
		
	}
	
	public static void uno() {
		System.out.println(rdao.buscarUno(177));
			
		
	}
	
	public static void sexo() {
		for (Empleado e: rdao.buscarPorSexo('H'))
			System.out.println(e);
		
	}
	
	public static void modificar() {
		Empleado empleado = rdao.buscarUno(999);
		empleado.setNombre("SIIIIIUUUUUUUUUUUUUU");
		
		System.out.println(rdao.modificarUno(empleado));
		System.out.println(rdao.buscarUno(999));
		
		
	}
	
	public static void eliminar() {
		System.out.println(rdao.eliminarUno(rdao.buscarUno(177)));
		System.out.println(rdao.buscarUno(177));
		
	}
	
	public static void alta() {
		Empleado empleado = new Empleado(1, "JUANITO", "MIULER MASCH", "H", "JMIULER@APPLE.COM", 99999, 70000, 
				new Trabajo("4000", "Limpiadora", 14000, 21000),
				new Departamento(50, "Sanidad",  
				new Localidad(666, "Pza Spagna", "Roma", "Italia")));
		System.out.println(rdao.alta(empleado));
		System.out.println(rdao.buscarUno(1));
		System.out.println(rdao.buscarTodos());
		
		
	}
	
	public static void buscarTodos() {
		
		for (Empleado e: rdao.buscarTodos())
			System.out.println(e);
		
	}
	
	
	

}

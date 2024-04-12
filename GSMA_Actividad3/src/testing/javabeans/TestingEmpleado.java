package testing.javabeans;

import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;
import modelo.javabeans.Localidad;
import modelo.javabeans.Trabajo;

public class TestingEmpleado {

	public static void main(String[] args) {
		
		// Creación de objetos
		Localidad loc = new Localidad (1, "Ctra. Barcelona nº1", "Museros", "España");
		Departamento dep = new Departamento(1, "Contabilidad", loc);
		Trabajo tra = new Trabajo("CON", "Contable", 22000, 38000);
		Empleado emp = new Empleado (77, "PEPE", "MARTINEZ LUJAN", "H", "pmartinez@pdp.es", 20000, 5000, tra, dep);
		
		// La información completa de un empleado SIN usar toString:
		System.out.println(emp.getNombre() + " - " + emp.getApellidos() + " - " + emp.getGenero() + " - " +  
						   emp.getDepartamento().getDescripcion() + " - " +
						   emp.getTrabajo().getDescripcion() + " - " +
						   emp.getDepartamento().getLocalidad().getDireccion() + " - " +
						   emp.getDepartamento().getLocalidad().getCiudad() + " - " +
						   emp.getDepartamento().getLocalidad().getPais());
	
		// Extraer del empleado su trabajo y su departamento en variables de su tipo:
		System.out.println(emp.getTrabajo());
		System.out.println(emp.getDepartamento());
		
		//PRUEBA METODOS EMPLEADO
		System.out.println(emp.salarioBruto());
		System.out.println(emp.salarioMensual(12));
		System.out.println(emp.literalSexo());
		System.out.println(emp.nombreCompleto());
		System.out.println(emp.obtenerEmail("PEPE", "MARTINEZ"));
		
	}

}

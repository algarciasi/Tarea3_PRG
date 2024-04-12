package modelo.dao;

import java.util.ArrayList;

import modelo.javabeans.Empleado;

public interface IntGestionEmpresa {

	// Creación de la interface
	
	boolean alta (Empleado empleado);
	boolean eliminarUno (Empleado empleado);
	boolean modificarUno (Empleado empleado);
	ArrayList<Empleado> buscarPorSexo(char sexo);
	Empleado buscarUno(int idEmpleado);
	double masaSalarial();
	ArrayList<Empleado> buscarPorDepartamento(int idDepar);
	ArrayList<Empleado> buscarPorTrabajo(String idTrabajo);
	ArrayList<Empleado> buscarPorPais(String pais);
	ArrayList<Empleado> buscarTodos();
	
}

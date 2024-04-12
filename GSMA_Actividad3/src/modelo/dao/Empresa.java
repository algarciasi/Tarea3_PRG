package modelo.dao;

import java.util.ArrayList;

import modelo.javabeans.Departamento;
import modelo.javabeans.Empleado;
import modelo.javabeans.Localidad;
import modelo.javabeans.Trabajo;

public class Empresa implements IntGestionEmpresa {

	// Datos privados del esquema
	private String nombre;
	private ArrayList<Empleado> lista;

	// Constructor vacio con cargarDatos()
	public Empresa() {
		nombre = "Central Gym";
		lista = new ArrayList<Empleado>();
		cargarDatos();
	}

	// Constructor con String nombreEmpresa y cargarDatos()
	public Empresa(String nombreEmpresa) {
		this.nombre = nombreEmpresa;
		lista = new ArrayList<Empleado>();
		cargarDatos();
	}

	// Metodos Getter & Setter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Métodos implementados de la interface
	// metodo dar de alta, sino lo contiene lo añade y sino devuelve false
	@Override
	public boolean alta(Empleado empleado) {
		if (!lista.contains(empleado))
			return lista.add(empleado);
		else
			return false;
	}

	// metodo que elimina un usuario dado
	@Override
	public boolean eliminarUno(Empleado empleado) {
		return lista.remove(empleado);
	}

	// metodo que modifica un usuario dado
	// Lo busca en la lista y si está lo modifica y sino devuelve false
	@Override
	public boolean modificarUno(Empleado empleado) {
		int pos = lista.indexOf(empleado);
		if (pos != -1) {
			lista.set(pos, empleado);
			return true;
		} else
			return false;
	}

	// Metodo que saca el total de mi bbdd virtual que contienen el sexo dado
	@Override
	public ArrayList<Empleado> buscarPorSexo(char sexo) {
		ArrayList<Empleado> aux = new ArrayList<Empleado>();
		String sexS = String.valueOf(sexo);	
		for (Empleado emp : lista) {
			if(emp.getGenero().equals(sexS))
			aux.add(emp);
		}
		return aux;
	}

	// metodo que busca un empleado por id. lo busca en la lista y lo devuelve si lo encuentra
	@Override
	public Empleado buscarUno(int idEmpleado) {
		for (Empleado emp : lista) {
			if (emp.getIdEmpleado() == idEmpleado)
				return emp;
		}
		return null;

	}
	
	//metodo que calcula el salario total de los usuarios
	@Override
	public double masaSalarial() {
		double total=0.0;
		for (Empleado emp : lista) {
			total+=emp.getSalario();
			
		}
		return total;
	}

	//metodo que busca por id departamento
	// se crea un array para ir guardando si existe el departamento y luego se devuelve
	@Override
	public ArrayList<Empleado> buscarPorDepartamento(int idDepar) {
		ArrayList<Empleado> aux = new ArrayList<Empleado>();
		for (Empleado emp : lista) {
			if (emp.getDepartamento().getIdDepartamento() == (idDepar)) {
				aux.add(emp);
			}
		}
		return aux;
	}

	//metodo que busca por id trabajo
	// se crea un array para ir guardando si existe el trabajo y luego se devuelve
	@Override
	public ArrayList<Empleado> buscarPorTrabajo(String idTrabajo) {
		ArrayList<Empleado> aux = new ArrayList<Empleado>();
		for (Empleado emp : lista) {
			if (emp.getTrabajo().getIdTrabajo() == idTrabajo)
				aux.add(emp);
		}
		return aux;
	}

	//metodo que busca por string pais
	// se crea un array para ir guardando si existe el pais y luego se devuelve
	@Override
	public ArrayList<Empleado> buscarPorPais(String pais) {
		ArrayList<Empleado> aux = new ArrayList<Empleado>();
		for (Empleado emp : lista) {
			if (emp.getDepartamento().getLocalidad().getPais().equals(pais))
				aux.add(emp);
		}
		return aux;
	}

	// Metodo privado cargarDatos() que simula una BBDD
	private void cargarDatos() {
		lista.add(new Empleado(50, "JUAN", "ACOSTA CALATRAVA", "H", "JACOSTA@UNIRFP.ES", 27000, 1300,
				(new Trabajo("1000", "Formador", 12000, 22000)),
				new Departamento(69, "Calidad", new Localidad(300, "Av Valles", "Valencia", "España"))));
		lista.add(new Empleado(177, "LUIS", "BERMEJO JUAN", "H", "LBERMEJO@MSN.ES", 33000, 1900,
				(new Trabajo("2000", "Entrenador", 11000, 18000)),
				new Departamento(79, "Calidad", new Localidad(99, "Av Hispanidad", "Sagunto", "España"))));
		lista.add(new Empleado(320, "AITOR", "MUÑOZ ROVIRA", "H", "AMUÑOZ@UNIRFP.ES", 17000, 800,
				(new Trabajo("3000", "Recepcionista", 12000, 19000)),
				new Departamento(89, "Att Cliente", new Localidad(555, "Av Victor Hugo", "Paris", "Francia"))));
		lista.add(new Empleado(88, "ESTER", "PERIS ANTUNES", "M", "EPERIS@DINAMITA.COM", 32500, 1500,
				(new Trabajo("4000", "Limpiadora", 14000, 21000)),
				new Departamento(50, "Sanidad", new Localidad(666, "Pza Spagna", "Roma", "Italia"))));
		lista.add(new Empleado(999, "ALICIA", "MARTI ESCRIVA", "M", "AMARTI@MSN.ES", 15500, 600,
				(new Trabajo("5000", "Paseante", 10000, 15000)),
				new Departamento(50, "Sanidad", new Localidad(777, "Piccadilly Circus", "Londres", "UK"))));

	}

	// metodo que busca todos y muestra la lista.
	@Override
	public ArrayList<Empleado> buscarTodos() {
		return lista;
	}

}

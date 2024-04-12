package modelo.javabeans;

import java.util.Objects;

public class Empleado {
	private int idEmpleado;
	private String nombre, apellidos, genero,email;
	private double salario, comision;
	private Trabajo trabajo;
	private Departamento departamento;
	
	//constructor con parametros
	public Empleado(int idEmpleado, String nombre, String apellidos, String genero, String email, double salario,
			double comision, Trabajo trabajo, Departamento departamento) {
		super();
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.genero = genero;
		this.email = email;
		this.salario = salario;
		this.comision = comision;
		this.trabajo = trabajo;
		this.departamento = departamento;
	}
	//constructor sin parametros
	public Empleado() {
		super();
	}
	
	//metodos getter 
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getComision() {
		return comision;
	}
	public void setComision(double comision) {
		this.comision = comision;
	}
	public Trabajo getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idEmpleado);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		return idEmpleado == other.idEmpleado;
	}
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", genero="
				+ genero + ", email=" + email + ", salario=" + salario + ", comision=" + comision + ", trabajo="
				+ trabajo + ", departamento=" + departamento + "]";
	}
	
	
	//METODOS PROPIOS
	public double salarioBruto() {
		return salario+comision;
	}
	
	public double salarioMensual(int meses) {
		return (double)salario/meses;
	}
	
	public String literalSexo() {
		if ((genero == "H") || (genero == "h")) 
			return "Hombre";
		else if ((genero == "M") || (genero == "m"))
			return "Mujer";
		else 
			return "Genero no especificado";
	}
	
		
	//metodo que devuelve el nombre y apellidos
	public String nombreCompleto() {
		return nombre + " " + apellidos; 
	}
	
	// Metodo que devuelve el email con el la primera letra del nombre en minusculas y el primer apellido
	// Incluye Método para coger el primer apellido. 
	// Usando un array de string que cogela posiciópn 0.
	public static String obtenerEmail(String nombre, String apellido) {
		String priMinus = nombre.substring(0,1).toLowerCase();
		String [] ap1 = apellido.split(" ");
		return priMinus + ap1[0].toLowerCase() + "@unirfp.es";
	}

}

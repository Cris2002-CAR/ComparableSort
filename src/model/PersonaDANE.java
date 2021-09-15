package model;

public class PersonaDANE implements Comparable<PersonaDANE> {

	private String nombre;
	private String apellido;
	private int edad;
	private int estrato;
	private double ingresos;
	
	public PersonaDANE(String nombre, String apellido, int edad, int estrato, double ingresos) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.estrato = estrato;
		this.ingresos = ingresos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	@Override
	public String toString() {
		
		String output = nombre+" "+apellido+" "+ingresos+" "+edad+" "+estrato;
		
		return output;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getEstrato() {
		return estrato;
	}

	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}

	public double getIngresos() {
		return ingresos;
	}

	public void setIngresos(double ingresos) {
		this.ingresos = ingresos;
	}

	//Ordenamiento natural
	@Override
	public int compareTo(PersonaDANE obj) {
		
		int criterioA = this.estrato - obj.estrato;
		
		if(criterioA == 0) {
			int criterioB =  this.apellido.compareTo(obj.apellido);
			return criterioB;
		}else {
			return criterioA;
		}
	}
	//MergeSort
	
	
	
	
}

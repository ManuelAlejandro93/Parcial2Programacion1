public class Empresa {
	private String codigo;
	private String nombre;
	private String direccion;
	private TurnoDisponible turnosDisponibles;
	private GestorGeneral gestorGeneral = new GestorGeneral();

	public Empresa(String codigo, String nombre, String direccion, TurnoDisponible turnosDisponibles) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.turnosDisponibles = turnosDisponibles;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TurnoDisponible getTurnosDisponibles() {
		return turnosDisponibles;
	}

	public void setTurnosDisponibles(TurnoDisponible turnosDisponibles) {
		this.turnosDisponibles = turnosDisponibles;
	}

	public GestorGeneral getGestorGeneral() {
		return gestorGeneral;
	}

	public void setGestorGeneral(GestorGeneral gestorGeneral) {
		this.gestorGeneral = gestorGeneral;
	}

}

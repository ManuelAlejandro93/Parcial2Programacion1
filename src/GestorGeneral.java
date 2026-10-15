
public class GestorGeneral {
	private GestorEquipos gestorEquipos = new GestorEquipos();
	private GestorOperadores gestorOperadores = new GestorOperadores();
	private GestorClientes gestorClientes = new GestorClientes();
	private GestorFuncionesEspeciales gestorFuncionesEspeciales = new GestorFuncionesEspeciales();
	private GestorReservas gestorReservas = new GestorReservas();
	private GestorReservasIndividuales gestorReservasIndividuales = new GestorReservasIndividuales();

	public GestorGeneral() {
	}

	public GestorEquipos getGestorEquipos() {
		return gestorEquipos;
	}

	public void setGestorEquipos(GestorEquipos gestorEquipos) {
		this.gestorEquipos = gestorEquipos;
	}

	public GestorOperadores getGestorOperadores() {
		return gestorOperadores;
	}

	public void setGestorOperadores(GestorOperadores gestorOperadores) {
		this.gestorOperadores = gestorOperadores;
	}

	public GestorClientes getGestorClientes() {
		return gestorClientes;
	}

	public void setGestorClientes(GestorClientes gestorClientes) {
		this.gestorClientes = gestorClientes;
	}

	public GestorFuncionesEspeciales getGestorFuncionesEspeciales() {
		return gestorFuncionesEspeciales;
	}

	public void setGestorFuncionesEspeciales(GestorFuncionesEspeciales gestorFuncionesEspeciales) {
		this.gestorFuncionesEspeciales = gestorFuncionesEspeciales;
	}

	public GestorReservas getGestorReservas() {
		return gestorReservas;
	}

	public void setGestorReservas(GestorReservas gestorReservas) {
		this.gestorReservas = gestorReservas;
	}

	public GestorReservasIndividuales getGestorReservasIndividuales() {
		return gestorReservasIndividuales;
	}

	public void setGestorReservasIndividuales(GestorReservasIndividuales gestorReservasIndividuales) {
		this.gestorReservasIndividuales = gestorReservasIndividuales;
	}
}

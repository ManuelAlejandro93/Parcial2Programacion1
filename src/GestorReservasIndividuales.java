import java.util.ArrayList;

public class GestorReservasIndividuales {
	private ArrayList<ReservaIndividualPorEquipo> reservasIndividuales = new ArrayList<ReservaIndividualPorEquipo>();

	public GestorReservasIndividuales() {
	}

	public ArrayList<ReservaIndividualPorEquipo> getReservasIndividuales() {
		return reservasIndividuales;
	}

	public void setReservasIndividuales(ArrayList<ReservaIndividualPorEquipo> reservasIndividuales) {
		this.reservasIndividuales = reservasIndividuales;
	}

	// CREATE - añadir cualquiera. ✅
	// necesito varios inputs para validar varias cosas
	public boolean anadirReservaIndividual(ReservaIndividualPorEquipo nuevaReservaIndividual,
			Reserva reservaActual, GestorReservas gestorReservas) {

		Equipo equipo = nuevaReservaIndividual.getEquipo();
		String codigoEquipo = equipo.getCodigo();

		// VALIDACIÓN 1: ¿Equipo disponible?
		if (!equipo.estaDisponible()) {
			return false;
		}

		// VALIDACIÓN 2: ¿Equipo ya existe en esta reserva?
		if (reservaActual.equipoYaExisteEnReserva(codigoEquipo)) {
			return false;
		}

		// VALIDACIÓN 3: ¿Equipo confirmado en otra reserva?
		if (gestorReservas.equipoConfirmadoEnOtraReserva(codigoEquipo, reservaActual.getCodigo())) {
			return false;
		}

		// Si pasa todas las validaciones
		reservasIndividuales.add(nuevaReservaIndividual);
		return true;
	}

	// READ (listar todas como texto, para mostrar en JOptionPane)
	// Leer✅
	public String mostrarTodasReservasIndividuales() {
		String resultado = "";
		if (reservasIndividuales == null || reservasIndividuales.size() == 0) {
			return "No hay reservas individuales registradas.";
		}

		for (int i = 0; i < reservasIndividuales.size(); i++) {
			resultado = resultado + reservasIndividuales.get(i).toString() + "\n";
		}
		return resultado;
	}

	// READ (buscar por id) devuelve objeto o null
	public ReservaIndividualPorEquipo buscarReservaIndividualPorCodigo(String codigo) {
		ReservaIndividualPorEquipo resultado = null;
		for (int i = 0; i < this.reservasIndividuales.size(); i++) {
			if (codigo.equalsIgnoreCase(this.reservasIndividuales.get(i).getCodigo())) {
				resultado = this.reservasIndividuales.get(i);
			}
		}
		return resultado;
	}

	// UPDATE - actualiza objeto
	public boolean actualizarInformacionReservaIndividual(
			String codigo, Equipo nuevoEquipo, long nuevasHorasDeTrabajo) {
		ReservaIndividualPorEquipo reservaRecuperada = buscarReservaIndividualPorCodigo(codigo);
		if (reservaRecuperada == null) {
			return false;
		}
		reservaRecuperada.setEquipo(nuevoEquipo);
		reservaRecuperada.setHorasDeTrabajo(nuevasHorasDeTrabajo);
		return true;
	}

	// DELETE objeto
	public boolean eliminarReservaIndividual(String codigo) {
		ReservaIndividualPorEquipo reservaRecuperada = buscarReservaIndividualPorCodigo(codigo);
		if (reservaRecuperada == null) {
			return false;
		} else {
			this.reservasIndividuales.remove(reservaRecuperada);
			return true;
		}
	}
}

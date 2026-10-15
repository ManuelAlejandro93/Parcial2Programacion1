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
	public boolean anadirReservaIndividual(ReservaIndividualPorEquipo nuevaReservaIndividual) {
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

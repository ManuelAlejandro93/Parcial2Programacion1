import java.time.LocalDate;
import java.util.ArrayList;

public class GestorReservas {
	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

	public GestorReservas() {
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}

	// CREATE - añadir cualquiera. ✅
	public boolean anadirReserva(Reserva nuevaReserva) {
		reservas.add(nuevaReserva);
		return true;
	}

	// READ (listar todas como texto, para mostrar en JOptionPane)
	// Leer✅
	public String mostrarTodasReservas() {
		String resultado = "";
		if (reservas == null || reservas.size() == 0) {
			return "No hay reservas individuales registradas.";
		}

		for (int i = 0; i < reservas.size(); i++) {
			resultado = resultado + reservas.get(i).toString() + "\n";
		}
		return resultado;
	}

	// READ (buscar por id) devuelve objeto o null
	public Reserva buscarReservaPorCodigo(String codigo) {
		Reserva resultado = null;
		for (int i = 0; i < this.reservas.size(); i++) {
			if (codigo.equalsIgnoreCase(this.reservas.get(i).getCodigo())) {
				resultado = this.reservas.get(i);
			}
		}
		return resultado;
	}

	// UPDATE - actualiza objeto
	public boolean actualizarInformacionReserva(
			String codigo, LocalDate nuevaFechaReserva, TurnoNombre nuevoTurno,
			EstadoActualProceso nuevoEstadoActualProceso) {
		Reserva reservaRecuperada = buscarReservaPorCodigo(codigo);
		if (reservaRecuperada == null) {
			return false;
		}
		reservaRecuperada.setFechaReserva(nuevaFechaReserva);
		reservaRecuperada.setTurno(nuevoTurno);
		reservaRecuperada.setEstadoActualProceso(nuevoEstadoActualProceso);
		return true;
	}

	// DELETE objeto
	public boolean eliminarReserva(String codigo) {
		Reserva reservaRecuperada = buscarReservaPorCodigo(codigo);
		if (reservaRecuperada == null) {
			return false;
		} else {
			this.reservas.remove(reservaRecuperada);
			return true;
		}
	}

	// En GestorReservas
	public boolean equipoConfirmadoEnOtraReserva(String codigoEquipo, String codigoReservaActual) {
		for (Reserva reserva : this.reservas) {
			// No validar contra la misma reserva
			if (reserva.getCodigo().equalsIgnoreCase(codigoReservaActual)) {
				continue;
			}

			// Solo verificar reservas CONFIRMADAS
			if (reserva.getEstadoActualProceso() != EstadoActualProceso.CONFIRMADA) {
				continue;
			}

			// Buscar si el equipo está en esa reserva
			if (reserva.equipoYaExisteEnReserva(codigoEquipo)) {
				return true; // Equipo confirmado en otra reserva
			}
		}
		return false; // Equipo no está confirmado en otra reserva
	}

}

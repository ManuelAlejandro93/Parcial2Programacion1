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

	public boolean confirmarReserva(String codigoReserva) {
		Reserva reserva = buscarReservaPorCodigo(codigoReserva);

		if (reserva == null) {
			return false; // Reserva no existe
		}

		// VALIDACIÓN 1: ¿Tiene al menos un equipo?
		if (!reserva.tieneEquipos()) {
			return false; // No tiene equipos
		}

		// VALIDACIÓN 2: ¿Tiene operador si tiene dron?
		if (!reserva.tieneOperadorSiTieneDron()) {
			return false; // Tiene dron pero no operador
		}

		// VALIDACIÓN 3: ¿Puede ser confirmada según su estado?
		if (!reserva.puedeSerConfirmada()) {
			return false; // Está cancelada o finalizada
		}

		// Si pasa las validaciones, cambiar estado a CONFIRMADA
		reserva.setEstadoActualProceso(EstadoActualProceso.CONFIRMADA);
		return true;
	}

	public boolean asignarClienteAReserva(String codigoReserva, Cliente cliente) {
		Reserva reserva = buscarReservaPorCodigo(codigoReserva);

		if (reserva == null) {
			return false; // Reserva no existe
		}

		if (cliente == null) {
			return false; // Cliente es nulo
		}

		reserva.setCliente(cliente);
		return true;
	}

	public boolean asignarOperadorAReserva(String codigoReserva, Operador operador) {
		Reserva reserva = buscarReservaPorCodigo(codigoReserva);

		if (reserva == null) {
			return false; // Reserva no existe
		}

		if (operador == null) {
			return false; // Operador es nulo
		}

		reserva.setOperador(operador);
		return true;
	}

	public boolean cambiarEstadoReserva(String codigoReserva, EstadoActualProceso nuevoEstado) {
		Reserva reserva = buscarReservaPorCodigo(codigoReserva);

		if (reserva == null) {
			return false; // Reserva no existe
		}

		EstadoActualProceso estadoActual = reserva.getEstadoActualProceso();

		// VALIDACIÓN: ¿La reserva está cancelada o finalizada?
		if (estadoActual == EstadoActualProceso.CANCELADA ||
				estadoActual == EstadoActualProceso.FINALIZADA) {
			return false; // No puede cambiar de estado
		}

		// VALIDACIÓN: ¿La transición es válida?
		// Solo permitir cambios a CANCELADA o FINALIZADA desde SOLICITADA o CONFIRMADA
		if (nuevoEstado != EstadoActualProceso.CANCELADA &&
				nuevoEstado != EstadoActualProceso.FINALIZADA) {
			return false; // Solo se puede cambiar a CANCELADA o FINALIZADA
		}

		// Si pasa las validaciones, cambiar estado
		reserva.setEstadoActualProceso(nuevoEstado);
		return true;
	}

	public boolean equipoEstaEnReservaConfirmadaParaFechaYTurno(String codigoEquipo, LocalDate fecha, TurnoNombre turno) {
		for (Reserva reserva : this.reservas) {
			if (reserva.getEstadoActualProceso() == EstadoActualProceso.CONFIRMADA &&
					reserva.getFechaReserva().equals(fecha) &&
					reserva.getTurno() == turno &&
					reserva.equipoYaExisteEnReserva(codigoEquipo)) {
				return true; // Equipo está confirmado
			}
		}
		return false; // Equipo no está confirmado
	}

	public String obtenerReservasConfirmadasPorCliente(String cedulaCliente) {
		String resultado = "";

		if (reservas == null || reservas.size() == 0) {
			return "No hay reservas registradas.";
		}

		for (Reserva reserva : reservas) {
			// VALIDACIÓN 1: ¿La reserva está confirmada?
			if (reserva.getEstadoActualProceso() != EstadoActualProceso.CONFIRMADA) {
				continue; // Saltar esta reserva
			}

			// VALIDACIÓN 2: ¿El cliente de la reserva coincide?
			if (reserva.getCliente() != null &&
					reserva.getCliente().cedula().equalsIgnoreCase(cedulaCliente)) {
				resultado += reserva.toString() + "\n";
			}
		}

		if (resultado.isEmpty()) {
			return "No hay reservas confirmadas para este cliente.";
		}

		return resultado;
	}

	public long obtenerValorTotalReserva(String codigoReserva) {
		Reserva reserva = buscarReservaPorCodigo(codigoReserva);

		if (reserva == null) {
			return 0; // Reserva no existe
		}

		return reserva.obtenerValorTotal();
	}
}

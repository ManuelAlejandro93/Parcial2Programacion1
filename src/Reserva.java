import java.time.LocalDate;

public class Reserva {
	private String codigo;
	private Cliente cliente;
	private LocalDate fechaReserva;
	private TurnoNombre turno;
	private EstadoActualProceso estadoActualProceso;
	private GestorReservasIndividuales gestorReservasIndividuales = new GestorReservasIndividuales();

	public Reserva(String codigo, LocalDate fechaReserva, TurnoNombre turno,
			EstadoActualProceso estadoActualProceso) {
		this.codigo = codigo;
		this.fechaReserva = fechaReserva;
		this.turno = turno;
		this.estadoActualProceso = estadoActualProceso;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public TurnoNombre getTurno() {
		return turno;
	}

	public void setTurno(TurnoNombre turno) {
		this.turno = turno;
	}

	public EstadoActualProceso getEstadoActualProceso() {
		return estadoActualProceso;
	}

	public void setEstadoActualProceso(EstadoActualProceso estadoActualProceso) {
		this.estadoActualProceso = estadoActualProceso;
	}

	public GestorReservasIndividuales getGestorReservasIndividuales() {
		return gestorReservasIndividuales;
	}

	public void setGestorReservasIndividuales(GestorReservasIndividuales gestorReservasIndividuales) {
		this.gestorReservasIndividuales = gestorReservasIndividuales;
	}

	public long obtenerValorTotal() {
		long valorTotal = 0;
		for (ReservaIndividualPorEquipo reservaIndividual : gestorReservasIndividuales.getReservasIndividuales()) {
			valorTotal += reservaIndividual.calcularCosto();
		}
		return valorTotal;
	}

	public boolean equipoYaExisteEnReserva(String codigoEquipo) {
		for (ReservaIndividualPorEquipo reservaIndividual : gestorReservasIndividuales.getReservasIndividuales()) {
			if (reservaIndividual.getEquipo().getCodigo().equalsIgnoreCase(codigoEquipo)) {
				return true; // El equipo ya existe
			}
		}
		return false; // El equipo no existe en la reserva
	}

	@Override
	public String toString() {
		String mensaje = "" + "\n";
		mensaje += "===============" + "\n";
		mensaje += "codigo : " + this.codigo + "\n";
		mensaje += "cliente : " + (this.cliente != null ? this.cliente.toString() : "Sin cliente") + "\n";
		mensaje += "fechaDeReserva : " + this.fechaReserva.toString() + "\n";
		mensaje += "turno : " + this.turno.toString() + "\n";
		mensaje += "estadoActualProceso : " + this.estadoActualProceso.toString() + "\n";
		mensaje += "valorTotal : " + this.obtenerValorTotal() + "\n";
		mensaje += "===============" + "\n";

		return mensaje;
	}
}
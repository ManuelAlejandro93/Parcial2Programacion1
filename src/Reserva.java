import java.time.LocalDate;

public class Reserva {
	private String codigo;
	private Cliente cliente;
	private LocalDate fechaReserva;
	private Turno turno;
	private EstadoActualProceso estadoActualProceso;
	private GestorReservasIndividuales gestorReservasIndividuales;

	public Reserva(String codigo, Cliente cliente, LocalDate fechaReserva, Turno turno,
			EstadoActualProceso estadoActualProceso, GestorReservasIndividuales gestorReservasIndividuales) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.fechaReserva = fechaReserva;
		this.turno = turno;
		this.estadoActualProceso = estadoActualProceso;
		this.gestorReservasIndividuales = gestorReservasIndividuales;
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

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
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

}

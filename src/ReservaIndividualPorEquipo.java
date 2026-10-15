public class ReservaIndividualPorEquipo {
	private String codigo;
	private Equipo equipo;
	private long horasDeTrabajo;

	public ReservaIndividualPorEquipo(String codigo, Equipo equipo, long horasDeTrabajo) {
		this.codigo = codigo;
		this.equipo = equipo;
		this.horasDeTrabajo = horasDeTrabajo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public long getHorasDeTrabajo() {
		return horasDeTrabajo;
	}

	public void setHorasDeTrabajo(long horasDeTrabajo) {
		this.horasDeTrabajo = horasDeTrabajo;
	}

	public long calcularCosto() {
		if (equipo instanceof Camara) {
			return ((Camara) equipo).calcularCosto(horasDeTrabajo);
		} else if (equipo instanceof Dron) {
			return ((Dron) equipo).calcularCosto(horasDeTrabajo);
		} else if (equipo instanceof Iluminacion) {
			return ((Iluminacion) equipo).calcularCosto(horasDeTrabajo);
		}
		return 0;
	}

	@Override
	public String toString() {
		String mensaje = "" + "\n";
		mensaje += "===============" + "\n";
		mensaje += "codigo : " + this.codigo + "\n";
		mensaje += "equipo : " + this.equipo + "\n";
		mensaje += "horasDeTrabajo: " + this.horasDeTrabajo + "\n";
		mensaje += "costo : " + this.calcularCosto() + "\n";
		mensaje += "===============" + "\n";

		return mensaje;
	}
}


public class Dron extends Equipo {
	private long autonomiaMin;
	private boolean tieneBateriaAdicional;

	public Dron(String marca, String modelo, String costoPorHora, CondicionEquipo condicionEquipo, long autonomiaMin,
			boolean tieneBateriaAdicional) {
		super(marca, modelo, costoPorHora, condicionEquipo);
		this.autonomiaMin = autonomiaMin;
		this.tieneBateriaAdicional = tieneBateriaAdicional;
	}

	public long getAutonomiaMin() {
		return autonomiaMin;
	}

	public void setAutonomiaMin(long autonomiaMin) {
		this.autonomiaMin = autonomiaMin;
	}

	public boolean isTieneBateriaAdicional() {
		return tieneBateriaAdicional;
	}

	public void setTieneBateriaAdicional(boolean tieneBateriaAdicional) {
		this.tieneBateriaAdicional = tieneBateriaAdicional;
	}

	// todo: hacer esto
	public long calcularCosto() {
		return 0;
	}
}
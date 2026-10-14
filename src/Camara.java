public class Camara extends Equipo {
	private long resolucionMaxima;
	private boolean tieneEstabilizador;

	public Camara(String codigo, String marca, String modelo, long costoPorHora, CondicionEquipo condicionEquipo,
			long resolucionMaxima, boolean tieneEstabilizador) {
		super(codigo, marca, modelo, costoPorHora, condicionEquipo);
		this.resolucionMaxima = resolucionMaxima;
		this.tieneEstabilizador = tieneEstabilizador;
	}

	public long getResolucionMaxima() {
		return resolucionMaxima;
	}

	public void setResolucionMaxima(long resolucionMaxima) {
		this.resolucionMaxima = resolucionMaxima;
	}

	public boolean isTieneEstabilizador() {
		return tieneEstabilizador;
	}

	public void setTieneEstabilizador(boolean tieneEstabilizador) {
		this.tieneEstabilizador = tieneEstabilizador;
	}

	// todo: hacer esto
	public long calcularCosto() {
		return 0;
	}
}

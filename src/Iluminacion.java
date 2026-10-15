public class Iluminacion extends Equipo {
	private long cantidadLuces;
	private boolean tieneControlInalambrico;

	public Iluminacion(String codigo, String marca, String modelo, long costoPorHora, CondicionEquipo condicionEquipo,
			long cantidadLuces, boolean tieneControlInalambrico) {
		super(codigo, marca, modelo, costoPorHora, condicionEquipo);
		this.cantidadLuces = cantidadLuces;
		this.tieneControlInalambrico = tieneControlInalambrico;
	}

	public long getCantidadLuces() {
		return cantidadLuces;
	}

	public void setCantidadLuces(long cantidadLuces) {
		this.cantidadLuces = cantidadLuces;
	}

	public boolean isTieneControlInalambrico() {
		return tieneControlInalambrico;
	}

	public void setTieneControlInalambrico(boolean tieneControlInalambrico) {
		this.tieneControlInalambrico = tieneControlInalambrico;
	}

	public long calcularCosto(long horasDeTrabajo) {
		long costo = horasDeTrabajo * 10000;
		if (tieneControlInalambrico) {
			costo += 12000;
		}
		return costo;
	}
}

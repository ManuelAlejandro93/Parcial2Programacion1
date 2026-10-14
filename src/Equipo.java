public class Equipo {
	private String marca;
	private String modelo;
	private String costoPorHora;
	private CondicionEquipo condicionEquipo;

	public Equipo(String marca, String modelo, String costoPorHora, CondicionEquipo condicionEquipo) {
		this.marca = marca;
		this.modelo = modelo;
		this.costoPorHora = costoPorHora;
		this.condicionEquipo = condicionEquipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCostoPorHora() {
		return costoPorHora;
	}

	public void setCostoPorHora(String costoPorHora) {
		this.costoPorHora = costoPorHora;
	}

	public CondicionEquipo getCondicionEquipo() {
		return condicionEquipo;
	}

	public void setCondicionEquipo(CondicionEquipo condicionEquipo) {
		this.condicionEquipo = condicionEquipo;
	}

}

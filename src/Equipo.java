public class Equipo {
	private String codigo;

	private String marca;
	private String modelo;
	private long costoPorHora;
	private CondicionEquipo condicionEquipo;

	public Equipo(String codigo, String marca, String modelo, long costoPorHora, CondicionEquipo condicionEquipo) {
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.costoPorHora = costoPorHora;
		this.condicionEquipo = condicionEquipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public long getCostoPorHora() {
		return costoPorHora;
	}

	public void setCostoPorHora(long costoPorHora) {
		this.costoPorHora = costoPorHora;
	}

	public CondicionEquipo getCondicionEquipo() {
		return condicionEquipo;
	}

	public void setCondicionEquipo(CondicionEquipo condicionEquipo) {
		this.condicionEquipo = condicionEquipo;
	}

	@Override
	public String toString() {
		String mensaje = "" + "\n";
		mensaje += "===============" + "\n";
		mensaje += "codigo : " + this.codigo + "\n";
		mensaje += "marca : " + this.marca + "\n";
		mensaje += "modelo : " + this.modelo + "\n";
		mensaje += "costoPorHora : " + this.costoPorHora + "\n";
		mensaje += "condicionEquipo : " + this.condicionEquipo + "\n";
		mensaje += "===============" + "\n";

		return mensaje;
	}
}

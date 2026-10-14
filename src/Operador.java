public class Operador {
	private String nombre;
	private String identificacion;
	private String certificacion;
	private int experienciaAnios;

	public Operador(String nombre, String identificacion, String certificacion, int experienciaAnios) {
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.certificacion = certificacion;
		this.experienciaAnios = experienciaAnios;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCertificacion() {
		return certificacion;
	}

	public void setCertificacion(String certificacion) {
		this.certificacion = certificacion;
	}

	public int getExperienciaAnios() {
		return experienciaAnios;
	}

	public void setExperienciaAnios(int experienciaAnios) {
		this.experienciaAnios = experienciaAnios;
	}

	@Override
	public String toString() {
		String mensaje = "" + "\n";
		mensaje += "===============" + "\n";
		mensaje += "nombre : " + this.nombre + "\n";
		mensaje += "identificacion : " + this.identificacion + "\n";
		mensaje += "certificacion : " + this.certificacion + "\n";
		mensaje += "experienciaAnios : " + this.experienciaAnios + "\n";
		mensaje += "===============" + "\n";

		return mensaje;
	}

}

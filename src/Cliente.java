public record Cliente(String nombre, String cedula, String telefono, String correo) {

	@Override
	public String toString() {
		String mensaje = "" + "\n";
		mensaje += "===============" + "\n";
		mensaje += "nombre : " + this.nombre + "\n";
		mensaje += "cedula : " + this.cedula + "\n";
		mensaje += "telefono : " + this.telefono + "\n";
		mensaje += "correo : " + this.correo + "\n";
		mensaje += "===============" + "\n";

		return mensaje;
	}

}

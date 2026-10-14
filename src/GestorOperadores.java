import java.util.ArrayList;

public class GestorOperadores {
	private ArrayList<Operador> operadores = new ArrayList<Operador>();

	public ArrayList<Operador> getOperadores() {
		return operadores;
	}

	public void setOperadores(ArrayList<Operador> operadores) {
		this.operadores = operadores;
	}

	public GestorOperadores() {
	}

	// CREATE - añadir cualquiera. ✅
	public boolean anadirOperador(Operador operador) {
		operadores.add(operador);
		return true;
	}

	// READ (listar todas como texto, para mostrar en JOptionPane)
	// Leer✅
	public String mostrarTodosOperadores() {
		String resultado = "";
		if (operadores == null || operadores.size() == 0) {
			return "No hay operadores registradas.";
		}

		for (int i = 0; i < operadores.size(); i++) {
			resultado = resultado + operadores.get(i).toString() + "\n";
		}
		return resultado;
	}

	// READ (buscar por id) devuelve objeto o null
	public Operador buscarOperadorPorIdentificacion(String identificacion) {
		Operador resultado = null;
		for (int i = 0; i < this.operadores.size(); i++) {
			if (identificacion.equalsIgnoreCase(this.operadores.get(i).getIdentificacion())) {
				resultado = this.operadores.get(i);
			}
		}
		return resultado;
	}

	// UPDATE - actualiza objeto
	public boolean actualizarInformacionOperador(
			String nuevoNombre, String identificacion, String nuevaCertificacion, int nuevaExperienciaAnios) {
		Operador operadorRecuperada = buscarOperadorPorIdentificacion(identificacion);
		if (operadorRecuperada == null) {
			return false;
		}
		operadorRecuperada.setNombre(nuevoNombre);
		operadorRecuperada.setCertificacion(nuevaCertificacion);
		operadorRecuperada.setExperienciaAnios(nuevaExperienciaAnios);
		return true;
	}

	// DELETE objeto
	public boolean eliminarOperador(String identificacion) {
		Operador operadorRecuperada = buscarOperadorPorIdentificacion(identificacion);
		if (operadorRecuperada == null) {
			return false;
		} else {
			this.operadores.remove(operadorRecuperada);
			return true;
		}
	}
}

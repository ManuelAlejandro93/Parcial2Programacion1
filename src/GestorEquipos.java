import java.util.ArrayList;

public class GestorEquipos {
	private ArrayList<Equipo> equipos = new ArrayList<Equipo>();

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}

	public GestorEquipos() {
	}

	// CREATE - añadir cualquiera. ✅
	public boolean anadirEquipo(Equipo equipo) {
		equipos.add(equipo);
		return true;
	}

	// READ (listar todas como texto, para mostrar en JOptionPane)
	// Leer✅
	public String mostrarTodosEquipos() {
		String resultado = "";
		if (equipos == null || equipos.size() == 0) {
			return "No hay equipos registradas.";
		}

		for (int i = 0; i < equipos.size(); i++) {
			resultado = resultado + equipos.get(i).toString() + "\n";
		}
		return resultado;
	}

	// READ (buscar por id) devuelve objeto o null
	public Equipo buscarEquipoPorCodigo(String codigo) {
		Equipo resultado = null;
		for (int i = 0; i < this.equipos.size(); i++) {
			if (codigo.equalsIgnoreCase(this.equipos.get(i).getCodigo())) {
				resultado = this.equipos.get(i);
			}
		}
		return resultado;
	}

	// UPDATE - actualiza objeto
	public boolean actualizarInformacionEquipo(
			String codigo, String nuevaMarca, String nuevoModelo, long nuevoCostoPorHora,
			CondicionEquipo nuevaCondicionEquipo) {
		Equipo equipoRecuperada = buscarEquipoPorCodigo(codigo);
		if (equipoRecuperada == null) {
			return false;
		}
		equipoRecuperada.setMarca(nuevaMarca);
		equipoRecuperada.setModelo(nuevoModelo);
		equipoRecuperada.setCostoPorHora(nuevoCostoPorHora);
		equipoRecuperada.setCondicionEquipo(nuevaCondicionEquipo);
		return true;
	}

	// DELETE objeto
	public boolean eliminarEquipo(String codigo) {
		Equipo equipoRecuperada = buscarEquipoPorCodigo(codigo);
		if (equipoRecuperada == null) {
			return false;
		} else {
			this.equipos.remove(equipoRecuperada);
			return true;
		}
	}
}

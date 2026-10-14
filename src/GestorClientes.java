import java.util.ArrayList;

public class GestorClientes {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public GestorClientes() {
	}

	// CREATE - añadir cualquiera. ✅
	public boolean anadirCliente(Cliente cliente) {
		clientes.add(cliente);
		return true;
	}

	// READ (listar todas como texto, para mostrar en JOptionPane)
	// Leer✅
	public String mostrarTodosClientes() {
		String resultado = "";
		if (clientes == null || clientes.size() == 0) {
			return "No hay clientes registradas.";
		}

		for (int i = 0; i < clientes.size(); i++) {
			resultado = resultado + clientes.get(i).toString() + "\n";
		}
		return resultado;
	}

	// !voy acá
	// READ (buscar por id) devuelve objeto o null
	public Cliente buscarClientePorCedula(String cedula) {
		Cliente resultado = null;
		for (int i = 0; i < this.clientes.size(); i++) {
			if (cedula.equalsIgnoreCase(this.clientes.get(i).cedula())) {
				resultado = this.clientes.get(i);
			}
		}
		return resultado;
	}

	// UPDATE - no hay update porque es Record

	// DELETE objeto
	public boolean eliminarCliente(String cedula) {
		Cliente clienteRecuperada = buscarClientePorCedula(cedula);
		if (clienteRecuperada == null) {
			return false;
		} else {
			this.clientes.remove(clienteRecuperada);
			return true;
		}
	}
}

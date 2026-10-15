import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Menu {
	private Empresa empresa;
	private DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public Menu(Empresa empresa) {
		this.empresa = empresa;
	}

	// ==================== MENÚ PRINCIPAL ====================
	public void mostrarMenuPrincipal() {
		boolean continuar = true;
		while (continuar) {
			String opciones = "=== SISTEMA ===\n\n"
					+ "1. Gestionar Equipos\n"
					+ "2. Gestionar Operarios\n"
					+ "3. Gestionar Clientes\n"
					+ "4. Gestionar Funciones Especiales\n"
					+ "0. Salir\n\n"
					+ "Seleccione una opción:";

			String opcion = JOptionPane.showInputDialog(null, opciones);

			if (opcion == null) {
				continuar = false;
				break;
			}
			switch (opcion) {
				case "1":
					menuEquipos();
					break;
				case "2":
					menuOperadores();
					break;
				case "3":
					menuClientes();
					break;
				case "4":
					menuFuncionesEspeciales();
					break;

				case "0":
					JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema!");
					continuar = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
			}
		}
	}

	// ==================== MENÚ EQUIPOS ====================
	private void menuEquipos() {
		boolean continuar = true;
		while (continuar) {
			String opciones = "=== GESTIÓN DE EQUIPOS ===\n\n"
					+ "1. Crear Equipo\n"
					+ "2. Listar Equipos\n"
					+ "3. Buscar Equipos por codigo\n"
					+ "4. Actualizar Equipo\n"
					+ "5. Eliminar Equipos\n"
					+ "6. Volver al Menú Principal\n\n"
					+ "Seleccione una opción:";

			String opcion = JOptionPane.showInputDialog(null, opciones);

			if (opcion == null) {
				continuar = false;
				break;
			}

			switch (opcion) {
				case "1":
					crearEquipos();
					break;
				case "2":
					listarEquipos();
					break;
				case "3":
					buscarEquipoPorCodigo();
					break;
				case "4":
					actualizarEquipo();
					break;
				case "5":
					eliminarEquipo();
					break;
				case "6":
					continuar = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
			}
		}
	}

	private void crearEquipos() {
		// String codigo,✅
		// String marca,✅
		// String modelo,✅
		// String costoPorHora,✅
		// CondicionEquipo condicionEquipo✅

		String codigo = JOptionPane.showInputDialog(null, "Ingrese codigo:");
		if (codigo == null)
			return;

		String marca = JOptionPane.showInputDialog(null, "Ingrese marca:");
		if (marca == null)
			return;

		String modelo = JOptionPane.showInputDialog(null, "Ingrese modelo:");
		if (modelo == null)
			return;

		String costoPorHora = JOptionPane.showInputDialog(null, "Ingrese costo por hora:");

		if (costoPorHora == null || costoPorHora.trim().isEmpty()) {
			return;
		}

		long costoPorHoraLong = Long.parseLong(costoPorHora);

		CondicionEquipo condicionEquipo = ingresarCondicionEquipo();

		Equipo nuevoEquipo = new Equipo(codigo, marca, modelo, costoPorHoraLong, condicionEquipo);

		boolean resultado = empresa.getGestorGeneral().getGestorEquipos().anadirEquipo(nuevoEquipo);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Equipo creado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo crear el equipo");
		}
	}

	// Ingresar estado operativo
	public CondicionEquipo ingresarCondicionEquipo() {
		String mensaje = "Seleccione una condicion de equipo posible: \n\n"
				+ "1. UTILIZADO\n"
				+ "2. EN_MANTENIMIENTO\n"
				+ "3. FUERA_DE_SERVICIO\n\n";
		String condicionEquipo = JOptionPane.showInputDialog(null, mensaje);

		switch (condicionEquipo) {
			case "1":
				return CondicionEquipo.DISPONIBLE;
			case "2":
				return CondicionEquipo.EN_MANTENIMIENTO;
			case "3":
				return CondicionEquipo.FUERA_DE_SERVICIO;
			default:
				return CondicionEquipo.DISPONIBLE;
		}
	}

	private void listarEquipos() {
		String equipos = empresa.getGestorGeneral().getGestorEquipos().mostrarTodosEquipos();
		JOptionPane.showMessageDialog(null, equipos);
	}

	private void buscarEquipoPorCodigo() {
		String codigo = JOptionPane.showInputDialog(null, "Ingrese codigo:");
		if (codigo == null)
			return;

		Equipo equipo = empresa.getGestorGeneral().getGestorEquipos().buscarEquipoPorCodigo(codigo);
		if (equipo != null) {
			JOptionPane.showMessageDialog(null, equipo.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
		}
	}

	private void actualizarEquipo() {
		// String codigo,✅
		// String marca,✅
		// String modelo,✅
		// long costoPorHora,
		// CondicionEquipo condicionEquipo

		String codigo = JOptionPane.showInputDialog(null, "Ingrese codigo del equipo a actualizar:");
		if (codigo == null)
			return;

		String nuevaMarca = JOptionPane.showInputDialog(null, "Ingrese nuevo marca:");
		if (nuevaMarca == null)
			return;

		String nuevoModelo = JOptionPane.showInputDialog(null, "Ingrese nuevo modelo:");
		if (nuevoModelo == null)
			return;

		String nuevoCostoPorHora = JOptionPane.showInputDialog(null, "Ingrese nuevo costo por hora:");

		if (nuevoCostoPorHora == null || nuevoCostoPorHora.trim().isEmpty()) {
			return;
		}

		long nuevoCostoPorHoraLong = Long.parseLong(nuevoCostoPorHora);

		CondicionEquipo nuevaCondicionEquipo = ingresarCondicionEquipo();

		boolean resultado = empresa.getGestorGeneral().getGestorEquipos().actualizarInformacionEquipo(codigo, nuevaMarca,
				nuevoModelo, nuevoCostoPorHoraLong, nuevaCondicionEquipo);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Equipo actualizado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
		}
	}

	private void eliminarEquipo() {
		String codigo = JOptionPane.showInputDialog(null, "Ingrese codigo del equipo a eliminar:");
		if (codigo == null)
			return;

		boolean resultado = empresa.getGestorGeneral().getGestorEquipos().eliminarEquipo(codigo);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Equipo eliminado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Equipo no encontrado.");
		}
	}

	// ==================== MENÚ OPERADORES ====================
	private void menuOperadores() {
		boolean continuar = true;
		while (continuar) {
			String opciones = "=== GESTIÓN DE OPERADORES ===\n\n"
					+ "1. Crear Operador\n"
					+ "2. Listar Operadores\n"
					+ "3. Buscar Operador por Código\n"
					+ "4. Actualizar Estado Operador\n"
					+ "5. Eliminar Operador\n"
					+ "6. Volver al Menú Principal\n\n"
					+ "Seleccione una opción:";

			String opcion = JOptionPane.showInputDialog(null, opciones);

			if (opcion == null) {
				continuar = false;
				break;
			}

			switch (opcion) {
				case "1":
					crearOperador();
					break;
				case "2":
					listarOperador();
					break;
				case "3":
					buscarOperadorPorCodigo();
					break;
				case "4":
					actualizarEstadoOperador();
					break;
				case "5":
					eliminarOperador();
					break;
				case "6":
					continuar = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
			}
		}
	}

	private void crearOperador() {
		// private String nombre;✅
		// private String identificacion;✅
		// private String certificacion;✅
		// private int experienciaAnios;

		String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre:");
		if (nombre == null)
			return;

		String identificacion = JOptionPane.showInputDialog(null, "Ingrese identificacion:");
		if (identificacion == null)
			return;

		String certificacion = JOptionPane.showInputDialog(null, "Ingrese certificacion:");
		if (certificacion == null)
			return;

		String aniosExperiencia = JOptionPane.showInputDialog(null, "Ingrese años de experiencia:");

		if (aniosExperiencia == null || aniosExperiencia.trim().isEmpty()) {
			return;
		}

		Integer aniosExperienciaInt = Integer.parseInt(aniosExperiencia);

		Operador nuevoOperador = new Operador(nombre, identificacion, certificacion, aniosExperienciaInt);

		boolean resultado = empresa.getGestorGeneral().getGestorOperadores().anadirOperador(nuevoOperador);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Operador creado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo crear el Operador");
		}
	}

	private void listarOperador() {
		String operadores = empresa.getGestorGeneral().getGestorOperadores().mostrarTodosOperadores();
		JOptionPane.showMessageDialog(null, operadores);
	}

	private void buscarOperadorPorCodigo() {
		String identificacion = JOptionPane.showInputDialog(null, "Ingrese identificacion a buscar: ");
		if (identificacion == null)
			return;

		Operador operador = empresa.getGestorGeneral().getGestorOperadores()
				.buscarOperadorPorIdentificacion(identificacion);

		if (operador != null) {
			JOptionPane.showMessageDialog(null, operador.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Operador no encontrado.");
		}
	}

	private void actualizarEstadoOperador() {
		// String identificacionx
		// String nombrex
		// String certificacion x
		// int experienciaAnios

		String identificacion = JOptionPane.showInputDialog(null, "Ingrese identificacion del operador a actualizar:");
		if (identificacion == null)
			return;

		String nuevaNombre = JOptionPane.showInputDialog(null, "Ingrese nuevo nombre:");
		if (nuevaNombre == null)
			return;

		String nuevoCertificacion = JOptionPane.showInputDialog(null, "Ingrese nuevo certificacion:");
		if (nuevoCertificacion == null)
			return;

		String nuevoExperienciaAnios = JOptionPane.showInputDialog(null, "Ingrese nueva experiencia en anios:");

		if (nuevoExperienciaAnios == null || nuevoExperienciaAnios.trim().isEmpty()) {
			return;
		}

		int nuevaExperienciaInt = Integer.parseInt(nuevoExperienciaAnios);

		boolean resultado = empresa.getGestorGeneral().getGestorOperadores()
				.actualizarInformacionOperador(nuevaNombre, identificacion, nuevoCertificacion, nuevaExperienciaInt);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Operario actualizado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Operario no encontrado.");
		}
	}

	private void eliminarOperador() {
		String identificacion = JOptionPane.showInputDialog(null, "Ingrese código del operario a eliminar:");
		if (identificacion == null)
			return;

		boolean resultado = empresa.getGestorGeneral().getGestorOperadores().eliminarOperador(identificacion);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Operador eliminado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Operador no encontrado.");
		}
	}

	// ==================== MENÚ CLIENTES ====================
	private void menuClientes() {
		boolean continuar = true;
		while (continuar) {
			String opciones = "=== GESTIÓN DE CLIENTES ===\n\n"
					+ "1. Crear Cliente\n"
					+ "2. Listar Clientes\n"
					+ "3. Buscar Cliente por Código\n"
					+ "4. Eliminar Cliente\n"
					+ "6. Volver al Menú Principal\n\n"
					+ "Seleccione una opción:";

			String opcion = JOptionPane.showInputDialog(null, opciones);

			if (opcion == null) {
				continuar = false;
				break;
			}

			switch (opcion) {
				case "1":
					crearCliente();
					break;
				case "2":
					listarClientes();
					break;
				case "3":
					buscarClientePorCodigo();
					break;
				case "4":
					eliminarCliente();
					break;
				case "6":
					continuar = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
			}
		}
	}

	private void crearCliente() {

		// String nombre x
		// String cedula x
		// String telefono x
		// String correo x

		String nombre = JOptionPane.showInputDialog(null, "Ingrese nombre:");
		if (nombre == null)
			return;

		String cedula = JOptionPane.showInputDialog(null, "Ingrese cedula:");
		if (cedula == null)
			return;

		String telefono = JOptionPane.showInputDialog(null, "Ingrese telefono:");
		if (telefono == null)
			return;

		String correo = JOptionPane.showInputDialog(null, "Ingrese correo:");
		if (correo == null)
			return;

		Cliente nuevoCliente = new Cliente(nombre, cedula, telefono, correo);

		boolean resultado = empresa.getGestorGeneral().getGestorClientes().anadirCliente(nuevoCliente);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Cliente creado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo crear el Cliente.");
		}

	}

	private void listarClientes() {
		String proyectos = empresa.getGestorGeneral().getGestorClientes().mostrarTodosClientes();
		JOptionPane.showMessageDialog(null, proyectos);
	}

	// No se puede actualizar cliente por requisito del sistema
	private void buscarClientePorCodigo() {
		String cedula = JOptionPane.showInputDialog(null, "Ingrese cédula del cliente a buscar:");
		if (cedula == null)
			return;

		Cliente cliente = empresa.getGestorGeneral().getGestorClientes().buscarClientePorCedula(cedula);
		if (cliente != null) {
			JOptionPane.showMessageDialog(null, cliente.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
		}
	}

	private void eliminarCliente() {
		String cedula = JOptionPane.showInputDialog(null, "Ingrese cédula del cliente a eliminar:");
		if (cedula == null)
			return;

		boolean resultado = empresa.getGestorGeneral().getGestorClientes().eliminarCliente(cedula);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Cliente eliminado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
		}
	}
	// ! 📌 Voy Acá 📌

	// ==================== MENÚ FUNCIONES ESPECIALES ====================
	private void menuFuncionesEspeciales() {
		boolean continuar = true;
		while (continuar) {
			String opciones = "=== GESTIÓN DE FUNCIONES ESPECIALES ===\n\n"
					+ "1. Configurar Turnos en reservas\n"
					+ "9. Volver al Menú Principal\n\n"
					+ "Seleccione una opción:";

			String opcion = JOptionPane.showInputDialog(null, opciones);

			if (opcion == null) {
				continuar = false;
				break;
			}

			switch (opcion) {
				case "1":
					crearProyecto();
					break;
				case "2":
					listarProyectos();
					break;
				case "3":
					buscarProyectoPorCodigo();
					break;
				case "4":
					asignarDesarrolladorAProyecto();
					break;
				case "5":
					agregarServicioAProyecto();
					break;
				case "6":
					calcularValorTotalProyecto();
					break;
				case "7":
					cambiarEstadoProyecto();
					break;
				case "8":
					eliminarProyecto();
					break;
				case "9":
					continuar = false;
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opción inválida. Intente nuevamente.");
			}
		}
	}

	private void crearProyecto() {
		String codigo = JOptionPane.showInputDialog(null, "Ingrese código del proyecto:");
		if (codigo == null)
			return;

		String documentoCliente = JOptionPane.showInputDialog(null, "Ingrese documento del cliente:");
		if (documentoCliente == null)
			return;

		Cliente cliente = empresa.getGestorGeneral().getGestorClientes().buscarClientePorDocumentoLegal(documentoCliente);
		if (cliente == null) {
			JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
			return;
		}

		String fechaSolicitud = JOptionPane.showInputDialog(null, "Ingrese fecha de solicitud (yyyy-MM-dd):");
		if (fechaSolicitud == null)
			return;

		String fechaInicio = JOptionPane.showInputDialog(null, "Ingrese fecha de inicio (yyyy-MM-dd):");
		if (fechaInicio == null)
			return;

		String fechaEntrega = JOptionPane.showInputDialog(null, "Ingrese fecha de entrega (yyyy-MM-dd):");
		if (fechaEntrega == null)
			return;

		String metodoPago = JOptionPane.showInputDialog(null,
				"Ingrese método de pago (Tarjeta de crédito/Transferencia bancaria/Efectivo):");
		if (metodoPago == null)
			return;

		try {
			LocalDate fSolicitud = LocalDate.parse(fechaSolicitud, formato);
			LocalDate fInicio = LocalDate.parse(fechaInicio, formato);
			LocalDate fEntrega = LocalDate.parse(fechaEntrega, formato);

			Proyecto nuevoProyecto = new Proyecto(codigo, fSolicitud, fInicio, fEntrega, metodoPago, cliente);
			boolean resultado = empresa.getGestorGeneral().getGestorProyectos().crear(nuevoProyecto);

			if (resultado) {
				JOptionPane.showMessageDialog(null, "Proyecto creado exitosamente.");
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo crear el proyecto. Límite alcanzado.");
			}
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Error: Formato de fecha inválido. Use yyyy-MM-dd");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
		}
	}

	private void listarProyectos() {
		String proyectos = empresa.getGestorGeneral().getGestorProyectos().mostrarProyectos();
		JOptionPane.showMessageDialog(null, proyectos);
	}

	private void buscarProyectoPorCodigo() {
		String codigo = JOptionPane.showInputDialog(null, "Ingrese código a buscar:");
		if (codigo == null)
			return;

		Proyecto proyecto = empresa.getGestorGeneral().getGestorProyectos().buscarProyectoPorCodigo(codigo);
		if (proyecto != null) {
			JOptionPane.showMessageDialog(null, proyecto.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
		}
	}

	private void asignarDesarrolladorAProyecto() {
		String codigoProyecto = JOptionPane.showInputDialog(null, "Ingrese código del proyecto:");
		if (codigoProyecto == null)
			return;

		Proyecto proyecto = empresa.getGestorGeneral().getGestorProyectos().buscarProyectoPorCodigo(codigoProyecto);
		if (proyecto == null) {
			JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
			return;
		}

		String codigoDesarrollador = JOptionPane.showInputDialog(null, "Ingrese código del desarrollador:");
		if (codigoDesarrollador == null)
			return;

		Desarrollador desarrollador = empresa.getGestorGeneral().getGestorDesarrolladores()
				.buscarDesarrolladorPorCodigo(codigoDesarrollador);
		if (desarrollador == null) {
			JOptionPane.showMessageDialog(null, "Desarrollador no encontrado.");
			return;
		}

		boolean resultado = proyecto.asignarDesarrollador(desarrollador);
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Desarrollador asignado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo asignar el desarrollador (no disponible o límite alcanzado).");
		}
	}

	private void agregarServicioAProyecto() {
		String codigoProyecto = JOptionPane.showInputDialog(null, "Ingrese código del proyecto:");
		if (codigoProyecto == null)
			return;

		Proyecto proyecto = empresa.getGestorGeneral().getGestorProyectos().buscarProyectoPorCodigo(codigoProyecto);
		if (proyecto == null) {
			JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
			return;
		}

		String codigoServicio = JOptionPane.showInputDialog(null, "Ingrese código del servicio:");
		if (codigoServicio == null)
			return;

		ServicioAdicional servicio = empresa.getGestorGeneral().getGestorServicios()
				.buscarServicioPorCodigo(codigoServicio);
		if (servicio == null) {
			JOptionPane.showMessageDialog(null, "Servicio no encontrado.");
			return;
		}

		boolean resultado = proyecto.agregarServicio(servicio);
		if (resultado) {
			JOptionPane.showMessageDialog(null, "Servicio agregado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "No se pudo agregar el servicio (límite alcanzado).");
		}
	}

	private void calcularValorTotalProyecto() {
		String codigoProyecto = JOptionPane.showInputDialog(null, "Ingrese código del proyecto:");
		if (codigoProyecto == null)
			return;

		Proyecto proyecto = empresa.getGestorGeneral().getGestorProyectos().buscarProyectoPorCodigo(codigoProyecto);
		if (proyecto == null) {
			JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
			return;
		}

		double valorTotal = proyecto.calcularValorTotal();
		JOptionPane.showMessageDialog(null, "Valor total del proyecto: $" + String.format("%.2f", valorTotal));
	}

	private void cambiarEstadoProyecto() {
		String codigoProyecto = JOptionPane.showInputDialog(null, "Ingrese código del proyecto:");
		if (codigoProyecto == null)
			return;

		String nuevoEstado = JOptionPane.showInputDialog(null,
				"Ingrese nuevo estado (Pendiente/Confirmado/En curso/Finalizado/Cancelado):");
		if (nuevoEstado == null)
			return;

		boolean resultado = empresa.getGestorGeneral().getGestorProyectos().cambiarEstadoProyecto(codigoProyecto,
				nuevoEstado);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Estado del proyecto actualizado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
		}
	}

	private void eliminarProyecto() {
		String codigoProyecto = JOptionPane.showInputDialog(null, "Ingrese código del proyecto a eliminar:");
		if (codigoProyecto == null)
			return;

		boolean resultado = empresa.getGestorGeneral().getGestorProyectos().eliminarProyecto(codigoProyecto);

		if (resultado) {
			JOptionPane.showMessageDialog(null, "Proyecto eliminado exitosamente.");
		} else {
			JOptionPane.showMessageDialog(null, "Proyecto no encontrado.");
		}
	}

	// ==================== MENÚ CONSULTA NÚMERO PERFECTO ====================
	private void menuConsultarClientePerfecto() {
		String telefono = JOptionPane.showInputDialog(null, "Ingrese el teléfono del cliente:");
		if (telefono == null)
			return;

		String resultado = empresa.getGestorGeneral().consultarClientePorTelefonoYValidarPerfecto(telefono);
		JOptionPane.showMessageDialog(null, resultado);
	}

	// ==================== MENÚ INGRESOS POR FECHA ====================
	private void menuConsultarIngresosPorFecha() {
		String fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha (yyyy-MM-dd):");
		if (fecha == null)
			return;

		try {
			LocalDate fechaConsultada = LocalDate.parse(fecha, formato);
			double ingresos = empresa.getGestorGeneral().consultarIngresosPorFecha(fechaConsultada);

			JOptionPane.showMessageDialog(null, "Ingresos en la fecha " + fecha + ": $" + String.format("%.2f", ingresos));
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Error: Formato de fecha inválido. Use yyyy-MM-dd");
		}
	}
}
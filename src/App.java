import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {

        TurnoDisponible turnosDisponible = new TurnoDisponible(TurnoNombre.MANANIA, TurnoNombre.TARDE,
                TurnoNombre.NOCHE);

        Empresa empresa = new Empresa("Sucursal1", "PixelRent", "Barrio Los Quindos", turnosDisponible);

        // ==================== AGREGAR EQUIPOS ====================
        Camara camara1 = new Camara("CAM001", "Canon", "EOS R5", 12000, CondicionEquipo.DISPONIBLE, 8000, true);
        Camara camara2 = new Camara("CAM002", "Sony", "A7S III", 15000, CondicionEquipo.DISPONIBLE, 12000, true);
        Camara camara3 = new Camara("CAM003", "Nikon", "Z9", 18000, CondicionEquipo.EN_MANTENIMIENTO, 45000, false);

        empresa.getGestorGeneral().getGestorEquipos().anadirEquipo(camara1);
        empresa.getGestorGeneral().getGestorEquipos().anadirEquipo(camara2);
        empresa.getGestorGeneral().getGestorEquipos().anadirEquipo(camara3);

        Dron dron1 = new Dron("DRN001", "DJI", "Air 3", 18000, CondicionEquipo.DISPONIBLE, 46, true);
        Dron dron2 = new Dron("DRN002", "DJI", "Air 2S", 15000, CondicionEquipo.DISPONIBLE, 31, false);
        Dron dron3 = new Dron("DRN003", "Auterll", "Evo 2", 12000, CondicionEquipo.FUERA_DE_SERVICIO, 42, true);

        empresa.getGestorGeneral().getGestorEquipos().anadirEquipo(dron1);
        empresa.getGestorGeneral().getGestorEquipos().anadirEquipo(dron2);
        empresa.getGestorGeneral().getGestorEquipos().anadirEquipo(dron3);

        Iluminacion iluminacion1 = new Iluminacion("ILU001", "Godox", "SL-60W", 10000, CondicionEquipo.DISPONIBLE, 4,
                true);
        Iluminacion iluminacion2 = new Iluminacion("ILU002", "Neewer", "RGB LED", 8000, CondicionEquipo.DISPONIBLE, 6,
                true);
        Iluminacion iluminacion3 = new Iluminacion("ILU003", "Aputure", "MC RGBWW", 12000,
                CondicionEquipo.EN_MANTENIMIENTO, 8, false);

        empresa.getGestorGeneral().getGestorEquipos().anadirEquipo(iluminacion1);
        empresa.getGestorGeneral().getGestorEquipos().anadirEquipo(iluminacion2);
        empresa.getGestorGeneral().getGestorEquipos().anadirEquipo(iluminacion3);

        // ==================== AGREGAR CLIENTES ====================
        Cliente cliente1 = new Cliente("Carlos López", "5001", "3001234567", "carlos@example.com");
        Cliente cliente2 = new Cliente("Ana Martínez", "5002", "3009876543", "ana@example.com");
        Cliente cliente3 = new Cliente("Roberto Gómez", "5003", "3015555555", "roberto@example.com");

        empresa.getGestorGeneral().getGestorClientes().anadirCliente(cliente1);
        empresa.getGestorGeneral().getGestorClientes().anadirCliente(cliente2);
        empresa.getGestorGeneral().getGestorClientes().anadirCliente(cliente3);

        // ==================== AGREGAR OPERADORES ====================
        Operador operador1 = new Operador("Juan Pérez", "1001", "Piloto Certificado", 5);
        Operador operador2 = new Operador("María García", "1002", "Técnica Audiovisual", 3);
        Operador operador3 = new Operador("Luis Rodríguez", "1003", "Piloto Avanzado", 7);

        empresa.getGestorGeneral().getGestorOperadores().anadirOperador(operador1);
        empresa.getGestorGeneral().getGestorOperadores().anadirOperador(operador2);
        empresa.getGestorGeneral().getGestorOperadores().anadirOperador(operador3);

        // ==================== AGREGAR RESERVAS ====================
        Reserva reserva1 = new Reserva("RES001", LocalDate.of(2026, 10, 20), TurnoNombre.TARDE,
                EstadoActualProceso.SOLICITADA);
        Reserva reserva2 = new Reserva("RES002", LocalDate.of(2026, 10, 21), TurnoNombre.MANANIA,
                EstadoActualProceso.SOLICITADA);
        Reserva reserva3 = new Reserva("RES003", LocalDate.of(2026, 10, 22), TurnoNombre.NOCHE,
                EstadoActualProceso.SOLICITADA);

        empresa.getGestorGeneral().getGestorReservas().anadirReserva(reserva1);
        empresa.getGestorGeneral().getGestorReservas().anadirReserva(reserva2);
        empresa.getGestorGeneral().getGestorReservas().anadirReserva(reserva3);

        // ==================== ASIGNAR CLIENTES A RESERVAS ====================
        reserva1.setCliente(cliente1);
        reserva2.setCliente(cliente2);
        reserva3.setCliente(cliente3);

        // ==================== AGREGAR EQUIPOS A RESERVAS ====================
        // Reserva 1: Cámara + Dron + Iluminación
        ReservaIndividualPorEquipo res1_equipo1 = new ReservaIndividualPorEquipo("RES1_EQ1", camara1, 5);
        ReservaIndividualPorEquipo res1_equipo2 = new ReservaIndividualPorEquipo("RES1_EQ2", dron1, 3);
        ReservaIndividualPorEquipo res1_equipo3 = new ReservaIndividualPorEquipo("RES1_EQ3", iluminacion1, 8);

        reserva1.getGestorReservasIndividuales().anadirReservaIndividual(res1_equipo1, reserva1,
                empresa.getGestorGeneral().getGestorReservas());
        reserva1.getGestorReservasIndividuales().anadirReservaIndividual(res1_equipo2, reserva1,
                empresa.getGestorGeneral().getGestorReservas());
        reserva1.getGestorReservasIndividuales().anadirReservaIndividual(res1_equipo3, reserva1,
                empresa.getGestorGeneral().getGestorReservas());

        // Reserva 2: Solo Cámara
        ReservaIndividualPorEquipo res2_equipo1 = new ReservaIndividualPorEquipo("RES2_EQ1", camara2, 4);
        reserva2.getGestorReservasIndividuales().anadirReservaIndividual(res2_equipo1, reserva2,
                empresa.getGestorGeneral().getGestorReservas());

        // Reserva 3: Dron + Iluminación
        ReservaIndividualPorEquipo res3_equipo1 = new ReservaIndividualPorEquipo("RES3_EQ1", dron2, 2);
        ReservaIndividualPorEquipo res3_equipo2 = new ReservaIndividualPorEquipo("RES3_EQ2", iluminacion2, 6);
        reserva3.getGestorReservasIndividuales().anadirReservaIndividual(res3_equipo1, reserva3,
                empresa.getGestorGeneral().getGestorReservas());
        reserva3.getGestorReservasIndividuales().anadirReservaIndividual(res3_equipo2, reserva3,
                empresa.getGestorGeneral().getGestorReservas());

        // ==================== ASIGNAR OPERADORES A RESERVAS ====================
        reserva1.setOperador(operador1); // RES001 tiene dron, necesita operador
        reserva3.setOperador(operador3); // RES003 tiene dron, necesita operador

        // ==================== CONFIRMAR RESERVAS ====================
        empresa.getGestorGeneral().getGestorReservas().confirmarReserva("RES001");
        empresa.getGestorGeneral().getGestorReservas().confirmarReserva("RES002");

        // RES003 NO se confirma (para mostrar validación)

        // ==================== INICIAR MENÚ ====================
        Menu menu = new Menu(empresa);
        menu.mostrarMenuPrincipal();
    }
}
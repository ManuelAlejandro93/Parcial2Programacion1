public class App {
    public static void main(String[] args) throws Exception {

        TurnoDisponible turnosDisponible = new TurnoDisponible();

        Empresa empresa = new Empresa("Sucursal1", "Sucursal1", "Barrio Los Quindos", turnosDisponible);

        Menu menu = new Menu(empresa);

        menu.mostrarMenuPrincipal();
    }
}

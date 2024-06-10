package ud09.actividades;

import java.sql.*;
import java.util.Scanner;

import ud09.test.Credenciales;

public class _09_GestionProductos {
    public static Scanner entrada = new Scanner(System.in);

    public static final int NUM_PAGINAS = 5;

    public static void menu() {
        int opcion = 0;
        do {
            System.out.println("----------------Gestion de productos----------------\n" +
                    "1.Mostrar productos por pagina\n" +
                    "2.Mostrar producto por nombre\n" +
                    "3.Mostrar numero total de productos\n" +
                    "4.Verificar si hay productos disponibles\n" +
                    "5.Salir\n");
            opcion = entrada.nextInt();
            entrada.nextLine();
            limpiarPantalla();
            switch (opcion) {
                case 1:
                    mostrarProductosPorPagina();
                    break;
                case 2:
                    System.out.println("Introduzca el nombre del producto");
                    buscarProductoPorNombre(entrada.nextLine());
                    break;
                case 3:
                    mostrarNumeroTotalDeProductos();
                    break;
                case 4:
                    verificarSiHayProductosDisponibles();
                    break;
                case 5:
                    System.out.println("ADIOOOS");
                    break;
                default:
                    System.out.println("Numero de opcion incorrecto, intentelo de nuevo.");
                    break;
            }
        } while (opcion != 5);
    }

    public static void menuPaginado() {
        System.out.println("----------------Mostrar producto paginado----------------\n" +
                "1.Inicio\n" +
                "2.Anterior\n" +
                "3.Siguiente\n" +
                "4.Ultima\n" +
                "5.Mostrar Pagina\n" +
                "6.Salir\n");
    }

    public static void limpiarPantalla() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void pulseParaContinuar() {
        System.out.println("Pulse enter para continuar: ");
        entrada.nextLine();
    }

    public static void mostrarProductosPorPagina() {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "Select * from productos";
            ResultSet rs = st.executeQuery(sql);

            rs.last();
            int total = rs.getRow();
            rs.beforeFirst();

            int opcion = 0;
            int numeroDePaginas = (int) Math.ceil((double) total / (double) NUM_PAGINAS);
            int numPaginaActual = 1;

            do {
                menuPaginado();
                opcion = entrada.nextInt();
                entrada.nextLine();
                limpiarPantalla();
                switch (opcion) {
                    case 1:
                        numPaginaActual = 1;
                        rs.beforeFirst();

                        System.out.printf("%-3s %-30s %-10s \n",
                                "ID", "Nombre", "Precio");

                        for (int i = 0; i < NUM_PAGINAS && rs.next(); i++) {
                            System.out.printf("%-3d %-30s %-10.2f\n",
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getDouble(3));
                        }
                        break;
                    case 2:
                        if (numPaginaActual > 1) {
                            numPaginaActual--;
                            rs.absolute((numPaginaActual * NUM_PAGINAS) - NUM_PAGINAS);
                            System.out.printf("%-3s %-30s %-10s \n",
                                    "ID", "Nombre", "Precio");

                            for (int i = 0; i < NUM_PAGINAS && rs.next(); i++) {
                                System.out.printf("%-3d %-30s %-10.2f\n",
                                        rs.getInt(1),
                                        rs.getString(2),
                                        rs.getDouble(3));
                            }
                        } else {
                            System.out.println("Ya estas en la primera pagina.");
                        }
                        break;
                    case 3:
                        if (numPaginaActual != numeroDePaginas) {
                            numPaginaActual++;
                            rs.absolute((numPaginaActual * NUM_PAGINAS) - NUM_PAGINAS);
                            System.out.printf("%-3s %-30s %-10s \n",
                                    "ID", "Nombre", "Precio");

                            for (int i = 0; i < NUM_PAGINAS && rs.next(); i++) {
                                System.out.printf("%-3d %-30s %-10.2f\n",
                                        rs.getInt(1),
                                        rs.getString(2),
                                        rs.getDouble(3));
                            }
                        } else {
                            System.out.println("Ya estas en la ultima pagina.");
                        }
                        break;
                    case 4:
                        numPaginaActual = numeroDePaginas;
                        rs.absolute((numeroDePaginas * NUM_PAGINAS) - NUM_PAGINAS);

                        System.out.printf("%-3s %-30s %-10s \n",
                                "ID", "Nombre", "Precio");

                        for (int i = 0; i < NUM_PAGINAS && rs.next(); i++) {
                            System.out.printf("%-3d %-30s %-10.2f\n",
                                    rs.getInt(1),
                                    rs.getString(2),
                                    rs.getDouble(3));
                        }
                        break;
                    case 5:
                        System.out.println("Introduzca la pagina:");
                        int num = entrada.nextInt();
                        entrada.nextLine();
                        if (num > 0 && num <= numeroDePaginas) {
                            numPaginaActual = num;
                            rs.absolute((numPaginaActual * NUM_PAGINAS) - NUM_PAGINAS);
                            System.out.printf("%-3s %-30s %-10s \n",
                                    "ID", "Nombre", "Precio");

                            for (int i = 0; i < NUM_PAGINAS && rs.next(); i++) {
                                System.out.printf("%-3d %-30s %-10.2f\n",
                                        rs.getInt(1),
                                        rs.getString(2),
                                        rs.getDouble(3));
                            }
                        } else {
                            System.out.println("Pagina no encontrada, intente con una que sea <= que " + numeroDePaginas);
                        }
                        break;
                    case 6:
                        System.out.println("Volviendo al menu principal");
                        break;
                    default:
                        System.out.println("Opcion equivocada, vuelva a intentarlo.");
                        break;
                }
                pulseParaContinuar();
                limpiarPantalla();
            } while (opcion != 6);
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buscarProductoPorNombre(String nombre) {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            Statement st = con.createStatement();
            String sql = "Select * from productos where nombre = '" + nombre + "'";
            ResultSet rs = st.executeQuery(sql);
            System.out.printf("%-3s %-30s %-10s \n",
                    "ID", "Nombre", "Precio");
            while (rs.next()) {
                System.out.printf("%-3d %-30s %-10.2f \n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3));
            }
            pulseParaContinuar();
            limpiarPantalla();
        } catch (SQLException e) {
            System.out.println("Error -> " + e.getMessage());
        }
    }

    public static void mostrarNumeroTotalDeProductos() {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "Select * from productos";
            ResultSet rs = st.executeQuery(sql);

            rs.last();
            int total = rs.getRow();
            System.out.println("Numero total de productos: " + total);

            pulseParaContinuar();
            limpiarPantalla();
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void verificarSiHayProductosDisponibles() {
        try (Connection con = DriverManager.getConnection(Credenciales.URL, Credenciales.USUARIO, Credenciales.CONTRASEÑA)) {
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "Select * from productos";
            ResultSet rs = st.executeQuery(sql);

            if (rs.isBeforeFirst()) {
                System.out.println("Hay productos disponibles en la base de datos.");
            } else if (rs.isAfterLast()) {
                System.out.println("No hay productos disponibles en la base de datos.");
            } else {
                rs.last();
                if (rs.getRow() > 0) {
                    System.out.println("Hay productos disponibles en la base de datos.");
                } else {
                    System.out.println("No hay productos disponibles en la base de datos.");
                }
            }

            pulseParaContinuar();
            limpiarPantalla();
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        menu();
    }
}

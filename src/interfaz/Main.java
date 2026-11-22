package interfaz;

import modelo.ProductoPerecedero;
import modelo.ProductoNoPerecedero;
import negocio.InventarioService;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        InventarioService servicio = new InventarioService();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nSISTEMA DE GESTION DE INVENTARIOS ");
            System.out.println("1. Registrar Producto Perecedero");
            System.out.println("2. Registrar Producto No Perecedero");
            System.out.println("3. Consultar Inventario Completo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                System.out.print("Ingrese el Codigo: ");
                String codigo = sc.nextLine();

                System.out.print("Ingrese el Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Ingrese el Precio Base ($): ");
                double precio = sc.nextDouble();

                System.out.print("Ingrese la Cantidad en Stock: ");
                int stock = sc.nextInt();

                System.out.print("Ingrese dias restantes para caducar: ");
                int diasCaducidad = sc.nextInt();
                sc.nextLine();

                // Validacion de campos vacios o numeros no validos
                if (codigo.equals("") || nombre.equals("") || precio <= 0 || stock <= 0 || diasCaducidad < 0) {
                    JOptionPane.showMessageDialog(null, "Error: No se permiten datos vacíos o valores numéricos menores/iguales a cero.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                } else {
                    ProductoPerecedero pp = new ProductoPerecedero(codigo, nombre, precio, stock, diasCaducidad);
                    String resultado = servicio.registrarProducto(pp);
                    JOptionPane.showMessageDialog(null, resultado, "Resultado del Registro", JOptionPane.INFORMATION_MESSAGE);
                }

            } else if (opcion == 2) {
                System.out.print("Ingrese el Codigo: ");
                String codigo = sc.nextLine();

                System.out.print("Ingrese el Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Ingrese el Precio Base ($): ");
                double precio = sc.nextDouble();

                System.out.print("Ingrese la Cantidad en Stock: ");
                int stock = sc.nextInt();

                System.out.print("Ingrese meses de garantia: ");
                int garantia = sc.nextInt();
                sc.nextLine();

                if (codigo.equals("") || nombre.equals("") || precio <= 0 || stock <= 0 || garantia < 0) {
                    JOptionPane.showMessageDialog(null, "Error: No se permiten datos vacíos o valores numéricos menores/iguales a cero.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
                } else {
                    ProductoNoPerecedero pnp = new ProductoNoPerecedero(codigo, nombre, precio, stock, garantia);
                    String resultado = servicio.registrarProducto(pnp);
                    JOptionPane.showMessageDialog(null, resultado, "Resultado del Registro", JOptionPane.INFORMATION_MESSAGE);
                }

            } else if (opcion == 3) {
                String inventarioStr = servicio.listarInventario();
                System.out.println("\n" + inventarioStr);
                JOptionPane.showMessageDialog(null, "Consulta de inventario completada exitosamente.", "Proceso Completado", JOptionPane.INFORMATION_MESSAGE);

            } else if (opcion == 4) {
                JOptionPane.showMessageDialog(null, "Proceso finalizado. Saliendo del sistema.", "Salida", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Sistema finalizado.");

            } else {
                JOptionPane.showMessageDialog(null, "Error: Opción no válida. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (opcion != 4);

        sc.close();
    }
}
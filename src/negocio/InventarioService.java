package negocio;

import modelo.Producto;
import java.util.ArrayList;

public class InventarioService {
    private ArrayList<Producto> listaProductos;
    private final int CAPACIDAD_MAXIMA_BODEGA = 500;

    public InventarioService() {
        this.listaProductos = new ArrayList<>();
    }

    public int calcularStockTotal() {
        int total = 0;
        for (int i = 0; i < listaProductos.size(); i++) {
            total += listaProductos.get(i).getStock();
        }
        return total;
    }

    public String registrarProducto(Producto p) {
        if (p.getPrecioBase() <= 0) {
            return "Error: El precio base debe ser mayor a cero.";
        }
        if (p.getStock() <= 0) {
            return "Error: La cantidad de stock debe ser mayor a cero.";
        }
        if (calcularStockTotal() + p.getStock() > CAPACIDAD_MAXIMA_BODEGA) {
            return "Error: Supera la capacidad máxima de la bodega (" + CAPACIDAD_MAXIMA_BODEGA + " unidades).";
        }

        // Bucle for tradicional para buscar duplicados con .equals()
        for (int i = 0; i < listaProductos.size(); i++) {
            Producto prod = listaProductos.get(i);
            if (prod.getCodigo().equals(p.getCodigo())) {
                return "Error: El código de producto ya se encuentra registrado.";
            }
        }

        listaProductos.add(p);
        return "¡Éxito! Producto registrado correctamente.";
    }

    public String listarInventario() {
        if (listaProductos.isEmpty()) {
            return "Error. El inventario se encuentra vacío.";
        }

        String reporte = "INVENTARIO DE PRODUCTOS EN BODEGA \n\n";

        for (int i = 0; i < listaProductos.size(); i++) {
            Producto p = listaProductos.get(i);
            reporte += "Código: " + p.getCodigo() +
                    " | Nombre: " + p.getNombre() +
                    " | Stock: " + p.getStock() +
                    " | " + p.obtenerDetallesEspecificos() +
                    "\n---------------------------------------------------\n";
        }

        return reporte;
    }
}

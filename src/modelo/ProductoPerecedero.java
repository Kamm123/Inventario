package modelo;

public class ProductoPerecedero extends Producto {
    private int diasParaCaducar;

    public ProductoPerecedero(String codigo, String nombre, double precioBase, int stock, int diasParaCaducar) {
        super(codigo, nombre, precioBase, stock);
        this.diasParaCaducar = diasParaCaducar;
    }

    public int getDiasParaCaducar() {
        return diasParaCaducar;
    }

    public void setDiasParaCaducar(int diasParaCaducar) {
        this.diasParaCaducar = diasParaCaducar;
    }

    @Override
    public double calcularPrecioFinal() {
        if (diasParaCaducar >= 0 && diasParaCaducar <= 7) {
            return getPrecioBase() * 0.80;
        }
        return getPrecioBase();
    }

    @Override
    public String obtenerDetallesEspecificos() {
        return "Tipo: Perecedero | Días para caducar: " + diasParaCaducar + " | Precio Final: $" + calcularPrecioFinal();
    }
}

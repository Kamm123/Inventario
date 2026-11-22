package modelo;

public class ProductoNoPerecedero extends Producto {
    private int garantiaMeses;

    public ProductoNoPerecedero(String codigo, String nombre, double precioBase, int stock, int garantiaMeses) {
        super(codigo, nombre, precioBase, stock);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public double calcularPrecioFinal() {
        return getPrecioBase() * 1.15;
    }

    @Override
    public String obtenerDetallesEspecificos() {
        return "Tipo: No Perecedero | Garantía: " + garantiaMeses + " meses | Precio Final (con IVA): $" + calcularPrecioFinal();
    }
}

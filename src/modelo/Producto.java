package modelo;

public class Producto {
    private String codigo;
    private String nombre;
    private double precioBase;
    private int stock;

    public Producto(String codigo, String nombre, double precioBase, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double calcularPrecioFinal() {
        return precioBase;
    }

    public String obtenerDetallesEspecificos() {
        return "Tipo: General | Precio Final: $" + calcularPrecioFinal();
    }
}
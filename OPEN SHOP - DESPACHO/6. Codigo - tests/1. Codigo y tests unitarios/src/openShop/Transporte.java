package openShop;

public class Transporte 
{
    private String nombre;
    private String domicilio;
    private float precio;

    public Transporte(String nombre, String domicilio, float precio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.precio = precio;
    }
    
    Transporte(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
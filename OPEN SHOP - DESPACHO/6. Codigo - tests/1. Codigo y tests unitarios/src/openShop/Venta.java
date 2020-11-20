package openShop;

import java.util.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
public class Venta 
{
    private int id;
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    private Cliente cliente;
    private Transporte transporte;
    private float totalAPagar;
    private boolean confirmacionPago;

    public Venta(int id, ArrayList<Producto> productos, Cliente cliente, Transporte transporte, float totalAPagar, boolean confirmacionPago) {
        this.id = id;
        this.productos = productos;
        this.cliente = cliente;
        this.transporte = transporte;
        this.totalAPagar = totalAPagar;
        this.confirmacionPago = confirmacionPago;
    }
    
    Venta(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Producto> getProductos() {
       return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isConfirmacionPago() {
        return this.confirmacionPago;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public float getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(float totalAPagar) {
        this.totalAPagar = totalAPagar;
    }
    
    @JsonIgnore
    @JsonProperty("getConfirmacionPago")
    public boolean getConfirmacionPago() {
        return this.confirmacionPago;
    }

    @JsonIgnore
    @JsonProperty("setConfirmacionPago")
    public void setConfirmacionPago(boolean confirmacionPago) {
        this.confirmacionPago = confirmacionPago;
    }
}
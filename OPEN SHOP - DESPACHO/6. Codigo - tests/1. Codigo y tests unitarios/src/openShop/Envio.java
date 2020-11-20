package openShop;

import java.time.LocalDate;
import java.util.ArrayList;

public class Envio 
{
    private LocalDate fecha;
    private Cliente cliente;
    private ArrayList<Producto> productosDespachoados;

    public Envio(LocalDate fecha, Cliente cliente, ArrayList<Producto> productosDespachoados) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.productosDespachoados = productosDespachoados;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Producto> getProductosDespachoados() {
        return productosDespachoados;
    }

    public void setProductosDespachoados(ArrayList<Producto> productosDespachoados) {
        this.productosDespachoados = productosDespachoados;
    }  
}
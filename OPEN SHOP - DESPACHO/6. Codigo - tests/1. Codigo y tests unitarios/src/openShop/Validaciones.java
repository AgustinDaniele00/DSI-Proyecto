package openShop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.map.ObjectMapper;

public class Validaciones {
    
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    public static ArrayList<Venta> ventas = new ArrayList<>();
    public static ArrayList<Producto> productos = new ArrayList<>();
    
    public boolean validarIdVenta() throws IOException{
        boolean idVentaCorrecto = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        for (Venta venta : ventas) {
            idVentaCorrecto = venta.getId() > 0;
        }
        
        return idVentaCorrecto;
    }
    
    public boolean validarNombre() throws IOException{
        boolean nombreCorrecto = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        for (Venta venta : ventas) {
            nombreCorrecto = venta.getCliente().getNombre() != null;
        }
        
        return nombreCorrecto;
    }
    
    public boolean validarApellido() throws IOException{
        boolean apellidoCorrecto = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        for (Venta venta : ventas) {
            apellidoCorrecto = venta.getCliente().getApellido() != null;
        }
        
        return apellidoCorrecto;
    }
    
    public boolean validarDNI() throws IOException{
        boolean dniCorrecto = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        for (Venta venta : ventas) {
            dniCorrecto = (venta.getCliente().getDni().length() == 7 || venta.getCliente().getDni().length() == 8) && 
                    venta.getCliente().getDni() != null;
        }
        
        return dniCorrecto;
    }
    
    public boolean validarDomicilio() throws IOException{
        boolean domicilioCorrecto = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        for (Venta venta : ventas) {
            domicilioCorrecto = venta.getCliente().getDomicilio() != null;
        }
        
        return domicilioCorrecto;
    }
    
    public boolean validarLocalidad() throws IOException{
        boolean localidadCorrecta = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        for (Venta venta : ventas) {
            localidadCorrecta = venta.getCliente().getLocalidad() != null;
        }
        
        return localidadCorrecta;
    }
    
    public boolean validarProvincia() throws IOException{
        boolean provinciaCorrecta = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        for (Venta venta : ventas) {
            provinciaCorrecta = venta.getCliente().getProvincia() != null;
        }
        
        return provinciaCorrecta;
    }
    
    
    public boolean validarIdProducto() throws IOException{
        boolean idProductoCorrecto = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        ventas.forEach(venta -> {
            productos = venta.getProductos();
        });
        
        for (Producto producto : productos){ 
            if(producto.getId() > 0){
                idProductoCorrecto = true;
            }
            else{
                idProductoCorrecto = false;
                break;
            }
        }
        
        return idProductoCorrecto;
    }
    
    public boolean validarNombreProducto() throws IOException{
        boolean nombreProductoCorrecto = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        ventas.forEach(venta -> {
            productos = venta.getProductos();
        });
        
        for (Producto producto : productos){ 
            if(producto.getNombre() != null){
                nombreProductoCorrecto = true;
            }
            else{
                nombreProductoCorrecto = false;
                break;
            }
        }
        
        return nombreProductoCorrecto;
    }
    
    public boolean validarMarcaProducto() throws IOException{
        boolean marcaProductoCorrecta = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        ventas.forEach(venta -> {
            productos = venta.getProductos();
        });
        
        for (Producto producto : productos){ 
            if(producto.getMarca() != null){
                marcaProductoCorrecta = true;
            }
            else{
                marcaProductoCorrecta = false;
                break;
            }
        }

        return marcaProductoCorrecta;
    }
    
    public boolean validarDescripcionProducto() throws IOException{
        boolean descripcionProductoCorrecta = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        ventas.forEach(venta -> {
            productos = venta.getProductos();
        });
        
        for (Producto producto : productos){ 
            if(producto.getDescripcion() != null){
                descripcionProductoCorrecta = true;
            }
            else{
                descripcionProductoCorrecta = false;
                break;
            }
        }
        
        return descripcionProductoCorrecta;
    } 
    
    public boolean validarPrecioProducto() throws IOException{
        boolean precioProductoCorrecto = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        ventas.forEach(venta -> {
            productos = venta.getProductos();
        });
        
        for (Producto producto : productos){
            
            if(producto.getPrecio() > 0 && String.valueOf(producto.getPrecio()) != null){
                precioProductoCorrecto = true;
            }
            else{
                precioProductoCorrecto = false;
                break;
            }
        }
        
        return precioProductoCorrecto;
    }
    
    public boolean validarCantidadProducto() throws IOException{
        boolean cantidadProductoCorrecta = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        ventas.forEach(venta -> {
            productos = venta.getProductos();
        });
        
         for (Producto producto : productos){
            
            if(producto.getCantidad() > 0 && String.valueOf(producto.getCantidad()) != null){
                cantidadProductoCorrecta = true;
            }
            else{
                cantidadProductoCorrecta = false;
                break;
            }
        }
        
        return cantidadProductoCorrecta;
    }
    
    public boolean validarPrecioTotal() throws IOException{
        boolean precioTotalCorrecto = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        for (Venta venta : ventas) {
            
            precioTotalCorrecto = venta.getTotalAPagar() > 0 && String.valueOf(venta.getTotalAPagar()) != null;
        }
        
        return precioTotalCorrecto;
    }
    
    public boolean validarConfirmacionPago() throws IOException{
        boolean pagoConfirmado = false;
        
        ventas = JSON_MAPPER.readValue(new File("src\\openShop\\archivo.json"),
        JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Venta.class));
        
        for (Venta venta : ventas) {
            
           pagoConfirmado = venta.getConfirmacionPago();
        }
        
        return pagoConfirmado;
    }
    
    public boolean jsonValido() throws IOException{
        return validarIdVenta() && validarNombre() && validarApellido() && validarDNI() && validarDomicilio()
                && validarLocalidad() && validarProvincia() && validarIdProducto() && validarNombreProducto()
                && validarMarcaProducto() && validarDescripcionProducto() && validarPrecioProducto()
                && validarCantidadProducto() && validarPrecioTotal() && validarConfirmacionPago();   
    }  
}
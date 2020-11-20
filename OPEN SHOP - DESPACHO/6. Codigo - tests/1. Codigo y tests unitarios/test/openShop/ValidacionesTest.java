package openShop;

import openShop.Validaciones;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidacionesTest {
    
    public ValidacionesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidarIdVenta() throws Exception {
        System.out.println("validarIdVenta");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarIdVenta();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarNombre() throws Exception {
        System.out.println("validarNombre");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarApellido() throws Exception {
        System.out.println("validarApellido");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarApellido();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarDNI() throws Exception {
        System.out.println("validarDNI");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarDNI();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarDomicilio() throws Exception {
        System.out.println("validarDomicilio");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarDomicilio();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarLocalidad() throws Exception {
        System.out.println("validarLocalidad");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarLocalidad();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarProvincia() throws Exception {
        System.out.println("validarProvincia");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarProvincia();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarIdProducto() throws Exception {
        System.out.println("validarIdProducto");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarIdProducto();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarNombreProducto() throws Exception {
        System.out.println("validarNombreProducto");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarNombreProducto();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarMarcaProducto() throws Exception {
        System.out.println("validarMarcaProducto");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarMarcaProducto();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarDescripcionProducto() throws Exception {
        System.out.println("validarDescripcionProducto");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarDescripcionProducto();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarPrecioProducto() throws Exception {
        System.out.println("validarPrecioProducto");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarPrecioProducto();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarCantidadProducto() throws Exception {
        System.out.println("validarCantidadProducto");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarCantidadProducto();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidarPrecioTotal() throws Exception {
        System.out.println("validarPrecioTotal");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarPrecioTotal();
        assertEquals(expResult, result);
    }

    @Test
    public void testValidarConfirmacionPago() throws Exception {
        System.out.println("validarConfirmacionPago");
        Validaciones instance = new Validaciones();
        boolean expResult = true;
        boolean result = instance.validarConfirmacionPago();
        assertEquals(expResult, result);
    }   
}
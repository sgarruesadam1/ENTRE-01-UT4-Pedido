

/**
 * Modela un pedido realizado por un cliente en una determinada fecha
 * El pedido incluye dos líneas de pedido que describen a cada uno de los dos
 * productos comprados en el pedido 
 * 
 *  Sergio Garrués Aizcorbe
 */
public class Pedido
{
    private final double IVA = 0.21;  // iva a aplicar
    private Fecha fecha;
    private Cliente cliente;
    private LineaPedido linea1;
    private LineaPedido linea2;

    /**
     * Constructor  
     */
    public Pedido(Fecha fecha, Cliente cliente, LineaPedido linea1, LineaPedido linea2)    {
         this.fecha = fecha;
         this.cliente = cliente;
         this.linea1 = linea1;
         this.linea2 = linea2;
    }

    /**
     * accesor para la fecha del pedido
     */
    public Fecha  getFecha() {
         return fecha;
    }

    /**
     * accesor para el cliente
     */
    public Cliente  getCliente() {
         return cliente;
    }
    
    
    /**
     * calcular y devolver el importe total del pedido sin Iva
     */
    public double  getImporteAntesIva() {
         return linea1.getCantidad() * linea1.getProducto().getPrecio() + linea2.getCantidad() * linea2.getProducto().getPrecio();
    }

    /**
     * calcular y devolver el iva a aplicar
     */
    public double getIva() {
         return getImporteAntesIva() * IVA;
    }

    /**
     * calcular y devolver el importe total del pedido con Iva
     */
    public  double getImporteTotal() {
         return getImporteAntesIva() + getIva();
    }

    /**
     * Representación textual del pedido
     * (ver enunciado)
     */
    public String toString() {
        String strSinIva = "IMPORTE SIN IVA:";
        String strIva = "IVA:";       
        String strTotal ="IMPORTE TOTAL:";
        
        String strPedido = String.format("-----------------\nFECHA PEDIDO: ")
        + fecha.toString() + "\nDATOS DEL CLIENTE\n" + cliente.toString()
        + String.format("\n\n**** Artículos en el pedido **** \n\n")
        + linea1.toString() + "\n" + linea2.toString()
        + String.format("\n\n**** A pagar **** \n\n")
        + String.format("%20s%8.2f" + "€" + "\n%20s%8.2f" + "€" + "\n%20s%8.2f" + "€\n",
        strSinIva, getImporteAntesIva(),
        strIva, getIva(), strTotal, getImporteTotal()); 
        return strPedido;
    }
    
    
    /**
     * devuelve true si el pedido actual es más antiguo que el recibido 
     * como parámetro
     */
    public boolean masAntiguoQue(Pedido otro) {
         if (fecha.getYear() < otro.getFecha().getYear())    {
             return true;
         }
         if (fecha.getYear() == otro.getFecha().getYear() && fecha.getMes() < otro.getFecha().getMes())    {
             return true;
         }
         if (fecha.getYear() == otro.getFecha().getYear() &&
         fecha.getMes() < otro.getFecha().getMes() &&
         fecha.getDia() < otro.getFecha().getDia()) {
             return true;
         }
         else {
             return false;
         }
    }
    
     /**
     * devuelve una referencia al pedido actual
     */
    public  LineaPedido  getPedidoActual() {
        return linea1.obtenerCopia();
    }

}

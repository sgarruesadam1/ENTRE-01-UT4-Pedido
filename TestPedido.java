
/**
 *  Clase para probar el resto de clases
 *  
 *   Sergio Garrués Aizcorbe
 *  
 */
public class TestPedido
{
    private Pedido pedido1; 
    private Pedido pedido2; 

    /**
     * Constructor  
     */
    public TestPedido()    {
        // crear pedido1
       pedido1 = new Pedido(new Fecha(4, 9, 2019),
       new Cliente("Juan Soto", "Avda. Pio XII", "Pamplona", "Navarra"),
       new LineaPedido(new Producto("Rotulador Fosforescente", 6.70), 20),
       new LineaPedido(new Producto("Memoria USB 64GB", 14.80) , 10));
       
       
       

        // crear pedido2
       pedido2 = new Pedido(new Fecha(8, 10, 2019),
       new Cliente("Elisa Nuin", "C/ Rio Alzania", "Pamplona", "Navarra"),
       new LineaPedido(new Producto("Sacapuntas manual", 16.64), 8),
       new LineaPedido(new Producto("Correcto tippex", 5.99), 20));
      

    }

    /**
     * Muestra la información de los dos pedidos (ver enunciado)
     */
    public void mostrarPedidos() {
        System.out.println("Pedido 1");
        System.out.println(pedido1.toString());
        System.out.println("Pedido 2");
        System.out.println(pedido2.toString());
        if  (pedido1.masAntiguoQue(pedido2))  {
            System.out.println("El pedido 1 se ha realizado antes que el pedido 2");
        }
        else    {
        System.out.println("El pedido 1 se ha realizado antes que el pedido 2");
        }
    }
}

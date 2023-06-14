package tiendajava.Servicios;

import java.util.Scanner;

public class ServicioTienda {
    
    private Scanner leer = new java.util.Scanner(System.in).useDelimiter("\n");
    ;
    private ServicioFabricante sf = new ServicioFabricante();
    private ServicioProducto sp = new ServicioProducto();
    private int op;
   

    public ServicioTienda() {
        op = 0;
        
    }

    public void menu() throws Exception {
      
        do {
            System.out.println("MENU");
            System.out.println("1- Lista el nombre de todos los productos que hay en la tabla producto.");
            System.out.println("2- Lista los nombres y los precios de todos los productos de la tabla producto.");
            System.out.println("3- Listar aquellos productos que su precio esté entre 120 y 202.");
            System.out.println("4- Buscar y listar todos los Portátiles de la tabla producto.");
            System.out.println("5- Listar el nombre y el precio del producto más barato.");
            System.out.println("6- Ingresar un producto a la base de datos");
            System.out.println("7- Ingresar un fabricante a la base de datos");
            System.out.println("9- Salir");
            op = leer.nextInt();

            switch (op) {
                case 1:
                    sp.imprimirProductos();
                    break;
                case 2:
                    sp.imprimirProductosNombrePrecio();
                    break;
                case 3:
                    sp.imprimirProductosPrecio(); //Modificar para buscar precio
                    break;
                case 4:
                    sp.imprimirProductoRef();
                    break;
                case 5:
                    sp.imprimirProdMasBarato();
                    break;
                case 6:
                    System.out.println("ingrese el nuevo producto");
                    System.out.println("codigo | nombre | precio | cod_fabricante ");
                    sp.crearProducto(leer.nextInt(), leer.next(), leer.nextDouble(),leer.nextInt());
                    sp.imprimirProductosNombrePrecio();
                    break;
                 case 7:
                    System.out.println("ingrese el nuevo Fabricante");
                    System.out.println("codigo | nombre ");
                    sf.crearFabricante(leer.nextInt(),leer.next());
                    sf.imprimirFabricantes();
                    break;
                 case 8:
                     System.out.println("codigo | nombre | precio | cod_fabricante ");
                     sp.modificarProducto(leer.nextInt(), leer.next(), leer.nextDouble(),leer.nextInt());
                     break;
            }
        } while (op != 9);

    }
}

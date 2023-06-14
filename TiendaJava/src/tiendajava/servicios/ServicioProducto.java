package tiendajava.Servicios;

import tiendajava.entidades.Producto;
import tiendajava.persistencia.ProductoDAO;
import java.util.Collection;

public class ServicioProducto {

    private ProductoDAO dao;

    public ServicioProducto() {
        this.dao = new ProductoDAO();
    }

    public void crearProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception {

        try {
            //Validamos
            if (codigo == 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (precio == 0) {
                throw new Exception("Debe indicar el precio");
            }

            if (codigoFabricante == 0) {
                throw new Exception("Debe indicar el codigo del producto");
            }

            //Creamos el producto
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);

            dao.guardarProducto(producto);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception {

        try {

            //Validamos
            if (codigo == 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            

            if (codigoFabricante == 0) {
                throw new Exception("Debe indicar el codigo del producto");
            }
            
            //Buscamos
            Producto producto = dao.buscarProductoPorCodigo(codigo);
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);
            dao.modificarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(int codigo) throws Exception {

        try {

            //Validamos 
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            Producto producto = dao.buscarProductoPorCodigo(codigo);

            //Verificamos
            if (producto == null) {
                throw new Exception("No se encontró producto para el codigo indicado");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProducto() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductos() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProducto();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductosNombrePrecio() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = dao.listarPorNombrePrecio();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println("Nombre:"+u.getNombre()+"|| Precio:"+ u.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductosPrecio() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = dao.listarPorPrecio();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirProductoRef() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = dao.listarPorRef();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
 public void imprimirProdMasBarato() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = dao.listarPorProdMasBarato();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println("Nombre:"+u.getNombre()+" || Precio:"+ u.getPrecio());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}

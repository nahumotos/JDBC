package tiendajava.Servicios;

import tiendajava.entidades.Fabricante;
import tiendajava.persistencia.FabricanteDAO;
import java.util.Collection;

public class ServicioFabricante{

    private FabricanteDAO dao;

    public ServicioFabricante() {
        this.dao = new FabricanteDAO();
    }

    public void crearFabricante(int codigo, String nombre) throws Exception {

        try {
            //Validamos
            if (codigo == 0)  {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe indicar el nombre");
            }

            //Creamos el fabricante
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);

            dao.guardarFabricante(fabricante);

        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarClaveFabricante(int codigo, String nombre) throws Exception {

        try {

            //Validamos
 
            if (codigo == 0) {
                throw new Exception("Debe indicar el codigo");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            //Buscamos
            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);

            dao.modificarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(int codigo) throws Exception {

        try {
            
            //Validamos 
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            dao.eliminarFabricante(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);
            
            //Verificamos
            if (fabricante == null) {
                throw new Exception("No se encontró fabricante para el codigo indicado");
            }

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Fabricante> listarFabricante() throws Exception {

        try {

            Collection<Fabricante> fabricantes = dao.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricantes() throws Exception {

        try {

            //Listamos los fabricantes
            Collection<Fabricante> fabricantes = listarFabricante();

            //Imprimimos los fabricantes
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (Fabricante u : fabricantes) {
                    System.out.println(u.toString());
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}

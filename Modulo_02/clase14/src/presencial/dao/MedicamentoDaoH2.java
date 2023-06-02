package presencial.dao;

import org.apache.log4j.Logger;
import presencial.modelo.Medicamento;

import java.sql.*;


public class MedicamentoDaoH2 implements IDao<Medicamento>{
    private static final String SQL_INSERT= "INSERT INTO MEDICAMENTOS(nombre, laboratorio, cantidad,precio) VALUES (?,?,?,?)";
    private static final String SQL_SELECT=
            "SELECT * FROM MEDICAMENTOS WHERE ID=?";
    private static final Logger logger= Logger.getLogger(MedicamentoDaoH2.class);
    @Override
    public Medicamento guardar(Medicamento medicamento) {
        //conectarnos a la base y guardar el medicamento
       //logger iniciando el guardado del medicamento nombre.
        logger.info("Registrando un pedido de nuevo"+medicamento.toString());
        Connection connection=null;

        try{
            connection=BD.getConnection();
            PreparedStatement ps= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
            ps.setString(1,medicamento.getNombre());
            ps.setString(2,medicamento.getLaboratorio());
            ps.setInt(3,medicamento.getCantidad());
            ps.setDouble(4,medicamento.getPrecio());
            ps.executeUpdate();

            //procesar la clave autogenerada
            ResultSet claveGenerada=ps.getGeneratedKeys();
//            System.out.println(claveGenerada);

            //Le asignamos el id al medicamento
            while (claveGenerada.next()){
                medicamento.setId(claveGenerada.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        logger.info("El medicamento se registró con éxito:"+medicamento.toString());
        return medicamento;

    }

    @Override
    public Medicamento buscar(Integer id) {
        //logger
        logger.info("Buscando al medicamento con id:"+id);
        Connection connection=null;
        Medicamento medicamento=null;
        try{
            connection=BD.getConnection();
            PreparedStatement ps=connection.prepareStatement(SQL_SELECT);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                medicamento=new Medicamento(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)
                );
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        logger.info("El medicamento se encontró, esta es su información:"+medicamento.toString());
        return medicamento;
    }
}


package controlador;

import sql.Conexion;
import modelo.Encomienda;
import java.sql.*;
import java.util.ArrayList;

public class Registro {
    
    public static boolean agregarEncomienda(Encomienda encomienda){
        try{
            Connection conexion = Conexion.getConexion();
            String query = "INSERT INTO encomienda(en_id,en_destinatario,en_direccion,en_tipo,en_entregadomicilio,en_tamano,en_remitente) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement insertar = conexion.prepareStatement(query);
            insertar.setInt(1, encomienda.getEn_id());
            insertar.setString(2, encomienda.getEn_destinatario());
            insertar.setString(3, encomienda.getEd_direccion());
            insertar.setString(4, encomienda.getEn_tipo());
            insertar.setBoolean(5, encomienda.isEn_entregadomicilio());
            insertar.setString(6, encomienda.getEn_tamano());
            insertar.setString(7, encomienda.getEn_remitente());
            insertar.execute();
            insertar.close();
            conexion.close();
            return true;
        }catch(SQLException s){
            System.out.println("Error SQL al agregar encomienda"+s.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Error al agregar encomienda"+e.getMessage());
            return false;
        }
    }
    
    public static boolean editarEncomienda(Encomienda encomienda){
        try{
            Connection conexion = Conexion.getConexion();
            String query = "UPDATE encomienda SET "
                    + " en_destinatario=?, "
                    + " en_direccion=?, "
                    + " en_tipo=?, "
                    + " en_entregadomicilio=?,"
                    + " en_tamano=?, "
                    + " en_remitente=? "
                    + " WHERE en_id=?";
            PreparedStatement insertar = conexion.prepareStatement(query);
            insertar.setString(1, encomienda.getEn_destinatario());
            insertar.setString(2, encomienda.getEd_direccion());
            insertar.setString(3, encomienda.getEn_tipo());
            insertar.setBoolean(4, encomienda.isEn_entregadomicilio());
            insertar.setString(5, encomienda.getEn_tamano());
            insertar.setString(6, encomienda.getEn_remitente());
            insertar.setInt(7, encomienda.getEn_id());
            insertar.execute();
            insertar.close();
            conexion.close();
            return true;
        }catch(SQLException s){
            System.out.println("Error SQL al editar encomienda"+s.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Error al editar encomienda"+e.getMessage());
            return false;
        }
    }
    
    public static boolean eliminarEncomienda(int idEliminar){
        try{
            Connection conexion = Conexion.getConexion();
            String query = "DELETE FROM encomienda WHERE en_id=?";
            PreparedStatement eliminar = conexion.prepareStatement(query);
            eliminar.setInt(1, idEliminar);
            int filas_afectadas = eliminar.executeUpdate();
            eliminar.close();
            conexion.close();
            if (filas_afectadas == 0) {
                System.out.println("El ID de encomienda no existe en la base de datos.");
                return false;
            }
            return true;
        }catch(SQLException s){
            System.out.println("Error SQL al eliminar encomienda"+s.getMessage());
            return false;
        }catch(Exception e){
            System.out.println("Error al eliminar encomienda"+e.getMessage());
            return false;            
        }
    }
 
    public static Encomienda buscarPorID(int id){
        ArrayList<Encomienda> listaEncomienda = new ArrayList<Encomienda>();
        Encomienda encomiendaBuscada = null;
        try{
            Connection conexion = Conexion.getConexion();
            String query = "SELECT en_id,en_destinatario,en_direccion,en_tipo,en_entregadomicilio,en_tamano,en_remitente from encomienda where en_id=?";
            PreparedStatement buscarPorID= conexion.prepareStatement(query);
            buscarPorID.setInt(1, id);
            ResultSet rs = buscarPorID.executeQuery(); 
            while(rs.next()){
                Encomienda encomienda = new Encomienda();
                encomienda.setEn_id(rs.getInt("en_id"));
                encomienda.setEn_destinatario(rs.getString("en_destinatario"));
                encomienda.setEd_direccion(rs.getString("en_direccion"));
                encomienda.setEn_tipo(rs.getString("en_tipo"));
                encomienda.setEn_entregadomicilio(rs.getBoolean("en_entregadomicilio"));
                encomienda.setEn_tamano(rs.getString("en_tamano"));
                encomienda.setEn_remitente(rs.getString("en_remitente"));
                encomiendaBuscada = encomienda;
                return encomiendaBuscada;
            }
        }catch(SQLException s){
            System.out.println("Error SQL al listar enocmienda"+s.getMessage());
        }catch(Exception e){
            System.out.println("Error al listar encomienda"+e.getMessage());
        }
        return null;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author SENA
 */
public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String documentoCliente;
    private String correoCliente;
    private String contraseñaCliente;
    private String celularCliente;



    public String getContraseñaCliente() {
        return contraseñaCliente;
    }

    public void setContraseñaCliente(String contraseñaCliente) {
        this.contraseñaCliente = contraseñaCliente;
    }
    

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }


    public String getCelularCliente() {
        return celularCliente;
    }

    public void setCelularCliente(String celularCliente) {
        this.celularCliente = celularCliente;
    }

    @Override
    public String toString() {
        return  nombreCliente + "";
    }

    

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return this.idCliente == other.idCliente;
    }
    
    public Iterator<Cliente> listar(){
        ArrayList<Cliente> losClientes = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Cliente unCliente;
            while (rs.next()){
                unCliente = new Cliente();
                System.out.println("id cliente "  + rs.getInt ("idCliente"));
                unCliente.setIdCliente(rs.getInt ("idCliente"));
                unCliente.setNombreCliente(rs.getString ("nombreCliente"));
                unCliente.setDocumentoCliente(rs.getString  ("documentoCliente"));
                unCliente.setCorreoCliente(rs.getString ("correoCliente"));
                unCliente.setContraseñaCliente(rs.getString ("contraseñaCliente"));
                unCliente.setCelularCliente(rs.getString("celularCliente"));
                losClientes.add(unCliente);
                
            }
        }catch (SQLException ex){
            System.err.println("Error al listar Cliente:"+ex.getMessage());
        }
       if (losClientes.isEmpty()){
            Cliente miCliente = new Cliente();
            miCliente.setNombreCliente("No hay clientes");
            losClientes.add(miCliente);
        }  
        return losClientes.iterator();
    }    
    public void insertar(){
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("INSERT INTO cliente VALUES(NULL,?,?,?,?,?,?)");
            sql.setString(1, this.getNombreCliente());
            sql.setString(2, this.getDocumentoCliente());
            sql.setString(3, this.getCorreoCliente());
            sql.setString(4, this.getContraseñaCliente());
            sql.setString(5, this.getCelularCliente());
            sql.setString(6, "admin");
            System.out.println(sql);
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+ "Insertado correctamente");
        }catch (SQLException ex){
            System.err.println("Error al insertar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public void modificar(){
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE cliente SET nombreCliente = ?, documentoCliente = ?, correoCliente =?, contraseñaCliente =?, celularCliente =?  WHERE idCliente =? ");
            sql.setString(1, this.getNombreCliente());
            sql.setString(2, this.getDocumentoCliente());
            sql.setString(3, this.getCorreoCliente());
            sql.setString(4, this.getContraseñaCliente());
            sql.setString(5, this.getCelularCliente());
            sql.setInt(6, this.getIdCliente());
            System.out.println(sql);
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+ "modificado correctamente");
            
        }catch (SQLException ex){
            System.err.println("Error al modificar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
      
    }
    public void eliminar(){
        try{
            PreparedStatement sql =  ConexionBD.conexion.prepareStatement("DELETE FROM  cliente WHERE idCliente = ?" );
            sql.setInt(1, this.getIdCliente());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+ "Eliminado correctamente");
        }catch (SQLException ex){
            System.err.println("Error al eliminar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public Iterator<Cliente> buscar(String busqueda){
        ArrayList<Cliente> losClientes = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName()+" WHERE nombreCliente LIKE ? OR documentoCliente LIKE ? OR correoCliente LIKE ? OR contraseñaCliente LIKE ? OR celularCliente LIKE ?    OR idCliente LIKE ?");
            sql.setString(1,"%"+busqueda+"%");
            sql.setString(2,"%"+busqueda+"%");
            sql.setString(3,"%"+busqueda+"%");
            sql.setString(4,"%"+busqueda+"%");
            sql.setString(5,"%"+busqueda+"%");
            sql.setString(6,"%"+busqueda+"%");
            ResultSet rs = sql.executeQuery();
            Cliente unCliente;
            while (rs.next()){
                unCliente = new Cliente();
                unCliente.setIdCliente(rs.getInt("idCliente"));
                unCliente.setNombreCliente(rs.getString("nombreCliente"));
                unCliente.setDocumentoCliente(rs.getString("documentoCliente"));
                unCliente.setCorreoCliente(rs.getString ("correoCliente"));
                unCliente.setContraseñaCliente(rs.getString ("contraseñaCliente"));
                unCliente.setCelularCliente(rs.getString("celularCliente"));
                losClientes.add(unCliente);
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
        return losClientes.iterator();
    }
    public   Cliente buscarPorId (int elId){
        Cliente unCliente = new Cliente();
        unCliente.setNombreCliente("Cliente no existe");
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM cliente WHERE idCliente = ?");
            sql.setInt(1, elId);
            ResultSet rs  =  sql.executeQuery();
            while (rs.next()){
                unCliente.setIdCliente(rs.getInt ("idCliente"));
                unCliente.setNombreCliente(rs.getString ("nombreCliente"));
                unCliente.setDocumentoCliente(rs.getString ("documentoCliente"));
                unCliente.setCorreoCliente(rs.getString ("correoCliente"));
                unCliente.setContraseñaCliente(rs.getString ("contraseñaCliente"));
                unCliente.setCelularCliente(rs.getString("celularCliente"));
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar por Id"+ex.getMessage());
        }
        return unCliente;
    }

}
    


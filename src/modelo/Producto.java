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
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private String facturaProducto;
    private String precioProducto;
    private String stockProducto;

    public String getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(String stockProducto) {
        this.stockProducto = stockProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFacturaProducto() {
        return facturaProducto;
    }

    public void setFacturaProducto(String facturaProducto) {
        this.facturaProducto = facturaProducto;
    }

    public String getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombreProducto=" + nombreProducto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Producto other = (Producto) obj;
        return this.idProducto == other.idProducto;
    }
    
    
    
     public Iterator<Producto> listar(){
        ArrayList<Producto> losProductos = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName());
            ResultSet rs = sql.executeQuery();
            Producto unProducto;
            while (rs.next()){
                unProducto = new Producto();
                unProducto.setIdProducto(rs.getInt ("idProducto"));
                unProducto.setNombreProducto(rs.getString ("nombreProducto"));
                unProducto.setPrecioProducto(rs.getString ("precioProducto"));
                unProducto.setStockProducto(rs.getString ("stockProducto"));
                losProductos.add(unProducto);
                
            }
        }catch (SQLException ex){
            System.err.println("Error al listar Producto:"+ex.getMessage());
        }
       if (losProductos.isEmpty()){
            Producto miProducto = new Producto();
            miProducto.setNombreProducto("No hay productos");
            losProductos.add(miProducto);
        }  
        return losProductos.iterator();
    }    
    public void insertar(){
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("INSERT INTO producto VALUES(NULL,?,?,?)");
            sql.setString(1, this.getNombreProducto());
            sql.setString(2, this.getStockProducto());
            sql.setString(3, this.getPrecioProducto());
            System.out.println(sql);
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+ "Insertado correctamente");
        }catch (SQLException ex){
            System.err.println("Error al insertar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public void modificar(){
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("UPDATE producto SET nombreProducto = ?, precioProducto = ?, stockProducto =? WHERE idProducto =? ");
            sql.setString(1, this.getNombreProducto());
            sql.setString(2, this.getPrecioProducto());
            sql.setString(3, this.getStockProducto());
            sql.setInt(4, this.getIdProducto());
            System.out.println(sql);
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+ "modificado correctamente");
            
        }catch (SQLException ex){
            System.err.println("Error al modificar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
      
    }
    public void eliminar(){
        try{
            PreparedStatement sql =  ConexionBD.conexion.prepareStatement("DELETE FROM  producto WHERE idProducto = ?" );
            sql.setInt(1, this.getIdProducto());
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+ "Eliminado correctamente");
        }catch (SQLException ex){
            System.err.println("Error al eliminar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    public Iterator<Producto> buscar(String busqueda){
        ArrayList<Producto> losProductos = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName()+" WHERE nombreProducto LIKE ? OR precioProducto LIKE ? OR stockProducto LIKE ? OR idProducto LIKE ?");
            sql.setString(1,"%"+busqueda+"%");
            sql.setString(2,"%"+busqueda+"%");
            sql.setString(3,"%"+busqueda+"%");
            sql.setString(4,"%"+busqueda+"%");
            ResultSet rs = sql.executeQuery();
            Producto unProducto;
            while (rs.next()){
                unProducto = new Producto();
                unProducto.setIdProducto(rs.getInt("idProducto"));
                unProducto.setNombreProducto(rs.getString("nombreProducto"));
                unProducto.setPrecioProducto(rs.getString("precioProducto"));
                unProducto.setStockProducto(rs.getString("stockProducto"));
                losProductos.add(unProducto);
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
        return losProductos.iterator();
    }
    public   Producto buscarPorId (int elId){
        Producto unProducto = new Producto();
        unProducto.setNombreProducto("Producto no existe");
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM producto  WHERE idProducto = ?");
            sql.setInt(1, elId);
            ResultSet rs  =  sql.executeQuery();
            while (rs.next()){
                unProducto.setIdProducto(rs.getInt ("idProducto"));
                unProducto.setNombreProducto(rs.getString ("nombreProducto"));
                unProducto.setPrecioProducto(rs.getString ("precioProducto"));
                unProducto.setStockProducto(rs.getString ("stockProducto"));
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar por Id"+ex.getMessage());
        }
        return unProducto;
    }

}
    

    


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author SENA
 */
public class Venta {
    
    private int idFactura;
    private int idProducto;
    private int cantidadProducto;
    private int valorDetalle;

    public int getValorDetalle() {
        return valorDetalle;
    }

    public void setValorDetalle(int valorDetalle) {
        this.valorDetalle = valorDetalle;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
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
        final Venta other = (Venta) obj;
        return this.idFactura == other.idFactura;
    }
    
    public Iterator<Cliente> listarNombre(){
        ArrayList<Cliente> losClientes = new ArrayList<>();
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM where nombreCliente");
            ResultSet rs = sql.executeQuery();
            Cliente unCliente;
            while (rs.next()){
                unCliente = new Cliente();
                unCliente.setNombreCliente(rs.getString("nombreCliente"));
                losClientes.add(unCliente);
                
            }
        }catch (SQLException ex){
            System.err.println("Error al listar Venta:"+ex.getMessage());
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
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("INSERT INTO detalle VALUES(?,?,?,?)");
            sql.setInt(1, this.getIdFactura());
            sql.setInt(2, this.getIdProducto());
            sql.setInt(3, this.getCantidadProducto());
            sql.setInt(4, this.getValorDetalle());
            System.out.println(sql);
            sql.executeUpdate();
            System.out.println(this.getClass().getSimpleName()+ "Insertado correctamente");
        }catch (SQLException ex){
            System.err.println("Error al insertar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
    }
    
}

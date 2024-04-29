/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Iterator;

/**
 *
 * @author SENA
 */
public class Factura {
    
    private int idFactura;
    private int idCliente;
    private Date fechaFactura;
    private int subTotal;

        public int getSubTotal() {
            return subTotal;
        }

        public void setSubTotal(int subTotal) {
            this.subTotal = subTotal;
        }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    @Override
    public String toString() {
        return  idFactura + "";
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
        final Factura other = (Factura) obj;
        return this.idFactura == other.idFactura;
    }
    
    
        
    public int insertar(){
        try {
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("INSERT INTO factura VALUES(?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            sql.setInt(1, this.getIdFactura());
            sql.setInt(2, this.getIdCliente());
            sql.setDate(3, this.getFechaFactura());
            sql.setInt(4, this.getSubTotal());
            System.out.println(sql);
            sql.executeUpdate();
            ResultSet rs= sql.getGeneratedKeys();
            if (rs.next()) 
             {
                // aquí está el id generado para esta venta
                System.out.println(this.getClass().getSimpleName()+ "Insertado correctamente");
                return rs.getInt(1);
             } 
        }catch (SQLException ex){
            System.err.println("Error al insertar "+this.getClass().getSimpleName()+":"+ex.getMessage());
        }
        return 0;
    }

    public Iterator<Factura> listar(){
        System.out.println("entra a listar");
        ArrayList<Factura> losFacturas = new ArrayList<>();
        try{
            System.out.println("entra al try");
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM "+this.getClass().getSimpleName());
            System.out.println(sql);
            ResultSet rs = sql.executeQuery();
            Factura unFactura;
            while (rs.next()){
                unFactura = new Factura();
                unFactura.setIdFactura(rs.getInt ("idfactura"));
                unFactura.setIdCliente(rs.getInt ("idCliente"));
                unFactura.setFechaFactura(rs.getDate("fecha"));
                unFactura.setSubTotal(rs.getInt  ("totalfactura"));
               
                losFacturas.add(unFactura);
                
            }
        }catch (SQLException ex){
            System.err.println("Error al listar Factura:"+ex.getMessage());
        }
       if (losFacturas.isEmpty()){
            Factura miFactura = new Factura();
            miFactura.setIdFactura(0);
            losFacturas.add(miFactura);
        }  
     
        return losFacturas.iterator();

   
    }

    public   Factura buscarPorId (int elId){
        Factura miFactura = new Factura();
       
        try{
            PreparedStatement sql = ConexionBD.conexion.prepareStatement("SELECT * FROM factura WHERE idfactura = ?");
            sql.setInt(1, elId);
            ResultSet rs  =  sql.executeQuery();
            while (rs.next()){
                miFactura.setIdFactura(rs.getInt ("idfactura"));
                miFactura.setIdCliente(rs.getInt("idcliente"));
                miFactura.setFechaFactura(rs.getDate("fechafactura"));
                miFactura.setSubTotal(rs.getInt("sudtotal"));
             
            }
        }catch (SQLException ex){
            System.err.println("Error al buscar por Id"+ex.getMessage());
        }
        return miFactura;
    }
}

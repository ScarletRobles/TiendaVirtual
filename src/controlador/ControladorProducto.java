/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Producto;

/**
 *
 * @author SENA
 */
public class ControladorProducto {
    
    public void controlarAccion(ActionEvent evento, Producto unProducto){
        String accion=evento.getActionCommand();
        switch(accion){
            case "Insertar" -> unProducto.insertar();
            case "Modificar" -> unProducto.modificar();
            case "Eliminar" -> unProducto.eliminar();
                
        }
    }
    
}

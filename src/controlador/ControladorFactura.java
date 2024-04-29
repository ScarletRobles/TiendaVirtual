/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import modelo.Factura;

/**
 *
 * @author SENA
 */
public class ControladorFactura {
    
    public void controlarAccion(ActionEvent evento, Factura unFactura){
        String accion=evento.getActionCommand();
        switch(accion){
            case "Insertar" -> unFactura.insertar();
                
        }
    }
    
}

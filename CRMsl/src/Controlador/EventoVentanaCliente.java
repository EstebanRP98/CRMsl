/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import GUI.VentanaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC-MATIC
 */
public class EventoVentanaCliente implements ActionListener {
    private VentanaCliente ventanaCliente;
    
    public EventoVentanaCliente(VentanaCliente ventanaCliente) {
        this.ventanaCliente = ventanaCliente;
    }

    public VentanaCliente getVentanaLocations() {
        return ventanaCliente;
    }

    public void setVentanaLocations(VentanaCliente ventanaCliente) {
        this.ventanaCliente = ventanaCliente;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==this.ventanaCliente.getBotonList().get(0)){
            this.ventanaCliente.getCons().InsertarClientes(this.ventanaCliente.getTxtList().get(0).getText(), this.ventanaCliente.getTxtList().get(1).getText(), this.ventanaCliente.getTxtList().get(2).getText(), this.ventanaCliente.getTxtList().get(3).getText(), this.ventanaCliente.getTxtList().get(4).getText());
            this.ventanaCliente.cargarTabla();
        }
        
    }
    
}

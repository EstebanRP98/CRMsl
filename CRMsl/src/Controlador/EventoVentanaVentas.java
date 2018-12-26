/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import GUI.VentanaVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author EstebanRM
 */
public class EventoVentanaVentas implements ActionListener {
    private VentanaVentas ventanaVentas;
    

    public EventoVentanaVentas(VentanaVentas ventanaVentas) {
        this.ventanaVentas = ventanaVentas;
    }

    public VentanaVentas getVentanaVentas() {
        return ventanaVentas;
    }

    public void setVentanaVentas(VentanaVentas ventanaVentas) {
        this.ventanaVentas = ventanaVentas;
    }
           
    

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

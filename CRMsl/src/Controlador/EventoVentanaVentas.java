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
         if (e.getSource().equals(this.ventanaVentas.getBotonList().get(1))){
            this.ventanaVentas.getTxtList().get(2).setText(""); //Codigo
            this.ventanaVentas.getTxtList().get(3).setText(""); //Descripcion
            this.ventanaVentas.getTxtList().get(4).setText(""); //Precio
            this.ventanaVentas.getTxtList().get(5).setText(""); //Cantidad
            this.ventanaVentas.getTxtList().get(6).setText(""); //SubTotal
        }
        if (e.getSource().equals(this.ventanaVentas.getBotonList().get(0))){
            
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BD.Consultas;
import Controlador.EventoVentanaCliente;
import Controlador.EventoVentanaVentas;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EstebanRM
 */
public class VentanaVentas extends JFrame{
    private List<JLabel> etiList;
    private List<JTextField> txtList;
    private List<JButton> botonList;
    private JPanel panelPrincipal;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private Consultas cons;

    public VentanaVentas() {
        super("Ventas");
        //this.cons=cons;
        this.iniciaComponentes();
        this.setSize(800,650);
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
    }
    public void iniciaComponentes(){
        this.etiList = new ArrayList<JLabel>();
        this.etiList.add(new JLabel("Producto"));
        this.etiList.add(new JLabel("Cantidad"));
        this.etiList.add(new JLabel("Codigo"));
        this.etiList.add(new JLabel("Descripcion"));
        this.etiList.add(new JLabel("Precio"));
        this.etiList.add(new JLabel("Cantidad"));
        this.etiList.add(new JLabel("SubTotal"));
        this.etiList.add(new JLabel("IVA"));
        this.etiList.add(new JLabel("Total General"));
        
        
        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        this.txtList.add(new JTextField());
        
        
        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Ingresar"));
        this.botonList.add(new JButton("Buscar"));
        this.botonList.add(new JButton("Aceptar"));
        
        LayoutManager disenioPrincipal = new GridLayout(1,2);
        this.panelPrincipal = new JPanel(disenioPrincipal);
        LayoutManager disenioIzq = new BorderLayout(2,1);
        LayoutManager disenioDer = new GridLayout(2,1); //talvez borderlayout
        LayoutManager disenioSup = new GridLayout(3,2);
        LayoutManager disenioInf = new GridLayout(6,2);
        LayoutManager disenioInfIzq = new GridLayout(2,2);
        
        JPanel panelSup = new JPanel(disenioSup);
        JPanel panelInfIzq = new JPanel(disenioInfIzq);
        JPanel panelInf = new JPanel(disenioInf);
        JPanel panelIzq = new JPanel(disenioIzq);
        JPanel panelDer = new JPanel(disenioDer);
        
         panelSup.add(this.etiList.get(0));
         panelSup.add(this.txtList.get(0));
         panelSup.add(this.etiList.get(1));
         panelSup.add(this.txtList.get(1));
         
         panelSup.add(this.botonList.get(1));
         
        for(int i=2;i<7;i++){
            panelInf.add(this.etiList.get(i));
           panelInf.add(this.txtList.get(i));
        }
        
        panelInf.add(this.botonList.get(0));
        
        panelInfIzq.add(this.etiList.get(8));
        panelInfIzq.add(this.txtList.get(8));
        panelInfIzq.add(this.botonList.get(2));
        
        panelDer.add(panelSup);
        panelDer.add(panelInf);
        
        this.botonList.get(0).addActionListener(new EventoVentanaVentas(this));
       
       
        
        this.modeloTabla = new DefaultTableModel();
        this.modeloTabla.setColumnIdentifiers(new Object[]{"CÓDIGO","DESCRIPCION","CANTIDAD","TOTAL"});
        
        this.tabla = new JTable();
        this.scroll = new JScrollPane(this.tabla);
        
        panelIzq.add(this.scroll,BorderLayout.CENTER);
        panelIzq.add(panelInfIzq,BorderLayout.SOUTH);
        this.panelPrincipal.add(panelDer);
        this.panelPrincipal.add(panelIzq);
        
        this.add(this.panelPrincipal);
        
    }
    
    public DefaultTableModel cargarTabla(){
        for(int i=this.modeloTabla.getRowCount()-1;i>=0;i--){
            this.modeloTabla.removeRow(i);
        }
        
        ResultSet resultado = this.cons.ConsultarClientes();
        try{
            while(resultado.next()){
                this.modeloTabla.addRow(new Object[]{resultado.getString("CÓDIGO"),resultado.getString("APELLIDOS"),resultado.getString("NOMBRES"),resultado.getString("TELEFONO"),resultado.getString("E-MAIL")});  
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return this.modeloTabla;
    } 

    public List<JLabel> getEtiList() {
        return etiList;
    }

    public void setEtiList(List<JLabel> etiList) {
        this.etiList = etiList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public Consultas getCons() {
        return cons;
    }

    public void setCons(Consultas cons) {
        this.cons = cons;
    }
    
    
    
}

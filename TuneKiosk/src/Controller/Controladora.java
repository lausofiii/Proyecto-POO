/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.ArrayList;
import Modelo.PresupuestoMateriales;
import Modelo.ListaPresupuestoM;
import Modelo.Material;
import Modelo.Apoyo;
import Modelo.ListaMateriales;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JFrame;

/**
 *
 * @author laura
 */
public class Controladora {
    
    JFrame ventana;
    JTable tablaMateriales;
    ArrayList<Material> materiales = new ArrayList<>();
    ListaMateriales lista;
    double totalM = 0;
    double totalMO = 0;
    double totalH = 0;
    
    
   public Controladora(JFrame ventana){
       this.ventana = ventana;
    }
    
   public void llenarTablaMateriales(JTable tablaMateriales,ArrayList<Material> materiales) {
       
       String[] columna = {"Material","Color","Proveedor","Funcion","Costo","Unidad"};
        DefaultTableModel dtm = new DefaultTableModel(null,columna);
        for (Material mat : materiales) {
            String[] row = {mat.getNombre(),mat.getColor(),mat.getProveedor(),mat.getFuncion(),Double.toString(mat.getCosto()),mat.getUnidad()};
            dtm.addRow(row);
        }
        tablaMateriales.setModel(dtm);
    }
   
   public void llenarTablaMaterialesP(JTable tablaMateriales,ArrayList<PresupuestoMateriales> materiales) {
       
       String[] columna = {"Material","Color","Proveedor","Funcion","Costo","Unidad","Cantidad","Total"};
        DefaultTableModel dtm = new DefaultTableModel(null,columna);
        for (PresupuestoMateriales mat : materiales) {
            String[] row = {mat.getNombre(),mat.getColor(),mat.getProveedor(),mat.getFuncion(),Double.toString(mat.getCosto()),mat.getUnidad(),Integer.toString(mat.getCant()),Double.toString(mat.getCant()*mat.getCosto())};
            dtm.addRow(row);
            totalM += mat.getCosto()*mat.getCant();
        }
        tablaMateriales.setModel(dtm);
    }
   
  
   
   public void llenarTablaManoDeObra(JTable tablaManoDeObra,ArrayList<Apoyo> lista) {
       
       String[] columna = {"Trabajador","Costo","Unidad"};
        DefaultTableModel dtm = new DefaultTableModel(null,columna);
        for (Apoyo ap : lista) {
            String[] row = {ap.getNombre(),Double.toString(ap.getCosto()),ap.getUnidad()};
            dtm.addRow(row);
            totalMO += ap.getCosto();
        }
        tablaManoDeObra.setModel(dtm);
    }
   
   public void llenarHerramientas(JTable tablaHerramientas,ArrayList<Apoyo> lista) {
       
       String[] columna = {"Herramienta","Costo","Unidad"};
        DefaultTableModel dtm = new DefaultTableModel(null,columna);
        for (Apoyo ap : lista) {
            String[] row = {ap.getNombre(),Double.toString(ap.getCosto()),ap.getUnidad()};
            dtm.addRow(row);
            totalH += ap.getCosto();
        }
        tablaHerramientas.setModel(dtm);
    }
   
   public void activaVentana(JFrame ventana,JFrame ventana2) {
        //ventana.setSize(810,510);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana2.dispose(); 

     }
   
   public void iniciaVentana(JFrame ventana){
       //ventana.setSize(822,540);
       ventana.setLocationRelativeTo(null); //permite centrar la ventana
       ventana.setIconImage(new ImageIcon("src/Images/icon.png").getImage()); 
       ventana.setResizable(false); 
    }

    public double getTotalM() {
        return totalM;
    }

    public void setTotalM(double totalM) {
        this.totalM = totalM;
    }

    public double getTotalMO() {
        return totalMO;
    }

    public void setTotalMO(double totalMO) {
        this.totalMO = totalMO;
    }

    public double getTotalH() {
        return totalH;
    }

    public void setTotalH(double totalH) {
        this.totalH = totalH;
    }
    
    
   
    
   
}

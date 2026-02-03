/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author laura
 */
public class PresupuestoMateriales extends Material {
    
    int cant;
         
    public PresupuestoMateriales() {};
    
    public PresupuestoMateriales(String material,String color,String proveedor,String funcion,double costo,String unidad, int cant) {
        super(material,color,proveedor,funcion,costo,unidad);
        this.cant = cant;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
     
        
        
            
        
       
}
    

    


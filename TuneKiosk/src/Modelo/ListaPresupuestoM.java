/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;


/**
 *
 * @author laura
 */
public class ListaPresupuestoM {
    
   ArrayList<PresupuestoMateriales> presupuestoMateriales = new ArrayList<>();
   
    public ListaPresupuestoM() {};

    public ArrayList<PresupuestoMateriales> getPresupuestoMateriales() {
        return presupuestoMateriales;
    }

    public void setPresupuestoMateriales(ArrayList<PresupuestoMateriales> presupuestoMateriales) {
        this.presupuestoMateriales = presupuestoMateriales;
    }
   
    public void agregarMaterial(PresupuestoMateriales mat) {
            presupuestoMateriales.add(mat);
    }
    
       
}

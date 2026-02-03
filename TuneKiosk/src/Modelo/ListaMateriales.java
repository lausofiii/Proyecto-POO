/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author laura
 */
public class ListaMateriales {
    
    private ArrayList<Material> materiales = new ArrayList<>();
    ArrayList<Material> presupuestoMateriales = new ArrayList<>();
    
    public ListaMateriales() {};
    
  /*  public ListaMateriales() {
        agregarMaterial();
    }*/
    
    public ListaMateriales(Material mat) {
        agregarMaterial(mat);
    }
    
    public void agregarMaterial() {
        JSONParser parser = new JSONParser();
        try {
            String dirarch = System.getProperty("user.dir") + File.separator + "materiales.json";
            JSONArray materialesjs = (JSONArray)parser.parse(new FileReader(dirarch));
            for (Object mat00 : materialesjs){
                JSONObject materialsito = (JSONObject) mat00;
                String nombre = materialsito.get("nombre").toString();
                String color = materialsito.get("color").toString();
                String proveedor = materialsito.get("proveedor").toString();
                String funcion = materialsito.get("funcion").toString();
                double costo = Double.parseDouble(materialsito.get("costo").toString());
                String unidad = materialsito.get("unidad").toString();
                
                Material matofc = new Material(nombre,color,proveedor,funcion,costo,unidad);
                materiales.add(matofc);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();    
        } catch (IOException ex) {
            Logger.getLogger(ListaMateriales.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ListaMateriales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escribirarch(){
        StringBuilder jsonbuilder = new StringBuilder();
        jsonbuilder.append("[");
        for (int i=0;i<materiales.size();i++){
            Material auxmat = (Material)materiales.get(i);
            jsonbuilder.append("{\n"
                    + "\"nombre\":\""+auxmat.getNombre()+"\",\n" 
                    + "\"color\":\"" + auxmat.getColor() + "\",\n" 
                    + "\"proveedor\":\"" + auxmat.getProveedor() + "\",\n" 
                    + "\"funcion\":\"" + auxmat.getFuncion() + "\",\n" 
                    + "\"costo\":" + auxmat.getCosto()+ ",\n" 
                    + "\"unidad\":\"" + auxmat.getUnidad()+ "\"\n"
                    + "}");
            if(i < materiales.size() - 1) { 
                jsonbuilder.append(", \n");
            }
        }
        jsonbuilder.append("]");
        
        try (FileWriter writer = new FileWriter("materiales.json")) { 
            writer.write(jsonbuilder.toString()); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
        
    }
    
    public void agregarMaterial(Material mat) {
        materiales.add(mat);
        escribirarch();
    }
    
    public void eliminarMaterial(Material material) {
        materiales.remove(material);
        escribirarch();
    }
    
    
    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(ArrayList<Material> materiales) {
        this.materiales = materiales;
    }

    public int vertamanomat(){
        return materiales.size();
    }
    

    }

    
        


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
public class ListaHerramientas {
    
    private ArrayList<Apoyo> herramientas = new ArrayList<>();
    private ArrayList<Apoyo> herramientasP = new ArrayList<>();

    public ListaHerramientas() {};  
    
    public void agregarHerramienta() {
        JSONParser parser = new JSONParser();
        try {
            String dirarch = System.getProperty("user.dir") + File.separator + "herramientas.json";
            JSONArray herramientasjs = (JSONArray)parser.parse(new FileReader(dirarch));
            for (Object her00 : herramientasjs){
                JSONObject herramientita = (JSONObject) her00;
                String nombre = herramientita.get("nombre").toString();
                double costo = Double.parseDouble(herramientita.get("costo").toString());
                String unidad = herramientita.get("unidad").toString();
                
                Apoyo herofc = new Apoyo(nombre,costo,unidad);
                herramientas.add(herofc);
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
        for (int i=0;i<herramientas.size();i++){
            Apoyo auxher = (Apoyo)herramientas.get(i);
            jsonbuilder.append("{\n"
                    + "\"nombre\":\""+auxher.getNombre()+"\",\n" 
                    + "\"costo\":" + auxher.getCosto()+ ",\n" 
                    + "\"unidad\":\"" + auxher.getUnidad()+ "\"\n"
                    + "}");
            if(i < herramientas.size() - 1) { 
                jsonbuilder.append(", \n");
            }
        }
        jsonbuilder.append("]");
        
        try (FileWriter writer = new FileWriter("herramientas.json")) { 
            writer.write(jsonbuilder.toString()); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
    }
    
    public void agregarHerramientaI(Apoyo her) {
        herramientas.add(her);
        escribirarch();
    }
    
    public void eliminarHerramienta(Apoyo her){
        herramientas.remove(her);
        escribirarch();
    }
    
    public void agregarHerramienta(Apoyo seleccionado) {
        herramientasP.add(seleccionado);
    }

    public ArrayList<Apoyo> getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(ArrayList<Apoyo> herramientas) {
        this.herramientas = herramientas;
    }

    public ArrayList<Apoyo> getHerramientasP() {
        return herramientasP;
    }

    public void setHerramientasP(ArrayList<Apoyo> herramientasP) {
        this.herramientasP = herramientasP;
    }
    
    public int vertamanoher(){
        return herramientas.size();
    }
    
    
    
    
    
}

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
public class ListaManoDeObra {
    
    private ArrayList<Apoyo> manoDeObra = new ArrayList<>();
    private ArrayList<Apoyo> manoDeObraP = new ArrayList<>();

    public ListaManoDeObra() {};
    
    public void agregarManoDeObra() {
        JSONParser parser = new JSONParser();
        try {
            String dirarch = System.getProperty("user.dir") + File.separator + "mano de obra.json";
            JSONArray manodeobrajs = (JSONArray)parser.parse(new FileReader(dirarch));
            for (Object mob00 : manodeobrajs){
                JSONObject manodeobrita = (JSONObject) mob00;
                String nombre = manodeobrita.get("nombre").toString();
                double costo = Double.parseDouble(manodeobrita.get("costo").toString());
                String unidad = manodeobrita.get("unidad").toString();
                
                Apoyo mobofc = new Apoyo(nombre,costo,unidad);
                manoDeObra.add(mobofc);
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
        for (int i=0;i<manoDeObra.size();i++){
            Apoyo auxmob = (Apoyo)manoDeObra.get(i);
            jsonbuilder.append("{\n"
                    + "\"nombre\":\""+auxmob.getNombre()+"\",\n" 
                    + "\"costo\":" + auxmob.getCosto()+ ",\n" 
                    + "\"unidad\":\"" + auxmob.getUnidad()+ "\"\n"
                    + "}");
            if(i < manoDeObra.size() - 1) { 
                jsonbuilder.append(", \n");
            }
        }
        jsonbuilder.append("]");
        
        try (FileWriter writer = new FileWriter("mano de obra.json")) { 
            writer.write(jsonbuilder.toString()); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }
        
    }
    
    public void agregarManoDeObraI(Apoyo mo) {
        manoDeObra.add(mo);
        escribirarch();
    }
    
    public void eliminarManoDeObra(Apoyo mano) {
        manoDeObra.remove(mano);
        escribirarch();
    }

    public ArrayList<Apoyo> getManoDeObra() {
        return manoDeObra;
    }

    public void setManoDeObra(ArrayList<Apoyo> manoDeObra) {
        this.manoDeObra = manoDeObra;
    }

    public ArrayList<Apoyo> getManoDeObraP() {
        return manoDeObraP;
    }

    public void setManoDeObraP(ArrayList<Apoyo> manoDeObraP) {
        this.manoDeObraP = manoDeObraP;
    }
    
    public void agregarManoDeObra(Apoyo seleccionado) {
        manoDeObraP.add(seleccionado);
    }
    
    public int vertamanomob(){
        return manoDeObra.size();
    }
    
    
    
    
    
}

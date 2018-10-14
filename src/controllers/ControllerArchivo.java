/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelArchivo;
import views.ViewArchivo;
/**
 *
 * @author JonatanVT
 */
public class ControllerArchivo implements ActionListener{
    
    private final ModelArchivo modelarchivo;
    private final ViewArchivo viewarchivo;
    
    public ControllerArchivo(ModelArchivo modelarchivo, ViewArchivo viewarchivo){
        this.modelarchivo = modelarchivo;
        this.viewarchivo = viewarchivo;
        viewarchivo.jmi_leer.addActionListener(this);
        viewarchivo.jmi_escribir.addActionListener(this);
        initView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewarchivo.jmi_leer){
            modelarchivo.setPath("C:\\Users\\Jonathan\\Documents\\utec\\archivo.pat");
            modelarchivo.readFile(modelarchivo.getPath());      
            viewarchivo.jta_txt.setText(modelarchivo.getMessage());
        }else if(e.getSource()==viewarchivo.jmi_escribir){
            modelarchivo.setPath("C:\\Users\\Jonathan\\Documents\\utec\\archivo.pat");
            modelarchivo.setMessage(viewarchivo.jta_txt.getText());
            modelarchivo.writeFile(modelarchivo.getPath(), modelarchivo.getMessage());
        }
    }
    private void initView() {
        viewarchivo.setTitle("Block de notas");
        viewarchivo.setResizable(false);
        viewarchivo.setLocationRelativeTo(null);
        viewarchivo.setVisible(true);
    }   
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Persona;
import View.Login;
import View.Personas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author SENA
 */
public class Controller implements ActionListener {

    Personas Person;
    Login Log = new Login();

    ArrayList<Persona> ListPersona = new ArrayList<Persona>();

    /**
     * vamos a crear e inivializar las variables
     */
    private int Doc = 0;
    private String Nombre = null;
    private String Ape = null;
    private String User = null;
    private String Pass = null;

    /**
     * creamos nuestro constructor
     *
     * @param Person
     */
    public Controller(Personas Person) {
        this.Person = Person;
        this.iniciar();
        this.Person.Registrar.addActionListener(this);
        this.Person.Buscar.addActionListener(this);
        this.Person.Mostrar.addActionListener(this);
        this.Person.Eliminar.addActionListener(this);
        this.Person.Entrar.addActionListener(this);
        this.Log.Ingresar.addActionListener(this);
        this.Log.Retornar.addActionListener(this);
    }

    public void iniciar() {
        this.Person.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (this.Person.Registrar == e.getSource()) {

            Doc = Integer.parseInt(this.Person.Doc.getText());
            Nombre = this.Person.Nom.getText();
            Ape = this.Person.Ape.getText();
            User = this.Person.User.getText();
            Pass = this.Person.Pass.getText();

            ListPersona.add(new Persona(Doc, Nombre, Ape, User, Pass));
            this.limpiar();
            table(this.Person.Tabla, ListPersona);
            JOptionPane.showMessageDialog(null, "DATO GUARDADO CON ÉXITO");
        }

        if (this.Person.Mostrar == e.getSource()) {

            System.out.println("La lista contiene " + ListPersona.size() + " elementos\n");

            for (int i = 0; i < ListPersona.size(); i++) {
                System.out.println("Documento: " + this.ListPersona.get(i).getDoc() + "\n" + "Nombre: " + this.ListPersona.get(i).getNom() + "\n" + "Apellidos: " + this.ListPersona.get(i).getApe() + "\n");
            }

            this.Person.Doc.setText("");
            this.Person.Nom.setText("");
            this.Person.Ape.setText("");

        }

        if (this.Person.Buscar == e.getSource()) {
            Doc = Integer.parseInt(this.Person.Doc.getText());
            for (int i = 0; i < ListPersona.size(); i++) {
                if (Doc == ListPersona.get(i).getDoc()) {
                    this.Person.Nom.setText(ListPersona.get(i).getNom());
                    this.Person.Ape.setText(ListPersona.get(i).getApe());
                }
            }

        }

        if (this.Person.Eliminar == e.getSource()) {
            Doc = Integer.parseInt(this.Person.Doc.getText());
            for (int i = 0; i < ListPersona.size(); i++) {
                if (Doc == ListPersona.get(i).getDoc()) {
                    ListPersona.remove(i);
                    JOptionPane.showMessageDialog(null, "DATO ELIMINADO CON ÉXITO");
                }
            }

        }

        if (this.Person.Entrar == e.getSource()) {
            Log.setVisible(true);
        }

        if (this.Log.Ingresar == e.getSource()) {

            User = this.Log.User.getText();
            Pass = this.Log.Pass.getText();
            boolean bs = false;
            for (int i = 0; i < ListPersona.size(); i++) {
                if (User.equals(ListPersona.get(i).getUser()) && Pass.equals(ListPersona.get(i).getPass())) {
                    JOptionPane.showMessageDialog(null, "USER: " + User + "\n" + "PASS: " + Pass);
                    bs = true;
                }
            }
            if (bs == false) {
                JOptionPane.showMessageDialog(null, "USUARIO NO REGISTRADO");
            }
        }
        
        if (e.getSource() == Log.Retornar){
            this.Log.dispose();
        }
    }
    public void table(JTable Tabla,ArrayList<Persona>ListPersona){
        
        for (int i = 0; i < ListPersona.size(); i++) {
            
            Tabla.setValueAt(ListPersona.get(i).getDoc(),i,0);
            Tabla.setValueAt(ListPersona.get(i).getNom(),i,1);
            Tabla.setValueAt(ListPersona.get(i).getApe(),i,2);
            Tabla.setValueAt(ListPersona.get(i).getUser(),i,3);
        }
        
    }

    private void limpiar() {

        this.Person.Doc.setText("");
        this.Person.Nom.setText("");
        this.Person.Ape.setText("");
        this.Person.User.setText("");
        this.Person.Pass.setText("");

    }

}
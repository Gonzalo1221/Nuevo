/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Vector;

/**
 *
 * @author SENA
 */
public class Persona {
    protected int Doc;
    protected String Nom;
    protected String Ape;
    protected String User;
    protected String Pass;

    public Persona(int Doc, String Nom, String Ape, String User, String Pass) {
        this.Doc = Doc;
        this.Nom = Nom;
        this.Ape = Ape;
        this.User = User;
        this.Pass = Pass;
    }

    public int getDoc() {
        return Doc;
    }

    public void setDoc(int Doc) {
        this.Doc = Doc;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getApe() {
        return Ape;
    }

    public void setApe(String Ape) {
        this.Ape = Ape;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
}
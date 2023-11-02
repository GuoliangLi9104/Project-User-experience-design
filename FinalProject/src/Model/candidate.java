/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.sql.Blob;
/**
 *
 * @author JRS
 */
public class candidate {

    private int id;
    private String name, lastName;
    private int id_party;
    private Blob picture;
    
    public candidate(int id, String name, String lastName, Blob picture, int id_party) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.id_party = id_party;
        this.picture = picture;
    }

    public candidate(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the id_party
     */
    public int getId_party() {
        return id_party;
    }

    /**
     * @param id_party the id_party to set
     */
    public void setId_party(int id_party) {
        this.id_party = id_party;
    }

    /**
     * @return the picture
     */
    public Blob getPicture() {
        return picture;
    }

    /**
     * @param picture the picture to set
     */
    public void setPicture(Blob picture) {
        this.picture = picture;
    }
}

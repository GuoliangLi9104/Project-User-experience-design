/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Blob;
/**
 *
 * @author JRS
 */
public class candidate {

    private int id;
    private String name, lastName, picture;
    private int id_party;
    
    public candidate(int id, String name, String lastName, String picture, int id_party) {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

 
}

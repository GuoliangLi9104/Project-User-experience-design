/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author JRS
 */
public class partie {

    private int id;
    private String name;
    private int id_candidate;

    public partie(int id, String name, int id_candidate) {
        this.id = id;
        this.name = name;
        this.id_candidate = id_candidate;
    }

    public partie(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public partie() {

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
     * @return the id_candidate
     */
    public int getId_candidate() {
        return id_candidate;
    }

    /**
     * @param id_candidate the id_candidate to set
     */
    public void setId_candidate(int id_candidate) {
        this.id_candidate = id_candidate;
    }
}

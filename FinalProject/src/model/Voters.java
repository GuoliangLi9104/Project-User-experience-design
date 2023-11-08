/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Li
 */
public class Voters {
    int id, IDNumber, vote;
    String name, lastName;

    public Voters() {
    }

    public Voters(int id, int IDNumber, String name, String lastName, int vote) {
        this.id = id;
        this.IDNumber = IDNumber;
        this.vote = vote;
        this.name = name;
        this.lastName = lastName;
    }

    public Voters(int IDNumber, String name, String lastName, int vote) {
        this.IDNumber = IDNumber;
        this.vote = vote;
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(int IDNumber) {
        this.IDNumber = IDNumber;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}

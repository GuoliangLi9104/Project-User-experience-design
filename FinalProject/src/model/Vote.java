/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Li
 */
public class Vote {
    int id, IDVoter, IDParty, IDVote;

      public Vote() {
    }
    
    public Vote(int id, int IDVoter, int IDParty, int IDVote) {
        this.id = id;
        this.IDVoter = IDVoter;
        this.IDParty = IDParty;
        this.IDVote = IDVote;
    }

    public Vote(int IDVoter, int IDParty, int IDVote) {
        this.IDVoter = IDVoter;
        this.IDParty = IDParty;
        this.IDVote = IDVote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIDVoter() {
        return IDVoter;
    }

    public void setIDVoter(int IDVoter) {
        this.IDVoter = IDVoter;
    }

    public int getIDParty() {
        return IDParty;
    }

    public void setIDParty(int IDParty) {
        this.IDParty = IDParty;
    }

    public int getIDVote() {
        return IDVote;
    }

    public void setIDVote(int IDVote) {
        this.IDVote = IDVote;
    }

  
    
    
}

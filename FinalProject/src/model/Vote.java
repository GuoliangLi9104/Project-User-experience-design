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
    int id, IDVoter, IDCandidate, IDVote;

      public Vote() {
    }
    
    public Vote(int id, int IDVoter, int IDCandidate, int IDVote) {
        this.id = id;
        this.IDVoter = IDVoter;
        this.IDCandidate = IDCandidate;
        this.IDVote = IDVote;
    }

    public Vote(int IDVoter, int IDParty, int IDVote) {
        this.IDVoter = IDVoter;
        this.IDCandidate = IDParty;
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

    public int getIDCandidate() {
        return IDCandidate;
    }

    public void setIDCandidate(int IDCandidate) {
        this.IDCandidate = IDCandidate;
    }

    public int getIDVote() {
        return IDVote;
    }

    public void setIDVote(int IDVote) {
        this.IDVote = IDVote;
    }

  
    
    
}

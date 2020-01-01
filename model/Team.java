package dev.futurepath.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Plain old java object representing a team.
 */
public class Team {
    
    //atributos
    private int id;
    private String name;
    private List<Player> players;
    //constructor vacio
    public Team() {
        this.id = 0;
        this.name = "";
        this.players = new ArrayList<>();
    }
    //constructor con parametros
    public Team(int id, String name, List<Player> players) {
        this.id = id;
        this.name = name;
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        if(players == null)
            players = new ArrayList<>();
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    @Override
    public String toString() {
        return getId() + " - " + getName();
    }
    
    public void listPlayers() {
        for(Player member : players)
            System.out.println(member);
    }
    
}

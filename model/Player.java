package dev.futurepath.model;

public class Player {
    //attributes
    private int id;
    private String name;
    private int number;
    private Team team;
    //empty constructor
    public Player() {
        this.id = 0;
        this.name = "";
        this.number = 0;
        this.team = null;
    }
    //full constructor
    public Player(int id, String name, int number, Team team) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.team = team;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return getNumber() + ".- " + getName();
    }
    
}

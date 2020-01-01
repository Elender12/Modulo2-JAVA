package dev.futurepath.model.repository;
import dev.futurepath.model.Player;
import dev.futurepath.model.Team;
import java.util.HashMap;
import java.util.Map;


public class SingletonDataRepository {
    
    //attributes: 
    private static SingletonDataRepository INSTANCE;
    private Map<Integer, Team> teams;
    private Map<Integer, Player> players;
    //constructor
    private SingletonDataRepository() {
        teams = new HashMap<>();
        players = new HashMap<>();
    }
    //returns an instance made of 2 maps: teams and players
    public static SingletonDataRepository getInstance() {
        if(INSTANCE == null)
            INSTANCE = new SingletonDataRepository();
        return INSTANCE;
    }
    //returns attribute players
    public Map<Integer, Player> getPlayers() {
        return players;
    }
    //returns attribute teams
    public Map<Integer, Team> getTeams() {
        return teams;
    }
    
}

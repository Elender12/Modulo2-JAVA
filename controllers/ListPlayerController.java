/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.futurepath.controllers;
import dev.futurepath.model.Player;
import dev.futurepath.model.Team;
import dev.futurepath.model.daos.PlayerDao;
import dev.futurepath.views.ListPlayers2Panel;
import dev.futurepath.views.ListPlayersPanel;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 *
 * @author Elena Cirstea
 */
public class ListPlayerController {
    //atributo
    private ListPlayersPanel listPanel;
    private ListPlayers2Panel listPanel2;
    private List<Player> players;
    
    //constructor
    public ListPlayerController(ListPlayersPanel listPanel) {
        this.listPanel = listPanel;
    }

    public ListPlayerController(ListPlayers2Panel listPanel2) {

        this.listPanel2 = listPanel2;
    }
    
    public void listPlayers(){
        List<Player> players = new PlayerDao().readAll();
        boolean empty = players.isEmpty();
        System.out.println("resultado"+empty);
        listPanel.getCBplayers();
        listPanel.setCBplayers((JComboBox<Player>) players);
    }
    
    public void loadPlayers() {
        List<Player> players = new PlayerDao().readAll();
        //aqui añade uno nuevo
       // listPanel.getCBplayers().addItem(new Player());
        players.forEach((player1) -> {
            listPanel.getCBplayers().addItem(player1);
        });
    }
      
    public void populateAll(){

        List<Player> players = new PlayerDao().readAll();
        DefaultListModel<Player> model = new DefaultListModel<Player>();
   
        players.forEach(t-> {
            model.addElement(t);
        });
        listPanel2.getListPlayers().setModel(model);
    }
    
            
    
}

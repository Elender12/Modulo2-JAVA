package dev.futurepath.controllers;
import dev.futurepath.model.Player;
import dev.futurepath.model.Team;
import dev.futurepath.model.daos.TeamDao;
import dev.futurepath.views.ListTeamPanel;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Ele
 */
public class ListTeamController {
    //attribute
    private ListTeamPanel panel;
    
    //constructor
    public ListTeamController(ListTeamPanel panel) {
        this.panel = panel;
    }
    public void listTeams(){
        List<Team> teams = new TeamDao().readAll();
        panel.getListTeams();
        panel.setListTeams((JList<Team>) teams);
    }
  
      
    public void populateAll(){

        List<Team> teams = new TeamDao().readAll();
        DefaultListModel<Team> model = new DefaultListModel<>();
   
        teams.forEach((Team t)-> {
            model.addElement(t);
        });
        panel.getListTeams().setModel(model);
    }
    
}

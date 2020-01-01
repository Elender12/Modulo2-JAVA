package dev.futurepath.controllers;

import dev.futurepath.controllers.exceptions.WrongNameException;
import dev.futurepath.model.Player;
import dev.futurepath.model.Team;
import dev.futurepath.model.daos.TeamDao;
import dev.futurepath.views.CreateTeamPanel;
import java.util.List;

/**
 *
 * @author Ele
 */
public class CreateTeamController {
    //atributo del panel
    private CreateTeamPanel panel;
    
    //constructor
    public CreateTeamController(CreateTeamPanel panel) {
        this.panel = panel;
    }
    
    public void createTeam() throws WrongNameException{
        Team team = getTeamFromInterface();
        if(team.getName().trim().isEmpty()){
             throw new WrongNameException();
        }
       // setTeamIntoInterface(new TeamDao().create(team));
        System.out.println("Team created");
    }
    private Team getTeamFromInterface(){
        Team team = new Team();
       // team.setName(panel.getTeamNameTF().getText());
       // team.setPlayers((List<Player>) panel.getPlayersListCB().getSelectedItem());
        //hasta aquí coge los datos
        System.out.println(team.toString());
        return team; 
    }
    private void setTeamIntoInterface(Team team){
        panel.getTeamNameTF().setText(team.getName());
        panel. getPlayersListCB().setSelectedItem(team.getPlayers());
                
        /*  createPanel.getLblId().setText("" + player.getId());
       createPanel.getTxtName().setText(player.getName());
       createPanel.getTxtNumber().setText("" + player.getNumber());
       createPanel.getCbTeam().setSelectedItem(player.getTeam());*/
        /*Player player = new Player();
       player.setName(createPanel.getTxtName().getText());
       player.setNumber(Integer.parseInt(createPanel.getTxtNumber().getText()));
       player.setTeam((Team) createPanel.getCbTeam().getSelectedItem());*/
        
        
    }
    
}

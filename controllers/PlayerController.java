package dev.futurepath.controllers;
import dev.futurepath.controllers.exceptions.NoTeamSelectedException;
import dev.futurepath.controllers.exceptions.WrongNumberException;
import dev.futurepath.controllers.exceptions.WrongNameException;
import dev.futurepath.model.Player;
import dev.futurepath.model.Team;
import dev.futurepath.model.daos.PlayerDao;
import dev.futurepath.views.CreatePlayerPanel;

public class PlayerController {
    //atributo
    private CreatePlayerPanel createPanel;

    //constructor
    public PlayerController(CreatePlayerPanel createPanel) {
        this.createPanel = createPanel;
    }
 
    //método para la creación del jugador
    public void createPlayer() throws NoTeamSelectedException, WrongNameException, WrongNumberException {
        Player player = getPlayerFromTheInteface();
        if(player.getTeam() == null)
            throw new NoTeamSelectedException();
        if(player.getName().trim().isEmpty())
            throw new WrongNameException();
        if(player.getNumber() < 0 || player.getNumber() > 99)
            throw new WrongNumberException();
        setPlayerIntoTheInterface(new PlayerDao().create(player));
    }
    //devuelve un objeto jugador con los datos del panel
    private Player getPlayerFromTheInteface() {
       Player player = new Player();
       player.setName(createPanel.getTxtName().getText());
       player.setNumber(Integer.parseInt(createPanel.getTxtNumber().getText()));
       player.setTeam((Team) createPanel.getCbTeam().getSelectedItem());
       return player;
    }
    
    //actualiza los datos
    private void setPlayerIntoTheInterface(Player player) {
       createPanel.getLblId().setText("" + player.getId());
       createPanel.getTxtName().setText(player.getName());
       createPanel.getTxtNumber().setText("" + player.getNumber());
       createPanel.getCbTeam().setSelectedItem(player.getTeam());
    }
    
 
  
}

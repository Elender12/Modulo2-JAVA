package dev.futurepath.controllers;
import dev.futurepath.controllers.exceptions.NoTeamSelectedException;
import dev.futurepath.controllers.exceptions.WrongNameException;
import dev.futurepath.controllers.exceptions.WrongNumberException;
import dev.futurepath.model.Player;
import dev.futurepath.model.daos.PlayerDao;
import dev.futurepath.views.UpdatePlayersPanel;
import java.util.List;

/**
 *
 * @author Elena Cirstea
 */
public class UpdatePlayerController {
    //atributo
    private UpdatePlayersPanel updatePanel;
    //constructor
    public UpdatePlayerController(UpdatePlayersPanel updatePanel) {
        this.updatePanel = updatePanel;
    }
    //cargar jugadores en una lista, elegir uno de la lista y modificar sus atributos
    
    public void updatePlayer() throws NoTeamSelectedException, WrongNameException, WrongNumberException{
        //este jugador es el que hay que modificar
        Player playerToUpdate = getPlayerToUpdate();
        //datos nuevos del jugador
        String newPlayerName= updatePanel.getNameTF().getText();
        int newPlayerNumber =  Integer.parseInt(updatePanel.getNumberTF().getText());
       //manejo de excepciones
        if(playerToUpdate.getTeam() == null)
            throw new NoTeamSelectedException();
        if(newPlayerName.trim().isEmpty())
            throw new WrongNameException();
        if(newPlayerNumber < 0 || newPlayerNumber > 99)
            throw new WrongNumberException();
        //sets new values
        playerToUpdate.setName(newPlayerName);
        playerToUpdate.setNumber(newPlayerNumber);
        PlayerDao pl1 = new PlayerDao();
      
        pl1.update(playerToUpdate);
      

    }
    
    public Player getPlayerToUpdate() {
        Player player = (Player) updatePanel.getCBplayers().getSelectedItem();
        return player;
    }
    
    public void loadPlayers() {
        List<Player> players = new PlayerDao().readAll();
        //aqui añade uno nuevo
        updatePanel.getCBplayers().addItem(new Player());
        players.forEach((player1) -> {
            updatePanel.getCBplayers().addItem(player1);
        });
    }
    
    
    
    
    
    
    
}

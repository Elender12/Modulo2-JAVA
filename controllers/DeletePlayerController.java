package dev.futurepath.controllers;
import dev.futurepath.model.Player;
import dev.futurepath.model.daos.PlayerDao;
import dev.futurepath.views.DeletePlayerPanel;
import java.util.List;

/**
 *
 * @author Elena Cirstea
 */
public class DeletePlayerController {
    //atributo
    private DeletePlayerPanel deletePanel;
    //constructor
    public DeletePlayerController(DeletePlayerPanel deletePanel) {
        this.deletePanel = deletePanel;
    }

    public Player getPlayerToDelete() {
        //deletePanel.getListPlayers();
        Player player = (Player) deletePanel.getListPlayers().getSelectedItem();
        return player;
    }

    public void deletePlayer() {
        //deletePanel.
        List<Player> players = new PlayerDao().readAll();
        Player playerToDelete = getPlayerToDelete();
        Player player = (Player) deletePanel.getListPlayers().getSelectedItem();
        System.out.println("Antes del remove");
        boolean remove;
        remove = players.remove(playerToDelete);
        System.out.println(remove + "result");
        Player delete = new PlayerDao().delete(playerToDelete.getId());
        System.out.println(delete + "esto es lo que borra");
    }

    public void loadPlayers() {
        List<Player> players = new PlayerDao().readAll();
        //aqui añade uno nuevo
        //deletePanel.getListPlayers().addItem(new Player());
        players.forEach((player1) -> {
            deletePanel.getListPlayers().addItem(player1);
        });
    }

}

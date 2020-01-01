package dev.futurepath.model.daos;
import dev.futurepath.model.Player;
import dev.futurepath.model.repository.SingletonDataRepository;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao implements IDao<Player> {

    private static int _id_generator = 0;
    
    @Override
    public Player create(Player element) {
        _id_generator++;
        int id = _id_generator;
        SingletonDataRepository.getInstance().getPlayers().put(id, element);
        element.setId(id);
        return element;
    }

    @Override
    public List<Player> readAll() {
        return new ArrayList(SingletonDataRepository.getInstance().getPlayers().values());
    }

    @Override
    public void update(Player element) {
        if(find(element.getId()) != null)
            SingletonDataRepository.getInstance().getPlayers().put(element.getId(), element);
    }

    @Override
    public Player delete(int id) {
        return SingletonDataRepository.getInstance().getPlayers().remove(id);
    }

    @Override
    public Player find(int id) {
        return SingletonDataRepository.getInstance().getPlayers().get(id);
    }
    
}

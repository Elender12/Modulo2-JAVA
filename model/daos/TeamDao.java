package dev.futurepath.model.daos;
import dev.futurepath.model.Team;
import dev.futurepath.model.repository.SingletonDataRepository;
import java.util.ArrayList;
import java.util.List;

public class TeamDao implements IDao<Team> {
    //
    private static int _id_generator = 0;
        
    @Override
    public Team create(Team element) {
        _id_generator++;
        int id = _id_generator;
        SingletonDataRepository.getInstance().getTeams().put(id, element);
        element.setId(id);
        return element;
    }

    @Override
    public List<Team> readAll() {
        return new ArrayList(SingletonDataRepository.getInstance().getTeams().values());
    }

    @Override
    public void update(Team element) {
        if(find(element.getId()) != null)
            SingletonDataRepository.getInstance().getTeams().put(element.getId(), element);
    }

    @Override
    public Team delete(int id) {
        return SingletonDataRepository.getInstance().getTeams().remove(id);
    }

    @Override
    public Team find(int id) {
        return SingletonDataRepository.getInstance().getTeams().get(id);
    }
    
}

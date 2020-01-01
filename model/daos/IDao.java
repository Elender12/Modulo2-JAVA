package dev.futurepath.model.daos;
import java.util.List;

public interface IDao<T> {
    
    T create(T element);
    List<T> readAll();
    void update(T element);
    T delete(int id);
    T find(int id);
            
}

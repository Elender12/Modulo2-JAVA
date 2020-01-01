package dev.futurepath.model.daos;
import dev.futurepath.core.MySQLConnection;
import dev.futurepath.model.Team;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Elena Cirstea
 */
public class TeamDataBaseDao implements IDao<Team> {

    private static final String SELECT = "SELECT * FROM teams";
    private static final String INSERT = "INSERT INTO teams (name) VALUES (?)";
    private static final String UPDATE = "UPDATE teams SET (name)=? WHERE id = ?";
    private static final String DELETE = "DELETE FROM teams WHERE id= ?";
    private static final String FIND = SELECT + " WHERE id= ?";

    @Override
    public List<Team> readAll() {
        Connection connection;
        PreparedStatement query = null;
        ArrayList<Team> result = new ArrayList<>();
        connection = MySQLConnection.getConnection();
        ResultSet rs = null;
        try {
            query = connection.prepareStatement(SELECT);
            rs = query.executeQuery();
            while (rs.next()) {
                Team team = new Team(
                        rs.getInt("id"),
                        rs.getString("name"),
                        new ArrayList<>()
                );
                result.add(team);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeamDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs.close();
            query.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public void update(Team element) {
        //falta por implementar
        
        
        
    }

    @Override
    public Team delete(int id) {
        Connection connection = null;
        PreparedStatement query = null;
       // ArrayList<Team> result = new ArrayList<>();
        ResultSet rs = null;
        Team team = null;
  
        try {
            connection = MySQLConnection.getConnection(); //calling connection
            query = connection.prepareStatement(DELETE);
            //binding data
            query.setInt(1,id);
            rs = query.executeQuery();
            while (rs.next()) {
                team = new Team(
                        rs.getInt("id"),
                        rs.getString("name"),
                        new ArrayList<>()
                );
            }
              rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
          
            query.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return team;
    }

    @Override
    public Team find(int id) {
        Connection connection = null;
        PreparedStatement query = null;
       // ArrayList<Team> result = new ArrayList<>();
        ResultSet rs = null;
        Team team = null;
  
        try {
            connection = MySQLConnection.getConnection(); //calling connection
            query = connection.prepareStatement(FIND);
            //binding data
            query.setInt(1, id);
            rs = query.executeQuery();
            while (rs.next()) {
                team = new Team(
                        rs.getInt("id"),
                        rs.getString("name"),
                        new ArrayList<>()
                );
            }
              rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
          
            query.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(TeamDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return team;
    }

    @Override
    public Team create(Team element) {
        Connection connection;
        PreparedStatement query = null;
        Team team = null;
        connection = MySQLConnection.getConnection();
        try {
            query = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            query.setString(1, element.getName());
            int rowsAfected = query.executeUpdate();
            if (rowsAfected > 0) {
                try (ResultSet rs = query.getGeneratedKeys()) {
                    int id = rs.getInt(0);
                    rs.next();
                    element.setId(id);
                }
            }
             query.close();
             connection.close();
             return team;
        } catch (SQLException ex) {
            Logger.getLogger(TeamDataBaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    

        return null;
    

}
}
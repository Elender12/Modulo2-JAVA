/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.futurepath.main;

import dev.futurepath.model.Team;
import dev.futurepath.model.daos.TeamDao;

/**
 *
 * @author anselm
 */
public class ApplicationTests {
    
    public static void main(String[] args) {
        Team team = new Team(0, "A", null);
        new TeamDao().create(team);
        System.out.println(team);
        new TeamDao().create(team);
        System.out.println(team);
        new TeamDao().create(team);
        System.out.println(team);
        
    }
}

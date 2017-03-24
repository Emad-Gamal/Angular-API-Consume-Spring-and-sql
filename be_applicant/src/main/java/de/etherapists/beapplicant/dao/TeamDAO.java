package de.etherapists.beapplicant.dao;

import java.util.List;

import de.etherapists.beapplicant.model.Team;

@SuppressWarnings("PMD.UnusedModifier")
public interface TeamDAO {

    /**
     * adds a {@link Team}
     *
     * @param team
     *            {@link Team} to add
     */
    public void addTeam(Team team);

    /**
     * update a {@link Team}
     *
     * @param team
     *            {@link Team} to update
     */
    public void updateTeam(Team team);

    /**
     * gets the team from database
     *
     * @param id
     *            {@link Team} id
     *            
     * @return the requested {@link Team}
     */
    public Team getTeam(int id);
    
    /**
     * delete a team from database
     *
     * @param id
     *            {@link Team} id to delete
     */
    public void deleteTeam(int id);
    
    /**
     * gets a list of all teams in the database
     * 
     * @return {@link List} of {@link Team}
     */
    public List<Team> getTeams();

}
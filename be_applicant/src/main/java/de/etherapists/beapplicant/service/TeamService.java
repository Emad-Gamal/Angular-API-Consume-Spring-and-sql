package de.etherapists.beapplicant.service;

import java.util.List;

import de.etherapists.beapplicant.model.Team;

@SuppressWarnings("PMD.UnusedModifier")
public interface TeamService {

    /**
     * adds a {@link Team}
     *
     * @param team
     *            {@link Team} to add
     */
    void addTeam(Team team);

    /**
     * updates a {@link Team}
     *
     * @param team
     *            {@link Team} to update
     */
    void updateTeam(Team team);
    /**
     * gets team from database by id
     *
     * @param id
     *            id of the {@link Team}
     * @return {@link Team}
     */
    Team getTeam(int id);
    /**
     * deletes a team from database
     *
     * @param id
     *            id of the {@link Team} to delete
     */
    void deleteTeam(int id);
    /**
     * gets a list of all saved teams
     *
     * @return List of teams
     */
    List<Team> getTeams();

}
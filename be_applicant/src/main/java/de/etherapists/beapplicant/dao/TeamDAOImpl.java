package de.etherapists.beapplicant.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.etherapists.beapplicant.restService.Team;
import  de.etherapists.util.BasicDAO;

@Repository
public class TeamDAOImpl extends BasicDAO implements TeamDAO {

    @Override
    public void addTeam(Team team) {
        getCurrentSession().save(team);
    }

    @Override
    public void updateTeam(Team team) {
        final Team teamToUpdate = getTeam(team.getId());
        teamToUpdate.setName(team.getName());
        teamToUpdate.setRating(team.getRating());
        getCurrentSession().update(teamToUpdate);
    }

    @Override
    public Team getTeam(int id) {
        final Team team = (Team) getCurrentSession().get(Team.class, id);
        return team;
    }

    @Override
    public void deleteTeam(int id) {
        final Team team = getTeam(id);
        if (team != null) {
            getCurrentSession().delete(team);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Team> getTeams() {
        return getCurrentSession().createQuery("from Team").list();
    }

}
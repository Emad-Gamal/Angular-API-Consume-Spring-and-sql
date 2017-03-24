package de.etherapists.beapplicant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.etherapists.beapplicant.dao.TeamDAO;
import de.etherapists.beapplicant.restService.Team;

@Service
@org.springframework.transaction.annotation.Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamDAO teamDAO;

    @Override
    public void addTeam(Team team) {
        teamDAO.addTeam(team);
    }

    @Override
    public void updateTeam(Team team) {
        teamDAO.updateTeam(team);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    @Override
    public Team getTeam(int id) {
        return teamDAO.getTeam(id);
    }

    @Override
    public void deleteTeam(int id) {
        teamDAO.deleteTeam(id);
    }

    @Override
    public List<Team> getTeams() {
        return teamDAO.getTeams();
    }

}
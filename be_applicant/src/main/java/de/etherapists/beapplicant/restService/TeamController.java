package de.etherapists.beapplicant.restService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import de.etherapists.beapplicant.service.TeamService;

@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    /**
     * redirect to the add team form
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/team/add")
    public ModelAndView addTeamPage() {
        final ModelAndView modelAndView = new ModelAndView("../add-team-form");
        modelAndView.addObject("team", new Team());
        return modelAndView;
    }

    /**
     * adding a new team
     *
     * @param team
     *            team to add
     * @return ModelAndView
     */
    @RequestMapping(value = "/team/add/process")
    public ModelAndView addingTeam(@ModelAttribute Team team) {

        final ModelAndView modelAndView = new ModelAndView("../../home");
        teamService.addTeam(team);

        final String message = "Team was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    /**
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "/team/list")
    public ModelAndView listOfTeams() {
        final ModelAndView modelAndView = new ModelAndView("../list-of-teams");

        final List<Team> teams = teamService.getTeams();
        modelAndView.addObject("teams", teams);

        return modelAndView;
    }

    /**
     * edit team page
     * 
     * @param id
     *            team id
     * @return ModelAndView
     */
    @RequestMapping(value = "/team/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editTeamPage(@PathVariable Integer id) {
        final ModelAndView modelAndView = new ModelAndView("../../edit-team-form");
        final Team team = teamService.getTeam(id);
        modelAndView.addObject("team", team);
        return modelAndView;
    }

    /**
     * updating a team
     *
     * @param team
     *            to update
     * @param id
     *            of the updating team
     * @return ModelAndView
     */
    @RequestMapping(value = "/team/edit/{id}", method = RequestMethod.POST)
    public ModelAndView edditingTeam(@ModelAttribute Team team, @PathVariable Integer id) {

        final ModelAndView modelAndView = new ModelAndView("../../home");

        teamService.updateTeam(team);

        final String message = "Team was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    /**
     * delete a team
     *
     * @param id
     *            id of the deleting team
     * @return ModelAndView
     */
    @RequestMapping(value = "/team/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteTeam(@PathVariable Integer id) {
        final ModelAndView modelAndView = new ModelAndView("../../home");
        teamService.deleteTeam(id);
        final String message = "Team was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

}
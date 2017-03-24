package de.etherapists.beapplicant.restService;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.etherapists.beapplicant.model.Team;
import de.etherapists.beapplicant.service.TeamService;
import de.etherapists.util.BasicController;

@Controller
@RequestMapping(value ="/team")
public class TeamController extends BasicController{


        @Autowired
        private HttpServletRequest request;

        @Autowired
        private HttpServletResponse response;
        
        @Autowired
        private TeamService teamService;
        

        @ResponseBody
        @RequestMapping(value = "/list", method = RequestMethod.GET)
        public void test() throws IOException {

      
         List<Team> teamList = teamService.getTeams();
        	

            callJSONResponse(request, response, teamList, HttpStatus.I_AM_A_TEAPOT);

        }
    
    
    

}
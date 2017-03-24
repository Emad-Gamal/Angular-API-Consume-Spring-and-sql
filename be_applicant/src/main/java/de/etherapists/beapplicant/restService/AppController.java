package de.etherapists.beapplicant.restService;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import util.BasicController;

@RestController
@RequestMapping(value = "/test")
public class TestController extends BasicController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void exerciseDone() throws IOException {

        final Team team = new Team();

        team.setId(2);
        team.setName("Jörg");

        callJSONResponse(request, response, team, HttpStatus.I_AM_A_TEAPOT);

    }

}

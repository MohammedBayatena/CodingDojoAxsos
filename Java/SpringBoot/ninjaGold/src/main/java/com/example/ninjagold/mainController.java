package com.example.ninjagold;


import ch.qos.logback.core.boolex.EvaluationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Controller
public class mainController {

    /*
     * Controller that attaches to / ,
     * if Session is new or not created yet , Create Session
     * If session created then get an instance
     * */

    @RequestMapping(value = "/")
    public String renderMain(HttpSession session) {
        if (session != null && !session.isNew()) { // Check if session not created or is empty
            ArrayList<HashMap<String, String>> activities = (ArrayList<HashMap<String, String>>) session.getAttribute("activities");
        } else {
            ArrayList<HashMap<String, String>> activities = new ArrayList<>();
            session.setAttribute("activities", activities); // session empty add gold counter and activities list
            session.setAttribute("goldamount", 0);
        }
        return "index.jsp";
    }
    /*
     *This is Controller that attaches to /process_money
     * Get parameter form type from POST request at this ROUTE then generate few stuff and add to sesssion
     * after adding to session redirect back home for page to render
     *
     * Passing something like the Context Dictionary in python becomes an array list of hash maps of type String , String or a json file
     * ArrayList<HashMap<String, String>> creates something similar to python context
     *
     *  */


    @RequestMapping("/process_money")
    public String processMoney(HttpSession session, @RequestParam("formtype") String formtype) {
        if (formtype.equals("farm")) {

            HashMap<String, String> activity = new HashMap<String, String>(); // get an activity object  (hashmap) to be filled with data
            activity.put("type", "farm");
            activity.put("rand", random(10, 20).toString());
            activity.put("date", (new Date()).toString());
            activity.put("win", "1");
            //update gold amount
            session.setAttribute("goldamount", (Integer) session.getAttribute("goldamount") + Integer.parseInt(activity.get("rand")));
            //ADD the new activity to the activities list inside the session
            ArrayList<HashMap<String, String>> activities = (ArrayList<HashMap<String, String>>) session.getAttribute("activities");
            activities.add(activity);
            session.setAttribute("activities", activities); // save session

        } else if (formtype.equals("cave")) {
            HashMap<String, String> activity = new HashMap<String, String>();
            activity.put("type", "cave");
            activity.put("rand", random(5, 10).toString());
            activity.put("date", (new Date()).toString());
            activity.put("win", "1");

            session.setAttribute("goldamount", (Integer) session.getAttribute("goldamount") + Integer.parseInt(activity.get("rand")));

            ArrayList<HashMap<String, String>> activities = (ArrayList<HashMap<String, String>>) session.getAttribute("activities");
            activities.add(activity);
            session.setAttribute("activities", activities);

        } else if (formtype.equals("house")) {
            HashMap<String, String> activity = new HashMap<String, String>();
            activity.put("type", "house");
            activity.put("rand", random(2, 5).toString());
            activity.put("date", (new Date()).toString());
            activity.put("win", "1");

            session.setAttribute("goldamount", (Integer) session.getAttribute("goldamount") + Integer.parseInt(activity.get("rand")));

            ArrayList<HashMap<String, String>> activities = (ArrayList<HashMap<String, String>>) session.getAttribute("activities");
            activities.add(activity);
            session.setAttribute("activities", activities);

        } else if (formtype.equals("casino")) {
            HashMap<String, String> activity = new HashMap<String, String>();
            activity.put("type", "casino");
            activity.put("rand", random(0, 50).toString());
            activity.put("date", (new Date()).toString());
            activity.put("win", random(0, 1).toString());

            ArrayList<HashMap<String, String>> activities = (ArrayList<HashMap<String, String>>) session.getAttribute("activities");
            activities.add(activity);
            session.setAttribute("activities", activities);
            //Decide if its a win or lose from casino
            if (activity.get("win").equals("1")) {
                session.setAttribute("goldamount", (Integer) session.getAttribute("goldamount") + Integer.parseInt(activity.get("rand")));
            } else if (activity.get("win").equals("0")) {
                session.setAttribute("goldamount", (Integer) session.getAttribute("goldamount") - Integer.parseInt(activity.get("rand")));
            }

        }
        //Go home to render
        return "redirect:/";
    }

    /*
     * This function Generates random int between two values (inclusive in both)
     * */
    public static Integer random(int min, int max) {
        Integer random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }


}

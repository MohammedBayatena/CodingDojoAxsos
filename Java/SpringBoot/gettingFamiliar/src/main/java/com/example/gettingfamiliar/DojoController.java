package com.example.gettingfamiliar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
    @RequestMapping("/dojo")
    public String handleDojo() {
        return "The " + "dojo" + " is awesome!";
    }

    @RequestMapping(value = "/{dojo}")
    public String handleLocation(@PathVariable("dojo") String dojo) {
        String ret = "Wrong Path Maybe?!";
        try {
            String arr[] = dojo.split("-");
            if (arr[1].equals("dojo")) {
                ret = String.format("%s %s is Located in Southern California", arr[0], arr[1]);
            } else if (arr[0].equals("san") && arr[1].equals("jose")) {
                ret = "SJ dojo is the headquarters ";
            }
        } catch (Exception e) {
            ret = dojo;
        }
        return ret;
    }
}

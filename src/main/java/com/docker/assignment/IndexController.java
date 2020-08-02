package com.docker.assignment;

import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    
    @Autowired
    PostRepository postRepository; 

    @SuppressWarnings("unchecked")
	@GetMapping("/")
    public String index(Model model) {
    	if(postRepository.save( new Post(1, "This is first POST!!!!",  new Date())) != null) {
    		model.addAttribute("status", "Value inserted in MySQL Database");
    		postRepository.save( new Post(1, "This is first POST!!!!",  new Date()));
    		model.addAttribute("newfeature", "I am running from Docker");
    	}
    	 	
        return "index";
    }
}

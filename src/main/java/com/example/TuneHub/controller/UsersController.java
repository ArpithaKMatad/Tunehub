package com.example.TuneHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TuneHub.entities.Song;
import com.example.TuneHub.entities.Users;
import com.example.TuneHub.services.SongService;
import com.example.TuneHub.services.UsersService;

import jakarta.servlet.http.HttpSession;
@Controller
public class UsersController 
{
	@Autowired
	UsersService service;
	@Autowired
	SongService songService;	
       @PostMapping("/register")
         public String addUsers(@ModelAttribute Users user)
         {
    	   boolean userstatus=service.emailExists(user.getEmail());
    	   if(userstatus==false)
    	   {
	           service.addUsers(user);
	           return "registersuccess";
    	   }
    	   else
    	   {
    		   return "registerfail";
    	   }
	          
         }
       @PostMapping("/validate")
       public String validateUser(@RequestParam("email") String email,@RequestParam("password") 
       String password,HttpSession session,Model model)
       {
    	   if(service.validateUser(email,password)==true)
    	   {
    		   String role=service.getRole(email);
    		   session.setAttribute("email",email);
    		   if(role.equals("admin"))
    		   {
    		     return "adminHome";
    		   }
    		   else
    		   {
    			   Users user=service.getUser(email);
        		   boolean userStatus=user.isPremium();
        		   List<Song> songsList=songService.fetchAllSongs();
       	           
       	           model.addAttribute("songs", songsList);
       	           model.addAttribute("isPremium",userStatus);
    			   return "customerHome";  
    		   }
    	   }
    	   else
    	   {
    		  
    		   return "loginfail";
    	   }
       }
       
     
      
       @GetMapping("/logout") 
       public String logout(HttpSession session)
       {
    	   session.invalidate();
    	   return "login";  
       }
}


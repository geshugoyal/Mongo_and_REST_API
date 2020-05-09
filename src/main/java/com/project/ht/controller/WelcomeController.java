package com.project.ht.controller;




import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import  com.project.ht.model.Welcome;
import com.project.ht.service.WelcomeService;

@Controller
public class WelcomeController {
	
	Welcome user;
	String prevemail;
	private static List<Welcome> listUser = new ArrayList<Welcome>();
	
    static {
		
		listUser.add(new Welcome("geshu", "goyal", "7206165841"));
	       }
	
	
    @RequestMapping(value = { "/listUser" }, method = RequestMethod.GET)                    
	    public  ModelAndView listUser() {
    	   
    	 ModelAndView model = new ModelAndView("viewUser");
   		 model.addObject("listUser", welcomeService.findAllUserList());
   		 return model;

	    }
	@Autowired
	   private WelcomeService welcomeService;
	
	@RequestMapping("/")
	   public ModelAndView forms() {
		 return new ModelAndView("form");
	}
	
	
	@RequestMapping(value = { "/add" }, method = RequestMethod.GET)
       public ModelAndView add(Model model) {
 
        Welcome welcome = new Welcome();
        model.addAttribute("listUser", welcome);
        return new ModelAndView("form");
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)  
       public ModelAndView add(@ModelAttribute("user") @Valid Welcome user, ModelMap model) throws Exception {
    	  System.out.println("Add list User Method Called"+user.getEmail());
    	 	
		  System.out.println("inside aff "+user.getId());
		  model.addAttribute("name", user.getName());
	      model.addAttribute("email", user.getEmail());
	      model.addAttribute("phoneno", user.getPhoneno());
	      listUser.add(user);
	      // listUser.add(new Welcome("getName().toString()", "getEmail().toString()", "getPhoneno().toString()"));
		  welcomeService.add(user);
		  
		  System.out.println(" welcome service of add:"+welcomeService);

		  
		  if(user.getId()==null)  {
			  System.out.println("from null welcome sevice of add method..");
		   	   return new ModelAndView("emailExist");
		       }
		   
		  else {
   	      System.out.println("from method Add when new user Called"+user.getId());
   	      return new ModelAndView("listUser1") ;
  		       }
     }
    

    @RequestMapping(value = "/delete", params = {"id"})  
       public @ResponseBody ModelAndView delete(@RequestParam(value = "id") String id, @ModelAttribute(value="user") Welcome user,  Model model)
        {
    	 System.out.println("from delete method.."+user.getId());
    	 System.out.println("from delete method.."+user.getName());

    	 //System.out.println(welcomeService.findUserById(user.getId()));
          user = welcomeService.findUserById(id);
     	 
		 System.out.println("from controller delete Method Called");
		 welcomeService.delete(id);
		 return new ModelAndView ("listUser");
  
        }    

    @RequestMapping(value = "/update" , params = {"id"})
	   public ModelAndView update(@RequestParam(value = "id") String id, @ModelAttribute(value="user") Welcome user,  Model model)
        {
    	  System.out.println("from update get method.."+user.getId());
    	  //System.out.println(welcomeService.findUserById(user.getId()));
    	  user = welcomeService.findUserById(id);
    	  //System.out.println("from update get method.."+user.getName());
		  //welcomeService.update(id);
    	     model.addAttribute("listUser", user);
 	         model.addAttribute("name", user.getName());
	         model.addAttribute("email", user.getEmail());
	         model.addAttribute("phoneno", user.getPhoneno());
	         prevemail= user.getEmail();
	         System.out.println("from update after get method in controller.."+user.getEmail());
		  return new ModelAndView( "update");
	    }

    @RequestMapping(value = "/update" , method = RequestMethod.POST, params = {"id","name", "email","phoneno"})
  	   public String update(@RequestParam(value = "id") String id,@RequestParam(value = "name") String name, @RequestParam(value = "email") String email,@RequestParam(value = "phoneno") String phoneno, @ModelAttribute("user")  Welcome user, ModelMap model) {
    	     System.out.println("from update post method..");
    	     String email12= user.getEmail();
			 System.out.println("from 123456 welcome service of add method.."+email12);
             
            
            	 
    	     model.addAttribute("name", user.getName());
   	         model.addAttribute("email", user.getEmail());
   	         model.addAttribute("phoneno", user.getPhoneno());
             System.out.println("from update POST method..");
             
  		     System.out.println("from update POST method after add user..");
  		    user= welcomeService.update(user);
  	          //user = welcomeService.findByEmail(email12);

  	       System.out.println("from required123456 welcome sevice of add method.."+email12);
  	       System.out.println("from required123456 welcome sevice of add method.."+prevemail);
  	      if(user==null) {
  	    	return ("emailExist12");
  	      }
 			 
 			 System.out.println("from null welcome sevice of add method for lisyUser2.."+user.getEmail());
  		     return ("listUser2");
 		  }
  		  
 		  }

       

  


/*
@RequestMapping(value="/listUser", method= RequestMethod.GET)
public ModelAndView listUser(@ModelAttribute("model") ModelMap model) {
System.out.println("List User Method Called");
model.addAttribute("listUser", listUser);
	return new ModelAndView ("listUser");
}
*/


/*
@RequestMapping(value = "/", method = RequestMethod.GET)  
public ModelAndView list() {  
   List<Welcome> list= listUser();  
    ModelAndView model= new ModelAndView("list");
    model.addObject("listUser", "list");
    return model;
}  
*/
    
/*
System.out.println("geshu1");

//listUser.add(new Welcome("getName().toString()", "getEmail().toString()", "getPhoneno().toString()"));
System.out.println("geshu2");
 model.addAttribute("listUser",listUser);
//modelMap.put("listUser",listUser);
System.out.println("geshu3");

// return new ModelAndView("viewUser");
return "viewUser";*/


/*
@RequestMapping(value = "/delete/{id}" , method = RequestMethod.POST)
public String delete(@PathVariable("id") String id) {
	User user = userService.findUserById(id);
	userService.delete(user);
	
	return "redirect:user/list";
}
*/

    /*
    @RequestMapping(value = "/update/{_id}" , method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute("user") Welcome user, Model model) {
    	System.out.println("from update get method.."+user.getId());
		 
		model.addAttribute("user", welcomeService.findUserById(user.getId()));
     	return new ModelAndView( "update");
        }
*/
    
    /*
    @RequestMapping(value = "/update/{_id}" , method=RequestMethod.POST)
    
    public String update(@ModelAttribute("user")  Welcome user) {
    	System.out.println("from update post method..");
		if(user.getEmail() != null && !user.getEmail().trim().equals("")) {
			welcomeService.update(user);
		}
		else {
			welcomeService.add(user);
		}
		return "listUser";
	}
*/
    
    /*
    
    @RequestMapping(value="/update" ,method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Welcome user) {
        welcomeService.add(user);
    }
    */
  
    
  
	//@RequestMapping(value="/save")
	//public  ModelAndView addUser(@ModelAttribute Welcome user, Model model) {
	//	System.out.println("Inside this method");
	//	welcomeService.add(user);
	//	model.addAttribute("name","welcome");
		
	//	return null;
	//}
		/*
	@RequestMapping(value = "/user" , method = RequestMethod.GET)
	public ModelAndView list(ModelMap model) {
		System.out.println("From list in WelcomeController..");
		model.addAttribute("userList", welcomeService.listUser()); 
		return new ModelAndView("list", "command", "new Welcome()");
		}
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public ModelAndView add(@ModelAttribute("SpringWeb") Welcome user, ModelMap model) {
		System.out.println("inside aff "+user.getName());
		  model.addAttribute("name", user.getName());
	      model.addAttribute("email", user.getEmail());
	      model.addAttribute("phoneno", user.getPhoneno());
		
		return new ModelAndView("list") ;
	}
	
	
	 
		@RequestMapping(value = "/delete/{id}" ,  method = RequestMethod.DELETE)
		public String delete(@PathVariable("id") String id) {
			//Welcome user = welcomeService.findUserById(id);
			welcomeService.delete(id);
			
			return "/user/list";
		}
		*/
	/*
	
	 @RequestMapping("/show/{id}")
	    public String show(@PathVariable String id, Model model) {
	        model.addAttribute("welcome", welcomeService.findUserById(id));
	        return "list";
	    }
	    */
//	@RequestMapping(value = "/update/{id}" , method = RequestMethod.GET)
//	public ModelAndView update(@PathVariable("id") String id) {
//		ModelAndView model = new ModelAndView("user/form");
//		model.addObject("userForm" , userService.findUserById(id));
//		return model;
//	}
	
	 /*
	
	@RequestMapping(value = "/update/{id}" , method = RequestMethod.PUT)
	public void update(@ModelAttribute  Welcome user) {
		if(user.getEmail() != null && !user.getEmail().trim().equals("")) {
			((WelcomeController) welcomeService).update(user);
		}
		else {
			welcomeService.add(user);
		}
		
	}
	*/
	
	



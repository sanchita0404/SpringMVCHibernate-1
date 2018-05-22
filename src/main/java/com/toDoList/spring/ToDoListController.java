package com.toDoList.spring;

import com.toDoList.spring.model.Task;
import com.toDoList.spring.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToDoListController {
	
	private ToDoListService toDoListService;
	
	@Autowired(required=true)
	@Qualifier(value="toDoListService")
	public void setToDoListService(ToDoListService ps){
		this.toDoListService = ps;
	}

	@RequestMapping(value = "/toDoList", method = RequestMethod.GET)
	public ModelAndView showLoginPage(Model model) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}


	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("Task", new Task());
		model.addAttribute("listTasks", this.toDoListService.listTasks());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addTask(@ModelAttribute("task") Task p){
		
		if(p.getTaskId() == 0){
			//new person, add it
			this.toDoListService.addTask(p);
		}else{
			//existing person, call update
			this.toDoListService.updateTask(p);
		}
		
		return "redirect:/persons";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeTask(@PathVariable("id") int id){
		
        this.toDoListService.removeTask(id);
        return "redirect:/persons";
    }
 
    @RequestMapping("/edit/{id}")
    public String editTask(@PathVariable("id") int id, Model model){
        model.addAttribute("Task", this.toDoListService.getTaskById(id));
        model.addAttribute("listTask", this.toDoListService.listTasks());
        return "person";
    }
	
}

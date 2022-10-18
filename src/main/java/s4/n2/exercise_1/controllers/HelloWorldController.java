package s4.n2.exercise_1.controllers;

import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping ("/hello_world")
	public String saluda (@RequestParam (defaultValue = "UNKNOWN") String name) {
			
		return "Hola " + name + ". Estàs executant un projecte Gradle";		
	}
	
	@RequestMapping (method = RequestMethod.GET, value = {"/hello_world2" , "/hello_world2/{name}"})
	public String saluda2 (@PathVariable Optional<String> name) {		
		String userName = "UNKNOWN";
		
		if (name.isPresent()) {
			userName = name.get();	
		}
		  
		return "Hola " + userName + ". Estàs executant un projecte Gradle";	
	}
}

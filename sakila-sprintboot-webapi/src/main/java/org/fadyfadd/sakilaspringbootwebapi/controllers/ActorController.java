package org.fadyfadd.sakilaspringbootwebapi.controllers;


import java.util.List;
import org.fadyfadd.sakilaspringbootwebapi.CrudOperationStatusResponse;
import org.fadyfadd.sakilaspringbootwebapi.EmailConfiguration;
import org.fadyfadd.sakilaspringbootwebapi.sakila.Actor;
import org.fadyfadd.sakilaspringbootwebapi.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;;



@CrossOrigin("http://localhost:4200")
@RestController
public class ActorController {
	
	@Autowired
	EmailConfiguration configuration;	
	
	@Autowired
	@Qualifier("sakilaJdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ActorService actorService;
	 
	@GetMapping("/actors")
	public ResponseEntity<List<Actor>> findAllActorsBy() {
		return ResponseEntity.ok(actorService.getAllActors());
	}
	
	
	@GetMapping("/actor/{actorid}")
	public ResponseEntity<Actor> findActorById(@PathVariable("actorid") Integer actorId) {
		return ResponseEntity.ok(actorService.getActorById(actorId));		 
	
	}
	
	@PostMapping("insert-actor")
 	public  ResponseEntity<CrudOperationStatusResponse> insertActor(@RequestBody Actor actor) {
		return ResponseEntity.ok(actorService.insertActor(actor));		
	}
 	
	@PutMapping("update-actor")
 	public  ResponseEntity<CrudOperationStatusResponse> updateActor(@RequestBody Actor actor) {
		return ResponseEntity.ok(actorService.updateActor(actor));		
	}
 	
	@DeleteMapping("delete-actor/{actorid}")
 	public  ResponseEntity<CrudOperationStatusResponse> deleteActor(@PathVariable("actorid") Integer actorId) {
		return ResponseEntity.ok(actorService.deleteActor(actorId));		
	}
	

}

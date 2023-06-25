package org.fadyfadd.sakilaspringbootwebapi.controllers;

import java.util.List;

import org.fadyfadd.sakilaspringbootwebapi.EmailConfiguration;
import org.fadyfadd.sakilaspringbootwebapi.sakila.Actor;
import org.fadyfadd.sakilaspringbootwebapi.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


 
@RestController
public class ActorController {

	@Autowired
	EmailConfiguration configuration;	
	
	@Autowired
	@Qualifier("todosJdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ActorService actorService;
	 
	@GetMapping("/actors")
	public ResponseEntity<List<Actor>> findAllActorsBy() {
		return ResponseEntity.ok(actorService.getAllActors());

	}

}

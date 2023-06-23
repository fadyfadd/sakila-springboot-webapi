package org.fadyfadd.sakilaspringbootwebapi.controllers;

import java.util.List;

import org.fadyfadd.sakilaspringbootwebapi.repositories.Actor;
import org.fadyfadd.sakilaspringbootwebapi.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {

	@Autowired
	ActorService actorService;

	public ActorController(ActorService actorService) {

	}

	@GetMapping("/hello")
	public ResponseEntity<List<Actor>> findAllActorsBy() {
		return ResponseEntity.ok(actorService.getAllActors());

	}

}

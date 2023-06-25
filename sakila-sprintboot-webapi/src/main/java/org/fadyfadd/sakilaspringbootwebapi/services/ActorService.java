package org.fadyfadd.sakilaspringbootwebapi.services;

import java.util.List;

import org.fadyfadd.sakilaspringbootwebapi.sakila.Actor;
import org.fadyfadd.sakilaspringbootwebapi.sakila.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

	@Autowired
	ActorRepository actorRepository;

	public ActorService() {

	}

	public List<Actor> getAllActors() {
		return actorRepository.findAll();
	}

}

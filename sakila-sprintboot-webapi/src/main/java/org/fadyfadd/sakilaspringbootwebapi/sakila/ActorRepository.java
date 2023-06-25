package org.fadyfadd.sakilaspringbootwebapi.sakila;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor , Integer> {

	
}  
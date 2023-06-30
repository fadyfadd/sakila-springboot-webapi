package org.fadyfadd.sakilaspringbootwebapi.services;

import java.util.List;
import java.util.Optional;

import org.fadyfadd.sakilaspringbootwebapi.CrudOperationStatusResponse;
import org.fadyfadd.sakilaspringbootwebapi.OperationStatus;
import org.fadyfadd.sakilaspringbootwebapi.sakila.Actor;
import org.fadyfadd.sakilaspringbootwebapi.sakila.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.micrometer.core.ipc.http.HttpSender.Response;

@Service
public class ActorService {

	@Autowired
	ActorRepository actorRepository;

	public List<Actor> getAllActors() {
		return actorRepository.findAll();
	}
	
	public Actor getActorById(Integer actorId) {
		Optional<Actor> actorOptional =  actorRepository.findById(actorId);
		
		if (actorOptional.isPresent())
			return actorOptional.get(); 
		
		return null; 
	}

	public CrudOperationStatusResponse insertActor(Actor actor) {		
		actor.setActorId(null);
		actorRepository.save(actor);
		CrudOperationStatusResponse response = new CrudOperationStatusResponse();	
		response.setExtraData(actor.getActorId());
		response.setOperationStatus(OperationStatus.Success);
		response.setNbrOfImpactedRows(1);
		
		return response;		
	}

    public CrudOperationStatusResponse updateActor(Actor actor) {
		
    	Actor aactor = this.getActorById(actor.getActorId());   	

    	
    	if (aactor == null) {
    		CrudOperationStatusResponse response = new CrudOperationStatusResponse();	
    		response.setOperationStatus(OperationStatus.Failure);
    		response.setNbrOfImpactedRows(0);
    		return response; 
    	}
    	
    	aactor.setFirstName(actor.getFirstName());
    	aactor.setLastName(actor.getLastName());
    	aactor.setLastUpdate(actor.getLastUpdate());
    	
    	actorRepository.save(aactor);
    	CrudOperationStatusResponse response = new CrudOperationStatusResponse();	
    	response.setOperationStatus(OperationStatus.Success);
    	response.setErrorMessage("Non existing actor");
		response.setNbrOfImpactedRows(1);
    	
    	return response; 
    }
    
    public CrudOperationStatusResponse deleteActor(Integer actorId) {
		
    	Actor aactor = this.getActorById(actorId);
    	
    	if (aactor == null) {
    		CrudOperationStatusResponse response = new CrudOperationStatusResponse();	
    		response.setOperationStatus(OperationStatus.Failure);
    		response.setNbrOfImpactedRows(0);
    		response.setErrorMessage("Non existing actor");
    		return response; 
    	}
    	
    	actorRepository.delete(aactor);
    	CrudOperationStatusResponse response = new CrudOperationStatusResponse();	
    	response.setOperationStatus(OperationStatus.Success);
		response.setNbrOfImpactedRows(1);
    	
    	return response; 
    }
	

}

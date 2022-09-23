package co.edu.uniandes.dse.parcialejemplo.services;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEnity;

import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;

import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HabitacionService {

    @Autowired
	HabitacionRepository habitacionRepository;
    

    @Transactional
	public HabitacionEnity crearhabitacion(HabitacionEnity habitacion) throws EntityNotFoundException, IllegalOperationException {
		
		if (habitacion.getNumeroBanios() > habitacion.getNumeroCamas()){
			throw new IllegalOperationException("la habitacion tiene mayor numero de baños");
        
		
	    }
    return habitacionRepository.save(habitacion);
		

}

}

package co.edu.uniandes.dse.parcialejemplo.services;

import co.edu.uniandes.dse.parcialejemplo.entities.HabitacionEnity;
import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.repositories.HabitacionRepository;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import co.edu.uniandes.dse.parcialejemplo.exceptions.IllegalOperationException;

import co.edu.uniandes.dse.parcialejemplo.exceptions.EntityNotFoundException;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HotelService {

    @Autowired
	HotelRepository hotelRepository;
    

    @Transactional
	public HotelEntity crearhotel(HotelEntity hotel) throws EntityNotFoundException, IllegalOperationException {
        Optional<HotelEntity> hotelentity = hotelRepository.findById(hotel.getId()); 
		
		if (hotelentity.isPresent()){
			throw new IllegalOperationException("Este hotel ya esta creado");
        
	
	    }
    return hotelRepository.save(hotel);
		

}

}

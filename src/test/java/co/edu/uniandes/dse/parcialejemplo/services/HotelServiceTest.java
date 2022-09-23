package co.edu.uniandes.dse.parcialejemplo.services;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import java.util.Optional;

import org.aspectj.asm.internal.ProgramElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcialejemplo.entities.HotelEntity;
import co.edu.uniandes.dse.parcialejemplo.repositories.HotelRepository;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(HotelService.class)
public class HotelServiceTest {
    @Autowired
    private HotelService hService;

    @Autowired
    private HotelRepository hRepository;


    @Autowired
    private TestEntityManager entityManager;

    private PodamFactory factory = new PodamFactoryImpl();

    private HotelEntity entidadh;

    @BeforeEach
    void setUp() {
            clearData();
            insertData();
    }

    private void clearData() {
        entityManager.getEntityManager().createQuery("delete from HotelEntity");
       
    }
    @Test
    private void insertData() {
            HotelEntity entidadhotel = factory.manufacturePojo(HotelEntity.class);
            entityManager.persist(entidadhotel);

            entidadh =entidadhotel; 
        
            
    }
    @Test
     void testcrearhotel() {
         
           Optional<HotelEntity> hotelentity = hRepository.findById(entidadh.getId()); 
           if (hotelentity.isPresent()){
            assertTrue(true);

           }
            
    }
    @Test
    void testcreatemediconovalid() {
        
          HotelEntity entidadhotel = factory.manufacturePojo(HotelEntity.class);
          entidadhotel.setId(entidadh.getId());

          try {
            hService.crearhotel(entidadhotel);
            
          } catch (Exception IllegalOperationException) {
             assertTrue(true);
          }

        
   }

    
}
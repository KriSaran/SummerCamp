package com.summercampquest.campquest.service;

import com.summercampquest.campquest.models.Camp;
import com.summercampquest.campquest.models.data.CampRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CampDataTest {

    @InjectMocks
    private CampData campData;

    @Mock
    private CampRepository campRepository;


    @Mock
    private Camp camp;

    @Test
    void displayCampById() {

//        Mockito.when(camp.getId()).thenReturn("IOS Camp");
//
//        List<Camp> camps = new ArrayList<>(1);
//        camps.add(camp);
//        Mockito.when(campRepository.findAllById(1)).thenReturn(camps);
//
//        List<Camp> responseEntity = campRepository.findAll();
//        assertNotNull(responseEntity);
//        assertEquals(1, responseEntity.size());
//        assertEquals("IOS Camp", responseEntity.get(0).getName());

    }

    @Test
    void displayCamps() {

        Mockito.when(camp.getName()).thenReturn("IOS Camp");

        List<Camp> camps = new ArrayList<>(1);
        camps.add(camp);
        Mockito.when(campRepository.findAll()).thenReturn(camps);

        List<Camp> responseEntity = campRepository.findAll();
        assertNotNull(responseEntity);
        assertEquals(1, responseEntity.size());
        assertEquals("IOS Camp", responseEntity.get(0).getName());
    }

    @Test
    void searchCamps() {

        Mockito.when(camp.getName()).thenReturn("IOS Camp");

        List<Camp> camps = new ArrayList<>(1);
        camps.add(camp);
        Mockito.when(campRepository.searchCampsByNameAndCategory("%IOS",null)).thenReturn(camps);

        List<Camp> responseEntity = campRepository.searchCampsByNameAndCategory("%IOS",null);
        assertNotNull(responseEntity);
        assertEquals(1, responseEntity.size());
        assertEquals("IOS Camp", responseEntity.get(0).getName());

    }

}
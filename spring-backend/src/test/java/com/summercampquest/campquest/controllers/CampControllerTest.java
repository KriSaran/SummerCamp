package com.summercampquest.campquest.controllers;

import com.summercampquest.campquest.models.Camp;
import com.summercampquest.campquest.service.CampData;
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
class CampControllerTest {

    @InjectMocks
    private CampController campController;

    @Mock
    private CampData campData;

    @Mock
    private Camp camp;

    @Test
    void displayCamps() {

        Mockito.when(camp.getName()).thenReturn("IOS Camp");

        List<Camp> camps = new ArrayList<>(1);
        camps.add(camp);
        Mockito.when(campData.displayCamps()).thenReturn(camps);

        ResponseEntity<List<Camp>> responseEntity = campController.displayCamps(null, null);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        assertEquals(1, responseEntity.getBody().size());
        assertEquals("IOS Camp", responseEntity.getBody().get(0).getName());
    }

    @Test
    void displayCampsForName() {

        Mockito.when(camp.getName()).thenReturn("IOS Camp");

        List<Camp> camps = new ArrayList<>(1);
        camps.add(camp);
        Mockito.when(campData.searchCamps("IOS camp",null)).thenReturn(camps);

        ResponseEntity<List<Camp>> responseEntity = campController.displayCamps("IOS camp", null);
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        assertEquals(1, responseEntity.getBody().size());
        assertEquals("IOS Camp", responseEntity.getBody().get(0).getName());
    }

    @Test
    void displayViewId() {
    }
}
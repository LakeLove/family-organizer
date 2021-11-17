package io.github.lakelove.familyorganizer.controller;
import io.github.lakelove.familyorganizer.entities.BasicInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

@SpringBootTest
class FamilyOrganizerControllerTest {

	private BasicInfo basicInfo;

	@MockBean
	private FamilyOrganizerController familyOrganizerController;

	@BeforeEach
	void setUp() {
		basicInfo = BasicInfo.builder().id(1L).firstName("Beyoncé").middleName("Giselle").lastName("Knowles").build();
	}

	@Test
	void getFamilyMember() {
	}

	@Test
	void saveFamilyMember() {
		ResponseEntity<BasicInfo> expected = new ResponseEntity<>(CREATED);
		when(familyOrganizerController.saveFamilyMember(basicInfo)).thenReturn(expected);
		ResponseEntity<BasicInfo> actual = familyOrganizerController.saveFamilyMember(basicInfo);
		assertEquals(expected, actual); verify(familyOrganizerController, atMostOnce()).saveFamilyMember(basicInfo);
		verifyNoMoreInteractions(familyOrganizerController);
	}

	@Test
	void updateFamilyMember() {
	}

}
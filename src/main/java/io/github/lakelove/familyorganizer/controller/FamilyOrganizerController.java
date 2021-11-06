package io.github.lakelove.familyorganizer.controller;

import io.github.lakelove.familyorganizer.entities.BasicInfo;
import io.github.lakelove.familyorganizer.service.FamilyOrganizerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api")
public class FamilyOrganizerController {

@Autowired
FamilyOrganizerService familyOrganizerService;

	@PostMapping("/member/save")
	ResponseEntity<BasicInfo> saveFamilyMember(@RequestBody BasicInfo basicInfo) {
		return familyOrganizerService.saveMember(basicInfo);
	}

	@PutMapping("/member/edit")
	ResponseEntity<BasicInfo> updateFamilyMember(@RequestBody BasicInfo basicInfo) {
		return familyOrganizerService.updateMember(basicInfo);
	}

}
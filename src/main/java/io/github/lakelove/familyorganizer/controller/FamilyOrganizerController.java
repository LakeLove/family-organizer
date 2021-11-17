package io.github.lakelove.familyorganizer.controller;

import io.github.lakelove.familyorganizer.entities.BasicInfo;
import io.github.lakelove.familyorganizer.service.FamilyOrganizerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api")
public class FamilyOrganizerController {

	@Autowired
	FamilyOrganizerService familyOrganizerService;

	@GetMapping("/member")
	@ResponseStatus(OK)
	ResponseEntity<BasicInfo[]> getFamilyMember(@RequestParam String firstName,	@RequestParam String lastName) {
		return familyOrganizerService.findMembers(firstName, lastName);
	}

	@PostMapping("/member/save")
	@ResponseStatus(CREATED)
	ResponseEntity<BasicInfo> saveFamilyMember(@RequestBody BasicInfo basicInfo) {
		return familyOrganizerService.saveMember(basicInfo);
	}

	@PutMapping("/member/edit")
	@ResponseStatus(OK)
	ResponseEntity<BasicInfo> updateFamilyMember(@RequestBody BasicInfo basicInfo) {
		return familyOrganizerService.updateMember(basicInfo);
	}

}
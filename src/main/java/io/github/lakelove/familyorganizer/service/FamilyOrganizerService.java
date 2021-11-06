package io.github.lakelove.familyorganizer.service;
import io.github.lakelove.familyorganizer.entities.BasicInfo;
import io.github.lakelove.familyorganizer.repository.FamilyOrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FamilyOrganizerService {

	@Autowired
	FamilyOrganizerRepository familyOrganizerRepository;

	public ResponseEntity<BasicInfo> saveMember(BasicInfo basicInfo) {
		familyOrganizerRepository.save(basicInfo);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	public ResponseEntity<BasicInfo> updateMember(BasicInfo basicInfo) {
		return null;
	}
}
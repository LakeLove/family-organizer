package io.github.lakelove.familyorganizer.service;
import io.github.lakelove.familyorganizer.repository.FamilyOrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyOrganizerService {

	@Autowired
	FamilyOrganizerRepository familyOrganizerRepository;

}
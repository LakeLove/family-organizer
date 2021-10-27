package io.github.lakelove.familyorganizer.repository;
import io.github.lakelove.familyorganizer.entities.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyOrganizerRepository extends JpaRepository<BasicInfo, Long> {

}
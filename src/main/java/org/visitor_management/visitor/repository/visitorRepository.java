package org.visitor_management.visitor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visitor_management.visitor.dto.visitor;

public interface visitorRepository extends JpaRepository<visitor, Integer> {

    boolean existsByslno(int slno);

    Optional<visitor> findByName(String name);

    List<visitor> findByDate(String date);

}

package org.visitor_management.visitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visitor_management.visitor.dto.visitor;

public interface visitorRepository extends JpaRepository<visitor, Integer> {

    boolean existsByslno(int slno);

}

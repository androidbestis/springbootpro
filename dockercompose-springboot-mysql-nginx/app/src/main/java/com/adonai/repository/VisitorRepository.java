package com.adonai.repository;

import com.adonai.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor,Long> {

    Visitor findByIp(String ip);
}

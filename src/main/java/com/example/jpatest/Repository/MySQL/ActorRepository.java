package com.example.jpatest.Repository.MySQL;

import com.example.jpatest.Entity.MySQL.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}

package com.clash.guide.repositories;

import com.clash.guide.domain.Troop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TroopRepository extends MongoRepository<Troop, String> { }

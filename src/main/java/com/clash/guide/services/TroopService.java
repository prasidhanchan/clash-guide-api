package com.clash.guide.services;

import com.clash.guide.domain.Troop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface TroopService {

    void addTroop(Troop troop);

    Page<Troop> getAllTroops(Pageable pageable);

    void updateTroop(Troop troop);

    void deleteTroop(String _id);

    Boolean isExits(String _id);
}

package com.clash.guide.services.impl;

import com.clash.guide.domain.Troop;
import com.clash.guide.repositories.TroopRepository;
import com.clash.guide.services.TroopService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TroopServiceImpl implements TroopService {

    private final TroopRepository troopRepository;

    private TroopServiceImpl(final TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    /**
     * Function to add a Troop.
     *
     * @param troop Actual Troop to be added to database.
     */
    @Override
    public void addTroop(Troop troop) {
        troopRepository.save(troop);
    }

    /**
     * Function to get all Troop.
     *
     * @param pageable Requires to get all troops as a Page.
     * @return Returns a all Troops.
     */
    @Override
    public Page<Troop> getAllTroops(Pageable pageable) {
        return troopRepository.findAll(pageable);
    }

    /**
     * Function to update a Troop.
     *
     * @param troop Actual Troop to be updated.
     */
    @Override
    public void updateTroop(Troop troop) {
        troopRepository.findById(troop.get_id()).map(
                        existingTroop -> {
                            Optional.ofNullable(troop.getName()).ifPresent(existingTroop::setName);
                            Optional.ofNullable(troop.getDescription()).ifPresent(existingTroop::setDescription);
                            Optional.ofNullable(troop.getImage()).ifPresent(existingTroop::setImage);
                            Optional.ofNullable(troop.getColor()).ifPresent(existingTroop::setColor);
                            Optional.ofNullable(troop.getIsSuperTroop()).ifPresent(existingTroop::setIsSuperTroop);

                            return troopRepository.save(existingTroop);
                        }
                )
                .orElseThrow(() -> new RuntimeException("Troop not found!"));
    }

    /**
     * Function to remove a Troop.
     *
     * @param _id The ID of the troop to be removed.
     */
    @Override
    public void deleteTroop(String _id) {
        troopRepository.deleteById(_id);
    }

    /**
     * Function to remove all Troops.
     */
    @Override
    public void deleteAllTroop() {
        troopRepository.deleteAll();
    }

    /**
     * Function to check if a Troop exists.
     *
     * @param _id Requires a Troop ID to be searched.
     * @return Returns true if the troop exists.
     */
    @Override
    public Boolean isExits(String _id) {
        return troopRepository.findById(_id).isPresent();
    }
}

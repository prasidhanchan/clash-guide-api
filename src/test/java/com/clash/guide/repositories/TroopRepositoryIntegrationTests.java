package com.clash.guide.repositories;

import com.clash.guide.TestUtils;
import com.clash.guide.domain.Troop;
import com.clash.guide.services.TroopService;
import com.clash.guide.services.impl.TroopServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TroopRepositoryIntegrationTests {

    private final TroopService troopService;
    private final TroopRepository troopRepository;

    @Autowired
    private TroopRepositoryIntegrationTests(
            final TroopServiceImpl troopService,
            final TroopRepository troopRepository
    ) {
        this.troopService = troopService;
        this.troopRepository = troopRepository;
    }

    @Test
    public void testAddTroop() {
        troopRepository.deleteAll();

        Troop troop = TestUtils.createTroopA();
        troopService.addTroop(troop); // Add
        List<Troop> troops = troopRepository.findAll();
        assertThat(troops).contains(troop);
    }

    @Test
    public void testGetAllPokemon() {
        troopRepository.deleteAll();

        Troop troopA = TestUtils.createTroopA();
        Troop troopB = TestUtils.createTroopB();
        troopService.addTroop(troopA);
        troopService.addTroop(troopB);
        List<Troop> troops = troopRepository.findAll();
        assertThat(troops).containsExactly(troopA, troopB);
    }

    @Test
    public void testUpdateTroop() {
        troopRepository.deleteAll();

        Troop troop = TestUtils.createTroopA();
        troopService.addTroop(troop);
        Troop troopNew = TestUtils.createTroopAUpdated();
        troopService.updateTroop(troopNew);
        List<Troop> troops = troopRepository.findAll();
        assertThat(troops).doesNotContain(troop).contains(troopNew);
    }

    @Test
    public void testDeleteTroop() {
        troopRepository.deleteAll();

        Troop troop = TestUtils.createTroopA();
        troopService.addTroop(troop);
        troopService.deleteTroop(troop.get_id());
        List<Troop> troops = troopRepository.findAll();
        assertThat(troops).doesNotContain(troop);
    }

    @Test
    public void testDeleteAllTroops() {
        Troop troopA = TestUtils.createTroopA();
        Troop troopB = TestUtils.createTroopB();
        troopService.addTroop(troopA);
        troopService.addTroop(troopB);
        troopService.deleteAllTroop();
        List<Troop> troops = troopRepository.findAll();
        assertThat(troops).isEmpty();
    }

    @Test
    public void testIsExists() {
        troopRepository.deleteAll();

        Troop troop = TestUtils.createTroopA();
        troopService.addTroop(troop);
        Boolean isExists = troopService.isExits(troop.get_id());
        assertThat(isExists).isTrue();

        troopService.deleteTroop(troop.get_id());
        Boolean isDoesNotExists = troopService.isExits(troop.get_id());
        assertThat(isDoesNotExists).isFalse();
    }
}

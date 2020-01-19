package pl.bolo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.bolo.domain.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}

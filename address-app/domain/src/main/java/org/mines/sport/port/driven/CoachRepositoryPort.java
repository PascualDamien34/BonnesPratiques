package org.mines.sport.port.driven;

import org.mines.address.domain.model.Town;
import org.mines.sport.domain.model.Coach;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface CoachRepositoryPort {

    Optional<Coach> select(UUID uuid);
    Coach insert(Coach coach);
    Coach update(Coach coach);
    Collection<Coach> selectAll();

}

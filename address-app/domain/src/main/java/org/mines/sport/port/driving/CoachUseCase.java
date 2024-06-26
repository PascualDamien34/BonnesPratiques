package org.mines.sport.port.driving;

import org.mines.sport.domain.model.Coach;
import org.mines.sport.domain.model.Sport;

import java.util.Collection;
import java.util.UUID;

public interface CoachUseCase {

    Coach save(Coach coach);

    Collection<Sport> getSportDoingByCoach(UUID id);
}

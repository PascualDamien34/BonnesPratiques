package org.mines.sport.port.driving;

import org.mines.sport.domain.model.Sport;

import java.util.Collection;

public interface SportsUseCase {
    Sport save(Sport sport);

    Collection<Sport> getSportsByContactOrNot(boolean contactSport);

    Collection<Sport> getSportsByTeamOrNot(boolean teamSport);
}

package org.mines.sport.domain.service;

import org.mines.sport.domain.model.Coach;
import org.mines.sport.domain.model.Sport;
import org.mines.sport.port.driving.CoachUseCase;

import java.util.Collection;

public class CoachService implements CoachUseCase {
    @Override
    public Coach save(Coach coach) {
        return null;
    }

    @Override
    public Collection<Sport> getSportDoingByCoach(Coach coach) {
        return null;
    }
}

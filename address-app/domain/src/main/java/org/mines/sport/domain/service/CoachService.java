package org.mines.sport.domain.service;

import org.mines.sport.domain.model.Coach;
import org.mines.sport.domain.model.Sport;
import org.mines.sport.port.driven.CoachRepositoryPort;
import org.mines.sport.port.driving.CoachUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class CoachService implements CoachUseCase {

    @Autowired
    private CoachRepositoryPort coachRepositoryPort;

    public CoachService(CoachRepositoryPort coachRepositoryPort) {
        this.coachRepositoryPort = coachRepositoryPort;
    }

    @Override
    public Coach save(Coach coach) {
        if (coach.getIndividual() == null || coach.getIndividual().getName().isEmpty() || coach.getCoachingSport().isEmpty())
        {
            throw new IllegalArgumentException("Coach name and coached sport are required");
        }

        if (coachRepositoryPort
                .selectAll()
                .stream()
                .anyMatch(coach1 -> isSameCoach(coach, coach1))
        ) {
            throw new IllegalArgumentException("Coach already exists");
        }

        if (coach.getUuid() == null) {
            return coachRepositoryPort.insert(coach);
        } else {
            return coachRepositoryPort.update(coach);
        }
    }

    private boolean isSameCoach(Coach coach, Coach coach1) {
        return coach1.getIndividual().getName().equalsIgnoreCase(coach.getIndividual().getName()) && coach1.getUuid() != coach.getUuid();
    }

    @Override
    public Collection<Sport> getSportDoingByCoach(UUID id) {
        Optional<List<Sport>> sports = coachRepositoryPort
                .select(id)
                .map(coach -> coach.getIndividual().getPracticateSports());

        return sports.orElse(List.of());
    }
}

package org.mines.sport.domain.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mines.address.domain.model.Town;
import org.mines.sport.domain.model.Person;
import org.mines.sport.domain.model.Coach;
import org.mines.sport.domain.model.Sport;
import org.mines.sport.port.driven.CoachRepositoryPort;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoachServiceTest {

    @Mock
    private CoachRepositoryPort coachRepositoryPort;
    @InjectMocks
    private CoachService coachService = new CoachService(coachRepositoryPort);

    @Test
    void shouldSaveACoach() {
        // GIVEN
        List<Sport> coachingSports = new ArrayList<>();
        coachingSports.add(Sport.SportBuilder.aSports().withNameSport("Handball").withContactSport(true).withTeamsSport(true).build());
        Coach coach = Coach.CoachBuilder.aCoach().withIndividual(Person.PersonBuilder.aPerson().withName("Jean").build()).withCoachingSport(coachingSports).build();

        UUID id = UUID.randomUUID();
        when(coachRepositoryPort.insert(any())).thenReturn(
                Coach.CoachBuilder.aCoach().withUuid(id).build()
        );

        // WHEN
        Coach saved = coachService.save(coach);

        // THEN
        assertEquals(id, (saved.getUuid()));
    }

    @Test
    void shouldNotSaveCoachWithEmptyPerson(){
        // GIVEN
        List<Sport> coachingSports = new ArrayList<>();
        coachingSports.add(Sport.SportBuilder.aSports().withNameSport("Handball").withContactSport(true).withTeamsSport(true).build());
        Coach coach = Coach.CoachBuilder.aCoach().withIndividual(null).withCoachingSport(coachingSports).build();

        // WHEN
        assertThrows(IllegalArgumentException.class, () -> coachService.save(coach));

        verify(coachRepositoryPort, never()).insert(any());
    }

    @Test
    void shouldNotSaveCoachWithEmptyNamePerson(){
        // GIVEN
        List<Sport> coachingSports = new ArrayList<>();
        coachingSports.add(Sport.SportBuilder.aSports().withNameSport("Handball").withContactSport(true).withTeamsSport(true).build());
        Coach coach = Coach.CoachBuilder.aCoach().withIndividual(Person.PersonBuilder.aPerson().withName("").build()).withCoachingSport(coachingSports).build();

        // WHEN
        assertThrows(IllegalArgumentException.class, () -> coachService.save(coach));
    }

    @Test
    void shouldGetSportDoingByCoach() {
        List<Sport> practiceSports = new ArrayList<>();
        practiceSports.add(Sport.SportBuilder.aSports().withNameSport("Handball").withContactSport(true).withTeamsSport(true).build());

        when(coachRepositoryPort.select(any())).thenReturn(

                Optional.of(Coach.CoachBuilder.aCoach()
                        .withIndividual(Person.PersonBuilder.aPerson().withPracticateSports(practiceSports).build())
                        .build())
        );

        Collection<Sport> sportDoingByCoach = coachService.getSportDoingByCoach(UUID.randomUUID());

        assertEquals(practiceSports, sportDoingByCoach);
    }
}
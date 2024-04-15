package org.mines.sport.domain.model;

import java.util.List;
import java.util.UUID;

public class Coach {

    private UUID uuid;
    private Person individual;
    private List<Sport> coachingSport;

    public Person getIndividual() {
        return individual;
    }

    public List<Sport> getCoachingSport() {
        return coachingSport;
    }

    public UUID getUuid() {
        return uuid;
    }

    public static final class CoachBuilder {
        private UUID uuid;
        private Person individual;
        private List<Sport> coachingSport;

        private CoachBuilder() {
        }

        public static CoachBuilder aCoach() {
            return new CoachBuilder();
        }

        public CoachBuilder withUuid(UUID uuid) {
            this.uuid = uuid;
            return this;
        }

        public CoachBuilder withIndividual(Person individual) {
            this.individual = individual;
            return this;
        }

        public CoachBuilder withCoachingSport(List<Sport> coachingSport) {
            this.coachingSport = coachingSport;
            return this;
        }

        public Coach build() {
            Coach coach = new Coach();
            coach.coachingSport = this.coachingSport;
            coach.individual = this.individual;
            coach.uuid = this.uuid;
            return coach;
        }
    }
}

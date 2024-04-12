package org.mines.sport.domain.model;

import java.util.List;

public class Coach {
    private Person individual;
    private List<Sports> coachingSport;

    public static final class CoachBuilder {
        private Person individual;
        private List<Sports> coachingSport;

        private CoachBuilder() {
        }

        public static CoachBuilder aCoach() {
            return new CoachBuilder();
        }

        public CoachBuilder withIndividual(Person individual) {
            this.individual = individual;
            return this;
        }

        public CoachBuilder withCoachingSport(List<Sports> coachingSport) {
            this.coachingSport = coachingSport;
            return this;
        }

        public Coach build() {
            Coach coach = new Coach();
            coach.coachingSport = this.coachingSport;
            coach.individual = this.individual;
            return coach;
        }
    }
}

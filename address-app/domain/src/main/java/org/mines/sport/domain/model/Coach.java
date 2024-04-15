package org.mines.sport.domain.model;

import java.util.List;

public class Coach {
    private Person individual;
    private List<Sport> coachingSport;

    public static final class CoachBuilder {
        private Person individual;
        private List<Sport> coachingSport;

        private CoachBuilder() {
        }

        public static CoachBuilder aCoach() {
            return new CoachBuilder();
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
            return coach;
        }
    }
}

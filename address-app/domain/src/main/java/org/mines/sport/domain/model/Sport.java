package org.mines.sport.domain.model;

public class Sport {

    private String nameSport;
    private boolean teamsSport;
    private boolean contactSport;
    public static final class SportBuilder {
        private String nameSport;
        private boolean teamsSport;
        private boolean contactSport;

        private SportBuilder() {
        }

        public static SportBuilder aSports() {
            return new SportBuilder();
        }

        public SportBuilder withNameSport(String nameSport) {
            this.nameSport = nameSport;
            return this;
        }

        public SportBuilder withTeamsSport(boolean teamsSport) {
            this.teamsSport = teamsSport;
            return this;
        }

        public SportBuilder withContactSport(boolean contactSport) {
            this.contactSport = contactSport;
            return this;
        }

        public Sport build() {
            Sport sport = new Sport();
            sport.contactSport = this.contactSport;
            sport.teamsSport = this.teamsSport;
            sport.nameSport = this.nameSport;
            return sport;
        }
    }
}

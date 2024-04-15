package org.mines.sport.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class Course {
    private Coach coach;
    private Sport sport;
    private LocalDateTime dateTime;
    private List<Person> participants;

    public static final class CourseBuilder {
        private Coach coach;
        private Sport sport;
        private LocalDateTime dateTime;
        private List<Person> participants;

        private CourseBuilder() {
        }

        public static CourseBuilder aCourse() {
            return new CourseBuilder();
        }

        public CourseBuilder withCoach(Coach coach) {
            this.coach = coach;
            return this;
        }

        public CourseBuilder withSport(Sport sport) {
            this.sport = sport;
            return this;
        }

        public CourseBuilder withDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public CourseBuilder withParticipants(List<Person> participants) {
            this.participants = participants;
            return this;
        }

        public Course build() {
            Course course = new Course();
            course.participants = this.participants;
            course.sport = this.sport;
            course.dateTime = this.dateTime;
            course.coach = this.coach;
            return course;
        }
    }
}

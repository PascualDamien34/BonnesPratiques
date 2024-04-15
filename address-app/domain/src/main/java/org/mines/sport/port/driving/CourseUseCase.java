package org.mines.sport.port.driving;

import org.mines.sport.domain.model.Coach;
import org.mines.sport.domain.model.Course;
import org.mines.sport.domain.model.Person;
import org.mines.sport.domain.model.Sport;

import java.time.LocalDateTime;
import java.util.Collection;

public interface CourseUseCase {

    Course save(Course course);

    Collection<Person> getPersonsWhichDoSportWithCoachBetweenDates(Sport sport, Coach coach, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);

}

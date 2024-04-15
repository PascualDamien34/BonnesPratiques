package org.mines.sport.port.driving;

import org.mines.sport.domain.model.Person;

import java.util.Collection;

public interface PersonUseCase {

    Person save(Person person);

    Collection<Person> getPersonsBySize(float minSize, float maxSize);
    Collection<Person> getPersonsByWeight(float minWeight, float maxWeight);
}

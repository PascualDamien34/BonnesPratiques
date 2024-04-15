package org.mines.sport.domain.model;

import java.util.List;

public class Person {

    private String name;
    private float weight;
    private float tall;
    private List<Sport> practicateSports;

    public static final class PersonBuilder {
        private String name;
        private float weight;
        private float tall;
        private List<Sport> practicateSports;

        private PersonBuilder() {
        }

        public static PersonBuilder aPerson() {
            return new PersonBuilder();
        }

        public PersonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder withWeight(float weight) {
            this.weight = weight;
            return this;
        }

        public PersonBuilder withTall(float tall) {
            this.tall = tall;
            return this;
        }

        public PersonBuilder withPracticateSports(List<Sport> practicateSports) {
            this.practicateSports = practicateSports;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.practicateSports = this.practicateSports;
            person.name = this.name;
            person.tall = this.tall;
            person.weight = this.weight;
            return person;
        }
    }
}

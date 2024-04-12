package org.mines.sport.domain.model;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.List;

public class Course {
    private Coach coach;
    private Sports sport;
    private LocalDateTime dateTime;
    private List<Person> participants;
}

package dto;

import lombok.Data;

@Data
public class Student {
    private final int id;
    private final long gpa;
    private final String name;
}

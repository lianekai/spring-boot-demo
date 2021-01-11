package com.lianekai.hashset;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Student {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
       o=(Student)o;
        return ((Student) o).id == this.id && ((Student) o).name == this.name;

    }

    @Override
    public int hashCode() {
        return id;
    }
}

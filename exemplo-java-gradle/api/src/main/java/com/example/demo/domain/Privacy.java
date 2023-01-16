package com.example.demo.domain;

public enum Privacy {
    PUBLIC, SUBJECT_TEACHERS, CLASSMATES, STUDENTS, TEACHERS;

    //Todo: refactor method
    public boolean isVisibleToUser() {
        return false;
    }

}

package com.webischia.LibraryAutomationBackend.Domains;

import lombok.Data;

@Data
public class Subject {
    int subjectID;
    String subjectName;

    public Subject(int subjectID, String subjectName) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
    }
}

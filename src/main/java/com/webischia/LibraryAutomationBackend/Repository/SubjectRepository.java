package com.webischia.LibraryAutomationBackend.Repository;

import com.webischia.LibraryAutomationBackend.Domains.ItemType;
import com.webischia.LibraryAutomationBackend.Domains.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Subject addSubject(Subject subject) {

        jdbcTemplate.execute("INSERT INTO FAHRI2.SUBJECT(subjectName) VALUES('"+subject.getSubjectName()+"')");
        return jdbcTemplate.queryForObject("select subjectID,subjectName from FAHRI2.SUBJECT where subjectName ='"+subject.getSubjectName()+"'",
                (rs,rowNum) ->new Subject(rs.getInt("subjectID"),rs.getString("subjectName")));
    }


    public Subject updateSubject(Subject subject, int id) {
        jdbcTemplate.execute("UPDATE FAHRI2.SUBJECT SET subjectName='"+subject.getSubjectName()+"' WHERE subjectID= "+id);
        return getSubject(id);
    }


    public void deleteSubject(int id) {
        jdbcTemplate.execute("DELETE FROM FAHRI2.SUBJECT WHERE subjectID= "+id);
    }

    public Subject getSubject(int id) {
        return jdbcTemplate.queryForObject("select subjectID,subjectName from FAHRI2.SUBJECT where subjectID= "+id,
                (rs,rowNum) ->new Subject(rs.getInt("subjectID"),rs.getString("subjectName")));
    }

    public List<Subject> getAllSubjects() {
        List<Subject> tmp = jdbcTemplate.query("select subjectID,subjectName from FAHRI2.SUBJECT ORDER BY subjectID ",
                (rs,rowNum) ->new Subject(rs.getInt("subjectID"),rs.getString("subjectName")));
        return tmp;
    }
}

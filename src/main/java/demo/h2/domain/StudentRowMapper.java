package demo.h2.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setUsername(rs.getString(FieldType.USERNAME.getValue()));
        student.setPassword(rs.getString(FieldType.PASSWORD.getValue()));
        student.setFirstname(rs.getString(FieldType.FIRSTNAME.getValue()));
        student.setLastname(rs.getString(FieldType.LASTNAME.getValue()));
        student.setEmail(rs.getString(FieldType.EMAIL.getValue()));
        return student;
    }


}
package demo.h2.dao;

import demo.h2.domain.FieldType;
import demo.h2.domain.Student;
import demo.h2.domain.StudentRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {


    private static final Logger LOG = LoggerFactory.getLogger(StudentRepository.class);
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Student getUser(String username) {
        try {
            String query = "SELECT username, password, firstname, lastname, email FROM students WHERE username = :username";
            MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue(FieldType.USERNAME.getValue(), username);
            return namedParameterJdbcTemplate.queryForObject(query, mapSqlParameterSource, new StudentRowMapper());
        } catch (Exception ex) {
            LOG.error("Exception in getUser() ", ex);
            return null;
        }
    }

    public void updateUser(Student student) {
        String query = "UPDATE students SET firstname = :firstname, lastname = :lastname, email = :email, password = :password WHERE username = :username";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(FieldType.FIRSTNAME.getValue(), student.getFirstname());
        mapSqlParameterSource.addValue(FieldType.LASTNAME.getValue(), student.getLastname());
        mapSqlParameterSource.addValue(FieldType.EMAIL.getValue(), student.getEmail());
        mapSqlParameterSource.addValue(FieldType.PASSWORD.getValue(), student.getPassword());
        mapSqlParameterSource.addValue(FieldType.USERNAME.getValue(), student.getUsername());
        namedParameterJdbcTemplate.update(query, mapSqlParameterSource);
    }

    public void registerUser(Student student) {
        String query = "INSERT INTO students (username, password, firstname, lastname, email) VALUES (:username, :password, :firstname, :lastname, :email)";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(FieldType.USERNAME.getValue(), student.getUsername());
        mapSqlParameterSource.addValue(FieldType.PASSWORD.getValue(), student.getPassword());
        mapSqlParameterSource.addValue(FieldType.FIRSTNAME.getValue(), student.getFirstname());
        mapSqlParameterSource.addValue(FieldType.LASTNAME.getValue(), student.getLastname());
        mapSqlParameterSource.addValue(FieldType.EMAIL.getValue(), student.getEmail());
        namedParameterJdbcTemplate.update(query, mapSqlParameterSource);
    }

    public void deleteUser(String username) {
        String query = "DELETE FROM students WHERE username = :username";
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue(FieldType.USERNAME.getValue(), username);
        namedParameterJdbcTemplate.update(query, mapSqlParameterSource);
    }
}


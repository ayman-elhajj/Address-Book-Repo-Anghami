package com.example.addressbook.dao;

import com.example.addressbook.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        String sql = "INSERT INTO person (id, name, phone, address) "
                + "VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, new Object[] { UUID.randomUUID(),
                person.getName(), person.getPhone(), person.getAddress()});
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name, phone, address FROM person;";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");
            return new Person(id, name, phone, address);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name FROM person WHERE id = ?;";

        Person person = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    UUID personId = UUID.fromString(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone");
                    String address = resultSet.getString("address");
                    return new Person(personId, name, phone, address);
        });
        return Optional.ofNullable(person); //if no match found
    }

    @Override
    public int deletePersonById(UUID id) {
        final String sql = "DELETE FROM person WHERE id=?;";
        jdbcTemplate.update(sql, new Object[] {id});
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        final String sql = "UPDATE person SET name=?, phone=?, address=? WHERE id=?;";
        jdbcTemplate.update(sql, new Object[] {
                person.getName(), person.getPhone(), person.getAddress(), id});
        return 1;
    }
}

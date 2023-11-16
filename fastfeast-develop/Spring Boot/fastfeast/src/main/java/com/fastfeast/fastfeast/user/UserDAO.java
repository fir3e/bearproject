package com.fastfeast.fastfeast.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class UserDAO extends JdbcDaoSupport {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO user(id, name, username, password, email, birthdate, role) VALUES (?, ?, ?, ?, ?, ?, ?)";

        // generating ID higher than the biggest present in the database
        String getHighestId = "SELECT MAX(id) FROM user"; // getting highest ID
        List<Map<String, Object>> highestId = getJdbcTemplate().queryForList(getHighestId);
        List<User> result = new ArrayList<User>();

        getJdbcTemplate().update(sql, new Object[] {
                user.getName(),
                user.getUserName(),
                passwordEncoder.encode(user.getPassword()),
                user.getEmail(),
                user.getBirthDate(),
                user.getRole()
        });
    }

    public User getUserById(int id) {
        String sql = "SELECT * FROM user WHERE id=?";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, id);

        List<User> result = new ArrayList<User>();
        for (Map<String, Object> row : rows) {
            User user = new User();
            user.setId((Integer) row.get("id"));
            user.setName((String) row.get("name"));
            user.setUserName((String) row.get("username"));
            user.setEmail((String) row.get("email"));
            user.setPassword((String) row.get("password"));
            user.setBirthDate((Integer) row.get("birthdate"));
            // user.setRole((String) row.get("role"));
            result.add(user);
        }

        return result.get(0);
    }

    public User getUserByName(String name) {
        String sql = "SELECT * FROM user WHERE name=?";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, name);

        List<User> result = new ArrayList<User>();
        for (Map<String, Object> row : rows) {
            User user = new User();
            user.setId((Integer) row.get("id"));
            user.setName((String) row.get("name"));
            user.setUserName((String) row.get("username"));
            user.setEmail((String) row.get("email"));
            user.setPassword((String) row.get("password"));
            user.setBirthDate((Integer) row.get("birthdate"));
            // user.setRole((String) row.get("role"));
            result.add(user);
        }

        return result.get(0);
    }

    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM user WHERE username=?";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, username);

        List<User> result = new ArrayList<User>();
        for (Map<String, Object> row : rows) {
            User user = new User();
            user.setId((Integer) row.get("id"));
            user.setName((String) row.get("name"));
            user.setUserName((String) row.get("username"));
            user.setEmail((String) row.get("email"));
            user.setPassword((String) row.get("password"));
            user.setBirthDate((Integer) row.get("birthdate"));
            // user.setRole((String) row.get("role"));
            result.add(user);
        }

        return result.get(0);
    }

    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email=?";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, email);

        List<User> result = new ArrayList<User>();
        for (Map<String, Object> row : rows) {
            User user = new User();
            user.setId((Integer) row.get("id"));
            user.setName((String) row.get("name"));
            user.setUserName((String) row.get("username"));
            user.setEmail((String) row.get("email"));
            user.setPassword((String) row.get("password"));
            user.setBirthDate((Integer) row.get("birthdate"));
            // user.setRole((String) row.get("role"));
            result.add(user);
        }

        return result.get(0);
    }

    public List<User> listUsers() {
        String sql = "SELECT * FROM user";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<User> result = new ArrayList<User>();
        for (Map<String, Object> row : rows) {
            User user = new User();
            user.setId((Integer) row.get("id"));
            System.out.println(user.getId());
            user.setName((String) row.get("name"));
            user.setUserName((String) row.get("username"));
            user.setEmail((String) row.get("email"));
            user.setBirthDate((Integer) row.get("birth_date"));
            // user.setRole((String) row.get("role"));

            result.add(user);
        }

        return result;
    }

}

package com.rxhms.hearify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDatabaseConnection() {
        // Test si la JdbcTemplate est bien injectée et la connexion est active
        assertNotNull(jdbcTemplate);
        Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        assertNotNull(result, "La connexion à la base de données a échoué");
    }
}

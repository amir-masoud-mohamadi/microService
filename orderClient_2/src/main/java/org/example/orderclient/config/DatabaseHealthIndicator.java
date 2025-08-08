package org.example.orderclient.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseHealthIndicator implements HealthIndicator {

    private final DataSource dataSource;

    public DatabaseHealthIndicator(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Health health() {
        try (Connection connection = dataSource.getConnection()) {
            if (connection.isValid(1000)) {
                return Health.up()
                        .withDetail("message", "اتصال به دیتابیس فعال است")
                        .build();
            }
        } catch (SQLException e) {
            return Health.down()
                    .withDetail("error", "خطا در اتصال به دیتابیس: " + e.getMessage())
                    .build();
        }
        return Health.unknown().build();
    }
}

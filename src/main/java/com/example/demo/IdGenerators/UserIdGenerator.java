package com.example.demo.IdGenerators;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.annotations.Parameter;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UserIdGenerator implements IdentifierGenerator, Configurable {
    private static final String PREFIX = "User_";
   
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        
        final String[] id = {""};
        session.doWork(connection -> {
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery("SELECT COUNT(id) + 1 FROM userdata");
                if (rs.next()) {
                    id[0] = PREFIX + rs.getInt(1);
                }
            } catch (SQLException e) {
                throw new RuntimeException("Failed to generate ID", e);
            }
        });

        return id[0];
    }
}

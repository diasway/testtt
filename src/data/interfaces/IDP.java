package data.interfaces;

import java.sql.Connection;

public interface IDP {
    Connection getConnection();
    void close();
}

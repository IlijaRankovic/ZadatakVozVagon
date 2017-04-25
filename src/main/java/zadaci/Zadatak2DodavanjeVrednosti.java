package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class Zadatak2DodavanjeVrednosti {
    public static void main(String[] args) {
        ConnectionSource conn = null;

        try {
            conn = new JdbcConnectionSource("jdbc:sqlite:vozVagon.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

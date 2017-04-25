package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Vagon;
import model.Voz;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class Zadatak1KreiranjeTabela {
    public static void main(String[] args) {
        ConnectionSource conn = null;

        try {
            conn = new JdbcConnectionSource("jdbc:sqlite:vozVagon.db");

            TableUtils.dropTable(conn, Vagon.class, true);
            TableUtils.dropTable(conn, Voz.class, true);

            TableUtils.createTable(conn, Voz.class);
            TableUtils.createTable(conn, Vagon.class);

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

package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Vagon;
import model.Voz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class Zadatak4BrisanjeVrednosti {
    static Dao<Voz,Integer> vozDao;
    static Dao<Vagon,Integer> vagonDao;

    public static void main(String[] args) {
        ConnectionSource conn = null;

        try {
            conn = new JdbcConnectionSource("jdbc:sqlite:vozVagon.db");

            vozDao = DaoManager.createDao(conn, Voz.class);
            vagonDao = DaoManager.createDao(conn, Vagon.class);

            List<Vagon> vagon = vagonDao.queryForAll();
            for(Vagon v:vagon)
                System.out.println("Vagon = " + v);

            List<Vagon> pronadjenVagon=vagonDao.queryForEq(Vagon.POLJE_NOSIVOST, 10);
            Vagon zaBrisanje= pronadjenVagon.get(0);
            vagonDao.delete(zaBrisanje);

            vagon = vagonDao.queryForAll();
            for(Vagon v:vagon)
                System.out.println("Vagon = " + v);
            
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

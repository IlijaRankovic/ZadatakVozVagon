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
public class Zadatak2DodavanjeVrednosti {
    static Dao<Voz,Integer> vozDao;
    static Dao<Vagon,Integer> vagonDao;

    public static void main(String[] args) {
        ConnectionSource conn = null;

        try {
            conn = new JdbcConnectionSource("jdbc:sqlite:vozVagon.db");

            vozDao = DaoManager.createDao(conn, Voz.class);
            vagonDao = DaoManager.createDao(conn, Vagon.class);

            Voz v1 = new Voz("Voz1", "Dizel");
            vozDao.create(v1);
            Voz v2 = new Voz("Voz2", "Elektricni");
            vozDao.create(v2);

            Vagon va1 = new Vagon("Vagon1", "Za prenos goriva", 10);
            va1.setVoz(v1);
            vagonDao.create(va1);
            Vagon va2 = new Vagon("Vagon2", "Za prenos toksicnih materija", 5);
            va2.setVoz(v1);
            vagonDao.create(va2);
            Vagon va3 = new Vagon("Vagon3", "Za prenos psenice", 20);
            va3.setVoz(v1);
            vagonDao.create(va3);
            Vagon va4 = new Vagon("Vagon4", "Za spavanje", 5);
            va4.setVoz(v2);
            vagonDao.create(va4);
            Vagon va5 = new Vagon("Vagon5", "Restoran", 3);
            va5.setVoz(v2);
            vagonDao.create(va5);

            List<Vagon> vagon = vagonDao.queryForAll();
            for(Vagon v:vagon)
                System.out.println("Vagon = " + v);

            List<Voz> voz = vozDao.queryForAll();
            for(Voz v:voz)
                System.out.println("Voz = " + v);

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

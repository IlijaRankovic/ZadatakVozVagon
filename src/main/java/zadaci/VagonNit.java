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
public class VagonNit extends Thread {

    static Dao<Voz,Integer> vozDao;
    static Dao<Vagon,Integer> vagonDao;

    private Vagon vagon;
    private String oznaka;

    public VagonNit(Vagon vagon, String oznaka){
        this.vagon = vagon;
        this.oznaka = oznaka;
    }

        public void run()
        {
            do {
                synchronized (vagon)
                {
                    if (vagon.getTeret() < vagon.getNosivost())
                    {

                    }
                }
                try
                {
                    this.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }while (vagon.getTeret() < vagon.getNosivost());

        }

    public static void main(String[] args) {

        ConnectionSource conn = null;

        try {
            conn = new JdbcConnectionSource ("jdbc:sqlite:vozVagon.db");

            vozDao = DaoManager.createDao(conn, Voz.class);
            vagonDao = DaoManager.createDao(conn, Vagon.class);


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

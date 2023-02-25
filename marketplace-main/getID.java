package Market;

import java.sql.ResultSet;
import java.sql.SQLException;
import Singleton.*;

public class getID {
    static DatabaseSingleton db = DatabaseSingleton.getInstance();
    public static int giveID(String name) throws SQLException {
        int id = 0;
        db.connect();
        String query = "select id from users where name ='"+name+"'";
        ResultSet r = db.result(query);
        if(r.next()){
            id = r.getInt("id");
        }
        return id;
    }
}

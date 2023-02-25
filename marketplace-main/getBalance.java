package Market;
import java.sql.ResultSet;
import java.sql.SQLException;
import Singleton.*;
public class getBalance {
    static DatabaseSingleton db = DatabaseSingleton.getInstance();
    public static int giveBalance(int id) throws SQLException {
        int balance = 0;
        db.connect();
        String query = "select balance from users where id ='"+id+"'";
        ResultSet r = db.result(query);
        if(r.next()){
            balance = r.getInt("balance");
        }
        return balance;
    }
}

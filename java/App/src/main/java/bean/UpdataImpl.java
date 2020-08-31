package bean;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdataImpl {
    private Connection conn;
    private PreparedStatement pstm;

    public void updataImpl(String tableName, String args, String newValue, String whereagrs, String value){
        String sql = "update " + tableName + " set " + args + "=" +newValue + " where " + whereagrs + "=" + value;
        System.out.println(sql);
        BasicDataSource ds = InitJDBC.dbpoolInit();
        try {
            conn = ds.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstm != null)
                    pstm.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

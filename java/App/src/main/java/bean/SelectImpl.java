package bean;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectImpl {
    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    public void selectImpl(String args, String tableName, String wherearges) {
        String sql = "";
        if (wherearges == null)
            sql = "select " + args + " from " + tableName;
        else
            sql = "select " + args + " from " + tableName + " where " + wherearges;
//        System.out.println(sql);
        BasicDataSource ds = InitJDBC.dbpoolInit();
        try {
            conn = ds.getConnection();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstm != null)
                    pstm.close();
                if(conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

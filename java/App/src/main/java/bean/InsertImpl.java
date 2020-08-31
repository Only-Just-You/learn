package bean;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImpl {
    private Connection conn = null;
    private PreparedStatement pstm = null;

    public void insert(String tableName, String insertagrs, String value){
        String sql = "insert into " + tableName + "(" + insertagrs +")" + "values (" + value + ")";
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

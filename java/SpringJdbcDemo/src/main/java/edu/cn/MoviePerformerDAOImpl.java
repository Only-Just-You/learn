package edu.cn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program SpringJdbcDemo
 * @description:
 * @author:
 * @create:2019-10-15 11:37:17
 **/
@Repository
public class MoviePerformerDAOImpl implements MoviePerformerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public MoviePerformer queryById(Integer id) {
        return null;
    }

    @Override
    public List<MoviePerformer> queryByName(String name) {
        List<MoviePerformer> list = new ArrayList<MoviePerformer>();
        String string = "select * from user where name = ?";
        list = jdbcTemplate.query(string,new MoviePerformerRowMapper(),name);
        return list;
    }

    @Override
    public void insertByvalue(String table, String args, String values) {
        String sql = "insert into ?(?) values(?)";
        System.out.println(table+","+args+","+values);
        jdbcTemplate.update(sql,new Object[]{
                table, args, values
        });
    }

    class MoviePerformerRowMapper implements RowMapper<MoviePerformer>{

        @Override
        public MoviePerformer mapRow(ResultSet resultSet, int i) throws SQLException {
            MoviePerformer moviePerformer = new MoviePerformer();
            moviePerformer.setName(resultSet.getString(1));
            moviePerformer.setSex(resultSet.getString(2));
            moviePerformer.setIphone(resultSet.getString(3));
            return moviePerformer;
        }
    }
}

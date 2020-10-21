package com.example.demo.repository;


import com.example.demo.entity.Orderby;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Log
@Repository
public class OrderbyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Orderby orderby) throws Exception {
        log.info("Repository Orderby create");
        String query = "insert into orderby(nickname, order, cafenum, place) values(?, ?, ?, ?)";
        jdbcTemplate.update(query, orderby.getNickname(), orderby.getOrders(), orderby.getCafenum(), orderby.getPlace());
    }

    public List<Orderby> list(String place) throws Exception {
        log.info("Repository Marker list()");
        List<Orderby> results = jdbcTemplate.query(
                "select nickname, order, cafenum from orderby where place = ?",
                new RowMapper<Orderby>() {
                    @Override
                    public Orderby mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Orderby orderby = new Orderby();
                        orderby.setNickname(rs.getString("nickname"));
                        orderby.setOrders(rs.getString("order"));
                        orderby.setCafenum(rs.getInt("cafenum"));

                        return orderby;
                    }
                }, place
        );
        return results;
    }
}

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
        String query = "insert into orderby(order_no,nickname, orders, cafenum, place) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, orderby.getOrderNo(), orderby.getNickname(), orderby.getOrders(), orderby.getCafenum(), orderby.getPlace());
    }

    public List<Orderby> list(String place) throws Exception {
        log.info("Repository Orderby list()");
        log.info(place);

        String query = "select order_no, nickname, orders, cafenum  from orderby where place = ?";

        List<Orderby> results = jdbcTemplate.query(
                query,
                new RowMapper<Orderby>() {
                    @Override
                    public Orderby mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        Orderby orderby = new Orderby();
                        orderby.setOrderNo(rs.getLong("order_no"));
                        orderby.setNickname(rs.getString("nickname"));
                        orderby.setOrders(rs.getString("orders"));
                        orderby.setCafenum(rs.getInt("cafenum"));
                        return orderby;
                    }
                }, place
        );

        return results;
    }
}

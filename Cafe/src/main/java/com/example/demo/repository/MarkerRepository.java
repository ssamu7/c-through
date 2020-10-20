package com.example.demo.repository;

import com.example.demo.entity.Marker;
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
public class MarkerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Marker marker) throws Exception {
        log.info("Repository Marker create");
        String query = "insert into marker(nickname, cafename, cafecall) values(?, ?, ?)";
        jdbcTemplate.update(query, marker.getNickname(), marker.getCafename(), marker.getCafecall());
    }

    public List<Marker> list(Marker marker) throws Exception {
        log.info("Repository Marker list()");
        List<Marker> results = jdbcTemplate.query(
            "select cafename, cafecall from marker where userid = ?",
            new RowMapper<Marker>() {
                @Override
                public Marker mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    Marker marker = new Marker();
                    marker.setCafename(rs.getString("cafename"));
                    marker.setCafecall(rs.getString("cafecall"));

                    return marker;
                }
            }, marker.getNickname()
        );
        return results;
    }
}

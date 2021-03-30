package com.example.demo.entity;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ConferencesEntity extends EntityBase {
    private Long id;
    private LocalDateTime date;
    private String place;
    private Integer quantityExpectedVisitors;
    private Integer quantityVisited;
    private String title;
    private Long moderatorId;
    private Long speakerId;

    public ConferencesEntity() {

    }

    @Override
    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getQuantityExpectedVisitors() {
        return quantityExpectedVisitors;
    }

    public void setQuantityExpectedVisitors(String quantityExpectedVisitors) {
        this.quantityExpectedVisitors = Integer.parseInt(quantityExpectedVisitors);
    }

    public Integer getQuantityVisited() {
        return quantityVisited;
    }

    public void setQuantityVisited(Integer quantityVisited) {
        this.quantityVisited = quantityVisited;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(Long moderatorId) {
        this.moderatorId = moderatorId;
    }

    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }

    public ConferencesEntity(Long id, LocalDateTime date, String place, Integer quantityExpectedVisitors, Integer quantityVisited, String title, UsersEntity moderatorId, UsersEntity speakerId) {
        this.id = id;
        this.date = date;
        this.place = place;
        this.quantityExpectedVisitors = quantityExpectedVisitors;
        this.quantityVisited = quantityVisited;
        this.title = title;
        this.moderatorId = moderatorId.getId();
        this.speakerId = speakerId.getId();
    }

    @Override
    public String getTableName() {
        return "Conference";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO " + getTableName() +
                " (date, place, quantity_expected_visitors, quantity_visited, title, moderator, speaker) VALUES(?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE " + getTableName() + " SET date=?, place=?, quantity_expected_visitors=?," +
                "quantity_visited=?, title=?, moderator=?, speaker=? WHERE " + getId() + "=?";
    }

    @Override
    public String getIdName() {
        return "id";
    }

    @Override
    public void parse(ResultSet resultSet) throws SQLException {
        id = resultSet.getLong("id");
        date = resultSet.getObject("date", LocalDateTime.class);
        place = resultSet.getString("place");
        quantityExpectedVisitors = resultSet.getInt("quantity_expected_visitors");
        quantityVisited = resultSet.getInt("quantity_visited");
        title = resultSet.getString("title");
        moderatorId = resultSet.getLong("moderator");
        speakerId = resultSet.getLong("speaker");
    }

    @Override
    public void serialize(PreparedStatement statement, boolean withId) throws SQLException {
        statement.setObject(1, date.toString());
        statement.setString(2, place);
        statement.setInt(3, quantityExpectedVisitors);
        statement.setInt(4, quantityVisited);
        statement.setString(5, title);
        statement.setLong(6, moderatorId);
        statement.setLong(7, speakerId);
        if (withId) {
            statement.setLong(7, id);
        }
    }
}

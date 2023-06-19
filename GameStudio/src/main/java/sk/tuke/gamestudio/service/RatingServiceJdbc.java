package sk.tuke.gamestudio.service;

//Tabulka v databaze
/* CREATE TABLE rating (
	game VARCHAR(60) NOT NULL,
	username VARCHAR ( 50 ) NOT NULL,
   	rating INT NOT NULL,
	rated_at TIMESTAMP WITHOUT time zone,
	CHECK (rating BETWEEN 1 AND 5),
	UNIQUE (game, username)
); */

import sk.tuke.gamestudio.entity.Rating;
import sk.tuke.gamestudio.exceptions.ServiceException;

import java.sql.*;

public class RatingServiceJdbc implements RatingService{

    private static final String JDBC_URL = "jdbc:postgresql://localhost/Gamestudio2";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "postgres";
    final String STATEMENT_SET_RATING = "INSERT INTO rating VALUES (?, ?, ?, ?);";
//    final String STATEMENT_UPDATE_RATING = "UPDATE rating SET game = ?, username = ?, rating = ?, rated_at = ?;";
    final String STATEMENT_UPDATE_RATING = "UPDATE rating SET rating = ?, rated_at = ? WHERE game = ? AND username = ?;";

    @Override
    public void setRating(Rating rating) {

        try (var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);) {
            PreparedStatement statement;
            if (getRating(rating.getGame(), rating.getUsername()) == 0) {
                statement = connection.prepareStatement(STATEMENT_SET_RATING);
                statement.setString(1, rating.getGame());
                statement.setString(2, rating.getUsername());
                statement.setInt(3, rating.getRating());
                statement.setTimestamp(4, new Timestamp(rating.getRated_at().getTime()));
                statement.executeUpdate();
            } else {
                statement = connection.prepareStatement(STATEMENT_UPDATE_RATING);
                statement.setInt(1, rating.getRating());
                statement.setTimestamp(2, new Timestamp(rating.getRated_at().getTime()));
                statement.setString(3, rating.getGame());
                statement.setString(4, rating.getUsername());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getAverageRating(String game){
        final String STATEMENT_AVERAGE_RATING = "SELECT AVG(rating) FROM rating WHERE game = ?;";

        try (var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             var statement = connection.prepareStatement(STATEMENT_AVERAGE_RATING);
             )
        {
            statement.setString(1, game);
            try (var rs = statement.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return 0;

        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getRating(String game, String username) {
        final String STATEMENT_GET_RATING = "SELECT game, username, rating, rated_at FROM rating WHERE game = ? AND username = ?;";

        try(var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            var statement = connection.prepareStatement(STATEMENT_GET_RATING);
        ){
            statement.setString(1, game);
            statement.setString(2, username);
            try(var rs = statement.executeQuery()){
                Rating rating = null;
                while (rs.next()) {
                    rating = new Rating(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getTimestamp(4));
                }
                if(rating == null)
                    return 0;
                else
                    return rating.getRating();
            }
        }catch (SQLException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public void reset() {
        final String STATEMENT_RESET = "DELETE FROM rating";
        try(var connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            var statement = connection.createStatement()
        )
        {
            statement.executeUpdate(STATEMENT_RESET);
        }catch(SQLException e){
            throw new ServiceException(e);
        }
    }
}

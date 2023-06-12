package com.example.uliral;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SongDao {
    private Connection connection;
    private static SongDao instance = null;

    private SongDao() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/songs", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static SongDao getInstance(){
        if (instance == null) {
            instance = new SongDao();
        }
        return instance;
    }

    public List<Song> getSongs() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM songs");
            resultSet = statement.executeQuery();
            List<Song> songs = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String artist = resultSet.getString("artist");
                double star = resultSet.getDouble("star");
                String length = resultSet.getString("length");
                String image = resultSet.getString("image");
                System.out.println(id);
                Song song = new Song(id, title, artist, star, length, image);
                songs.add(song);
            }
            return songs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(statement, resultSet);
        }
    }

    public boolean addSong(Song song) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO songs (title, artist, star, length, image) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, song.getTitle());
            statement.setString(2, song.getArtist());
            statement.setDouble(3, song.getStar());
            statement.setString(4, song.getLength());
            statement.setString(5, song.getImage());
            int numRowsAffected = statement.executeUpdate();
            return numRowsAffected > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close(statement, null);
        }
    }

    public boolean updateSong(Song song) {
        PreparedStatement statement = null;

        try {
            System.out.println("in db: " + song.getId());
            statement = connection.prepareStatement("UPDATE songs SET title = ?, artist = ?, star = ?, length = ?, image = ? WHERE id = ?");

            statement.setString(1, song.getTitle());
            statement.setString(2, song.getArtist());
            statement.setDouble(3, song.getStar());
            statement.setString(4, song.getLength());
            statement.setString(5, song.getImage());
            statement.setInt(6, song.getId());
//            statement.setString(6, song.getTitle());
            int numRowsAffected = statement.executeUpdate();
            return numRowsAffected > 0;
        } catch (SQLException e) {
            return false;
        } finally {
            close(statement, null);
        }
    }

    public boolean deleteSong(int id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("DELETE FROM songs WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            close(statement, resultSet);
        }
    }

    private void close(Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

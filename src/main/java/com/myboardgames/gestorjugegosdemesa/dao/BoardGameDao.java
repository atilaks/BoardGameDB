/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myboardgames.gestorjugegosdemesa.dao;

import com.myboardgames.gestorjugegosdemesa.models.BoardGame;
import com.mysql.jdbc.StringUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BoardGameDao {
    
    public Connection conect(){
        String dataBase = "boardgamedb";
        String user = "root";
        String password = "";
        String host = "localhost";
        String port = "3306";
        String driver = "com.mysql.jdbc.Driver";
        String connectionUrl = "jdbc:mysql://" + host + ":" + port + "/" + dataBase + "?useSSL=false";
        
        Connection connection = null;
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);
        } catch (Exception ex) {
            Logger.getLogger(BoardGameDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public void add(BoardGame boardGame){
        try {
            Connection connection = conect(); 
            String sql = "INSERT INTO `boardgame` (`id`, `title`, `designer`, `category`, `playing_time`, `players`, `bgg_rating`) VALUES (NULL, '"
                    + boardGame.getTitle()+ "', '" 
                    + boardGame.getDesigner() +"', '" 
                    + boardGame.getCategory() + "', '" 
                    + boardGame.getPlaying_time() + "', '" 
                    + boardGame.getPlayers() + "', '" 
                    + boardGame.getBgg_rating() + "');";

            Statement statement = connection.createStatement();
            statement.execute(sql);
            //System.out.println("PASA");
        
        } catch (Exception ex) {
            Logger.getLogger(BoardGameDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public List<BoardGame> toList(){
        List<BoardGame> list = new ArrayList<>();
        
        try {
            Connection conexion = conect(); 
            String sql = "SELECT * FROM `boardgame`";
                    
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery(sql);
            
            while(resultado.next()){
                BoardGame boardGame = new BoardGame();
                boardGame.setId(resultado.getString("id"));
                boardGame.setTitle(resultado.getString("title"));
                boardGame.setDesigner(resultado.getString("designer"));
                boardGame.setCategory(resultado.getString("category"));
                boardGame.setPlaying_time(resultado.getString("playing_time"));
                boardGame.setPlayers(resultado.getString("players"));
                boardGame.setBgg_rating(resultado.getString("bgg_rating"));
                list.add(boardGame);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(BoardGameDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
        
    public void delete(String id){
        try {
            Connection connection = conect(); 
            String sql = "DELETE FROM boardgame WHERE `boardgame`.`id` = " + id;
            
            Statement statement = connection.createStatement();
            statement.execute(sql);
            
        } catch (Exception ex) {
            Logger.getLogger(BoardGameDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void update(BoardGame boardGame){
        try {
            Connection connection = conect(); 
            String sql = "UPDATE `boardgame` SET `title` = '" 
                    + boardGame.getTitle()
                    + "', `designer` = '" + boardGame.getDesigner()
                    + "', `category` = '" + boardGame.getCategory()
                    + "', `playing_time` = '" + boardGame.getPlaying_time()
                    + "', `players` = '" + boardGame.getPlayers()
                    + "', `bgg_rating` = '" + boardGame.getBgg_rating()
                    + "' WHERE `boardgame`.`id` = " 
                    + boardGame.getId() + ";";
            
            Statement statement = connection.createStatement();
            statement.execute(sql);
            
        } catch (Exception ex) {
            Logger.getLogger(BoardGameDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(BoardGame boardGame) {
        if (StringUtils.isEmptyOrWhitespaceOnly(boardGame.getId())){
            add(boardGame);
        } else {
            update(boardGame);
        }
    }
}

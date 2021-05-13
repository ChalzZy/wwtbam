/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp603_cui_whowantstobeamillionaire;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jona Stevenson & Charles Monaghan
 */
public class InitiateDB {
    
    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;
    
    public InitiateDB() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }
    
    /**
     * Initiates all the questions into the database
     */
    public void connectQuestionsDB() {
        try {
            this.statement = conn.createStatement();
            this.checkExistedTable("QUESTIONS");
            this.statement.addBatch("CREATE TABLE QUESTIONS ("
                    + "ID INT, "
                    + "QUESTION VARCHAR(200), "
                    + "QUESTIONA VARCHAR(100), "
                    + "QUESTIONB VARCHAR(100), "
                    + "QUESTIONC VARCHAR(100), "
                    + "QUESTIOND VARCHAR(100), "
                    + "CORRECTANSWER INT, "
                    + "PRIZE INT)");
            this.statement.addBatch("INSERT INTO QUESTIONS VALUES "
                    + "(1,'Where was the world trade center?','A - Wall Street','B - Brooklyn','C - Manhattan','D - Broadway',3,500),\n"
                    + "(2,'What is the capital of Brazil?','A - Rio de Janeiro','B - Basilia','C - Sao Paulo','D - Santo Domingo',2,1000),\n"
                    + "(3,'Which country makes the FIAT cars?','A - France','B - Japan','C - USA','D - Italy',4,2000),\n"
                    + "(4,'Who is the singer of the pop group REM?','A - Michael Stipe','B - Steven Tyler','C - Mark Knopfler','D - Bobby McFerrin',1,5000),\n"
                    + "(5,'The Earth is approximately how many miles away from the Sun?','A - 9.3 million','B - 39 million','C - 93 million','D - 193 million',3,10000),\n"
                    + "(6,'A knish is traditionally stuffed with what filling?','A - Potato','B - Creamed Corn','C - Lemon Custard','D - Raspberry Jelly',1,20000),\n"
                    + "(7,'According to Greek mythology who was Apollo''s twin sister?','A - Aphrodite','B - Artemis','C - Venus','D - Athena',2,50000),\n"
                    + "(8,'According to the Bible Moses and Aaron had a sister named what?','A - Jochebed','B - Ruth','C - Leah','D - Miriam',4,75000),\n"
                    + "(9,'An airplane''s black box is usually what color?','A - Black','B - White','C - Orange','D - Purple',3,150000),\n"
                    + "(10,'Cheddar cheese got its name from a village in what country?','A - England','B - France','C - Switzerland','D - Denmark',1,250000),\n"
                    + "(11,'From what language does the term ''R.S.V.P.'' originate?','A - Russian','B - Italian','C - Portuguese','D - Fench',4,500000),\n"
                    + "(12,'How many keys are on a standard piano?','A - 20','B - 54','C - 88','D - 100',3,1000000)");
            this.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getNextException());
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Add player to the leaderboard
     * @param playerName Name of the player
     * @param score Final game score
     */
    public void addToDBLeaderboard(String playerName, int score) {
        try {
            this.statement = conn.createStatement();
            this.statement.addBatch("INSERT INTO LEADERBOARD VALUES "
                    + "('"+playerName+"',"+score+")");
            this.statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getNextException());
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Checks if a table already exists
     * @param name Name of the table
     */
    public void checkExistedTable(String name) {
        try {
            DatabaseMetaData dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = this.conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);

            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                System.out.println(table_name);
                if (table_name.equalsIgnoreCase(name)) {
                    statement.executeUpdate("Drop table " + name);
                    System.out.println("Table " + name + " has been deleted.");
                    break;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void closeConnection() {
        this.dbManager.closeConnections();
    }
}

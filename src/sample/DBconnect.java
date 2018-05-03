package sample;

import java.sql.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class DBconnect {

    public Stack nickNames = new Stack();
    public Stack userScores = new Stack();


    public Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;

    public DBconnect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");


            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/leaderboard", "root", "");
            st = con.createStatement();

        } catch (Exception ex) {
            alertBox.display("Error!", "We have a database error! Please tell the administrator. Exception: " + ex, "Okay");
        }
    }

    public void getData() {
        String users = "SELECT * FROM `userscore` ORDER BY `userscore`.`Score` ASC";
        try {


            rs = st.executeQuery(users);

            while (rs.next()) {

                String name = rs.getString("Nickname");
                String score = rs.getString("Score");
                populateData(nickNames, name);
                populateData(userScores, score);
            }
        } catch (Exception exc) {
            alertBox.display("Error", "Sorry, we are unable to get data from the leaderboard. Error code:" + exc + "Please contact the administrator", "Okay");

        }

    }


    public void populateData(Stack stack, String value) {
        try {
            stack.push(value);
        } catch (Exception e) {
            alertBox.display("Error", "Sorry, we cant add data at this time. Please try again later. Error code: " + e, " Okay");
        }
    }


    public void addData(String nickname, int score) {
        try {

            String addResult = "INSERT INTO userscore"
                    + "(Nickname, Score) VALUES"
                    + "(?,?)";

            ps = con.prepareStatement(addResult);

            ps.setString(1, nickname);
            ps.setInt(2, score);

            ps.executeUpdate();
        } catch (Exception exc) {
            alertBox.display("Error!", "Sorry, your details cannot be added at this time. Error code : " + exc, "Okay");
        }

    }

}
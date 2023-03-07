package ro.ase.acs.sql.main;

import ro.ase.acs.sql.classes.DataInserter;
import ro.ase.acs.sql.classes.DataReader;
import ro.ase.acs.sql.classes.TableCreater;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {


    public static void main(String[] args) {

        TableCreater tableCreater = new TableCreater();
        DataInserter dataInserter = new DataInserter();
        DataReader dataReader = new DataReader();

        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);

            tableCreater.createTable(connection);
            dataInserter.insertData(connection);
            dataReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }






}
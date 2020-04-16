package project.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;


public class Table_handle {


    private String path;
    private Connection c;
    private Statement s;
    //Constructors
    public Table_handle(){
        c = null;
        s = null;
        path = "jdbc:sqlite:F:\\College\\OOP\\Java\\Java Project\\database.db";
        create_table();
    }

    //Others
    //Create a table if it does not exist
    private void create_table(){
        //Structure of my table
        String crTable = "Create table if not exists investments(\n"
                + "proposal_id varchar2(20) PRIMARY KEY,\n"
                + "programme_name varchar2(100),\n"
                + "lead_applicant varchar2(100),\n"
                + "research_body varchar2(200),\n"
                + "title_of_research varchar2(300),\n"
                + "start_date date,\n"
                + "end_date date,\n"
                + "commitment number(9)"
                + ");";

        //Create connection and execute statement

        this.connect();
        this.command(crTable);
    }
    //Create a connection
    private Connection connect() {
        try {
            c = DriverManager.getConnection(path);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
    //Create and execute a statement
    private Statement command(String querry) {
        try {
            this.connect();
            s = c.createStatement();
            s.execute(querry);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    public void insert(String proposalID, String progName, String leadApplicant,
                        String researchBody, String titleOfResearch, String startDate,
                        String endDate, String commitment){

        String sqlInsert = "insert into investments values(\n"
                            + "\'" + proposalID + "\'" + ",\n"
                            + "\'" + progName + "\'" + ",\n"
                            + "\'" + leadApplicant + "\'" + ",\n"
                            + "\'" + researchBody + "\'" + ",\n"
                            + "\'" + titleOfResearch + "\'" + ",\n"
                            + "\'" + startDate + "\'" + ",\n"
                            + "\'" + endDate + "\'" + ",\n"
                            + commitment + ");";
        System.out.println(sqlInsert);
    }



    //Populates the table

}

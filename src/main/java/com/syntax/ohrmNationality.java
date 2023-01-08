package com.syntax;

import java.sql.*;

public class ohrmNationality {
    public static void main(String[] args) {
        // To build connection to the database, we need 3 things
        // : url, username ,password
        //              type of database             /database we wanna connect
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";   //jdbc: java database conectivity
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            //1.connection to database
            Connection conn= DriverManager.getConnection(url, username, password);

            //2. create a statement object to send sql queries
            Statement st =conn.createStatement();

            //3. using statement object we are sending query and database return
            // an object of resultset (table with rows and columns)
            ResultSet rset= st.executeQuery("select * from ohrm_nationality;");  // it will hold ohrm_nationality table

            System.out.println("-----EXTRACTING DATA FROM RESULTSET USING LOOP");

            while (rset.next()){
               String Empid= rset.getString("id");
               String Empname= rset.getString("name");
                System.out.println(Empid+" "+Empname);
            }

            System.out.println("connection is created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

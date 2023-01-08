package com.syntax;

import java.sql.*;

public class DataBaseTest {
    public static void main(String[] args) {
        // To build connection to the database, we need 3 things
       // : url, username ,password

        //Type of database : mysql, oracle etc.
       //              type of database             /database we wanna connect
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";   //jdbc: java database conectivity
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            //1.connection to database
            Connection conn=DriverManager.getConnection(url, username, password);

            //2. create a statement object to send sql queries
            Statement st =conn.createStatement();

            //3. using statement object we are sending query and database return
            // an object of resultset (table with rows and columns)
           ResultSet rset= st.executeQuery("select firstname,lastname from person;");  // it will hold entire person table

           rset.next();   // to move in the next row bcuz don't need the header
          String fName= rset.getString("FirstName");
          String lName= rset.getString("LastName");
            System.out.println(fName+" "+lName);   //jon jerry

            rset.next();
            fName= rset.getString("FirstName");
            lName= rset.getString("LastName");
            System.out.println(fName+" "+lName);   //Mary kim

            System.out.println("-----EXTRACTING DATA FROM RESULTSET USING LOOP");

            while (rset.next()){
                fName= rset.getString("FirstName");  //Exact name as in the table
                lName= rset.getString("LastName");
                System.out.println(fName+" "+lName);
            }

            System.out.println("connection is created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

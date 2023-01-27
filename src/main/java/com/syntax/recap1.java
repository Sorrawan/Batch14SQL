package com.syntax;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class recap1 {
    public static void main(String[] args) {
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection connect = DriverManager.getConnection(url, username, password);
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from person order by firstname;");
            ResultSetMetaData metaData = resultSet.getMetaData();

            List<Map<String, String>> listFromResultSet = new ArrayList<>();

            //while iterate over rows
            while (resultSet.next()){
                Map<String,String> map = new LinkedHashMap<>();
                //iterate over columns
                for(int i=1; i<=metaData.getColumnCount(); i++){
                    String key = metaData.getColumnName(i);
                    String value= resultSet.getString(key);
                    map.put(key,value);

                }
                System.out.println(map);
                listFromResultSet.add(map);
            }




        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    }


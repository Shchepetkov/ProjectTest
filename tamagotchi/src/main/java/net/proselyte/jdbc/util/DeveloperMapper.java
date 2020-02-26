package net.proselyte.jdbc.util;

import net.proselyte.jdbc.model.Developer;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperMapper implements RowMapper
    {
        public static String Usernam;
        public static String Passwor;
        public static String Data_OLD;
        public static String Person;
        public static String Years;

        @Override
            public Developer mapRow(ResultSet rs, int rowNum) throws SQLException
                {
                    Developer developer = new Developer();
                    String yer = developer.setYears(rs.getString("Years"));
                    String date = developer.setData_OLD(rs.getString("Data_OLD"));
                    String Use = developer.setLoginV(rs.getString("LoginV"));
                    String Pas = developer.setPasswordV(rs.getString("PasswordV"));
                    String Pers = developer.setPerson(rs.getString("Person"));

                    Years = yer;
                    Usernam = Use;
                    Passwor = Pas;
                    Data_OLD = date;
                    Person = Pers;

                    return developer;
                }
    }
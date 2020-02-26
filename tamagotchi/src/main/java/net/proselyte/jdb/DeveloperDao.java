package net.proselyte.jdb;

import javax.sql.DataSource;
import java.text.ParseException;

public interface DeveloperDao
    {
        void setDataSource(DataSource dataSource);
        void InsertDeveloper() throws ParseException;
        void InsertYears();
        void listDevelopers();
        void createDeveloper();
        void InstPerson();

        void restart();
    }


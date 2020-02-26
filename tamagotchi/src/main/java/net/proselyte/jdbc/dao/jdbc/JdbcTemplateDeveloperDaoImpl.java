package net.proselyte.jdbc.dao.jdbc;

import static com.devcolibri.mavenjavafxapp.controller.Hunter.getStrYears;
import static com.devcolibri.mavenjavafxapp.controller.VHOD.getStrPassword;
import static com.devcolibri.mavenjavafxapp.controller.VHOD.getStrUsername;
import com.devcolibri.mavenjavafxapp.controller.Controller;
import com.devcolibri.mavenjavafxapp.controller.Reg;
import net.proselyte.jdb.DeveloperDao;
import net.proselyte.jdbc.util.DeveloperMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;

public class JdbcTemplateDeveloperDaoImpl implements DeveloperDao
    {
        private JdbcTemplate jdbcTemplate;

        @Override
            public void setDataSource(DataSource dataSource)
                {
                    this.jdbcTemplate = new JdbcTemplate(dataSource);
                }


        @Override
            public void InsertDeveloper()
                {
                    String SQL = "INSERT INTO new_table(Data_OLD, LoginV, PasswordV)" +
                            "VALUES ('" + Controller.DataOLD() + "','" + getStrUsername() + "','" + getStrPassword() +"' ) " +
                            "on duplicate key update Data_OLD = values(Data_OLD)";
                    jdbcTemplate.update(SQL);
                }

        @Override
            public void InsertYears()
                {
                    String SQL = "INSERT INTO new_table(Years, LoginV, PasswordV) " +
                            "VALUES ('" + getStrYears() + "','" + getStrUsername() + "','" + getStrPassword() +"' ) " +
                            "on duplicate key update Years = values(Years);";
                    jdbcTemplate.update(SQL);
                }



        @Override
            public void listDevelopers()
                {
                    String SQL = "SELECT LoginV, PasswordV, Data_OLD, Person, Years FROM user.new_table WHERE (LoginV = '" + getStrUsername() + "' AND PasswordV ='"
                        + getStrPassword() + "') ";
                    jdbcTemplate.query(SQL, new DeveloperMapper());
                }

        @Override
            public void createDeveloper()
                {
                    String SQL = "INSERT INTO new_table (LoginV,PasswordV) VALUES ('" + Reg.getLab() + "','" + Reg.getPas() + "') ";
                    jdbcTemplate.update(SQL);
                }

        @Override
            public void InstPerson()
            {
                String SQL = "INSERT INTO new_table (LoginV,PasswordV,Person) VALUES ('" + getStrUsername() + "','" + getStrPassword() + "','" + Controller.getNane() + "') on duplicate key update Person = values(Person) ";
                jdbcTemplate.update(SQL);
            }

        @Override
            public void restart()
                {
                    String SQL = "UPDATE user.new_table SET Years ='0', Person ='0',Data_OLD ='00:00:00' where (LoginV = '" + getStrUsername() + "' AND PasswordV ='"
                            + getStrPassword() + "') ";
                    jdbcTemplate.update(SQL);
                }

    }


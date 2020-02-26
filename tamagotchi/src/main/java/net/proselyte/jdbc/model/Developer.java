package net.proselyte.jdbc.model;

public class Developer
    {
        private String Data_OLD;
        private String LoginV;
        private String PasswordV;
        private String Person;
        private String Years;

        public String setLoginV(String loginV)
            {
                this.LoginV = loginV;
                return loginV;
            }

        public String setPasswordV(String passwordV)
            {
                this.PasswordV = passwordV;
                return passwordV;
            }

        public String setData_OLD(String Data_OLD)
            {
                this.Data_OLD = Data_OLD;
                return Data_OLD;
            }

        public String setPerson(String person) {
            this.Person = person;
            return person;
        }

        public String setYears(String years) {
            this.Years = years;
            return years;
        }

        @Override
            public String toString()
                {
                    return LoginV + PasswordV + Data_OLD + Person + Years;
                }


    }

package domain.db.util;

import java.util.Properties;

public abstract class Credentials {
    static public void setPass(Properties dbProperties) {
        dbProperties.setProperty("user", dbProperties.getProperty("user"));
        dbProperties.setProperty("password", dbProperties.getProperty("password"));
    }
}

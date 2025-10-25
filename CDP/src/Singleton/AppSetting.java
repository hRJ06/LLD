package Singleton;

import java.util.Objects;

public class AppSetting {
    /* private static AppSetting instance; */

    /* volatile - Ensure visibility across thread. */
    private static volatile AppSetting instance;
    private final String databaseURl;
    private final String apiKey;

    private AppSetting() {
        databaseURl = "jdbc:mysql://localhost:3306/test-db";
        apiKey = "test-API-Key";
    }

    /* Non - Thread safe
        private static AppSetting getInstance() {
            if(Objects.isNull(instance)) {
                instance = new AppSetting();
            }
            return instance;
        }
     */

    private static AppSetting getInstance() {
        if(Objects.isNull(instance)) {
            synchronized (AppSetting.class) {
                if(Objects.isNull(instance)) {
                    instance = new AppSetting();
                }
            }
        }
        return instance;
    }

    public String getDatabaseURl() {
        return databaseURl;
    }

    public String getAPIKey() {
        return apiKey;
    }
}

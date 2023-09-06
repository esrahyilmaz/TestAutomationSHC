package com.fadv.automation.core;

import java.util.logging.Logger;

public class Environment {
    static final Logger logger = Logger.getLogger(Environment.class.getName());
    protected static String env = System.getProperty("env");
    protected static String cloud_env = System.getProperty("cloud_env");
    protected TestObject testObject;
    protected String envName = null;

    public Environment(String name) {
        this.envName = name;
    }

    public static String getEnvironmentBaseUrl() {
        if (env == null) {
            return TestObject.getProperty("data.uat.env.url");
        }

        return TestObject.getProperty("data." + env + ".env.url");
    }

    public static String getEaEnvironmentBaseUrl() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uat.env.url");
        }

        return TestObject.getProperty("data.ea." + env + ".env.url");
    }

    public static String getEaCMEnvironmentAccount() {
        if (env == null) {
            return TestObject.getProperty("data.cm.uat.login.account");
        }

        return TestObject.getProperty("data.cm." + env + ".login.account");
    }

    public static String getEaCMEnvironmentUser() {
        if (env == null) {
            return TestObject.getProperty("data.cm.uat.login.user");
        }

        return TestObject.getProperty("data.cm." + env + ".login.user");
    }

    public static String getEaCMEnvironmentPassword() {
        if (env == null) {
            return TestObject.getProperty("data.cm.uat.login.password");
        }

        return TestObject.getProperty("data.cm." + env + ".login.password");
    }

    public static String getEaEnvironmentAccount() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uat.login.account");
        }

        return TestObject.getProperty("data.ea." + env + ".login.account");
    }

    public static String getEaRndEnvironmentAccount() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uatrnd.login.account");
        }

        return TestObject.getProperty("data.ea." + env + ".login.account");
    }

    public static String getEaEnvironmentUser() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uat.login.user");
        }

        return TestObject.getProperty("data.ea." + env + ".login.user");
    }

    public static String getEaRndEnvironmentUser() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uatrnd.login.user");
        }

        return TestObject.getProperty("data.ea." + env + ".login.user");
    }

    public static String getEaEnvironmentPassword() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uat.login.password");
        }

        return TestObject.getProperty("data.ea." + env + ".login.password");
    }

    public static String getEaRndEnvironmentPassword() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uatrnd.login.password");
        }

        return TestObject.getProperty("data.ea." + env + ".login.password");
    }

    public static String getEnvironmentInviteUuid() {
        if (env == null) {
            return TestObject.getProperty("data.uat.invite.uuid");
        }
        return TestObject.getProperty("data." + env + "invite.uuid");
    }

    public static String getEnvironmentLocationUuid() {
        if (env == null) {
            logger.info("setting default location");
            return TestObject.getProperty("data.uat.location.uuid");
        } else {
            logger.info("setting environment location for " + env);
            return TestObject.getProperty("data." + env + ".location.uuid");
        }
    }

    public static String getEaEnvironmentSecret() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uat.login.secret");
        }

        return TestObject.getProperty("data.ea." + env + ".login.secret");
    }

    public static String getEnvironmentLocationAlias() {
        if (env == null) {
            logger.info("setting default location alias");
            return TestObject.getProperty("data.uat.location.alias");
        } else {
            logger.info("setting environment location alias for " + env);
            return TestObject.getProperty("data." + env + ".location.alias");
        }
    }

    public static String getCloudEnvironmentBaseUrl() {
        if (cloud_env == null) {
            return TestObject.getProperty("data.cloud.dev.cloud_env.url");
        }

        return TestObject.getProperty("data.cloud." + cloud_env + ".cloud_env.url");
    }

    public static String getEaAirEnvironmentAccount() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uatair.login.account");
        }

        return TestObject.getProperty("data.ea." + env + ".login.account");
    }

    public static String getEaAirSkpEnvironmentAccount() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uatairskp.login.account");
        }

        return TestObject.getProperty("data.ea." + env + ".login.account");
    }

    public static String getEaAirEnvironmentUser() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uatair.login.user");
        }

        return TestObject.getProperty("data.ea." + env + ".login.user");
    }

    public static String getEaAirEnvironmentPassword() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uatair.login.password");
        }

        return TestObject.getProperty("data.ea." + env + ".login.password");
    }

    public static String getEaAirSkpEnvironmentUser() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uatairskp.login.user");
        }

        return TestObject.getProperty("data.ea." + env + ".login.user");
    }

    public static String getEaAirSkpEnvironmentPassword() {
        if (env == null) {
            return TestObject.getProperty("data.ea.uatairskp.login.password");
        }

        return TestObject.getProperty("data.ea." + env + ".login.password");
    }

    public static String getEaUsfcSkpEnvironmentAccount() {
        if (env == null)
        {
            return TestObject.getProperty("data.ea.uatusfskp.login.account");
        }

        return TestObject.getProperty("data.ea." + env + ".login.account");
    }
    public static String getEaUsfcSkpEnvironmentUser() {
        if (env == null)
        {
            return TestObject.getProperty("data.ea.uatusfskp.login.user");
        }

        return TestObject.getProperty("data.ea." + env + ".login.user");
    }

    public static String getEaUsfcSkpEnvironmentPassword() {
        if (env == null)
        {
            return TestObject.getProperty("data.ea.uatusfskp.login.password");
        }

        return TestObject.getProperty("data.ea." + env + ".login.password");
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public String getEnv() {
        return env;
    }

    public String getEnvironmentLocationUiUuid() {
        if (env == null) {
            logger.info("setting default UI location");
            return TestObject.getProperty("data.uat.location.ui.uuid");
        } else {
            logger.info("setting UI environment location for " + env);
            return TestObject.getProperty("data.ea." + env + ".location.ui.uuid");
        }
    }

    public String getEnvironmentLocationName() {
        if (env == null) {
            logger.info("setting default location name");
            return TestObject.getProperty("data.uat.location.name");
        } else {
            logger.info("setting environment location for " + env);
            return TestObject.getProperty("data." + env + ".location.name");
        }
    }

    public String getEnvironmentLocationState() {
        if (env == null) {
            logger.info("setting default location state");
            return TestObject.getProperty("data.uat.location.state");
        } else {
            logger.info("setting environment location for " + env);
            return TestObject.getProperty("data." + env + ".location.state");
        }
    }

}

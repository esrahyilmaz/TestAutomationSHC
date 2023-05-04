package com.fadv.automation.environment;

import com.fadv.automation.core.Environment;
import com.fadv.automation.core.TestObject;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * @author phamlong
 */
public class EspEnv extends Environment {
    static Logger logger = Logger.getLogger(EspEnv.class.getName());

    public static final String QAA = "QC1";
    public static final String QAB = "QC2";
    public static final String QAC = "QC3";
    public static final String CUST_TEST = "CUST_TEST";
    public static final String STAGING = "STAGING";
    public static final String UAT = "UAT";
    public static final String PRODUCTION = "PRODUCTION";

    public static enum DBType {
        LOCAL, MASTER, TSN
    }

    public EspEnv(String name) {
        super(name);
    }

    public static EspEnv loadEnvironment(TestObject testObject) {
        String selectedEnv = null;
        //using system property
        String env = System.getProperty("env");
        if (env != null && !env.isEmpty()){
            logger.info("using test.env specified by system property " + env);
            selectedEnv = env;
        }else {
            //using config file
            String configEnv = testObject.getProperty("env");
            if (configEnv != null && !configEnv.isEmpty()) {
                logger.info("using env specified by config file " + configEnv);
                selectedEnv = configEnv;
            }
        }
        return new EspEnv(selectedEnv);
    }
//need to be moved to the config file
    public String getEAUrl() {
        if (envName.equalsIgnoreCase(QAA)) {
            return "https://qa-cpscreen.fadv.net/";
        } else if (envName.equalsIgnoreCase(QAB)) {
            return "https://qa02-cpscreen.fadv.net/";
        } else if (envName.equalsIgnoreCase(QAC)) {
            return "https://apqtsnc.fadv.net/";
        } else if (envName.equalsIgnoreCase(CUST_TEST)) {
            return "https://screentest.lexisnexis.com/";
        } else if (envName.equalsIgnoreCase(PRODUCTION)) {
            return "https://enterprise.fadv.com/";
        } else if (envName.equalsIgnoreCase(STAGING)) {
            return "https://ua.enterprisetest.fadv.com/";
        } else {
            //default url is UAT
            return "https://ua.enterprisetest.fadv.com/";
        }
    }


    public Connection getDBConnection(DBType dbType) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            if (envName.equalsIgnoreCase(QAA)) {
                switch (dbType) {
                    case LOCAL:
                        // WPSQ1
                        // =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)(HOST=dbqwpspr.apac.fadv.net)
                        // (PORT=1540)))(CONNECT_DATA=(SID=WPSPRQ1) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbqwpspr.apac.fadv.net:1540:WPSPRQ1",
                                "empserv", "empserv");
                        break;
                    case MASTER:
                        // EMPT2
                        // =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)(HOST=dbtemp.apac.fadv.net)
                        // (PORT=1566)))(CONNECT_DATA=(SID=EMPT2) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbtemp.apac.fadv.net:1566:EMPT2", "empserv",
                                "empserv");
                        break;
                    case TSN:
                        // TSNQ1 =(DESCRIPTION= (ADDRESS= (PROTOCOL=TCP)(HOST=dbqtsn.apac.fadv.net)
                        // (PORT=1573)) (CONNECT_DATA=(SID=TSNQ1) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbqtsn.apac.fadv.net:1573:TSNQ1", "dbptsn",
                                "tsnqc");
                        break;
                    default:
                        logger.info("Unsupported dbType [" + dbType + "] on environment [" + envName + "]");
                        System.err.println("Unsupported dbType [" + dbType + "] on environment [" + envName + "]");
                }

            } else if (envName.equalsIgnoreCase(QAB)) {
                switch (dbType) {
                    case LOCAL:
                        // WPSQ2 =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)
                        // (HOST=dbqwpsq2.apac.fadv.net) (PORT=1543)))(CONNECT_DATA=(SID=WPSQ2) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbqwpsq2.apac.fadv.net:1543:WPSQ2", "empserv",
                                "empserv");
                        break;
                    case MASTER:
                        // ESPQ2 =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)
                        // (HOST=dbqesp.apac.fadv.net) (PORT=1560)))(CONNECT_DATA=(SID=ESPQ2) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbqesp.apac.fadv.net:1560:ESPQ2", "empserv",
                                "empserv");
                        break;
                    case TSN:
                        // TSNQ2 =(DESCRIPTION= (ADDRESS= (PROTOCOL=TCP)
                        // (HOST=dbqtsn2.apac.fadv.net) (PORT=1574)) (CONNECT_DATA=(SID=TSNQ2) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbqtsn2.apac.fadv.net:1574:TSNQ2", "dbptsn",
                                "tsnqc");
                        break;
                    default:
                        logger.info("Unsupported dbType [" + dbType + "] on environment [" + envName + "]");
                        System.err.println("Unsupported dbType [" + dbType + "] on environment [" + envName + "]");
                }
            } else if (envName.equalsIgnoreCase(QAC)) {
                switch (dbType) {
                    case LOCAL:
                        // WPSQ3 =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)
                        // (HOST=dbqwpsq3.apac.fadv.net) (PORT=1560)))(CONNECT_DATA=(SID=WPSQ3) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbqwpsq3.apac.fadv.net:1560:WPSQ3", "empserv",
                                "empserv");
                        break;
                    case MASTER:
                        // ESPQ3 =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)
                        // (HOST=dbqesp3.apac.fadv.net) (PORT=1558)))(CONNECT_DATA=(SID=ESPQ3) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbqesp3.apac.fadv.net:1558:ESPQ3", "empserv",
                                "empserv");
                        break;
                    case TSN:
                        // TSNQ3 =(DESCRIPTION= (ADDRESS= (PROTOCOL=TCP)
                        // (HOST=dbqtsn3.apac.fadv.net) (PORT=1555)) (CONNECT_DATA=(SID=TSNQ3) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbqtsn3.apac.fadv.net:1555:TSNQ3", "dbptsn",
                                "tsnqc");
                        break;
                    default:
                        logger.info("Unsupported dbType [" + dbType + "] on environment [" + envName + "]");
                        System.err.println("Unsupported dbType [" + dbType + "] on environment [" + envName + "]");
                }
            } else if (envName.equalsIgnoreCase(STAGING)) {
                switch (dbType) {
                    case LOCAL:
                        // WPSPRU1=(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)(HOST=dbuwpspr)
                        // (PORT=1545)))(CONNECT_DATA=(SID=WPSPRU1) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbuwpspr.noam.fadv.net:1545:WPSPRU1",
                                "wpsrecserv", "recserv");
                        break;
                    case MASTER:
                        // MAU1
                        // =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)(HOST=dbuma)
                        // (PORT=1571)))(CONNECT_DATA=(SID=MAU1) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbuma.noam.fadv.net:1571:MAU1", "wpsrecserv",
                                "recserv");
                        break;
                    case TSN:
                        // TSNU1
                        // =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)(HOST=dbutsn)
                        // (PORT=1572)))(CONNECT_DATA=(SID=TSNU1) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbutsn.noam.fadv.net:1572:TSNU1", "website",
                                "website");
                        break;
                    default:
                        logger.info("Unsupported dbType [" + dbType + "] on environment [" + envName + "]");
                        System.err.println("Unsupported dbType [" + dbType + "] on environment [" + envName + "]");
                }
            } else if (envName.equalsIgnoreCase(CUST_TEST)) {
                switch (dbType) {
                    case LOCAL:
                        // WPSC1
                        // =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)(HOST=dbcwpspr)
                        // (PORT=1542)))(CONNECT_DATA=(SID=WPSPRC1) ))
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbcwpspr.noam.fadv.net:1542:WPSPRC1",
                                "wpsrecserv", "recserv");
                        break;
                    case MASTER:
                        // MAC1
                        // =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)(HOST=dbcma)
                        // (PORT=1560)))(CONNECT_DATA=(SID=MAC1) )) //
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbcma.noam.fadv.net:1560:MAC1", "wpsrecserv",
                                "recserv");
                        break;
                    case TSN:
                        // TSNC1
                        // =(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(COMMUNITY=TCPCOM)(PROTOCOL=TCP)(HOST=dbctsn)
                        // (PORT=1572)))(CONNECT_DATA=(SID=TSNC1) )) //
                        conn = DriverManager.getConnection("jdbc:oracle:thin:@dbctsn.noam.fadv.net:1572:TSNC1", "website",
                                "website");
                        break;
                    default:
                        logger.info("Unsupported dbType [" + dbType + "] on environment [" + envName + "]");
                        System.err.println("Unsupported dbType [" + dbType + "] on environment [" + envName + "]");
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.info(e.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            logger.info(e.toString());
        }
        return conn;
    }

}

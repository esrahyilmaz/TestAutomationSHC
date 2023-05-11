package com.fadv.automation.core;

import com.fadv.automation.environment.EspEnv;
import com.fadv.automation.utils.CommonMethods;
import com.fadv.automation.utils.UtilTextProcessor;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author phamlong
 */
public class TestObject {
    protected static Properties defaultProperties = null;
    protected static Properties localProperties = null;
    static Logger logger = Logger.getLogger(TestObject.class.getName());
    private static Map<Object, Object> testList = new HashMap<Object, Object>();
    protected Map<String, Object> runTimeData = null;
    protected Map<String, String> testData = null;
    protected Environment testEnv = null;
    protected Object testKey = null;
    protected ExtentReporter reporter = null;
    protected Scenario scenario = null;

    TestObject(Object key) {
        this.runTimeData = new HashMap<String, Object>();
        this.testData = new HashMap<String, String>();
        this.testKey = key;
        this.reporter = new ExtentReporter(key.toString());
        TestObject.testList.put(key, this);
    }

    /**
     * Get Property from config file
     * - First, check at the local property
     * - Second, check at the default property if not found from local.
     *
     * @param name
     * @return
     */
    public static String getProperty(String name) {
        if (localProperties != null) {
            String value = localProperties.getProperty(name);
            if (value != null && !value.isEmpty()) {
                return value;
            }
        }
        if (defaultProperties != null) {
            String value = defaultProperties.getProperty(name);
            return value;
        }
        return null;
    }

    public static void setSharedData(Map<String, String> inputs) throws IOException {
        String file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\sharedData.json";
        Object c = null;
        Map<String, Object> data = new HashMap<String, Object>();
        try {
            c = CommonMethods.jsonFile2Object(file);
            if (c != null) {
                data = (Map<String, Object>) c;
            }
        } catch (Exception e) {
        }

        data.putAll(inputs);
        CommonMethods.object2JsonFile(data, file);
    }

    public static void setSharedData(String key, Object value) throws IOException {
        String file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\sharedData.json";
        Map<String, Object> data = new HashMap<>();
        try {
            Object c = null;
            c = CommonMethods.jsonFile2Object(file);
            if (c != null) {
                data = (Map<String, Object>) c;
            }
        } catch (Exception e) {
        }
        data.put(key, value);
        CommonMethods.object2JsonFile(data, file);
    }

    public static Object getSharedData(String key) throws IOException {
        String file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\sharedData.json";
        Object c = CommonMethods.jsonFile2Object(file);
        Map<String, Object> data = (Map<String, Object>) c;
        return data.get(key);
    }

    /**
     * Class function to get/instantiate a test object
     *
     * @param key
     * @return
     */
    public static TestObject get(Object key) throws IOException {
        if (key == null) {
            key = "DEFAULT-TEST";
        }

        Object to = TestObject.testList.get(key);
        if (to != null) {
            if (to instanceof TestObject) {
                TestObject testObject = (TestObject) to;
                return testObject;
            } else {
                logger.info("can't find the testObject for [" + key + "]");
            }
        } else {
            logger.info("creating new testObject for [" + key + "]");
            TestObject nto = new TestObject(key);
            nto.loadFromConfig();
            TestObject.testList.put(key, nto);
            return nto;
        }
        return null;
    }

    /**
     * Same as class get method.
     *
     * @param key
     * @return
     */
    public static TestObject init(Object key) throws IOException {
        return get(key);
    }

    /**
     * init TestObject with scenario object
     *
     * @param scenario
     * @return
     */
    public static TestObject createWith(Scenario scenario) throws IOException {
        TestObject to = get(scenario.getName());
        to.setScenario(scenario);
        //to.loadFromConfig();
        return to;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public ExtentReporter getReporter() {
        return reporter;
    }

    public Environment getTestEnv() {
        return testEnv;
    }

    public void setTestEnv(Environment testEnv) {
        this.testEnv = testEnv;
    }

    /**
     * Load default and local configs for test object
     *
     * @throws IOException
     */
    private void loadFromConfig() throws IOException {
        String file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\config.properties";
        String env = System.getProperty("env");

        if ("qaa".equals(env) || "qab".equals(env)) {
            file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\config_qa.properties";
        } else {
            if ("uat".equals(env)) {
                file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\config_uat.properties";
            }
        }
        defaultProperties = CommonMethods.readProperties(file);
        logger.info("loading default properties from " + file);
        String localConfig = defaultProperties.getProperty("test.local.config");
        if (localConfig != null && !localConfig.isEmpty()) {
            localProperties = CommonMethods.readProperties(localConfig);
            logger.info("loading local properties from " + file);
        }
        //String env = System.getProperty("env");
//        String envProperty = this.getProperty("data." + env + ".env.url");
//        String env = this.getProperty("test.env");
        if (env != null && !env.isEmpty()) {
            this.setTestEnv(new EspEnv(env));
            logger.info("Setting env: " + env);
        }
    }

    public String processString(String value) {
        if (value.startsWith("data.runtime.")) {
            value = (String) getRuntimeData(value.substring(13));
        } else if (value.startsWith("data.")) {
            value = getProperty(value); // load from config file
        }
        value = UtilTextProcessor.processText(value);
        return value;
    }

    public void setRuntimeData(String key, Object value) {
        this.runTimeData.put(key, value);
    }

    public Object getRuntimeData(String key) {
        return this.runTimeData.get(key);
    }

    public Map<String, Object> getRunTimeData() {
        return runTimeData;
    }

    public void setTestData(String key, String value) {
        this.testData.put(key, value);
    }

    public String getTestData(String key) {
        return this.testData.get(key);
    }

    public Map<String, String> getTestData() {
        return testData;
    }

    public void testComplete() {
        //logger.info("perform test completing tasks.");
        if (reporter != null) {
            reporter.endReporting();
        }
    }
}
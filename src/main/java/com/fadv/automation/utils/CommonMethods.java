package com.fadv.automation.utils;

import com.google.gson.*;
import io.restassured.response.Response;
//import org.apache.velocity.VelocityContext;
//import org.apache.velocity.app.Velocity;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class CommonMethods {
    protected Logger logger = Logger.getLogger(CommonMethods.class.getName());
    /**
     * Get's the value of the specified attribute from the Response Object. This
     * works on both XML and Json
     *
     * @param attributeName Node to retrieve
     * @return value of the node in the Response
     */
    public String getAttributeValue(Response response, String attributeName) {
        String stringValue = null;
        try {
            stringValue = response.then().extract().path(attributeName);
            if (stringValue == null) {
                logger.info("Unable to find attribute: " + attributeName);
                return null;
            }
        } catch (Exception e) {
            logger.info("Unable to find attribute: " + attributeName);
            e.printStackTrace();
        } catch (Error e) {
            logger.info("Unable to find attribute: " + attributeName);
            e.printStackTrace();
        }
        if (stringValue != null)
            logger.info("Returned value:" + stringValue);
        return stringValue;
    }
    /**
     * Returns the Long value of the specified attribute from the Response Object.
     * Note: To retrieve the string attribute value use method getAttributeValue()
     *
     * @param response
     * @param String   attributeName
     * @return Long Value of the attribute
     */
    public Long getAttributeIntegerValue(Response response, String attributeName) {
        Long attrValue = null; // to support the return type null, using Long instead of long
        try {
            attrValue = Long.valueOf(response.then().extract().path(attributeName).toString());// Cast exception is
            // thrown when not
            // converting to String
            // first, as in this
            // case, object returned
            // from restassured
            // method does support
            // it
            if (attrValue == null)
                logger.info("Unable to find attribute: " + attributeName);
        } catch (Exception e) {
            logger.info("Unable to find attribute: " + attributeName);
            e.printStackTrace();
        } catch (Error e) {
            logger.info("Unable to find attribute: " + attributeName);
            e.printStackTrace();
        }
        logger.info("Returned value:" + attrValue);
        return attrValue;
    }

    /**
     * Replaces attribute values in the supplied JSON/XML body template with values
     * supplied in the VelocityContext Object. The template should be a String of
     * JSON/XML that has attribute values populated with placeholder identifiers.
     * The identifiers are prefixed with "$" character (example: $PLACE_HOLDER) The
     * identifiers will be replaced with the values supplied in the The
     * VolocityContext object. Values in the VelocityContext that are non numeric
     * are wrapped in quotes to make make them valid JSON/XML String attributes.
     *
     * @param body    JSON/XML String with $PLACE_HOLDER identifiers to be replaced
     *                with values from "context"
     * @param context A VelocityContext object that contains the replacement values
     * @return String of JSON/XML with the replacements completed
     */
//    public String replaceTemplateWithValues(String body, VelocityContext context) {
//        String replacedInput = null;
//        try {
//            Velocity.init();
//            StringWriter writer = new StringWriter();
//            for (Object o : context.getKeys()) {
//                String key = (String) o;
//                String value = (String) context.internalGet(key);
//                /*
//                 * if (!StringUtils.isNumeric(value)) { value = "\"" + value + "\"";
//                 * context.put(key, value); }
//                 */
//                context.put(key, value);
//            }
//            Velocity.evaluate(context, writer, "ServiceTestTemplate", body);
//            replacedInput = writer.toString();
//            logger.info("Template replaced with values successfully");
//        } catch (Exception e) {
//            logger.info("Unable to replace Template with values");
//        }
//        return replacedInput;
//    }

    /**
     * Replaces attribute values in the supplied JSON/XML body template with values
     * supplied in the VelocityContext Object. The template should be a String of
     * JSON/XML that has attribute values populated with placeholder identifiers.
     * The identifiers are prefixed with "$" character (example: $PLACE_HOLDER) The
     * identifiers will be replaced with the values supplied in the The
     * VolocityContext object. All Values in the VelocityContext are wrapped in
     * quotes to make make them valid String
     *
     * @param body    JSON/XML String with $PLACE_HOLDER identifiers to be replaced
     *                with values from "context"
     * @param context A VelocityContext object that contains the replacement values
     * @return String of JSON/XML with the replacements completed
     */
//    public String replaceTemplateWithStringValues(String body, VelocityContext context) {
//        String replacedInput = null;
//        try {
//            Velocity.init();
//            StringWriter writer = new StringWriter();
//            for (Object o : context.getKeys()) {
//                String key = (String) o;
//                Object vo = context.internalGet(key);
//
//                if (vo instanceof String){
//                    String value = (String) context.internalGet(key);
//                    if (value.equals("") || !value.substring(value.length() - 1).equals("_"))
//                        value = "\"" + value + "\"";
//                    else
//                        value = value.replace("_", "");
//                    context.put(key, value);
//                } else {
//                    context.put(key, vo);
//                }
//            }
//            Velocity.evaluate(context, writer, "ServiceTestTemplate", body);
//            replacedInput = writer.toString();
//            logger.info("Template replaced with values successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.info("Unable to replace Template with values");
//        }
//        return replacedInput;
//    }

    /**
     * Read Text File
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String readTextFile(String fileName) throws IOException {
        String body = null;
        File file = new File(fileName);
        body = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        return body;
    }


    /**
     * Read Json Object from file
     * @param fileName
     * @return
     * @throws IOException
     */
    public static JsonObject readJsonFile(String fileName) throws IOException {
        String jsonBody = readTextFile(fileName);
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = jsonObject = parser.parse(jsonBody).getAsJsonObject();
        return jsonObject;
    }


    /**
     * Convert String to Json
     * @param jsonAsString
     * @return
     */
    public static JsonObject convertStringToJson(String jsonAsString) {
        JsonObject jsonObject = null;
        JsonParser parser = new JsonParser();
        jsonObject = parser.parse(jsonAsString).getAsJsonObject();
        return jsonObject;
    }

    /**
     * Creates a context object from the hashmap containing attribute names and
     * values
     *
     * @param HashMap nameValue
     * @return VelocityContext
     */
//    public VelocityContext getContextObject(Map<String, Object> nameValue) {
//        VelocityContext context = new VelocityContext();
//        try {
//            nameValue.forEach((attrName, attrValue) -> {
//                context.put(attrName, attrValue);
//            });
//        } catch (Exception e) {
//            logger.info("Error while creating VelocityContext object");
//        }
//        return context;
//    }
    /**
     * Returns the class name for the specified attribute
     *
     * @param attributeName
     * @return String
     */
    public String getAttributeClassName(Response response, String attributeName) {
        String className = null;
        try {
            className = response.then().extract().path(attributeName).getClass().getSimpleName();
            logger.info("Class type of attribute: \"" + attributeName + "\"" + " is " + className);
        } catch (NullPointerException e) {
            e.getMessage();
            logger.info("NullPointerException caught. Attribute name:" + attributeName);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(
                    "Exception caught. Refer stacktraceAttrubute name:" + attributeName);
        }
        return className;
    }

    /**
     * Gets the list of attributes from an array within the Response object
     *
     * @param arrayPath Path to array[.attribute]
     *
     * @return List A List of attribute values
     */
    public List<Object> getAttributesListFromArray(Response response, String attributePath) {
        List<Object> attributesList = new ArrayList<Object>();
        try {
            attributesList = response.then().extract().jsonPath().getList(attributePath);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(
                    "Unable to find array attribute: " + attributePath + " .Please refer stacktrace");
        }
        return attributesList;
    }
    /**
     * Returns boolean value based upon the comparison - string matches with the
     * regular expression Note: To perform the verification use
     * {@link CommonServiceVerificationLibraries#verifyStringMatchesExpression(String, String)}
     *
     * @param value, String to test
     * @param expression, String regex used to validate the value
     */
    public boolean isStringMatchingExpression(String value, String expression) {
        try {
            return Pattern.matches(expression, value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Please refer stacktrace");
            return false;
        }
    }
    /**
     * Removes specified element from the original json and returns the modified
     * json
     *
     * @param jsonObject
     * @param blockNameToRemove
     * @return
     */
    public String removeBlockFromJson(JsonObject jsonObject, String blockNameToRemove) {
        try {
            for (JsonElement jsonElement : jsonObject.getAsJsonArray(blockNameToRemove)) {
                jsonElement.getAsJsonArray().remove(jsonElement);
            }
            logger.info(String.format("Removed Block: %s Successfully" + blockNameToRemove));
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(String.format("Unable to remove: %s from the original json", blockNameToRemove));
        }
        return jsonObject.toString();
    }

    public static void object2JsonFile(Object obj, String filePath) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        //Gson gson = new Gson();
        Writer writer = new FileWriter(filePath);
        gson.toJson(obj, writer);
        writer.close();
    }

    public static Object jsonFile2Object(String filePath) throws IOException {
        // create Gson instance
        Gson gson = new Gson();
        Reader reader = new FileReader(filePath);
        Object obj = gson.fromJson(reader, Object.class);
        // close reader
        reader.close();
        return obj;
    }

    /**
     *  read properties from file
     * @param fileLocation
     * @throws IOException
     */
    public static Properties readProperties(String fileLocation) throws IOException {
        FileReader reader=new FileReader(fileLocation);

        Properties p=new Properties();
        p.load(reader);

        return p;
    }

    public static void main(String[] a) throws IOException, InterruptedException {
//        String file = System.getProperty("user.dir");
//        file += "/src/test/resources/configs/config.properties";
//        System.out.println("file = " + file);
//       // readProperties(file);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("t1", "v1");
//        map.put("t2", "v2");
//        object2JsonFile(map, "./cookies.json");
//
//        Object obj = jsonFile2Object("./cookies.json");
//        obj = (Map<String, String>)obj;
//
//        System.out.println("read obj = " + obj.toString());

        String id = "69676fec-0d6e-4717-9b02-b7078c66a834";

        Process process = new ProcessBuilder("C:\\Automation\\ValueEncrypter\\ApplicantSelfCollect.Backend.ValueEncrypter.exe", id).start();
        //Process process = new ProcessBuilder("C:\\Automation\\ValueEncrypter\\encrypt.bat", id).start();

       // Process process = Runtime.getRuntime().exec("C:\\Automation\\ValueEncrypter\\encrypt.bat");

        //        InputStream is = process.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);


     //   System.out.printf("Output of running %s is:", Arrays.toString(args));

//        while ((line = br.readLine()) != null) {
//            System.out.println("--> " + line);
//        }

        process.waitFor();
        BufferedReader bri = new BufferedReader(new InputStreamReader(process.getInputStream()));
 //       Thread.sleep(1000);

// bri may be empty or incomplete.
        String line;
        while ((line = bri.readLine()) != null) {
            System.out.println(line);
        }

        System.out.println("Done.");
        process.destroy();
    }
}
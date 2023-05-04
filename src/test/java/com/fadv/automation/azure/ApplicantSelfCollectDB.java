package com.fadv.automation.azure;

import com.fadv.automation.core.BaseClass;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.database.azure.CosmosDB;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ApplicantSelfCollectDB extends BaseClass {

    private CosmosDB db = null;

    public ApplicantSelfCollectDB() {
        db = new CosmosDB();
    }
    public ApplicantSelfCollectDB(TestObject to) {
        super(to);
        db = new CosmosDB();
    }

    public void close() {
        db.close();
    }

    public List<JsonNode> getDrugCollectionByQuery(String sql) throws IOException {
        return db.query(sql);
    }

    public void validate(String sql, Map<String, String> validations) throws IOException {
        SoftAssert softAssert = new SoftAssert();
        List<JsonNode> results = db.query(sql);

        if (results != null) {


        } else {
            softAssert.fail("db query returns null");
        }

        softAssert.assertAll();
    }

    public static void main(String[] a) throws IOException {
        ApplicantSelfCollectDB db = new ApplicantSelfCollectDB();
        List<JsonNode> data = db.getDrugCollectionByQuery("SELECT * FROM c where c.lastName = 'AUTO21112'");

        System.out.println("data = " + data.toString());
        System.out.println("cocBarcode = " + data.get(0).get("cocBarcode").textValue());

        db.close();
    }
}

package com.fadv.automation.stepdef;

import com.fadv.automation.core.BaseClass;
import com.fadv.automation.database.esp.Database;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RulesEngineDef extends BaseClass {



    @Given("the custom rule {string} is setup in the system")
    public void theCustomIsSetupInTheSystem(String ruleName) {
        report("Checking for the rule: " + ruleName);
        //fail("test failed");
    }


    /**
     * Add new process history to the database
     *  - element : the element such as ED, PEMP, FEMP
     *  - code : the process history code
     * @param dataTable
     */
    @Then("add process history code")
    public void addProcessHistoryCode(DataTable dataTable) throws SQLException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        Database db = new Database(testObject);
        for (Map<String, String> d : data){
            String code = d.get("code");
            String element = d.get("element");
            if (element!= null && !element.isEmpty() && code != null && !code.isEmpty()){
                db.addProcessHistoryCode(element, 1, code);
            }
        }
    }

    /**
     * Update component's date range
     * @param dataTable
     * @throws SQLException
     */
    @Then("update the component date range")
    public void updateDateRangeComponentWithReportData(DataTable dataTable) throws SQLException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        Database db = new Database(testObject);
        String element = data.get(0).get("element");

        String startDate = data.get(0).get("startDate");
        if (startDate != null && !startDate.isEmpty()){
            db.updateDateRangeData(element, 1, 1, "DR_REP_START_DT", startDate);
        }

        String endDate = data.get(0).get("endDate");
        if (endDate != null && !endDate.isEmpty()){
            db.updateDateRangeData(element, 1, 1, "DR_REP_END_DT", endDate);
        }

        String location = data.get(0).get("location");
        if (location != null && !location.isEmpty()) {
            db.updateDateRangeData(element, 1, 1, "DR_REP_LOCATION_TX", location);
        }
    }

    /**
     * Update employment component with report data
     *  - element
     *  - position
     *  - positionType
     *  - income
     *  - incomeType
     *  - unverifiedReason
     *
     * @param dataTable
     */
    @Then("update the FEMP component with report data")
    public void updateFEMPComponentWithReportData(DataTable dataTable) throws SQLException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        Database db = new Database(testObject);
        String element = "FEMP";
        String pempOrFempTable = "case_femp_info";

        String position = data.get(0).get("position");
        if (position != null && !position.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CFEI_REP_POSITION_TX", position);
        }

        String positionType = data.get(0).get("positionType");
        if (positionType != null && !positionType.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CFEI_REP_POSITION_TP", positionType);
        }

        String income = data.get(0).get("income");
        if (income != null && !income.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CFEI_REP_INCOME_AT", income);
        }

        String incomeType = data.get(0).get("incomeType");
        if (incomeType != null && !incomeType.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CFEI_REP_INCOME_TP", incomeType);
        }

        String unverifiedReason = data.get(0).get("unverifiedReason");
        if (unverifiedReason != null && !unverifiedReason.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CFEI_UNVERIFIED_REASON", unverifiedReason);
        }

        String startDate = data.get(0).get("startDate");
        if (startDate != null && !startDate.isEmpty()){
            db.updateDateRangeData(element, 1, 1, "DR_REP_START_DT", startDate);
        }

        String endDate = data.get(0).get("endDate");
        if (endDate != null && !endDate.isEmpty()){
            db.updateDateRangeData(element, 1, 1, "DR_REP_END_DT", endDate);
        }

        String location = data.get(0).get("location");
        if (location != null && !location.isEmpty()){
            db.updateDateRangeData(element, 1, 1, "DR_REP_LOCATION_TX", location);
        }

        String rehire = data.get(0).get("eligibleForRehire");
        if (rehire != null && !rehire.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CFEI_REP_REHIRE_FG", rehire);
        }

        String leftVoluntarily = data.get(0).get("leftVoluntarily");
        if (leftVoluntarily != null && !leftVoluntarily.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CFEI_REP_VOL_FG", leftVoluntarily);
        }

        String reasonForIneligibility = data.get(0).get("reasonForIneligibility");
        if (reasonForIneligibility != null && !reasonForIneligibility.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CFEI_REP_RSN_FOR_INELIGIBLE", reasonForIneligibility);
        }

        String reasonForLeaving = data.get(0).get("reasonForLeaving");
        if (reasonForLeaving != null && !reasonForLeaving.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CFEI_REP_RSN_LFT_TX", reasonForLeaving);
        }


    }

    /**
     * Update employment component with report data
     *  - element
     *  - position
     *  - positionType
     *  - income
     *  - incomeType
     *  - unverifiedReason
     *
     * @param dataTable
     */
    @Then("update the PEMP component with report data")
    public void updatePEMPComponentWithReportData(DataTable dataTable) throws SQLException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        Database db = new Database(testObject);
        String element = "PEMP";
        String pempOrFempTable = "case_pemp_info";

        String position = data.get(0).get("position");
        if (position != null && !position.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CPEI_REP_POSITION_TX", position);
            //db.updateEmploymentData(element, "CPEI_REP_POSITION_TX", position);
        }

        String positionType = data.get(0).get("positionType");
        if (positionType != null && !positionType.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CPEI_REP_POSITION_TP", positionType);
        }

        String income = data.get(0).get("income");
        if (income != null && !income.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CPEI_REP_INCOME_AT", income);
        }

        String incomeType = data.get(0).get("incomeType");
        if (incomeType != null && !incomeType.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CPEI_REP_INCOME_TP", incomeType);
        }

        String unverifiedReason = data.get(0).get("unverifiedReason");
        if (unverifiedReason != null && !unverifiedReason.isEmpty()){
            db.updateEmploymentWithColumnName(pempOrFempTable, "CPEI_UNVERIFIED_REASON", unverifiedReason);
        }

        String startDate = data.get(0).get("startDate");
        if (startDate != null && !startDate.isEmpty()){
            db.updateDateRangeData(element, 1, 1, "DR_REP_START_DT", startDate);
        }

        String endDate = data.get(0).get("endDate");
        if (endDate != null && !endDate.isEmpty()){
            db.updateDateRangeData(element, 1, 1, "DR_REP_END_DT", endDate);
        }

        String location = data.get(0).get("location");
        if (location != null && !location.isEmpty()){
            db.updateDateRangeData(element, 1, 1, "DR_REP_LOCATION_TX", location);
        }
    }

    @Then("update the education component")
    public void updateTheEducationComponent(DataTable dataTable) throws Exception {
        Database db = new Database(testObject);
        db.getDatatableUpdateEduInfo(dataTable);
    }

    @Then("update the element status")
    public void updateTheElementStatus(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Database db = new Database(testObject);
        for (Map<String, String> d : data){
            db.updateElement(d.get("element"), "1", d.get("statusCode"), null);
        }
    }

    @Then("wait for {int} seconds")
    public void waitForSeconds(Integer int1) {
        try {
            Thread.sleep(int1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("check the element status")
    public void checkTheElementStatus(DataTable dataTable) throws Exception {
        Database database = new Database(testObject);
        database.checkValuesInCaseElementTable(dataTable);
    }

    @Then("check the rule {string} was triggered")
    public void checkTheWasTriggered(String value) throws Exception{
        Database database = new Database(testObject);
        String message = String.format("Rule %s was checked for triggering.", value);
        report(database.checkCaseEventClob(value), message);
    }

    @Then("check the case event log contains the following")
    public void checkCaseEventLog(DataTable dataTable) throws Exception{
        Database database = new Database(testObject);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Database db = new Database(testObject);

        List<String> texts = new ArrayList<>();
        for (Map<String, String> d : data){
            texts.add(d.get("text"));
        }
        if (!texts.isEmpty()){
            db.checkCaseEventLog(texts);
        }
    }
}

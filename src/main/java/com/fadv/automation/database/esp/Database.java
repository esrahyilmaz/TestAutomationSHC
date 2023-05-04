package com.fadv.automation.database.esp;

import com.aventstack.extentreports.Status;
import com.fadv.automation.Constants;
import com.fadv.automation.core.BaseClass;
import com.fadv.automation.core.TestObject;
import com.fadv.automation.environment.EspEnv;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Database extends BaseClass {
    static Logger logger = Logger.getLogger(Database.class.getName());
    public String newCid = (String) testObject.getRuntimeData(Constants.CID);;

    public Database(TestObject to) {
        super(to);
    }

    /**
     * Update Element Status Code
     * @param comp
     * @param elemNb
     * @param elemStatusCd
     * @param elemConsidCd
     */
    public void updateElement(String comp, String elemNb, String elemStatusCd, String elemConsidCd) {
        Connection conn = null;

        String cid = (String) testObject.getRuntimeData(Constants.CID);
        if (cid == null || cid.isEmpty()){
            report(Status.FAIL, "CID not found");
            return;
        } else if (comp.isEmpty() || elemNb.isEmpty() || elemStatusCd.isEmpty()) {
            report(Status.FAIL, "Update comp/elemNb/elemStatusCd is missing");
            return;
        }

        try {
            EspEnv env = (EspEnv)testObject.getTestEnv();
            conn = env.getDBConnection(EspEnv.DBType.LOCAL);
            conn.setAutoCommit(true);

            // UPDATE case_element SET elem_status_cd = 'IR' WHERE control_nb = '9555538' AND comp_tp = 'ED' AND elem_nb = 1;
            String sql = "UPDATE case_element SET elem_status_cd = ? WHERE control_nb = ? AND comp_tp = ? AND elem_nb = ?";

            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, elemStatusCd);
            prepStmt.setString(2, cid);
            prepStmt.setString(3, comp);
            prepStmt.setString(4, elemNb);
            prepStmt.execute();

            logger.info(sql);
            logger.info("updated case_element elem_status_cd to value [" + elemStatusCd + "] on control_nb " + cid);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.toString());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception ignored) {
            }
        }
    }


    /**
     * Add Process History Code
     * @param compType
     * @param elementNb
     * @param processHistoryCode
     * @throws SQLException
     */
    public void addProcessHistoryCode(String compType, Integer elementNb, String processHistoryCode) throws SQLException {
        Connection conn = null;

        String cid = (String) testObject.getRuntimeData(Constants.CID);
        if (cid == null || cid.isEmpty()) {
            throw new RuntimeException("CID not found");
        } else if(compType.isEmpty() || elementNb == null) {
            throw new RuntimeException("Update component type, Element Number or Record Number is missing");
        } else if (processHistoryCode.isEmpty()) {
            throw new RuntimeException("Process History Code is missing");
        }

        try {
            EspEnv env = (EspEnv)testObject.getTestEnv();
            conn = env.getDBConnection(EspEnv.DBType.LOCAL);
            conn.setAutoCommit(true);

            String sql = "Insert into case_process_history (Control_Nb, Comp_Tp, Elem_Nb, Event_Cd, Event_date, Increment_Call_Counter, Event_ts, Ph_user_id) " +
                    "values (?, ?, ?, ?, sysdate, 'N', sysdate, 'AUTOM')";

            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, cid);
            prepStmt.setString(2, compType);
            prepStmt.setInt(3, elementNb);
            prepStmt.setString(4, processHistoryCode);
            prepStmt.execute();

            report(sql);
            report("Inserted case_process_history processHistoryCode [" + processHistoryCode + "] to control_nb " + cid);

            conn.close();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception ignored) {
            }
        }
    }


    /**
     * Update the date range table
     *  - support fields:
     *          DR_REP_START_DT
     *          DR_REP_END_DT
     *          DR_REP_LOCATION_TX
     *
     * @param compType
     * @param elementNb
     * @param drNumber
     * @param fieldName
     * @param fieldValue
     */
    public void updateDateRangeData(String compType, Integer elementNb, Integer drNumber, String fieldName, String fieldValue) throws SQLException {
        Connection conn = null;

        String cid = (String) testObject.getRuntimeData(Constants.CID);
        if (cid == null || cid.isEmpty()) {
            throw new RuntimeException("CID not found");
        } else if(compType.isEmpty() || elementNb == null || drNumber == null) {
            throw new RuntimeException("Update component type, Element Number or Record Number is missing");
        } else if (fieldName.isEmpty() || fieldValue.isEmpty()) {
            throw new RuntimeException("Update field/value is missing");
        }

        try {
            EspEnv env = (EspEnv)testObject.getTestEnv();
            conn = env.getDBConnection(EspEnv.DBType.LOCAL);
            conn.setAutoCommit(true);

            String sql = "UPDATE date_range SET " + fieldName + " = TO_DATE(?, 'MM/DD/YYYY') WHERE control_nb = ? and comp_tp = ? and elem_nb = ? and dr_nb = ?";
            if (!fieldName.contains("_DT")) { // if not a date field
                sql = "UPDATE date_range SET " + fieldName + " = ? WHERE control_nb = ? and comp_tp = ? and elem_nb = ? and dr_nb = ?";
            }
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, fieldValue);
            prepStmt.setString(2, cid);
            prepStmt.setString(3, compType);
            prepStmt.setInt(4, elementNb);
            prepStmt.setInt(5, drNumber);
            prepStmt.execute();

            report(sql);
            report("updated date_range fieldName [" + fieldName + "] to value [" + fieldValue + "] on control_nb " + cid);

            conn.close();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception ignored) {
            }
        }

    }

    /**
     * Update Employment (PEMP OR FEMP) data
     * @param pempOrfempTable
     * @param fieldName
     * @param fieldValue
     * @throws SQLException
     */
    public void updateEmploymentWithColumnName(String pempOrfempTable, String fieldName, String fieldValue) throws SQLException {
        Connection conn = null;

        String cid = (String) testObject.getRuntimeData(Constants.CID);
        if (cid == null || cid.isEmpty()){
            throw new RuntimeException("CID not found");
        } else if (pempOrfempTable.isEmpty() || fieldName.isEmpty() || fieldValue.isEmpty()) {
            throw new RuntimeException("Update table/field/value is missing");
        }

        try {
            EspEnv env = (EspEnv)testObject.getTestEnv();
            conn = env.getDBConnection(EspEnv.DBType.LOCAL);
            conn.setAutoCommit(true);

            // UPDATE case_pemp_info SET cei_rep_major_tx = 'MATH2' WHERE control_nb = '9555538';
            String sql = String.format("UPDATE %s SET %s = ? where control_nb = ?", pempOrfempTable, fieldName);

            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, fieldValue);
            prepStmt.setString(2, cid);
            prepStmt.execute();

            report(sql);
            report("updated employment info fieldName [" + fieldName + "] to value [" + fieldValue + "] on control_nb " + cid);

            conn.close();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception ignored) {
            }
        }
    }

    /**
     * Update Education Data
     *  - support fields:
     *          cei_rep_major_tx
     *          cei_rep_degree_tx
     *          cei_rep_gpa_tx
     *          cei_rep_grad_date
     * @param fieldName
     * @param fieldValue
     */
    public void updateEduData(String fieldName, String fieldValue) {
        Connection conn = null;

        String cid = (String) testObject.getRuntimeData(Constants.CID);
        if (cid == null || cid.isEmpty()){
            //report(Status.FAIL, "CID not found");
            throw new RuntimeException("CID not found");
            //return;
        } else if (fieldName.isEmpty() || fieldValue.isEmpty()) {
            //report(Status.FAIL, "Update field/value is missing");
            throw new RuntimeException("Update field/value is missing");
            //return;
        }

        try {
            EspEnv env = (EspEnv)testObject.getTestEnv();
            conn = env.getDBConnection(EspEnv.DBType.LOCAL);
            conn.setAutoCommit(true);

            // UPDATE case_edu_info SET cei_rep_major_tx = 'MATH2' WHERE control_nb = '9555538';
            String sql = "UPDATE case_edu_info SET " + fieldName + " = ? WHERE control_nb = ?";

            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, fieldValue);
            prepStmt.setString(2, cid);
            prepStmt.execute();

            //report(Status.INFO, sql);
            //report(Status.INFO, "updated fieldName [" + fieldName + "] to value [" + fieldValue + "] on control_nb " + cid);
            logger.info(sql);
            logger.info("updated case_edu_info fieldName [" + fieldName + "] to value [" + fieldValue + "] on control_nb " + cid);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.toString());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception ignored) {
            }
        }
    }


    public void updateSsnvData(String fieldName, String fieldValue) {
        Connection conn = null;

        String cid = (String) testObject.getRuntimeData(Constants.CID);
        if (cid == null || cid.isEmpty()){
            //report(Status.FAIL, "CID not found");
            throw new RuntimeException("CID not found");
            //return;
        } else if (fieldName.isEmpty() || fieldValue.isEmpty()) {
            //report(Status.FAIL, "Update field/value is missing");
            throw new RuntimeException("Update field/value is missing");
            //return;
        }

        try {
            EspEnv env = (EspEnv)testObject.getTestEnv();
            conn = env.getDBConnection(EspEnv.DBType.LOCAL);
            conn.setAutoCommit(true);

            // UPDATE case_edu_info SET cei_rep_major_tx = 'MATH2' WHERE control_nb = '9555538';
            String sql = "UPDATE case_edu_info SET " + fieldName + " = ? WHERE control_nb = ?";

            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, fieldValue);
            prepStmt.setString(2, cid);
            prepStmt.execute();

            //report(Status.INFO, sql);
            //report(Status.INFO, "updated fieldName [" + fieldName + "] to value [" + fieldValue + "] on control_nb " + cid);
            logger.info(sql);
            logger.info("updated case_edu_info fieldName [" + fieldName + "] to value [" + fieldValue + "] on control_nb " + cid);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info(e.toString());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception ignored) {
            }
        }
    }


    public void checkValuesInCaseElementTable(DataTable dataTable) throws Exception {
        List<List<String>> values = dataTable.asLists(String.class);
        int rows = values.size();
        int headers = values.get(0).size();
        Connection conn = getCurrentConnection();
        String controlNumberColumn = "control_nb";
        Status currentStatus;
        SoftAssert softAssert = new SoftAssert();
        if (newCid == null || newCid.isEmpty()) {
            currentStatus = Status.FAIL;
            report(currentStatus, "CID not found");
            Assert.fail("No CID was found.");
        }
        EspEnv env = (EspEnv) testObject.getTestEnv();
        conn = env.getDBConnection(EspEnv.DBType.LOCAL);
        conn.setAutoCommit(true);
        String sql = String.format("Select * from case_element WHERE %s  = '%s'", controlNumberColumn, newCid);
        logger.info(sql);
        PreparedStatement prepStmt = conn.prepareStatement(sql);
        prepStmt.execute();
        ResultSet resultSet = prepStmt.getResultSet();

        //check against all rows of data returned in the database
        if (resultSet.next()) {
            do {
                for (int i = 1; i < rows; i++) {
                    for (int column = 0; column < headers; column++) {
                        String header = values.get(0).get(column);
                        String value = values.get(i).get(column);
                        if (resultSet.getString(header).contains(value)) {
                            //handle remarks clob
                            if (header.equalsIgnoreCase("elem_remark_clob")) {
                                String resultValue = resultSet.getString("elem_remark_clob");
                                report("Case Element Remark Log: " + resultValue);
                                if (!resultValue.contains(value)) {
                                    //for logging to report log
                                    currentStatus = Status.FAIL;
                                    report(currentStatus, "Case Element remark was not found.");
                                    //for logged to cucumber report as step failed.
                                    closeConnection();
                                    softAssert.fail( "Case Element remark was not found");
                                }
                            }
                            report("Header " + header + " and value " + value + " were checked.");
                        } else {
                            currentStatus = Status.FAIL;
                            report(currentStatus, "Expected value of " + value + " was not found for: " + header);
                            closeConnection();
                            softAssert.fail("Expected value of " + value + " was not found for: " + header);
                        }
                    }
                }
            } while (resultSet.next());
        }
        else { //no records found
            conn.close();
            //for logging to report log
            currentStatus = Status.FAIL;
            report(currentStatus, "Rule was not found in the log.");
            //for logged to cucumber report as step failed.
            softAssert.fail("Rule was not found in the log.");
        }
        softAssert.assertAll();

    }

    public void checkCaseEventLog(List<String> textList) throws SQLException {
        Connection conn = null;

        String cid = (String) testObject.getRuntimeData(Constants.CID);
        if (cid == null || cid.isEmpty()){
            throw new RuntimeException("CID not found");
        } else if(textList.isEmpty()) {
            throw new RuntimeException("text list is empty");
        }

        try {
            EspEnv env = (EspEnv)testObject.getTestEnv();
            conn = env.getDBConnection(EspEnv.DBType.LOCAL);
            conn.setAutoCommit(true);

            //select * from case_event where COMP_TP = 'ED'
            //                               AND ELEM_NB = 1
            //                               AND CE_DESC_TX = 'Verification Rule Engine Processing is Complete'
            //                               AND control_nb = '9555644';

            String sql = "select * from case_event where CE_DESC_TX = 'Verification Rule Engine Processing is Complete' AND control_nb = ?";

            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, cid);

            report("Retrieve case event log from db: " + sql);

            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()){
                Clob clob = rs.getClob("ce_addl_tx");
                String text = clob.getSubString(1, (int) clob.length());

                if (text.isEmpty()) {
                    throw new RuntimeException("Case event log is empty");
                }
                report("Case event Log: " + text);

                for (String value : textList){
                    if (text.contains(value)) {
                        report("Text [" + value + "] was found in the case event log");
                    } else {
                        report("Text [" + value + "] was NOT found in the case event log");
                        Assert.fail("Text [" + value + "] was NOT found in the case event log");
                    }
                }
            } else {
                throw new RuntimeException("Query from db for case event returns no results");
            }
            rs.close();
            conn.close();
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception ignored) {
            }
        }
    }

    public Status checkCaseEventClob(String... fieldRuleNames) throws Exception
    {
        Connection conn = getCurrentConnection();

        String resultValue = null;
        Status currentStatus = Status.PASS;
        String clobColumn = "ce_addl_tx";
        String controlNumberColumn = "control_nb";
        String ceDescriptionTextColumn = "ce_desc_tx";
        String noConflictMessage = "No Conflicting Rules. Processing this element";
        /* select * from case_event where control_nb='xxxx' and ce_desc_tx = 'Verification Rule Engine Processing is Complete';
         */
        String sql = String.format("select * from case_event where %s = ? and %s = ?", controlNumberColumn, ceDescriptionTextColumn);
        PreparedStatement prepStmt = conn.prepareStatement(sql);
        prepStmt.setString(1, newCid);
        prepStmt.setString(2, "Verification Rule Engine Processing is Complete");
        prepStmt.execute();
        ResultSet resultSet= prepStmt.getResultSet();
        logger.info(sql);
        if(resultSet.next()) {
            do {
                resultValue = resultSet.getString(clobColumn);

                report("Case Event Log: " + resultValue);

                for (String value : fieldRuleNames) {
//                 Pattern Example: The Account Rules  rule:ED Grad Year - Equals Non Scoring Priority : 1 has a result:fired=true
                    String patternTriggerRuleMessage = String.format("The Account Rules  rule:%s\\sPriority :\\s\\d+\\shas a result:fired=true", value);
                    if (!(Pattern.compile(patternTriggerRuleMessage).matcher(resultValue).find()) || !(resultValue.contains(noConflictMessage)))
                    {
                        conn.close();
                        //for logging to report log
                        currentStatus = Status.FAIL;
                        report(currentStatus, "Rule was not found as triggered in the clob or conflicting rules may exist.");
                        //for logged to cucumber report as step failed.
                        Assert.fail("Rule was not found as triggered in the clob or conflicting rules may exist.");
                        return currentStatus;
                    }
                }
            } while (resultSet.next());
        }
        // no rows returned in the result set
        else {
            conn.close();
            //for logging to report log
            currentStatus = Status.FAIL;
            report(currentStatus, "Rule was not found in the log.");
            //for logged to cucumber report as step failed.
            Assert.fail("Rule was not found in the log.");
            return currentStatus;
        }
        return currentStatus;

    }

    public void getDatatableUpdateEduInfo(DataTable dataTable) throws Exception {
        List<List<String>> values = dataTable.asLists();
        for (int i = 0; i < values.size(); i++) {
            String field = values.get(i).get(0);
            String value = values.get(i).get(1);
            if (field != null || !field.isEmpty()) {
                updateEduData(field, value);
            }
        }
    }


    public void getDatatableUpdateEmployeeInfo(DataTable dataTable) throws Exception {
        List<List<String>> values = dataTable.asLists();
//        Database db = new Database(testObject);
        for (int i = 0; i < values.size(); i++) {
            String field = values.get(i).get(0);
            String value = values.get(i).get(1);
            if (field.equalsIgnoreCase("null")) {
                updateEduData(field, null);
            }
            else{
                updateEduData(field, value);
            }
        }
    }



    private Connection getCurrentConnection() throws Exception
    {
        Connection conn = null;
        if (newCid == null || newCid.isEmpty())
        {
            report(Status.FAIL, "CID not found");
            logger.info("Connection was not established because the CID was empty. (getCurrentConnection)...");
            return null;
        }
        EspEnv env = (EspEnv) testObject.getTestEnv();
        conn = env.getDBConnection(EspEnv.DBType.LOCAL);
        conn.setAutoCommit(true);
        logger.info("Connection established via getCurrentConnection...");
        return conn;
    }

    private void closeConnection() throws Exception
    {
        Objects.requireNonNull(getCurrentConnection()).close();
    }

    public static void main(String[] a) throws IOException {
        TestObject to = TestObject.init(null);
        to.setTestEnv(new EspEnv(EspEnv.QAC));
        to.setRuntimeData(Constants.CID, "9565972");

        Database db = new Database(to);
        db.updateEduData("cei_rep_grad_date", "01/01/2010");
        db.updateElement("ED", "1", "IR", null);
    }

}
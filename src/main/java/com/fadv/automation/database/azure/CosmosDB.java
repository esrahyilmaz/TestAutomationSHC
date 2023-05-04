package com.fadv.automation.database.azure;

import com.azure.cosmos.*;
import com.azure.cosmos.models.CosmosContainerProperties;
import com.azure.cosmos.models.FeedOptions;
import com.azure.cosmos.models.FeedResponse;
import com.fadv.automation.utils.CommonMethods;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CosmosDB {

    // The name of our database host.
    private String databaseHost = null;

    // The name of our database master key.
    private String databaseMasterKey = null;

    // The name of our database.
    private String databaseID = null;

    // The name of our collection.
    private String containerID = null;

    // The Cosmos DB Client
    private CosmosClient cosmosClient = null;

    // The Cosmos DB database
    private CosmosDatabase cosmosDatabase = null;

    // The Cosmos DB container
    private CosmosContainer cosmosContainer = null;

    private void initCosmosClient() throws IOException {
        String file = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\config.properties";
        Properties properties = CommonMethods.readProperties(file);
        
        this.databaseHost = properties.getProperty("azure.cosmosdb.host");
        this.databaseMasterKey = properties.getProperty("azure.cosmosdb.master.key");
        this.databaseID = properties.getProperty("azure.cosmosdb.database.id");
        this.containerID = properties.getProperty("azure.cosmosdb.container.id");


        cosmosClient = new CosmosClientBuilder()
                .setEndpoint(databaseHost)
                .setKey(databaseMasterKey)
                .setConnectionPolicy(ConnectionPolicy.getDefaultPolicy())
                .setConsistencyLevel(ConsistencyLevel.EVENTUAL)
                .buildClient();
    }

    public void close() {
        if (cosmosClient != null) {
            cosmosClient.close();
        }
    }

    public static void main(String[] a) throws IOException {
        CosmosDB db = new CosmosDB();
        String sql = "SELECT * FROM c where c.lastName = 'Auto31027'";

        sql = "SELECT * FROM c where c.lastName = 'Auto71110' or c.lastName = 'Auto61110'";

        List<JsonNode> data = db.query(sql);
        System.out.println("getDocumentByQuery : " + data.toString());

        System.out.println("done main");

        db.close();
    }

    public List<JsonNode> query(String sql) throws IOException {
        int maxItemCount = 1000;
        int maxDegreeOfParallelism = 1000;
        int maxBufferedItemCount = 100;

        FeedOptions options = new FeedOptions();
        options.setMaxItemCount(maxItemCount);
        options.setMaxBufferedItemCount(maxBufferedItemCount);
        options.setMaxDegreeOfParallelism(maxDegreeOfParallelism);
        options.setRequestContinuation(null);
        options.setPopulateQueryMetrics(false);

        List<JsonNode> itemList = new ArrayList();
        do {

            for (FeedResponse<JsonNode> pageResponse:
                    getContainerCreateResourcesIfNotExist()
                            .queryItems(sql, options, JsonNode.class)
                            .iterableByPage()) {

                options.setRequestContinuation(pageResponse.getContinuationToken());

                for (JsonNode item : pageResponse.getElements()) {
                    itemList.add(item);
                }
            }

        } while(options.getRequestContinuation() != null);

        if (itemList.size() > 0) {
            return itemList;
        } else {
            return null;
        }
    }

    private CosmosContainer getContainerCreateResourcesIfNotExist() throws IOException {
        if (cosmosClient == null) {
            this.initCosmosClient();
        }

        try {
            if (cosmosDatabase == null) {
                cosmosDatabase = cosmosClient.createDatabaseIfNotExists(databaseID).getDatabase();
            }

        } catch(CosmosClientException e) {
            // TODO: Something has gone terribly wrong - the app wasn't
            // able to query or create the collection.
            // Verify your connection, endpoint, and key.
            System.out.println("Something has gone terribly wrong - " +
                    "the app wasn't able to create the Database.\n");
            e.printStackTrace();
        }

        try {
            if (cosmosContainer == null) {
                CosmosContainerProperties properties = new CosmosContainerProperties(containerID,"/id");
                cosmosContainer = cosmosDatabase.createContainerIfNotExists(properties).getContainer();
            }
        } catch(CosmosClientException e) {
            // TODO: Something has gone terribly wrong - the app wasn't
            // able to query or create the collection.
            // Verify your connection, endpoint, and key.
            System.out.println("Something has gone terribly wrong - " +
                    "the app wasn't able to create the Container.\n");
            e.printStackTrace();
        }
        return cosmosContainer;
    }
}

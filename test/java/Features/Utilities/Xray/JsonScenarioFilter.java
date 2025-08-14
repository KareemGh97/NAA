package Utilities.Xray;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonScenarioFilter {
    public static ArrayNode filterScenarios(JsonNode rootNode, ObjectMapper objectMapper) {
        ArrayNode filteredFeatures = objectMapper.createArrayNode();

        if (rootNode.isArray()) {
            for (JsonNode feature : rootNode) {
                if (feature.has("elements")) {
                    Map<String, JsonNode> latestScenarios = new HashMap<>();
                    ArrayNode filteredElements = objectMapper.createArrayNode();

                    for (JsonNode element : feature.get("elements")) {
                        // Get the TEST_XRAY tag
                        String testXrayTag = getTestXrayTag(element.get("tags"));
                        if (testXrayTag != null) {
                            // Compare timestamps to determine the latest scenario
                            String currentTimestamp = element.get("start_timestamp").asText();
                            if (!latestScenarios.containsKey(testXrayTag)) {
                                latestScenarios.put(testXrayTag, element);
                            } else {
                                String existingTimestamp = latestScenarios.get(testXrayTag).get("start_timestamp").asText();
                                if (currentTimestamp.compareTo(existingTimestamp) > 0) {
                                    latestScenarios.put(testXrayTag, element);
                                }
                            }
                        }
                    }

                    // Add the latest scenarios to the filtered elements
                    for (JsonNode scenario : latestScenarios.values()) {
                        filteredElements.add(scenario);
                    }

                    // If the feature has valid elements, add it to the filtered features
                    if (filteredElements.size() > 0) {
                        ObjectNode filteredFeature = (ObjectNode) feature.deepCopy();
                        filteredFeature.set("elements", filteredElements);
                        filteredFeatures.add(filteredFeature);
                    }
                }
            }
        }

        return filteredFeatures;
    }

    private static String getTestXrayTag(JsonNode tagsNode) {
        if (tagsNode != null && tagsNode.isArray()) {
            for (JsonNode tag : tagsNode) {
                String tagValue = tag.get("name").textValue();
                if (tagValue.contains("TEST_XRAY-")) {
                    return tagValue; // Return the full tag (e.g., TEST_XRAY-123)
                }
            }
        }
        return null; // Return null if no TEST_XRAY tag is found
    }
}

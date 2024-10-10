package task3;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class Main {

    public static void main(String[] args) {
                String valuesFilePath = args[0];
                String testsFilePath = args[1];
                String reportFilePath = args[2];

                try {
                    String valuesContent = new String(Files.readAllBytes(Paths.get(valuesFilePath)));
                    String testsContent = new String(Files.readAllBytes(Paths.get(testsFilePath)));
                    JSONObject valuesJson = new JSONObject(valuesContent);
                    JSONObject testsJson = new JSONObject(testsContent);
                    JSONObject reportJson = fillValues(testsJson, valuesJson);

                    Files.write(Paths.get(reportFilePath), reportJson.toString(4).getBytes());
                    System.out.println("Report generated successfully: " + reportFilePath);
                } catch (IOException e) {
                    System.err.println("Error reading or writing files: " + e.getMessage());
                }
            }

            private static JSONObject fillValues(JSONObject tests, JSONObject values) {
                JSONObject report = new JSONObject();

                for (String key : tests.keySet()) {
                    JSONObject testObject = tests.getJSONObject(key);
                    String testId = testObject.getString("id");

                    if (values.has(testId)) {
                        testObject.put("value", values.get(testId));
                    } else {
                        testObject.put("value", null);
                    }
                    if (testObject.has("subtests")) {
                        JSONArray subtests = testObject.getJSONArray("subtests");
                        for (int i = 0; i < subtests.length(); i++) {
                            JSONObject subtest = subtests.getJSONObject(i);
                            String subtestId = subtest.getString("id");

                            if (values.has(subtestId)) {
                                subtest.put("value", values.get(subtestId));
                            } else {
                                subtest.put("value", null);
                            }
                        }
                    }
                    report.put(key, testObject);
                }
                return report;
            }
        }



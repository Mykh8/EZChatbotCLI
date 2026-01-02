package api;

import config.Config;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class AiClient {
    private static final String API_URL = "https://api.groq.com/openai/v1/chat/completions";
    private static final String MODEL = "llama-3.3-70b-versatile";

    private final HttpClient client = HttpClient.newHttpClient();

    public String getResponse(String userMessage) {

        try {
            // Build request JSON body
            JSONObject json = new JSONObject();
            json.put("model", MODEL);

            JSONArray messages = new JSONArray();
            JSONObject message = new JSONObject();

            message.put("role", "user");
            message.put("content", userMessage);

            messages.put(message);

            json.put("messages", messages);


            // Build HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .version(HttpClient.Version.HTTP_2)
                    .header("Authorization", "Bearer " + Config.GROQ_API_KEY)
                    .header("Content-Type", "aplication/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                    .build();

            // Send request and receive a response
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            // DEBUG LOL
            if (Config.DEBUG) {
                System.out.println(": [DEBUG] - Status: " + response.statusCode());
            }

            // Parse response
            JSONObject responseObj = new JSONObject(response.body());
            JSONArray choices = responseObj.getJSONArray("choices");
            JSONObject firstChoice = choices.getJSONObject(0);
            JSONObject messageObj = firstChoice.getJSONObject("message");

            return messageObj.getString("content");

        } catch (Exception e) {
            if (Config.DEBUG) {
                e.printStackTrace();
            }
            return ": ERROR: Bot was not able to answer.";
        }
    }
}

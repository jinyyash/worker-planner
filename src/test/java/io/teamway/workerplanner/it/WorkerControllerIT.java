package io.teamway.workerplanner.it;

import io.teamway.workerplanner.WorkerplannerApplication;
import io.teamway.workerplanner.controller.WorkerController;
import io.teamway.workerplanner.model.Worker;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkerControllerIT {
    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();


    @Test
    public void testGetAllWorkers() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/v1/workers"), HttpMethod.GET, entity, String.class);

        String expected = "[{\"id\":2,\"name\":\"jinadi\",\"email\":\"jinyyash\",\"shifts\":[]},{\"id\":3,\"name\":\"jinadi peiris\",\"email\":\"jinyyash\",\"shifts\":[]}]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}

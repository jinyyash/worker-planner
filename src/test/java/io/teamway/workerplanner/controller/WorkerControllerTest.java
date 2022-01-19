package io.teamway.workerplanner.controller;

import io.teamway.workerplanner.model.Worker;
import io.teamway.workerplanner.service.WorkerService;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(WorkerController.class)
public class WorkerControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private WorkerService workerService;

    @Test
    public void getWorkers() throws Exception {
        Worker worker = new Worker(1l,"teamway","teamway@gmail.com");
        List<Worker> workers = Collections.singletonList(worker);
        Mockito.when(
                workerService.getWorkers()).thenReturn(workers);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/v1/workers").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "[{id:1,name:teamway,email:teamway@gmail.com,shifts:null}]";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void addWorker() throws Exception {
        Worker worker = new Worker(1l,"teamway","teamway@gmail.com");
        List<Worker> workers = Collections.singletonList(worker);
        Mockito.when(
                workerService.addWorker(worker)).thenReturn(worker);
        String exampleJson = "{\"name\":\"jinadi\",\"email\":\"jinyyash@gmail.com\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/worker")
                .accept(MediaType.APPLICATION_JSON).content(exampleJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
}

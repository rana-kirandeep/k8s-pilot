import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.rana.pilot.PilotApplication;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import javax.sound.sampled.Port;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@SpringBootTest(classes = PilotApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {ComponentTestInitilizer.class})
class FirstTest {

    @Autowired
    WireMockServer wireMockServer;

    @LocalServerPort
    private Integer port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void abc() throws JSONException {

        //https://0720f2d1-7d09-4872-a7d9-b6d51979b55b.mock.pstmn.io/helloworld

        wireMockServer.stubFor(
                WireMock.get(WireMock.urlEqualTo("/helloworld"))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBody("{\"name\":\"munish\"}"))
        );


    ResponseEntity<String> actualJSON = this.testRestTemplate.getForEntity("http://localhost:"+port+"/hello", String.class);

        String expectedJSONString="{\"name\":\"munish\"}";

        JSONAssert.assertEquals(expectedJSONString, actualJSON.getBody().toString(),true);


    }


    @Test
    public void abc1(){

        //https://0720f2d1-7d09-4872-a7d9-b6d51979b55b.mock.pstmn.io/helloworld

        wireMockServer.stubFor(
                WireMock.get(WireMock.urlEqualTo("/helloworld"))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withBody("{\"name\":\"Preeti\"}"))
        );


        ResponseEntity<String> result = this.testRestTemplate.getForEntity("http://localhost:"+port+"/hello", String.class);

        System.out.println("hello world"+result);

    }



}
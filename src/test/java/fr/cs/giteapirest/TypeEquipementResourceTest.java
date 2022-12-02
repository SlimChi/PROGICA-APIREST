package fr.cs.giteapirest;

import fr.cs.giteapirest.endpoint.TypeEquipementResource;
import jakarta.servlet.http.HttpServletResponse;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.jboss.resteasy.spi.Dispatcher;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class TypeEquipementResourceTest {
    MockHttpRequest request;
    MockHttpResponse response;
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
    POJOResourceFactory noDefaults = new POJOResourceFactory(TypeEquipementResource.class);

    @Test
    void getAll() throws URISyntaxException {
        dispatcher.getRegistry().addResourceFactory(noDefaults);

        {
            request = MockHttpRequest.post("/TypeEquipement");
            response = new MockHttpResponse();

            dispatcher.invoke(request, response);
            assertEquals(HttpServletResponse.SC_OK, response.getStatus());

        }
    }

    @Test
    void getbyId() throws URISyntaxException {
        dispatcher.getRegistry().addResourceFactory(noDefaults);

        {
            request = MockHttpRequest.get("/TypeEquipement/6");
            response = new MockHttpResponse();

            dispatcher.invoke(request, response);
            assertEquals(HttpServletResponse.SC_OK, response.getStatus());

        }
    }

    @Test
    void update() throws URISyntaxException {
        dispatcher.getRegistry().addResourceFactory(noDefaults);

        {
            request = MockHttpRequest.put("/TypeEquipement");
            response = new MockHttpResponse();

            dispatcher.invoke(request, response);
            assertEquals(HttpServletResponse.SC_OK, response.getStatus());

        }
    }

    @Test
    void insert() throws URISyntaxException {
        dispatcher.getRegistry().addResourceFactory(noDefaults);

        {
            request = MockHttpRequest.post("/TypeEquipement");
            response = new MockHttpResponse();

            dispatcher.invoke(request, response);
            assertEquals(HttpServletResponse.SC_OK, response.getStatus());

        }
    }

    @Test
    void delete() throws URISyntaxException {
        dispatcher.getRegistry().addResourceFactory(noDefaults);

        {
            request = MockHttpRequest.delete("/TypeEquipement");
            response = new MockHttpResponse();

            dispatcher.invoke(request, response);
            assertEquals(HttpServletResponse.SC_OK, response.getStatus());

        }
    }
}
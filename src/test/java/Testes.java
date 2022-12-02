import fr.cs.giteapirest.endpoint.MailResource;
import jakarta.servlet.http.HttpServletResponse;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.jboss.resteasy.plugins.server.resourcefactory.POJOResourceFactory;
import org.jboss.resteasy.spi.Dispatcher;
import org.junit.jupiter.api.Test;


import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testes {
    MockHttpRequest request;
    MockHttpResponse response;
    Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
    POJOResourceFactory noDefaults = new POJOResourceFactory(MailResource.class);

    @Test
    void direBonjour() throws UnsupportedEncodingException, URISyntaxException {


        dispatcher.getRegistry().addResourceFactory(noDefaults);

        {
            request = MockHttpRequest.get("/hello");
            response = new MockHttpResponse();

            dispatcher.invoke(request, response);
            assertEquals(HttpServletResponse.SC_OK, response.getStatus());
            assertEquals("Bonjour, Monde !", response.getContentAsString());
        }
    }

    @Test
    void direBonjourToi() throws UnsupportedEncodingException, URISyntaxException {

        dispatcher.getRegistry().addResourceFactory(noDefaults);
        request = MockHttpRequest.get("/hello/toto");
        response = new MockHttpResponse();

        dispatcher.invoke(request, response);
        assertEquals(HttpServletResponse.SC_OK, response.getStatus());
        assertEquals("Bonjour toto !", response.getContentAsString());
    }

}

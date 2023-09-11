package lt.codeacademy.javau5.autopart;



import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lt.codeacademy.javau5.autopartshop.security.AuthEntryPointJwt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.AuthenticationException;
import org.springframework.mock.web.MockHttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class AuthEntryPointJwtTest {

    private AuthEntryPointJwt authEntryPointJwt;
    private HttpServletRequest request;
    private MockHttpServletResponse response;
    private AuthenticationException authException;

    @BeforeEach
    public void setUp() {
        authEntryPointJwt = new AuthEntryPointJwt();
        request = mock(HttpServletRequest.class);
        response = new MockHttpServletResponse();
        authException = mock(AuthenticationException.class);
    }

    @Test
    public void testCommence() throws Exception {
        when(authException.getMessage()).thenReturn("Test Exception Message");
        when(request.getServletPath()).thenReturn("/test-path");

        authEntryPointJwt.commence(request, response, authException);

        // Check response status
        assertEquals(HttpServletResponse.SC_UNAUTHORIZED, response.getStatus());

        // Deserialize response content
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> responseBody = mapper.readValue(response.getContentAsString(), Map.class);

        // Check response body
        assertEquals(HttpServletResponse.SC_UNAUTHORIZED, responseBody.get("status"));
        assertEquals("Unauthorized", responseBody.get("error"));
        assertEquals("Test Exception Message", responseBody.get("message"));
        assertEquals("/test-path", responseBody.get("path"));
    }
}

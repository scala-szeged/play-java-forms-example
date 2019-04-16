package controllers;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import play.test.WithApplication;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;

/**
 * Tests form processing.
 * <p>
 * https://www.playframework.com/documentation/latest/JavaFunctionalTest
 */
public class WidgetControllerTest extends WithApplication {

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method(GET)
                .uri("/");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    @Test
    public void testListWidgets() {
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method(GET)
                .uri("/widgets");

        Result result = route(app, request);
        assertEquals(OK, result.status());
    }

    @Test
    public void testCreateWidget() {
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method(POST)
                .bodyForm(ImmutableMap.of("name", "widget 6", "price", "6"))
                .uri("/widgets");

        Result result = route(app, request);
        assertEquals(SEE_OTHER, result.status());
    }

    @Test
    public void testCreateWidgetWithInvalidData() {
        Http.RequestBuilder request = Helpers.fakeRequest()
                .method(POST)
                .bodyForm(ImmutableMap.of("name", "widget 6", "price", "not a number"))
                .uri("/widgets");

        try {
            Result result = route(app, request);
            fail("testCreateWidgetWithInvalidData should fail if price is 'not a number', but the result was " + result);
        } catch (Exception ex) {
            long count = Arrays.stream(ex.getStackTrace()).filter(e -> e.getMethodName().equals("reportBadRequest") && e.getClassName().equals("controllers.WidgetController")).count();
            assertEquals(1L, count);
        }
    }

}

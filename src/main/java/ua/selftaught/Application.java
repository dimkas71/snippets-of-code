package ua.selftaught;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.runtime.Micronaut;
import io.micronaut.views.View;

@Controller("/")
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @View("home")
    @Get()
    public HttpResponse index(@QueryValue("name") String name) {
        return HttpResponse.ok(CollectionUtils.mapOf("name", name));
    }

}

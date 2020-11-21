package ua.selftaught;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.runtime.Micronaut;
import io.micronaut.views.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.selftaught.model.Snippet;
import ua.selftaught.repository.SnippetRepository;

import javax.inject.Inject;

@Controller("/")
public class Application {

    private final static Logger LOG = LoggerFactory.getLogger(Application.class);

    @Inject
    private SnippetRepository repository;

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @View("home")
    @Get()
    public HttpResponse index(@QueryValue("name") String name) {
        return HttpResponse.ok(CollectionUtils.mapOf("name", name));
    }

    @Post("/snippet")
    public HttpResponse<String> loadData(@Body Snippet snippet) {
        LOG.info("The value of snippet => {}", snippet);
        repository.save(snippet);
        return HttpResponse.ok("OK");
    }


    @Get("/demo")
    public HttpResponse<String> demo(@QueryValue("param") String value) {
        LOG.info("The value of param => {}", value);
        return HttpResponse.ok(String.format("Value of param => %s", value));
    }



}

package ua.selftaught.controller;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;
import ua.selftaught.model.Snippet;
import ua.selftaught.repository.SnippetRepository;

import javax.inject.Inject;
import java.util.List;

@Controller("snippet")
public class SnippetController {

    private SnippetRepository repository;

    @Inject
    public SnippetController(SnippetRepository repository) {
        this.repository = repository;
    }


    @View("snippet/list")
    @Get("list")
    public HttpResponse list() {
        List<Snippet> snippets = repository.findAll();
        return HttpResponse.ok(CollectionUtils.mapOf("snippets", snippets));
    }

}

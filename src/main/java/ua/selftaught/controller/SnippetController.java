package ua.selftaught.controller;

import io.micronaut.core.util.CollectionUtils;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.views.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.selftaught.model.Snippet;
import ua.selftaught.repository.SnippetRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Controller("snippet")
public class SnippetController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SnippetController.class.getSimpleName());

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

    @View("snippet/edit")
    @Get("edit/{id}")
    public HttpResponse edit(@PathVariable("id") Long id) {
        Optional<Snippet> found = repository.findById(id);
        if (found.isPresent()) {
            return HttpResponse.ok(CollectionUtils.mapOf("snippet", found.get()));
        } else {
            return HttpResponse.notFound("Page not found");
        }
    }

    @Post("update")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String update(@Body("snippet") Snippet snippet) {
        LOGGER.info("The value of snippet is {}", snippet);
        repository.save(snippet);
        return "redirect:/snippet/list";
    }

}

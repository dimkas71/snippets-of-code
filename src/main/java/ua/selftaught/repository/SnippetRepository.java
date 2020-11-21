package ua.selftaught.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import ua.selftaught.model.Snippet;

@Repository
public interface SnippetRepository  extends JpaRepository<Snippet, Long> {
}

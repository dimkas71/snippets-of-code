package ua.selftaught.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
public class Snippet {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    @Lob
    private String source;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Snippet() {    }

    public Snippet(Long id, String description, String source) {
        this.id = id;
        this.description = description;
        this.source = source;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getSource() {
        return source;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Snippet.class.getSimpleName() + "(", ")")
                .add("id=" + id)
                .add("description='" + description + "'")
                .add("source='" + source + "'")
                .toString();
    }
}

package App.model;

import org.springframework.stereotype.Component;

@Component
public interface BookDao {
    void save(Book book);
    Book get(Long id);
}

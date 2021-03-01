package App;

import App.model.Book;
import App.model.BookDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class SpringJpaApplication {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJpaApplication.class);
        BookDao bookDao = ctx.getBean(BookDao.class);
        Book book = new Book("1234", "Robertinio", "Java jest spoko");
        bookDao.save(book);

        Book book1 = bookDao.get(1L);
        System.out.println(book1);
        ctx.close();

    }
}

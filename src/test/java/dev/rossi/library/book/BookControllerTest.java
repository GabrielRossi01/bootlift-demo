package dev.rossi.library.book;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private BookRepository books;

    @Test
    void listsBooks() throws Exception {
        given(books.findAll()).willReturn(List.of(new Book("Dom Casmurro", "Machado de Assis")));

        mvc.perform(get("/books"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].title").value("Dom Casmurro"));
    }
}

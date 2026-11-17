package dev.rossi.library.book;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookController.class)
class BookControllerCreateTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private BookRepository books;

    @Test
    void createsBook() throws Exception {
        given(books.save(any())).willAnswer(call -> call.getArgument(0));

        mvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Vidas Secas\",\"author\":\"Graciliano Ramos\"}"))
            .andExpect(status().isCreated());
    }
}

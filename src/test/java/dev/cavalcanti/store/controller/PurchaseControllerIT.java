package dev.cavalcanti.store.controller;


import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PurchaseControllerIT {

    @Autowired
    private MockMvc mvc;

    @Test
    public void find()
            throws Exception {

        this.mvc.perform(get("/purchases"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].customer.email").value("joao@test.com"))
                .andExpect(jsonPath("$[1].customer.email").value("maria@test.com"))
                .andExpect(jsonPath("$[2].customer.email").value("carlos@test.com"));

        this.mvc.perform(get("/purchases?productCode=PS5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].customer.email").value("maria@test.com"))
                .andExpect(jsonPath("$[1].customer.email").value("carlos@test.com"));

        this.mvc.perform(get("/purchases?customerEmail=carlos@test.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].product.code").value("PS5"));

        this.mvc.perform(get("/purchases?productMinPrice=3000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].product.code").value("PS5"))
                .andExpect(jsonPath("$[1].product.code").value("PS5"));

        this.mvc.perform(get("/purchases?productMaxPrice=3000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].product.code").value("NINTENDO-SWITCH"));

        this.mvc.perform(get("/purchases" +
                        "?productCode=NINTENDO-SWITCH" +
                        "&customerEmail=joao@test.com" +
                        "&productMinPrice=1899" +
                        "&productMaxPrice=1899"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].product.code").value("NINTENDO-SWITCH"));

    }

}


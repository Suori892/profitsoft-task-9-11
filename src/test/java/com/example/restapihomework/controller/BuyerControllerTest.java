package com.example.restapihomework.controller;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.restapihomework.RestApiHomeworkApplication;
import com.example.restapihomework.model.Buyer;
import com.example.restapihomework.repository.BuyerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    classes = RestApiHomeworkApplication.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
public class BuyerControllerTest {

  private final MockMvc mockMvc;
  private final BuyerRepository buyerRepository;

  @BeforeEach
  void setup(){
    buyerRepository.deleteAll();
  }

  @Autowired
  public BuyerControllerTest(MockMvc mockMvc, BuyerRepository buyerRepository) {
    this.mockMvc = mockMvc;
    this.buyerRepository = buyerRepository;
  }

  @Test
  void checkFindAllBuyers() throws Exception {
    Buyer buyer1 = new Buyer();
    buyer1.setName("Alex");
    buyer1.setEmail("alex13@gmail.com");

    Buyer buyer2 = new Buyer();
    buyer2.setName("Michael");
    buyer2.setEmail("michael513@gmail.com");

    buyerRepository.save(buyer1);
    buyerRepository.save(buyer2);

    mockMvc.perform(MockMvcRequestBuilders.get("/api/buyer/all")
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect((ResultMatcher) jsonPath("$[0].name", is("Alex")))
        .andExpect((ResultMatcher) jsonPath("$[1].name", is("Michael")))
        .andExpect((ResultMatcher) jsonPath("$[0].email", is("alex13@gmail.com")))
        .andExpect((ResultMatcher) jsonPath("$[1].email", is("michael513@gmail.com")));
  }
}

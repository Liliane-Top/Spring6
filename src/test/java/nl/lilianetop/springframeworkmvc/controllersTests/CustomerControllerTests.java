package nl.lilianetop.springframeworkmvc.controllersTests;

import nl.lilianetop.springframeworkmvc.controllers.CustomerController;
import nl.lilianetop.springframeworkmvc.models.Customer;
import nl.lilianetop.springframeworkmvc.services.CustomerService;
import nl.lilianetop.springframeworkmvc.services.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService service;

    CustomerServiceImpl customerService = new CustomerServiceImpl();


    @Test
    void call_listCustomers() throws Exception {
        given(service.listCustomers()).willReturn(customerService.listCustomers());

        mockMvc.perform(get("/api/v1/customer")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.length()", is(3)));


    }

    @Test
    void call_customerById() throws Exception {
        Customer testCustomer = customerService.listCustomers().get(0);

        given(service.getCustomerById(testCustomer.getId())).willReturn(testCustomer);

        mockMvc.perform(get("/api/v1/customer/" + testCustomer.getId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(testCustomer.getId().toString())))
                .andExpect(jsonPath("$.customerName", is(testCustomer.getCustomerName())));
    }
}

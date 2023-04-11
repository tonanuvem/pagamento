package padroesgof.padroesgof;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoPagamentoTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/pagamento?tipo_pagamento=CARTAO&valor_pagamento=500")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("sucesso")));
		this.mockMvc.perform(get("/pagamento?tipo_pagamento=CARTAO&valor_pagamento=1500")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("não autorizado")));
	}
}

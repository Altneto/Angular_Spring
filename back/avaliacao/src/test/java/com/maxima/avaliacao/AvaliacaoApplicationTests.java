package com.maxima.avaliacao;

import static org.assertj.core.api.Assertions.assertThat;
import com.maxima.avaliacao.services.ClienteService;
import com.maxima.avaliacao.vo.ClienteRecebeVO;
import com.maxima.avaliacao.vo.ClienteVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

@SpringBootTest
class AvaliacaoApplicationTests {

	@Autowired
	private ClienteService clienteService;

	@Test
	public void testarCadastroClienteComSucesso() {
		// cenário
		ClienteRecebeVO vo = new ClienteRecebeVO();
		vo.setNome("Atacadao");
		vo.setCnpj("74896325000170");
		vo.setEndereco("-16.751629, -49.241795");

		// ação
		ClienteVO clienteVO = new ClienteVO();
		clienteVO = clienteService.save(vo);

		// validação
		assertThat(clienteVO).isNotNull();
		assertThat(clienteVO.getCodigo()).isNotNull();
		assertThat(clienteVO.getNome()).isNotNull();
		assertThat(clienteVO.getEndereco()).isNotNull();
	}
}

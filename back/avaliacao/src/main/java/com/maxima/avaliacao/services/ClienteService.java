package com.maxima.avaliacao.services;

import com.maxima.avaliacao.exceptions.DataAlreadyExistsException;
import com.maxima.avaliacao.exceptions.DataNotFoundException;
import com.maxima.avaliacao.models.Cliente;
import com.maxima.avaliacao.models.Endereco;
import com.maxima.avaliacao.repositories.ClienteRepository;
import com.maxima.avaliacao.vo.ClienteCompletoVO;
import com.maxima.avaliacao.vo.ClienteRecebeVO;
import com.maxima.avaliacao.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoService enderecoService;

    public Page<ClienteCompletoVO> search(
            String searchTerm,
            int page,
            int size
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        int length = clienteRepository.findAll().size();
        Page<Cliente> clientes = clienteRepository.search(searchTerm.toLowerCase(), pageRequest);
        List<ClienteCompletoVO> vos = new ArrayList<>();
        clientes.forEach((cliente -> {
            vos.add(clienteToFullVo(cliente));
        }));
        Page<ClienteCompletoVO> voPage = new PageImpl<>(vos, pageRequest, length);
        return voPage;
    }

    public ClienteVO findById(Long codigo) {
        Optional<Cliente> cliente = Optional.ofNullable(clienteRepository.findById(codigo).orElseThrow(() -> new DataNotFoundException()));

        return clienteToVo(cliente.get());
    }

    public ClienteVO save(ClienteRecebeVO vo) {
        clienteRepository.findByCnpj(vo.getCnpj()).ifPresent((c) -> {
            throw new DataAlreadyExistsException();
        });

        Endereco endereco = enderecoService.stringToEndereco(vo.getEndereco());

        Cliente cliente = new Cliente(vo.getNome(), vo.getCnpj(), endereco);

        clienteRepository.save(cliente);

        return new ClienteVO(cliente.getCodigo(), cliente.getNome(), cliente.getEndereco());
    }

    private ClienteCompletoVO clienteToFullVo (Cliente cliente) {
        return new ClienteCompletoVO(cliente.getCodigo(), cliente.getNome(), cliente.getCnpj(), cliente.getEndereco());
    }

    private ClienteVO clienteToVo (Cliente cliente) {
        return new ClienteVO(cliente.getCodigo(), cliente.getNome(), cliente.getEndereco());
    }


}

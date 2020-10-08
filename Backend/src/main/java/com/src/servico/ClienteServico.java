package com.src.servico;

import com.src.dominio.Cliente;
import com.src.servico.excecao.RegraNegocioException;
import com.src.servico.mapper.ClienteMapper;
import com.src.repositorio.ClienteRepositorio;
import com.src.servico.dto.ClienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ClienteServico {

	private final ClienteRepositorio clienteRepositorio;
	private final ClienteMapper clienteMapper;

	public List<ClienteDTO> listar() {
		List<Cliente> clientes = clienteRepositorio.findAll();
		List<ClienteDTO> clientesDto = clienteMapper.toDto(clientes);
		return clientesDto;
	}

	public ClienteDTO buscar(Integer id) {
		Cliente cliente = clienteRepositorio.findById(id)
				.orElseThrow(()-> new RegraNegocioException("Cliente não encontrado"));
		ClienteDTO clienteDto = clienteMapper.toDto(cliente);
		return clienteDto;
	}

	public ClienteDTO adicionar(ClienteDTO clienteDto) {
		Cliente cliente = clienteMapper.toEntity(clienteDto);
		Cliente clienteSalvo = clienteRepositorio.save(cliente);
		return clienteMapper.toDto(clienteSalvo);
	}

	public ClienteDTO atualizar(ClienteDTO clienteDto) {
		Cliente cliente = clienteMapper.toEntity(clienteDto);
		Cliente clienteSalvo = clienteRepositorio.save(cliente);
		return clienteDto;
	}

	public void remover(Integer id) {
		clienteRepositorio.deleteById(id);
	}
}

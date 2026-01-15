package dio.service.impl;

import dio.model.Cliente;
import dio.model.Endereco;
import dio.repository.ClienteRepository;
import dio.repository.EnderecoRepository;
import dio.service.ClienteService;
import dio.service.ViaCepService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton<b>.
 * 
 * @author marcusteixeirabr
 */
@Service
public class ClienteServiceImpl implements ClienteService {    

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        // Buscar todos os clientes.
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        // Buscar cliente  por id.
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    
    @Override
    public void atualizar(Long id, Cliente cliente) {
        // Buscar cliente por ID, caso exista:
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            cliente.setId(id);
            salvarClienteComCep(cliente);
        }
    }
    
    @Override
    public void deletar(Long id) {
        // Deletar cliente por ID.
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereço do cliente já existe (pelo CEP).
        String cep = cliente.getEndereco().getCep().replaceAll("-", "");
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o Endereço.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        // Inserir o Cliente, vinculando o Endereço (novo ou existente).
        clienteRepository.save(cliente);
    }

}

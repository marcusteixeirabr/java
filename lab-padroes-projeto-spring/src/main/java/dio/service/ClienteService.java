package dio.service;

import dio.model.Cliente;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio  de cliente. Com
 * isso, se necessário, podemos ter múltiplas  implementações dessa mesma
 * interface
 * 
 * @author marcusteixeirabr
 */
public interface ClienteService {
    Iterable<Cliente> buscarTodos();
    Cliente buscarPorId(Long id);
    void inserir(Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar(Long id);
}
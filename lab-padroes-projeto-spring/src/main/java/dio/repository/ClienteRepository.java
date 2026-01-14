package dio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dio.model.Cliente;

// Opcionalmente, para ficar mais claro, você pode colocar aqui a anotação @Repository
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}

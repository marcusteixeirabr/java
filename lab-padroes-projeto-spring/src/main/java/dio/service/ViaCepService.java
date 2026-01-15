package dio.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;

import dio.model.Endereco;

/**
 * Client HTTP, criado via <b>OpenFeingn</b>, para consumo da API do
 * <b>ViaCEP</b>.
 * 
 * @see <a href="https://viacep.com.br/">ViaCEP</a>
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">OpenFeign</a>
 * 
 * @author marcusteixeirabr
 */
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    // @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);

}

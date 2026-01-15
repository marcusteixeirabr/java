package dio.bootcamp.springboot.primeiros_passos.app;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {
    public int somar(int a, int b) {
        return a + b;
    }
}
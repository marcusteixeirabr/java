package dio.handler;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String menssagem, Object... params) {
        super(String.format(menssagem, params));
    }

}

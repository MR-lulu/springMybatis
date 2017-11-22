package exception;

/**
 * Created by keruyun on 2017/11/1.
 */
public class NoUserException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoUserException(String msg){
        super(msg);
    }
}

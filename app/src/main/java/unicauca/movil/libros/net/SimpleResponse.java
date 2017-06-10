package unicauca.movil.libros.net;

/**
 * Created by darfe on 9/06/2017.
 */

public class SimpleResponse {

    boolean success;
    String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

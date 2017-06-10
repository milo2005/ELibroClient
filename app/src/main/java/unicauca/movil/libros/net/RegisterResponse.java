package unicauca.movil.libros.net;

/**
 * Created by darfe on 9/06/2017.
 */

public class RegisterResponse extends SimpleResponse {

    boolean exist;

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
}

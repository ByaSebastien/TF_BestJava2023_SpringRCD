package be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.user;

public class UserPasswordException extends UserException{

    public UserPasswordException() {
        super("Wrong password.");
    }

    public UserPasswordException(String message) {
        super(message);
    }
}

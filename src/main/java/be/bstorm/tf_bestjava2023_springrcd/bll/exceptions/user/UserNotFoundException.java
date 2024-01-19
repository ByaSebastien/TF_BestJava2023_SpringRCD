package be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.user;

public class UserNotFoundException extends UserException{

    public UserNotFoundException() {
        super("User not found.");
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}

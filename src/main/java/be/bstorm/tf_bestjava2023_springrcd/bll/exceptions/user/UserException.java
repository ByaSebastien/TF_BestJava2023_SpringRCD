package be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.user;

import be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.SpringRCDException;

public class UserException extends SpringRCDException {
    public UserException(String message) {
        super(message);
    }
}

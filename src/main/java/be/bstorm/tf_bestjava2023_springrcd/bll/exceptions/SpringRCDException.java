package be.bstorm.tf_bestjava2023_springrcd.bll.exceptions;

public class SpringRCDException extends RuntimeException{

    public SpringRCDException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        StackTraceElement element = this.getStackTrace()[0];
        return this.getClass().getSimpleName() + " throw in " + element.getFileName() + " in method " + element.getMethodName() + " at line number " + element.getLineNumber() + ".";
    }
}

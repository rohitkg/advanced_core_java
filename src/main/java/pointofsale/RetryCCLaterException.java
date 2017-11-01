package pointofsale;

public class RetryCCLaterException extends Exception {

  public RetryCCLaterException() {
  }

  public RetryCCLaterException(String message) {
    super(message);
  }

  public RetryCCLaterException(String message, Throwable cause) {
    super(message, cause);
  }

  public RetryCCLaterException(Throwable cause) {
    super(cause);
  }

  public RetryCCLaterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}

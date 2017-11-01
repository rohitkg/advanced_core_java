package pointofsale;

class ModemDidNotConnectException extends Exception {

  public ModemDidNotConnectException() {
  }

  public ModemDidNotConnectException(String message) {
    super(message);
  }

  public ModemDidNotConnectException(String message, Throwable cause) {
    super(message, cause);
  }

  public ModemDidNotConnectException(Throwable cause) {
    super(cause);
  }

  public ModemDidNotConnectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}

package pointofsale;

public interface ModemDialler {
  void dialModem(String number) throws ModemDidNotConnectException;
}

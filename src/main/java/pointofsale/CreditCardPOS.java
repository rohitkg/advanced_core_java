package pointofsale;

import java.net.SocketException;

public class CreditCardPOS {

  private ModemDialler dialler;
  SocketUtil socketUtil;

  private int mode = 2;

  public int getPaid() {
    try {
      authorizePayment("", 0);
    } catch (RetryCCLaterException ex) {
      // ???
    } catch (LaughInFaceException e) {

    }
    return 0;
  }

  public int authorizePayment(String cc, int amount) throws RetryCCLaterException, LaughInFaceException {
    try {
      if (mode == 1) {
        dialler.dialModem("123 4567");
      } else {
        socketUtil.networkStuff();
      }
    } catch (ModemDidNotConnectException | SocketException ex) {
      throw new RetryCCLaterException(ex);
    }
    return 0;
  }
}

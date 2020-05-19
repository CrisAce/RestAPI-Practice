package Utils;

import org.test.automation.world.restul.booker.herokuapp.com.AuthCreateTokenPOST;

public class RetriveTokenId {

    public static void main(String[] args) {


       String tocken = AuthCreateTokenPOST.getToken();
       System.out.println(tocken);

    }
}

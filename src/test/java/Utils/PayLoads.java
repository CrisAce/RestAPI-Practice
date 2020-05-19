package Utils;

public class PayLoads {

    public static String createBookingPayLoad(){

        return "{\n" +
                "    \"firstname\" : \"Vali\",\n" +
                "    \"lastname\" : \"Tone\",\n" +
                "    \"totalprice\" : 380,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2020-08-30\",\n" +
                "        \"checkout\" : \"2020-09-10\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
    }

    public static String authCreateTokenPOSTPayLoad(){

        return "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
    }

    public static String updateBookingPUTPayLoad(){

        return "{\n" +
                "        \"firstname\": \"Catalina\",\n" +
                "        \"lastname\": \"Ion\",\n" +
                "        \"totalprice\": 1400,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2020-08-30\",\n" +
                "            \"checkout\": \"2020-09-10\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";
    }

    public static String addBookPayLoad(String isbn, String aisle){

        return  "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+ isbn +"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}";
    }

    public static String deleteBookPayLoad(){

        return "{\n" +
                " \n" +
                "\"ID\" : \"cris187\"\n" +
                " \n" +
                "} \n";
    }
}

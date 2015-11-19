/**
 * Created by MAShahsavand on 11/19/15 AD.
 */

import org.json.simple.parser.JSONParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class JsonParser {

    private static final String filePath = "deposits.json";

    private static List<Deposit> deposits = new ArrayList<Deposit>();

    public static void main(String[] args) {

        try {

            // read the json file
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            //System.out.println("here");
            // get port number
            Integer port = (Integer) jsonObject.get("port");

            // get an array from the JSON object

            JSONArray deps= (JSONArray) jsonObject.get("deposits");

            // take the elements of the json array
            for(int i=0; i<deps.size(); i++){
                System.out.println("The " + i + " element of the array: " + deps.get(i));
            }
            Iterator i = deps.iterator();

            // take each value from the json array separately

            while (i.hasNext()) {
                System.out.println("in while...");
                JSONObject innerObj = (JSONObject) i.next();

                String name = (String)innerObj.get("customer");
                Integer id = (Integer)innerObj.get("id");
                BigDecimal initBal = (BigDecimal) (innerObj.get("initialBalance"));
                BigDecimal upBal = (BigDecimal) innerObj.get("upperBound");



                Deposit inputDeps = new Deposit(name, id, initBal, upBal);

                deposits.add(inputDeps);


                System.out.println("Name: "+ inputDeps.getOwnerName() + " ; ID: " + inputDeps.getAccountId()
                                + "; Initial Balance: " + inputDeps.getInitialBalance() + "; Upper Bound: " + inputDeps.getUpperBound());
            }

            // handle a structure into the json object
            JSONObject outLog = (JSONObject) jsonObject.get("outLog");

            //System.out.println("Into job structure, name: " + structure.get("name"));

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

}


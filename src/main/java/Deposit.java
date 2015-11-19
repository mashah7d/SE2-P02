import java.math.BigDecimal;

/**
 * Created by MAShahsavand on 11/19/15 AD.
 */
public class Deposit {

    private String ownerName;
    private Integer accountId;
    private BigDecimal initialBalance;
    private BigDecimal upperBound;

    Deposit(String name, Integer id, BigDecimal initBal, BigDecimal upBound){
        ownerName = name;
        accountId = id;
        initialBalance = initBal;
        upperBound = upBound;
    }

    String getOwnerName(){ return ownerName; }
    Integer getAccountId(){ return accountId; }
    BigDecimal getInitialBalance(){ return initialBalance; }
    BigDecimal getUpperBound(){ return upperBound; }

}

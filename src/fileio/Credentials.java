package fileio;

/**
 * Contains all the information (credentials)
 * for a user
 */
public class Credentials {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    /**
     * Copy constructor
     * @param credentials credentials that I want to copy
     */
    public Credentials(final Credentials credentials) {
        this.name = credentials.getName();
        this.password = credentials.getPassword();
        this.accountType = credentials.getAccountType();
        this.country = credentials.getCountry();
        this.balance = credentials.getBalance();
    }
    public Credentials() {

    }
    public Credentials(final String name, final String password, final String accountType,
                       final String country, final String balance) {
        this.name = name;
        this.password = password;
        this.accountType = accountType;
        this.country = country;
        this.balance = balance;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name new value
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password new value
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType new value
     */
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country new value
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * @return balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance new value
     */
    public void setBalance(final String balance) {
        this.balance = balance;
    }
}

package approach.events;

import approach.CurrentPage;

/**
 * Class that contains the implementations for buy actions
 */
public final class BuyFeatures {

    public static final int PRICE_ACCOUNT = 10;
    private BuyFeatures() { }

    /**
     * Transform part of the balance in tokens
     * @param currentPage the current page I'm on
     * @param count the number of tokens to be purchased
     */
    public static void buyTokens(final CurrentPage currentPage, final int count) {

         String balanceUser = currentPage.getCurrentUser().getCredentials().getBalance();
         String newBalance = Integer.toString(Integer.parseInt(balanceUser) - count);
         currentPage.getCurrentUser().getCredentials().setBalance(newBalance);

         int tokensUser = currentPage.getCurrentUser().getTokensCount();
         currentPage.getCurrentUser().setTokensCount(tokensUser + count);
    }

    /**
     * Decrease number of tokens by 10 and receive Premium Account
     * @param currentPage the current page I'm on
     */
    public static void buyPremiumAccount(final CurrentPage currentPage) {

        currentPage.getCurrentUser().getCredentials().setAccountType("premium");
        int tokensUser = currentPage.getCurrentUser().getTokensCount();
        currentPage.getCurrentUser().setTokensCount(tokensUser - PRICE_ACCOUNT);
    }
}

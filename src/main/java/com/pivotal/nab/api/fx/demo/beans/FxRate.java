package com.pivotal.nab.api.fx.demo.beans;

public class FxRate
{
    private String buyCurrency;
    private String sellCurrency;
    private String currentBuyRate;
    private String currentSellRate;
    private String previousBuyRate;
    private String previousSellRate;

    public FxRate()
    {
    }

    public String getBuyCurrency() {
        return buyCurrency;
    }

    public void setBuyCurrency(String buyCurrency) {
        this.buyCurrency = buyCurrency;
    }

    public String getSellCurrency() {
        return sellCurrency;
    }

    public void setSellCurrency(String sellCurrency) {
        this.sellCurrency = sellCurrency;
    }

    public String getCurrentBuyRate() {
        return currentBuyRate;
    }

    public void setCurrentBuyRate(String currentBuyRate) {
        this.currentBuyRate = currentBuyRate;
    }

    public String getCurrentSellRate() {
        return currentSellRate;
    }

    public void setCurrentSellRate(String currentSellRate) {
        this.currentSellRate = currentSellRate;
    }

    public String getPreviousBuyRate() {
        return previousBuyRate;
    }

    public void setPreviousBuyRate(String previousBuyRate) {
        this.previousBuyRate = previousBuyRate;
    }

    public String getPreviousSellRate() {
        return previousSellRate;
    }

    public void setPreviousSellRate(String previousSellRate) {
        this.previousSellRate = previousSellRate;
    }
}

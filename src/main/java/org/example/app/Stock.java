package org.example.app;


public class Stock {

    private Long id;

    private String companyName;

    private int currentPrice;

    private int totalShares;

    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getTotalShares() {
        return totalShares;
    }

    public void setTotalShares(int totalShares) {
        this.totalShares = totalShares;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Stock(String companyName, int currentPrice, int totalShares, String userName) {
        this.companyName = companyName;
        this.currentPrice = currentPrice;
        this.totalShares = totalShares;
        this.userName = userName;
    }
}
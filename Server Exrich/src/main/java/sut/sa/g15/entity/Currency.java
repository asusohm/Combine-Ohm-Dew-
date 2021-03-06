package sut.sa.g15.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Currency {
    @Id
    @Column(name = "CURRENCY_CODE")
    private @NonNull
    String currencyCode;
    private @NonNull
    String currencyName;


    // OneToMany with Country
    // OneToMany with ExchangeRate


    public Currency() {
    }

    public Currency(String currencyCode, String currencyName) {
        this.currencyCode = currencyCode;
        this.currencyName = currencyName;

    }


    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }


}

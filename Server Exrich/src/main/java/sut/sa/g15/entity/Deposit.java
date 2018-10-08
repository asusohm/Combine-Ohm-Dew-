package sut.sa.g15.entity;

import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Deposit {
    @Id
    @GeneratedValue
    @Column(name = "DEPOSIT_ID")
    private @NonNull
    Long dopositID;
    private @NonNull
    Double depositAmount;

    public Deposit() {
    }

    public Deposit(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public Long getDopositID() {
        return dopositID;
    }

    public void setDopositID(Long dopositID) {
        this.dopositID = dopositID;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }
}

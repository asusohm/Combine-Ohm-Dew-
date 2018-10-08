package sut.sa.g15.entity;

import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Withdraw implements Serializable {

    @Id
    @Column(name = "WITHDRAW_ID")
    @GeneratedValue
    private @NonNull
    Long withdrawID;
    private @NonNull
    Double withdrawAmount;


    public Withdraw() {
    }

    public Withdraw(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public Long getWithdrawID() {
        return withdrawID;
    }

    public void setWithdrawID(Long withdrawID) {
        this.withdrawID = withdrawID;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}

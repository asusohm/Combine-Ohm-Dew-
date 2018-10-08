package sut.sa.g15.entity;

import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Position {
    @Id
    @GeneratedValue
    @Column(name = "POSITION_ID")
    private @NonNull
    Long positionID;
    private @NonNull
    String positionName;
    private @NonNull
    String positionSymbol;

    public Position() {
    }

    public Position(String positionName, String positionSymbol) {
        this.positionName = positionName;
        this.positionSymbol = positionSymbol;
    }

    public String getPositionSymbol() {
        return positionSymbol;
    }

    public void setPositionSymbol(String positionSymbol) {
        this.positionSymbol = positionSymbol;
    }

    public Long getPositionID() {
        return positionID;
    }

    public void setPositionID(Long positionID) {
        this.positionID = positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}

package com.infoworld.model;

import javax.persistence.*;

@Entity
@Table(name="atm")
public class Atm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atmId")
    private Integer atmId;

    @Column(name = "banknote_1")
    private Integer banknote1;

    @Column(name = "banknote_5")
    private Integer banknote5;

    @Column(name = "banknote_10")
    private Integer banknote10;

    @Column(name = "banknote_50")
    private Integer banknote50;

    @Column(name = "banknote_100")
    private Integer banknote100;

    public Integer getAtmId() {
        return atmId;
    }

    public void setAtmId(Integer atmId) {
        this.atmId = atmId;
    }

    public Integer getBanknote1() {
        return banknote1;
    }

    public void setBanknote1(Integer banknote1) {
        this.banknote1 = banknote1;
    }

    public Integer getBanknote5() {
        return banknote5;
    }

    public void setBanknote5(Integer banknote5) {
        this.banknote5 = banknote5;
    }

    public Integer getBanknote10() {
        return banknote10;
    }

    public void setBanknote10(Integer banknote10) {
        this.banknote10 = banknote10;
    }

    public Integer getBanknote50() {
        return banknote50;
    }

    public void setBanknote50(Integer banknote50) {
        this.banknote50 = banknote50;
    }

    public Integer getBanknote100() {
        return banknote100;
    }

    public void setBanknote100(Integer banknote100) {
        this.banknote100 = banknote100;
    }
}

package com.infoworld.model;


public class Amount {

    private Integer banknote1;
    private Integer banknote5;
    private Integer banknote10;
    private Integer banknote50;
    private Integer banknote100;
    private Integer total;

    public Amount() {
        this.banknote1 = 0;
        this.banknote5 = 0;
        this.banknote10 = 0;
        this.banknote50 = 0;
        this.banknote100 = 0;
        this.total = 0;
    }

    public Amount(Integer banknote1, Integer banknote5, Integer banknote10, Integer banknote50, Integer banknote100) {
        this.banknote1 = banknote1;
        this.banknote5 = banknote5;
        this.banknote10 = banknote10;
        this.banknote50 = banknote50;
        this.banknote100 = banknote100;
        this.total = 1 * this.banknote1 + 5 * this.banknote5 + 10 * this.banknote10 + 50 * this.banknote50 + 100 * this.banknote100;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer b1, Integer b5, Integer b10, Integer b50, Integer b100) {
        this.total = 1 * b1 + 5 * b5 + 10 * b10 + 50 * b50 + b100 * 100;
    }
}

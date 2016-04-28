package com.plpgogogo.capsuleup.database;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "DATA".
 */
public class Data {

    private Long id;
    private int userid;
    private double money;
    private int mtype;
    private int patten;
    private String picture;
    private String tape;
    /** Not-null value. */
    private String tame;

    public Data() {
    }

    public Data(Long id) {
        this.id = id;
    }

    public Data(Long id, int userid, double money, int mtype, int patten, String picture, String tape, String tame) {
        this.id = id;
        this.userid = userid;
        this.money = money;
        this.mtype = mtype;
        this.patten = patten;
        this.picture = picture;
        this.tape = tape;
        this.tame = tame;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getMtype() {
        return mtype;
    }

    public void setMtype(int mtype) {
        this.mtype = mtype;
    }

    public int getPatten() {
        return patten;
    }

    public void setPatten(int patten) {
        this.patten = patten;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTape() {
        return tape;
    }

    public void setTape(String tape) {
        this.tape = tape;
    }

    /** Not-null value. */
    public String getTame() {
        return tame;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setTame(String tame) {
        this.tame = tame;
    }

}
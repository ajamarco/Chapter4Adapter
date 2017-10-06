package com.example.jamarco.chapter4adapter;

/**
 * Created by Jamarco on 10/4/2017.
 */

public class Car {
    private String mModel;
    private int mYear;
    private int mManufacturer;
    private boolean mGas;
    private boolean mEtanol;

    public Car(String model,int year, int manufacturer, boolean gas, boolean etanol){
        mModel = model;
        mYear = year;
        mManufacturer = manufacturer;
        mGas = gas;
        mEtanol = etanol;
    }


    public String getModel() {
        return mModel;
    }

    public int getYear() {
        return mYear;
    }

    public int getManufacturer() {
        return mManufacturer;
    }

    public boolean isGas() {
        return mGas;
    }

    public boolean isEtanol() {
        return mEtanol;
    }
}

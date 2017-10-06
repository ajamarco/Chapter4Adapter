package com.example.jamarco.chapter4adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jamarco on 10/4/2017.
 */

public class CarAdapter extends BaseAdapter {
    Context mContext;
    List<Car> mCars;

    public CarAdapter(Context context, List<Car> cars){
        mContext = context;
        mCars = cars;
    }

    @Override
    public int getCount() {
        return mCars.size();
    }

    @Override
    public Object getItem(int position) {
        return mCars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Car car = mCars.get(position);

        ViewHolder holder = null;

        //new View, we have to create a new one.
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_car,parent,false);
            holder = new ViewHolder();

            holder.imgLogo = (ImageView) convertView.findViewById(R.id.img_logo);
            holder.txtModel = (TextView) convertView.findViewById(R.id.txt_model);
            holder.txtYear = (TextView) convertView.findViewById(R.id.txt_year);
            holder.txtFuel = (TextView) convertView.findViewById(R.id.txt_fuel);

            convertView.setTag(holder);
        }   else { //reusable view. We just get the ViewHolder.
            holder = (ViewHolder)convertView.getTag();
        }

        View row = LayoutInflater.from(mContext).inflate(R.layout.item_car,parent,false);

        ImageView imgLogo = (ImageView) row.findViewById(R.id.img_logo);
        TextView txtModel = (TextView) row.findViewById(R.id.txt_model);
        TextView txtYear = (TextView) row.findViewById(R.id.txt_year);
        TextView txtFuel = (TextView) row.findViewById(R.id.txt_fuel);

        Resources res = mContext.getResources();
        TypedArray logos = res.obtainTypedArray(R.array.logos);
        imgLogo.setImageDrawable(logos.getDrawable(car.getManufacturer()));
        txtModel.setText(car.getModel());
        txtYear.setText(String.valueOf(car.getYear()));
        txtFuel.setText(
                (car.isGas() ? "G" : "") +
                (car.isEtanol() ? "E" : ""));

        return row;
    }

    static class ViewHolder{
        ImageView imgLogo;
        TextView txtModel;
        TextView txtYear;
        TextView txtFuel;
    }
}

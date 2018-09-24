package com.plusend.wheelview;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import java.util.List;

public class WheelAdapter extends RecyclerView.Adapter<WheelAdapter.WheelHolder> {

    class WheelHolder extends RecyclerView.ViewHolder {

        TextView name;
        AppCompatImageView imageView;

        WheelHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            imageView = itemView.findViewById(R.id.progress_bar);
        }
    }

    List<String> mList;
    public boolean cci;

    public WheelAdapter(List<String> list) {
        this.mList = list;
    }

    @NonNull
    @Override
    public WheelHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new WheelHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wheel_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WheelHolder wheelHolder, int i) {
        wheelHolder.name.setText(mList.get(i));
        wheelHolder.imageView.setVisibility(View.VISIBLE);
        if (i > 0 || cci) {
            wheelHolder.name.setTextColor(Color.parseColor("#8AFFFFFF"));
            wheelHolder.imageView.setImageResource(R.drawable.ajd);
            wheelHolder.imageView.clearAnimation();
            return;
        }
        wheelHolder.name.setTextColor(Color.parseColor("#DEFFFFFF"));
        wheelHolder.imageView.setImageResource(R.drawable.aje);
        Animation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(500);
        wheelHolder.imageView.startAnimation(rotateAnimation);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public final boolean contains(String str) {
        return mList.contains(str);
    }

    public final void add(String str) {
        mList.add(0, str);
    }

    public void clearData() {
        mList.clear();
    }

}

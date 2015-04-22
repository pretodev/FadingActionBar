package com.example.sapps.fadingactionbarexample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class FadingScrollView extends ScrollView {

    private Drawable mActionBackground;
    private ActionBar mActionBar;

    public FadingScrollView(Context context) {
        super(context);
    }

    public FadingScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FadingScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mActionBar = ((ActionBarActivity) getContext()).getSupportActionBar();
        setActionBackground();
    }

    public void setActionBar(ActionBar actionBar) {
        mActionBar = actionBar;
        setActionBackground();
    }

    private void setActionBackground(){
        mActionBackground = getResources().getDrawable(R.drawable.black);
        mActionBar.setBackgroundDrawable(mActionBackground);
        //optional
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBackground.setAlpha(0);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        mActionBackground.setAlpha(getAlphaforActionBar(t));
    }

    private int getAlphaforActionBar(int scrollY) {
        int minDist = 0, maxDist = 250;
        if (scrollY > maxDist) {
            return 255;
        } else if (scrollY < minDist) {
            return 0;
        } else {
            return (int) ((255.0 / maxDist) * scrollY);
        }
    }

}

package com.github.browep.ratiobuttons.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import com.github.browep.ratiobuttons.R;

import static android.view.View.MeasureSpec.getMode;
import static android.view.View.MeasureSpec.getSize;
import static android.view.View.MeasureSpec.makeMeasureSpec;

public class RatioButton extends Button {

    private static String TAG = RatioButton.class.getCanonicalName();

    private float ratio;

    public RatioButton(Context context) {
        super(context);
    }

    public RatioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup(context, attrs);
    }

    public RatioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setup(context, attrs);
    }


    private void setup(Context context, AttributeSet attrs) {
        TypedArray styledAttribute = context.obtainStyledAttributes(attrs,
                R.styleable.com_github_browep_ratiobuttons_view_RatioButton);

        ratio = styledAttribute.getFloat(R.styleable.com_github_browep_ratiobuttons_view_RatioButton_percent_of_width,
                1.0f);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getSize(widthMeasureSpec);
        int height = (int) (width * ratio);
        super.onMeasure(makeMeasureSpec(width, getMode(widthMeasureSpec)),
                makeMeasureSpec(height, getMode(heightMeasureSpec)));
    }


}

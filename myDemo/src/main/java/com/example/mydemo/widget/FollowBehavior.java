package com.example.mydemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.example.mydemo.R;

/**
 * Created by ldh on 2016/5/24 0024.
 */
public class FollowBehavior extends CoordinatorLayout.Behavior {
    private int targetId;

    public FollowBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Follow);
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            if(a.getIndex(i) == R.styleable.Follow_target){
                targetId = a.getResourceId(attr, -1);
            }
        }
        a.recycle();
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        child.setY(dependency.getY()+dependency.getHeight());
        return true;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency.getId() == targetId;
    }
}

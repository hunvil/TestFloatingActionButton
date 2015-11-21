package actionbar.hjr.example.com.testprojectactionbar;
/*
 * © 2007-2015 Fidelity National Information Services, Inc. 
 * and/or its subsidiaries - All Rights Reserved worldwide.
 * This document is protected under the trade secret and copyright laws as the 
 * property of Fidelity National Information Services, Inc. and/or its subsidiaries.
 * Copying, reproduction or distribution should be limited and only to 
 * employees with a “need to know” to do their job. 
 * Any disclosure of this document to third parties is strictly prohibited.
 */

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hunvil.rodrigues on 11/20/15.
 */
public class FloatingActionButtonBehavior extends CoordinatorLayout.Behavior<FloatingActionButton>{
    public FloatingActionButtonBehavior(Context context, AttributeSet attrs) {}

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }
}

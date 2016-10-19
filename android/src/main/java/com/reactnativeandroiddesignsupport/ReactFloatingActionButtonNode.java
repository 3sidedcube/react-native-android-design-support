package com.reactnativeandroiddesignsupport;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.csslayout.CSSMeasureMode;
import com.facebook.csslayout.CSSNodeAPI;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.react.uimanager.LayoutShadowNode;

/**
 * Created by tim on 13/10/2016.
 */
public class ReactFloatingActionButtonNode extends LayoutShadowNode implements CSSNodeAPI.MeasureFunction
{
	private int mWidth;
	private int mHeight;
	private boolean mMeasured;

	public ReactFloatingActionButtonNode()
	{
		setMeasureFunction(this);
	}

	@Override
	public void measure(CSSNodeAPI node, float width, CSSMeasureMode widthMode, float height, CSSMeasureMode heightMode, MeasureOutput measureOutput)
	{
		if (!mMeasured)
		{
			FloatingActionButton nodeView = new FloatingActionButton(getThemedContext());
			final int spec = View.MeasureSpec.makeMeasureSpec(ViewGroup.LayoutParams.WRAP_CONTENT, View.MeasureSpec.UNSPECIFIED);
			nodeView.measure(spec, spec);
			mWidth = nodeView.getMeasuredWidth();
			mHeight = nodeView.getMeasuredHeight();
			mMeasured = true;
		}
		measureOutput.width = mWidth;
		measureOutput.height = mHeight;
	}
}
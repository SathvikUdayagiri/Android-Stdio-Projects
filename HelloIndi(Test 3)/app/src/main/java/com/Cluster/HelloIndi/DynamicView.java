package com.Cluster.HelloIndi;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.EditText;

public class DynamicView {
    Context context;
    public DynamicView(Context context) {
        this.context=context;
    }
    public EditText getPlayers(Context context, int init)
    {
        final ViewGroup.LayoutParams layoutParams=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText editText=new EditText(context);
        editText.setId(init);
        editText.setMinEms(20);
        editText.setTextColor(Color.rgb(0,0,0));
        return editText;
    }
}

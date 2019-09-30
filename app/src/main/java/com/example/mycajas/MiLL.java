package com.example.mycajas;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MiLL extends LinearLayout {

    private boolean tocado;
    private static int tot;

    public void plusMiLL() {
        tot++;
    }
    public int getTot() {
        return tot;
    }

    public MiLL(Context context) {

        super(context);
        this.tocado = false;
    }

    public MiLL(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.tocado = false;
    }

    public MiLL(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.tocado = false;
    }

    public boolean isTocado() {
        return tocado;
    }

    public void setTocado(boolean tocado) {
        this.tocado = tocado;
    }
}

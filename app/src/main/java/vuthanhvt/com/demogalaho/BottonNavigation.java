package vuthanhvt.com.demogalaho;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/12/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * TODO: Add a class header comment!
 */
public class BottonNavigation extends LinearLayout {
    public static final String TAG = "BottonNavigation";

    private TextView mSubKey01;
    private TextView mSubKey02;
    private TextView mSubKey03;
    private TextView mSubKey04;
    private TextView mSelectKey;

    public BottonNavigation(Context context) {
        super(context);
        initView();
    }

    public BottonNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BottonNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        View v =inflate(getContext(),R.layout.bottot_navigation,this);
        mSubKey01 = v.findViewById(R.id.subkey_01);
        mSubKey02 = v.findViewById(R.id.subkey_02);
        mSubKey03 = v.findViewById(R.id.subkey_03);
        mSubKey04 = v.findViewById(R.id.subkey_04);
        mSelectKey = v.findViewById(R.id.select_btn);
    }

    public void setTextSubKey01(String subkey01) {
        this.mSubKey01.setText(subkey01);
    }

    public void setTextSubKey02(String subkey02) {
        this.mSubKey02.setText(subkey02);
    }

    public void setTextSubKey03(String subkey03) {
        this.mSubKey03.setText(subkey03);
    }

    public void setTextSubKey04(String subkey04) {
        this.mSubKey04.setText(subkey04);
    }

    public void setTextSelectSubKey(String selectSubkey) {
        this.mSelectKey.setText(selectSubkey);
    }

    public TextView getmSubKey01() {
        return mSubKey01;
    }

    public TextView getmSubKey02() {
        return mSubKey02;
    }

    public TextView getmSubKey03() {
        return mSubKey03;
    }

    public TextView getmSubKey04() {
        return mSubKey04;
    }

    public TextView getmSelectKey() {
        return mSelectKey;
    }
}

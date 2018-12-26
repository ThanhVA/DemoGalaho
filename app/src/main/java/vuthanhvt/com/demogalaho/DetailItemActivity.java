package vuthanhvt.com.demogalaho;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/12/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * TODO: Add a class header comment!
 */
public class DetailItemActivity extends AppCompatActivity {

    private BottonNavigation mBottonNavigation;
    private TextView mName;
    private TextView mPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
        mBottonNavigation = findViewById(R.id.bottom_navigation);
        mName = findViewById(R.id.item_name);
        mPosition = findViewById(R.id.item_position);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = getIntent().getBundleExtra(Constants.DETAIL_ITEM_BUNDLE);
            mName.setText(bundle.getString(Constants.DETAIL_ITEM_NAME));
            mPosition.setText(bundle.getString(Constants.DETAIL_ITEM_POSITION));
            mBottonNavigation.setTextSelectSubKey("Select");
            mBottonNavigation.setTextSubKey01("");
            mBottonNavigation.setTextSubKey02("");
            mBottonNavigation.setTextSubKey03("Back");
            mBottonNavigation.setTextSubKey04("Exit");
        } else {
            finish();
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_SOFT_LEFT:
                break;
            case KeyEvent.KEYCODE_SOFT_RIGHT:
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                break;
            case KeyEvent.KEYCODE_DPAD_CENTER:
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    mBottonNavigation.getmSelectKey().setPressed(true);
                }
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    mBottonNavigation.getmSelectKey().setPressed(false);
                }
                break;
            case KeyEvent.KEYCODE_CALL:
                break;
            case KeyEvent.KEYCODE_ENDCALL:
                break;

            case KeyEvent.KEYCODE_F1:
                break;

            case KeyEvent.KEYCODE_F3:
                break;

            case KeyEvent.KEYCODE_F2:
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    mBottonNavigation.getmSubKey03().setPressed(true);
                }
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    mBottonNavigation.getmSubKey03().setPressed(false);
                    Toast.makeText(DetailItemActivity.this, "Clicked Back button", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
                break;

            case KeyEvent.KEYCODE_F4:
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    mBottonNavigation.getmSubKey04().setPressed(true);
                }
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    Toast.makeText(DetailItemActivity.this, "Clicked Exit button", Toast.LENGTH_SHORT).show();
                    mBottonNavigation.getmSubKey04().setPressed(false);
                    finish();
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
                break;

            default:
                break;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        View v = getWindow().getDecorView();
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}

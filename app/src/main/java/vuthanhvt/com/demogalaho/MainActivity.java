package vuthanhvt.com.demogalaho;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MainViewPagerAdapter mAdapter;
    private Fragment01 mFragment01;
    private Fragment02 mFragment02;
    private Fragment03 mFragment03;
    private Fragment04 mFragment04;
    private Fragment mFragmentSelected;
    private BottonNavigation mBottonNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.view_pager);
        mTabLayout.setupWithViewPager(mViewPager, true);
        mAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mFragment01 = new Fragment01();
        mFragment02 = new Fragment02();
        mFragment03 = new Fragment03();
        mFragment04 = new Fragment04();
        mAdapter.addFragment(mFragment01, "Tab 01");
        mAdapter.addFragment(mFragment02, "Tab 02");
        mAdapter.addFragment(mFragment03, "Tab 03");
        mAdapter.addFragment(mFragment04, "Tab 04");
        mFragmentSelected = mAdapter.getItem(0);
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mFragmentSelected = mAdapter.getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mBottonNavigation = findViewById(R.id.bottom_navigation);
        mBottonNavigation.setTextSubKey01("SubKey 01");
        mBottonNavigation.setTextSubKey02("SubKey 02");
        mBottonNavigation.setTextSubKey03("Menu");
        mBottonNavigation.setTextSubKey04("SubKey 04");
        mBottonNavigation.setTextSelectSubKey("Select");

        final View v = getWindow().getDecorView();
        v.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        //if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                        if (visibility == View.VISIBLE) {
                            Toast.makeText(getApplicationContext(), "Visible", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "onSystemUiVisibilityChange: ");
                            v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                        } else {
                            //don't anything
                        }
                    }
                });
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d(TAG, "dispatchKeyEvent: getKeyCode = " + event.getKeyCode());
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
                    Toast.makeText(MainActivity.this, "Clicked Select button", Toast.LENGTH_SHORT).show();
                }
                break;
            case KeyEvent.KEYCODE_CALL:
                break;
            case KeyEvent.KEYCODE_ENDCALL:
                break;

            case KeyEvent.KEYCODE_F1:
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    mBottonNavigation.getmSubKey01().setPressed(true);
                }
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    mBottonNavigation.getmSubKey01().setPressed(false);
                    //TODO: do something
                    Toast.makeText(MainActivity.this, "Clicked Subkey 01", Toast.LENGTH_SHORT).show();
                    showDialog(false, MainActivity.this, "", "abc", "yes", null, null, null);
                }
                break;

            case KeyEvent.KEYCODE_F2:
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    mBottonNavigation.getmSubKey03().setPressed(true);
                }
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    mBottonNavigation.getmSubKey03().setPressed(false);
                    Toast.makeText(MainActivity.this, "Clicked Menu Subkey", Toast.LENGTH_SHORT).show();
                    final PopupMenu menu = new PopupMenu(MainActivity.this, mBottonNavigation.getmSubKey03());

                    menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.item_1:
                                    Log.d(TAG, "onMenuItemClick: item 1");
                                    Toast.makeText(MainActivity.this, "Clicked item 01 in menu", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.item_2:
                                    Log.d(TAG, "onMenuItemClick: item 2");
                                    Toast.makeText(MainActivity.this, "Clicked item 02 in menu", Toast.LENGTH_SHORT).show();
                                    break;
                                case R.id.item_3:
                                    Log.d(TAG, "onMenuItemClick: item 3");
                                    Toast.makeText(MainActivity.this, "Clicked item 03 in menu", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            return false;
                        }
                    });
                    menu.inflate(R.menu.main_menu);
                    menu.show();
                }
                break;

            case KeyEvent.KEYCODE_F3:
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    mBottonNavigation.getmSubKey02().setPressed(true);
                }
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    mBottonNavigation.getmSubKey02().setPressed(false);
                    Toast.makeText(MainActivity.this, "Clicked Subkey 02", Toast.LENGTH_SHORT).show();
                }
                break;

            case KeyEvent.KEYCODE_F4:
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    mBottonNavigation.getmSubKey04().setPressed(true);
                }
                if (event.getAction() == KeyEvent.ACTION_UP) {
                    mBottonNavigation.getmSubKey04().setPressed(false);
                    Toast.makeText(MainActivity.this, "Clicked Subkey 04", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                break;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        super.onResume();
        View v = getWindow().getDecorView();
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    public Dialog showDialog(boolean isFull, Context context, @Nullable String title,
                                    String message, String yesTitle, @Nullable DialogInterface.OnClickListener yesListener,
                                    @Nullable String cancelTitle,
                                    @Nullable DialogInterface.OnClickListener cancelListener) {
        Dialog dialog = new AlertDialog.Builder(context).setTitle(title)
                .setMessage(message)
                .setPositiveButton(yesTitle, yesListener)
                .setNegativeButton(cancelTitle, cancelListener)
                .setCancelable(false)
                .show();
        /*if (isFull) {
            dialog.getWindow()
                    .setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
            dialog.getWindow()
                    .addFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
                            | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            dialog.getWindow()
                    .getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        }*/

        
        dialog.getWindow()
                .getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        return dialog;
    }
}

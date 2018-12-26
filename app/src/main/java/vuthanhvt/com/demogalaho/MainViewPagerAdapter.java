package vuthanhvt.com.demogalaho;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 22/11/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class MainViewPagerAdapter.
 */
public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mRegistedFragmentList;
    private List<String> mFragmentTitleList;

    public MainViewPagerAdapter(FragmentManager fm, List<Fragment> registedFragment) {
        super(fm);
        mRegistedFragmentList = registedFragment;
        mFragmentTitleList = new ArrayList<>();
    }

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mRegistedFragmentList = new ArrayList<>();
        mFragmentTitleList = new ArrayList<>();
    }
    @Override
    public Fragment getItem(int i) {
        if (mRegistedFragmentList == null) {
            return null;
        }
        return mRegistedFragmentList.get(i);
    }

    @Override
    public int getCount() {
        if (mRegistedFragmentList == null) {
            return 0;
        }
        return mRegistedFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mRegistedFragmentList.add(fragment);
        mFragmentTitleList.add(title);
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        int realPosition = position % mFragmentTitleList.size();
        return mFragmentTitleList.get(realPosition);
    }
}

package dla.saygift.listpage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/9.
 */
public class GiftPageAdapter extends FragmentPagerAdapter{

    ArrayList<Fragment> fragments;
    ArrayList<String> arrayList;

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    public GiftPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrayList.get(position);
    }
}

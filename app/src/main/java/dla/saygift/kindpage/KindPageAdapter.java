package dla.saygift.kindpage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import dla.saygift.baseclass.BaseFragment;

/**
 * Created by dllo on 16/10/12.
 */
public class KindPageAdapter extends FragmentPagerAdapter {

    ArrayList<String> titles = new ArrayList<>();
    ArrayList<BaseFragment> fragments = new ArrayList<>();

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public void setFragments(ArrayList<BaseFragment> fragments) {
        this.fragments = fragments;
    }

    public KindPageAdapter(FragmentManager fm) {
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
        return titles.get(position);
    }

}

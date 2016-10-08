package dla.saygift.hompage.abasehomepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/27.
 */
public class HomePagerFragmentAdapter extends FragmentPagerAdapter{

    private ArrayList<String> titles= new ArrayList<>();
    private ArrayList<Fragment> fragments = new ArrayList<>();

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }

    public HomePagerFragmentAdapter(FragmentManager fm) {
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

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}

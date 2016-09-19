package dla.saygift.BuildActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/19.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter{

    ArrayList<Fragment> arrayList = new ArrayList<>();
    ArrayList<String> titleList = new ArrayList<>();

    public void setTitleList(ArrayList<String> titleList) {
        this.titleList = titleList;
    }

    public void setArrayList(ArrayList<Fragment> arrayList) {
        this.arrayList = arrayList;
        Log.d("MyFragmentPagerAdapter", "arrayList.size():" + arrayList.size());
    }

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}

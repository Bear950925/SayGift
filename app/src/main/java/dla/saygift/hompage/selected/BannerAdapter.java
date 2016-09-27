package dla.saygift.hompage.selected;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/9/27.
 */
public class BannerAdapter extends FragmentPagerAdapter{

    ArrayList<Fragment> banners = new ArrayList();

    public void setBanners(ArrayList banners) {
        this.banners = banners;
    }

    public BannerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return banners.get(position);
    }

    @Override
    public int getCount() {
        return banners.size();
    }
}

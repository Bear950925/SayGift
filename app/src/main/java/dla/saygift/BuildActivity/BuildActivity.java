package dla.saygift.BuildActivity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import dla.saygift.BaseClass.BaseFragmentActivity;
import dla.saygift.HomePager.HomePagerFragment;
import dla.saygift.R;

public class BuildActivity extends BaseFragmentActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected int setLayout() {
        return R.layout.activity_base;
    }

    @Override
    protected void initView() {
        viewPager = bindView(R.id.base_vp);
        tabLayout = bindView(R.id.base_tb);
    }

    @Override
    public void initData() {
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        ArrayList<Fragment> arrayList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            arrayList.add(new HomePagerFragment());
            titleList.add("" + i);
        }
        myFragmentPagerAdapter.setArrayList(arrayList);
        myFragmentPagerAdapter.setTitleList(titleList);
        viewPager.setAdapter(myFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}

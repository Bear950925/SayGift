package dla.saygift.kindpage;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import dla.saygift.baseclass.BaseFragment;
import dla.saygift.R;
import dla.saygift.kindpage.raiders.KPRaiders;
import dla.saygift.kindpage.single.KPSingle;

/**
 * Created by dllo on 16/9/20.
 */
public class KindPageFragment extends BaseFragment {

    private ViewPager vp;
    private TabLayout tb;

    @Override
    protected int setLayout() {
        return R.layout.kindpage;
    }

    @Override
    protected void initView() {
        tb = bindView(R.id.kindpage_tb);
        vp = bindView(R.id.kindpage_vp);
    }

    @Override
    protected void initData() {

        KindPageAdapter kindPageAdapter = new KindPageAdapter(getChildFragmentManager());

        ArrayList<String> Tabs = new ArrayList<>();
        Tabs.add("攻略");
        Tabs.add("单品");

        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new KPRaiders());
        fragments.add(new KPSingle());

        kindPageAdapter.setTitles(Tabs);
        kindPageAdapter.setFragments(fragments);
        vp.setAdapter(kindPageAdapter);
        tb.setupWithViewPager(vp);

    }
}

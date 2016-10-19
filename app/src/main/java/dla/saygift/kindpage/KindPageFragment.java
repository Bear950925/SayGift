package dla.saygift.kindpage;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import dla.saygift.baseclass.BaseFragment;
import dla.saygift.R;
import dla.saygift.kindpage.raiders.KPRaiders;
import dla.saygift.kindpage.single.KPSingle;
import dla.saygift.search.searchActivity;

/**
 * Created by dllo on 16/9/20.
 */
public class KindPageFragment extends BaseFragment {

    private ViewPager vp;
    private TabLayout tb;
    private View view;
    private TextView textView;

    @Override
    protected int setLayout() {
        return R.layout.kindpage;
    }

    @Override
    protected void initView() {
        tb = bindView(R.id.kindpage_tb);
        vp = bindView(R.id.kindpage_vp);
//        view = LayoutInflater.from(getContext()).inflate(R.layout.kindpage_raiders_title, null);
        textView = bindView(R.id.kp_raider_title);
    }

    @Override
    protected void initData() {

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), searchActivity.class);
//                startActivity(intent);
//            }
//        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), searchActivity.class);
                startActivity(intent);
            }
        });

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

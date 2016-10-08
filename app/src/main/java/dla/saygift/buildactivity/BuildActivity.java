package dla.saygift.buildactivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import dla.saygift.baseclass.BaseFragmentActivity;
import dla.saygift.hompage.abasehomepage.HomePagerFragment;
import dla.saygift.kindpage.KindPageFragment;
import dla.saygift.listpage.GiftPageFragment;
import dla.saygift.personpage.PersonPageFragment;
import dla.saygift.R;

public class BuildActivity extends BaseFragmentActivity implements BottomNavigationBar.OnTabSelectedListener {


    //    private ViewPager viewPager;
//    private TabLayout tabLayout;
    private FrameLayout frameLayout;
    //    private Button home, gift, kind, person;
    private BottomNavigationBar bottomNavigationBar;

    private HomePagerFragment homePagerFragment;
    private GiftPageFragment giftPageFragment;
    private KindPageFragment kindPageFragment;
    private PersonPageFragment personPageFragment;
    private BottomNavigationItem bottomNavigationItem0;
    private BottomNavigationItem bottomNavigationItem1;
    private BottomNavigationItem bottomNavigationItem2;
    private BottomNavigationItem bottomNavigationItem3;
    private EditText base_ed;

    @Override
    protected int setLayout() {
        return R.layout.activity_base;
    }

    @Override
    protected void initView() {
        base_ed = bindView(R.id.base_ed);
        frameLayout = bindView(R.id.base_frame);
        bottomNavigationBar = bindView(R.id.base_bar);

    }

    @Override
    public void initData() {

        setDefaultFragment();
        buildBottomNavigationBar();
        bottomNavigationBar.setTabSelectedListener(this);

    }

    public void buildBottomNavigationBar() {

        bottomNavigationItem0 = new BottomNavigationItem(R.mipmap.ic_tab_home_normal, "首页").setActiveColor("#00CCFF");
        bottomNavigationItem1 = new BottomNavigationItem(R.mipmap.ic_tab_gift_normal, "榜单").setActiveColor("#F1ADA2");
        bottomNavigationItem2 = new BottomNavigationItem(R.mipmap.ic_tab_category_normal, "分类").setActiveColor("#F79AB5");
        bottomNavigationItem3 = new BottomNavigationItem(R.mipmap.ic_tab_profile_normal, "我").setActiveColor("#FEF143");

        bottomNavigationBar.addItem(bottomNavigationItem0)
                .addItem(bottomNavigationItem1)
                .addItem(bottomNavigationItem2)
                .addItem(bottomNavigationItem3)
                .setInActiveColor("#78222222")
                .setBarBackgroundColor("#34ff0000")
                .setMode(BottomNavigationBar.MODE_FIXED).setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .initialise();
    }

    public void setDefaultFragment() {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        homePagerFragment = new HomePagerFragment();
        transaction.replace(R.id.base_frame, homePagerFragment);
        transaction.commit();

    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        switch (position) {
            case 0:
                if (homePagerFragment == null) {
                    homePagerFragment = new HomePagerFragment();
                }
                transaction.replace(R.id.base_frame, homePagerFragment);
                break;
            case 1:
                if (giftPageFragment == null) {
                    giftPageFragment = new GiftPageFragment();
                }
                transaction.replace(R.id.base_frame, giftPageFragment);
                break;
            case 2:
                if (kindPageFragment == null) {
                    kindPageFragment = new KindPageFragment();
                }
                transaction.replace(R.id.base_frame, kindPageFragment);
                break;
            case 3:
                if (personPageFragment == null) {
                    personPageFragment = new PersonPageFragment();
                }
                transaction.replace(R.id.base_frame, personPageFragment);
                break;
        }

        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}

package dla.saygift.hompage.selected.baseselected;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

import dla.saygift.MyApp;
import dla.saygift.R;
import dla.saygift.baseclass.BaseFragment;
import dla.saygift.hompage.basehomepage.URLValues;
import dla.saygift.hompage.selected.firstbanner.BannerBean;
import dla.saygift.hompage.selected.firstbanner.BannerFragment;
import dla.saygift.hompage.selected.secondbanner.SecondBannerBean;
import dla.saygift.volleysingle.VolleySingleTon;

/**
 * Created by dllo on 16/9/27.
 */
public class SelectedColumns extends BaseFragment implements View.OnClickListener {

    private Handler handler;

    private ViewPager viewPager;
    private ArrayList<TextView> textViews = new ArrayList<>();
    private LinearLayout homepage_secondbanner_ll;
    private RecyclerView recyclerView;

    @Override
    protected int setLayout() {
        return R.layout.homepage_selected;
    }

    @Override
    protected void initView() {

        textViews.add((TextView) bindView(R.id.homepage_selected_doa0));
        textViews.add((TextView) bindView(R.id.homepage_selected_doa1));
        textViews.add((TextView) bindView(R.id.homepage_selected_doa2));
        textViews.add((TextView) bindView(R.id.homepage_selected_doa3));
        textViews.add((TextView) bindView(R.id.homepage_selected_doa4));
        textViews.add((TextView) bindView(R.id.homepage_selected_doa5));
        textViews.add((TextView) bindView(R.id.homepage_selected_doa6));

        for (int i = 0; i < textViews.size(); i++) {
            textViews.get(i).setOnClickListener(this);
        }

        viewPager = bindView(R.id.homepage_selected_vp);

        recyclerView = bindView(R.id.homepage_selected_rv);

    }

    @Override
    protected void initData() {
        
        setBanner();
        setSecondBanner();
        
    }
    
    public void setBanner() {
        
        StringRequest stringRequest = new StringRequest(URLValues.BANNER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                BannerBean bannerBean = gson.fromJson(response, BannerBean.class);
                ArrayList<Fragment> arrayList = new ArrayList();
                ArrayList<String> img_url = new ArrayList<>();
                BannerFragment bannerFragment = null;

                /**
                 * 创建轮播图 c a b c a
                 */
                bannerFragment = new BannerFragment();
                bannerFragment.setImgUrl(bannerBean.getData().getBanners().get(bannerBean.getData().getBanners().size() - 1).getImage_url());
                arrayList.add(bannerFragment);
                for (int i = 0; i < bannerBean.getData().getBanners().size(); i++) {

                    img_url.add(bannerBean.getData().getBanners().get(i).getImage_url());
                    bannerFragment = new BannerFragment();
                    bannerFragment.setImgUrl(img_url.get(i));
                    arrayList.add(bannerFragment);
                }
                bannerFragment = new BannerFragment();
                bannerFragment.setImgUrl(bannerBean.getData().getBanners().get(0).getImage_url());
                arrayList.add(bannerFragment);

                FirstBannerAdapter bannerAdapter = new FirstBannerAdapter(getChildFragmentManager());
                bannerAdapter.setBanners(arrayList);
                viewPager.setAdapter(bannerAdapter);
                VisibilityDot(viewPager.getAdapter().getCount() - 2);
                viewPager.setCurrentItem(1);
                startScroll();

                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    int viewPagerItem;
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        Log.d("SelectedColumns", "position:" + position);
                        viewPagerItem = position;

                        switch (viewPagerItem) {
                            case 1:
                                SelectedDot(0);
                                break;
                            case 2:
                                SelectedDot(1);
                                break;
                            case 3:
                                SelectedDot(2);
                                break;
                            case 4:
                                SelectedDot(3);
                                break;
                            case 5:
                                SelectedDot(4);
                                break;
                            case 6:
                                SelectedDot(5);
                                break;
                            case 7:
                                SelectedDot(6);
                                break;
                                default:
                                    Toast.makeText(mContext, "DotView不够, 请添加", Toast.LENGTH_SHORT).show();
                                    break;
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                        switch (state) {
                            case 0:
                                if (viewPagerItem == 0) {
                                    viewPager.setCurrentItem(viewPager.getAdapter().getCount() - 2, false);
                                } else if (viewPagerItem == viewPager.getAdapter().getCount() - 1) {
                                    viewPager.setCurrentItem(1, false);
                                }
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                        }
                    }
                });
                viewPager.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:
                                stopScroll();
                            break;
                            case MotionEvent.ACTION_UP:
                                startScroll();
                            break;
                        }
                        return false;
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                
            }
        });

        VolleySingleTon.getInstance().addQueue(stringRequest);

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                int CurrentItem;
                CurrentItem = viewPager.getCurrentItem();
                CurrentItem++;
                viewPager.setCurrentItem(CurrentItem);
                stopScroll();
                startScroll();
                return false;
            }
        });

    }

    public void startScroll() {
        handler.sendEmptyMessageDelayed(1, 2000);
    }

    public void stopScroll() {
        handler.removeMessages(1);
    }

    public void SelectedDot(int position) {

        DefaultDot();
        textViews.get(position).setBackgroundResource(R.drawable.banner_icon_selected);

    }

    public void VisibilityDot(int Visibility) {

        for (int i = 0; i < Visibility; i++) {
            textViews.get(i).setVisibility(View.VISIBLE);
        }

    }

    public void DefaultDot() {

        for (int i = 0; i < textViews.size(); i++) {
            textViews.get(i).setBackgroundResource(R.drawable.banner_icon_normal);
        }

    }

    @Override
    public void onClick(View v) {
        stopScroll();
        switch (v.getId()) {
            case R.id.homepage_selected_doa0:
                viewPager.setCurrentItem(1);
                break;
            case R.id.homepage_selected_doa1:
                viewPager.setCurrentItem(2);
                break;
            case R.id.homepage_selected_doa2:
                viewPager.setCurrentItem(3);
                break;
            case R.id.homepage_selected_doa3:
                viewPager.setCurrentItem(4);
                break;
            case R.id.homepage_selected_doa4:
                viewPager.setCurrentItem(5);
                break;
            case R.id.homepage_selected_doa5:
                break;
            case R.id.homepage_selected_doa6:
                break;
        }
        startScroll();
    }

    public void setSecondBanner() {

        StringRequest stringRequest = new StringRequest(URLValues.SECOND_BANNER_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Gson gson = new Gson();

                SecondBannerBean bannerBean = gson.fromJson(response, SecondBannerBean.class);

                SecondBannerAdapter secondBannerAdapter = new SecondBannerAdapter();
                secondBannerAdapter.setSecondBannerBean(bannerBean);
                LinearLayoutManager manager = new LinearLayoutManager(MyApp.getmContext());
                manager.setOrientation(manager.HORIZONTAL);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(secondBannerAdapter);

                recyclerView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {

                        recyclerView.getParent().requestDisallowInterceptTouchEvent(true);

                        return false;
                    }
                });

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        VolleySingleTon.getInstance().addQueue(stringRequest);

    }

}

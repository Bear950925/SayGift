package dla.saygift.hompage.aselected.baseselected;

import android.content.Context;
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
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import dla.saygift.MyApp;
import dla.saygift.R;
import dla.saygift.hompage.aselected.firstbanner.BannerFragment;
import dla.saygift.hompage.aselected.firstbanner.FirstBannerAdapter;
import dla.saygift.hompage.aselected.firstbanner.FirstBannerBean;
import dla.saygift.hompage.aselected.secondbanner.SecondBannerAdapter;
import dla.saygift.hompage.aselected.secondbanner.SecondBannerBean;
import dla.saygift.hompage.aselected.thirdchannels.ThirdChannelsSelectedBean;

/**
 * Created by dllo on 16/9/30.
 */
public class BaseSelectAdapter extends RecyclerView.Adapter {

    private Context context;

    private FirstBannerAdapter firstBannerAdapter;
    private FirstBannerBean firstBannerBean;

    private SecondBannerAdapter secondBannerAdapter;
    private SecondBannerBean secondBannerBean;

    private ThirdChannelsSelectedBean thirdChannelsSelectedBean;

    private Handler handler;

    public void setThirdChannelsSelectedBean(ThirdChannelsSelectedBean thirdChannelsSelectedBean) {
        this.thirdChannelsSelectedBean = thirdChannelsSelectedBean;
    }

    public void setSecondBannerAdapter(SecondBannerAdapter secondBannerAdapter) {
        this.secondBannerAdapter = secondBannerAdapter;
    }

    public void setSecondBannerBean(SecondBannerBean secondBannerBean) {
        this.secondBannerBean = secondBannerBean;
    }

    public void setFirstBannerBean(FirstBannerBean firstBannerBean) {
        this.firstBannerBean = firstBannerBean;
//        Log.d("BaseSelectAdapter", "firstBannerBean.getData().getBanners().size():" + firstBannerBean.getData().getBanners().size());
    }

    public void setFirstBannerAdapter(FirstBannerAdapter firstBannerAdapter) {
        this.firstBannerAdapter = firstBannerAdapter;
//        Log.d("BaseSelectAdapter", "firstBannerAdapter:" + firstBannerAdapter);
    }

    public BaseSelectAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = null;

        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(context).inflate(R.layout.homepage_selected_banner, parent, false);
                holder = new FirstBannerViewHolder(view);
                break;
            case 1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.homepage_selected_secondbanner, parent, false);
                holder = new SecondBannerViewHolder(view1);
                break;
            default:
                View view2 = LayoutInflater.from(context).inflate(R.layout.homepage_selected_channels, parent, false);
                holder = new ThirdChannelsViewHolder(view2);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (position) {
            case 0:

                FirstBannerViewHolder firstBannerViewHolder = (FirstBannerViewHolder) holder;

                setBanner(firstBannerViewHolder);

                break;

            case 1:

                SecondBannerViewHolder secondBannerViewHolder = (SecondBannerViewHolder) holder;

                setSecondBanner(secondBannerViewHolder);

                break;
            default:

                ThirdChannelsViewHolder thirdChannelsViewHolder = (ThirdChannelsViewHolder) holder;

                setThirdChannels(thirdChannelsViewHolder, position - 2);

                break;
        }

    }

    public void setBanner(final FirstBannerViewHolder firstBannerViewHolder) {
        ArrayList<Fragment> arrayList = new ArrayList<>();

        BannerFragment bannerFragment = null;

        bannerFragment = new BannerFragment();
        bannerFragment.setImgUrl(firstBannerBean.getData().getBanners().get(firstBannerBean.getData().getBanners().size() - 1).getWebp_url());
        arrayList.add(bannerFragment);
        for (int i = 0; i < firstBannerBean.getData().getBanners().size(); i++) {
            bannerFragment = new BannerFragment();
            bannerFragment.setImgUrl(firstBannerBean.getData().getBanners().get(i).getImage_url());
            arrayList.add(bannerFragment);
        }
        bannerFragment = new BannerFragment();
        bannerFragment.setImgUrl(firstBannerBean.getData().getBanners().get(0).getImage_url());
        arrayList.add(bannerFragment);


        firstBannerAdapter.setBanners(arrayList);
        VisibilityDot(firstBannerBean.getData().getBanners().size(), firstBannerViewHolder);

        firstBannerViewHolder.viewPager.setAdapter(firstBannerAdapter);
        firstBannerViewHolder.viewPager.setCurrentItem(1);

        firstBannerViewHolder.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int viewPagerItem;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                viewPagerItem = position;

                switch (position) {
                    case 1:
                        SelectedDot(0, firstBannerViewHolder);
                        break;
                    case 2:
                        SelectedDot(1, firstBannerViewHolder);
                        break;
                    case 3:
                        SelectedDot(2, firstBannerViewHolder);
                        break;
                    case 4:
                        SelectedDot(3, firstBannerViewHolder);
                        break;
                    case 5:
                        SelectedDot(4, firstBannerViewHolder);
                        break;
                    case 6:
                        SelectedDot(5, firstBannerViewHolder);
                        break;
                    case 7:
                        SelectedDot(6, firstBannerViewHolder);
                        break;
                    default:
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case 0:
                        if (viewPagerItem == 0) {
                            firstBannerViewHolder.viewPager.setCurrentItem(firstBannerViewHolder.viewPager.getAdapter().getCount() - 2, false);
                        } else if (viewPagerItem == firstBannerViewHolder.viewPager.getAdapter().getCount() - 1) {
                            firstBannerViewHolder.viewPager.setCurrentItem(1, false);
                        }
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });

        firstBannerViewHolder.viewPager.setOnTouchListener(new View.OnTouchListener() {
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


        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                int CurrentItem;
                CurrentItem = firstBannerViewHolder.viewPager.getCurrentItem();
                CurrentItem++;
                firstBannerViewHolder.viewPager.setCurrentItem(CurrentItem);
                stopScroll();
                startScroll();
                return false;
            }
        });
        handler.sendEmptyMessageDelayed(1, 2000);

    }

    public void startScroll() {
        handler.sendEmptyMessageDelayed(1, 2000);
    }

    public void stopScroll() {
        handler.removeMessages(1);
    }

    public void VisibilityDot(int Visibility, FirstBannerViewHolder firstBannerViewHolder) {
        for (int i = 0; i < Visibility; i++) {
            firstBannerViewHolder.textViews.get(i).setVisibility(View.VISIBLE);
        }
    }

    public void SelectedDot(int selected, FirstBannerViewHolder firstBannerViewHolder) {
        DefaultDot(firstBannerViewHolder);
        firstBannerViewHolder.textViews.get(selected).setBackgroundResource(R.drawable.banner_icon_selected);
    }

    public void DefaultDot(FirstBannerViewHolder firstBannerViewHolder) {
        for (int i = 0; i < firstBannerViewHolder.textViews.size(); i++) {
            firstBannerViewHolder.textViews.get(i).setBackgroundResource(R.drawable.banner_icon_normal);
        }
    }

    public void setSecondBanner(final SecondBannerViewHolder secondBannerViewHolder) {

        secondBannerAdapter.setSecondBannerBean(secondBannerBean);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(manager.HORIZONTAL);
        secondBannerViewHolder.recyclerView.setLayoutManager(manager);
        secondBannerViewHolder.recyclerView.setAdapter(secondBannerAdapter);

        secondBannerViewHolder.recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                secondBannerViewHolder.recyclerView.getParent().requestDisallowInterceptTouchEvent(true);

                return false;
            }
        });

    }

    public void setThirdChannels(ThirdChannelsViewHolder thirdChannelsViewHolder, int position) {


        String authorImgUrl = thirdChannelsSelectedBean.getHomepage_selected_channels_author_avatar_url().get(position);
        setImgAndText(thirdChannelsViewHolder.homepage_selected_channels_author_img_url, authorImgUrl, null, null);

        String channelsImgUrl = thirdChannelsSelectedBean.getHomepage_selected_channels_Cover_img_url().get(position);
        setImgAndText(thirdChannelsViewHolder.homepage_selected_channels_img_url, channelsImgUrl, null, null);

        setImgAndText(null, null, thirdChannelsViewHolder.homepage_selected_channels_columns_category, thirdChannelsSelectedBean.getHomepage_selected_channels_columns_category().get(position));
        setImgAndText(null, null, thirdChannelsViewHolder.homepage_selected_channels_columns_title, thirdChannelsSelectedBean.getHomepage_selected_channels_columns_title().get(position));
        setImgAndText(null, null, thirdChannelsViewHolder.homepage_selected_channels_title, thirdChannelsSelectedBean.getHomepage_selected_channels_title().get(position));
        setImgAndText(null, null, thirdChannelsViewHolder.homepage_selected_channels_author_nickname, thirdChannelsSelectedBean.getHomepage_selected_channels_author_nickname().get(position));
        setImgAndText(null, null, thirdChannelsViewHolder.homepage_selected_channels_like_counts_tv, thirdChannelsSelectedBean.getHomepage_selected_channels_like_counts_tv().get(position));

    }

    public void setImgAndText(ImageView imageView, String imgUrl, TextView textView, String tv) {

        if (imgUrl != null) {
            try {
                Glide.with(MyApp.getmContext())
                        .load(imgUrl)
                        .placeholder(R.mipmap.ic_action_compact_favourite_normal)
                        .into(imageView);
            } catch (IndexOutOfBoundsException e) {
                Log.d("BaseSelectAdapter", "IMG_ERROR");
            }
        }

        if (tv != null) {
            try {
                textView.setText(tv);
            } catch (IndexOutOfBoundsException e) {
                Log.d("BaseSelectAdapter", "TV_ERROR");
            }
        }

    }

    @Override
    public int getItemCount() {
        return thirdChannelsSelectedBean.getHomepage_selected_channels_Cover_img_url().size() + 2;
    }

    private class FirstBannerViewHolder extends RecyclerView.ViewHolder {

        private final ViewPager viewPager;
        private final ArrayList<TextView> textViews;

        public FirstBannerViewHolder(View view) {
            super(view);

            viewPager = (ViewPager) view.findViewById(R.id.homepage_selected_vp);
            textViews = new ArrayList<>();
            textViews.add((TextView) view.findViewById(R.id.homepage_selected_doa0));
            textViews.add((TextView) view.findViewById(R.id.homepage_selected_doa1));
            textViews.add((TextView) view.findViewById(R.id.homepage_selected_doa2));
            textViews.add((TextView) view.findViewById(R.id.homepage_selected_doa3));
            textViews.add((TextView) view.findViewById(R.id.homepage_selected_doa4));
            textViews.add((TextView) view.findViewById(R.id.homepage_selected_doa5));
            textViews.add((TextView) view.findViewById(R.id.homepage_selected_doa6));


        }
    }

    private class SecondBannerViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;

        public SecondBannerViewHolder(View view) {
            super(view);
            recyclerView = (RecyclerView) view.findViewById(R.id.homepage_selected_rv);
        }
    }

    private class ThirdChannelsViewHolder extends RecyclerView.ViewHolder {
        private TextView homepage_selected_channels_columns_category;
        private TextView homepage_selected_channels_columns_title;
        private ImageView homepage_selected_channels_author_img_url;
        private TextView homepage_selected_channels_author_nickname;
        private ImageView homepage_selected_channels_img_url;
        private TextView homepage_selected_channels_title;
        private TextView homepage_selected_channels_like_counts_tv;

        public ThirdChannelsViewHolder(View view2) {
            super(view2);
            homepage_selected_channels_columns_category =
                    (TextView) view2.findViewById(R.id.homepage_selected_channels_columns_category);
            homepage_selected_channels_columns_title =
                    (TextView) view2.findViewById(R.id.homepage_selected_channels_columns_title);
            homepage_selected_channels_author_img_url =
                    (ImageView) view2.findViewById(R.id.homepage_selected_channels_author_avatar);
            homepage_selected_channels_author_nickname =
                    (TextView) view2.findViewById(R.id.homepage_selected_channels_author_nickname);
            homepage_selected_channels_img_url =
                    (ImageView) view2.findViewById(R.id.homepage_selected_channels_img);
            homepage_selected_channels_title =
                    (TextView) view2.findViewById(R.id.homepage_selected_channels_title);
            homepage_selected_channels_like_counts_tv =
                    (TextView) view2.findViewById(R.id.homepage_selected_channels_like_counts_tv);
        }
    }
}

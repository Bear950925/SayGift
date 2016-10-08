package dla.saygift.hompage.aselected.firstbanner;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import dla.saygift.MyApp;
import dla.saygift.R;
import dla.saygift.baseclass.BaseFragment;

/**
 * Created by dllo on 16/9/27.
 */
public class BannerFragment extends BaseFragment {

    private String ImgUrl;
    private ImageView imageView;

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    @Override
    protected int setLayout() {
        return R.layout.homepage_selected_banner_view;
    }

    @Override
    protected void initView() {
        imageView = bindView(R.id.homepage_selected_banner_img);
    }

    @Override
    protected void initData() {
        Glide.with(MyApp.getmContext())
                .load(ImgUrl)
                .placeholder(R.mipmap.icon_searched)
                .into(imageView);
    }
}

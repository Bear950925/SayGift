package dla.saygift.hompage.aselected.secondbanner;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import dla.saygift.volleysingle.MyApp;
import dla.saygift.R;

/**
 * Created by dllo on 16/9/28.
 */
public class SecondBannerAdapter extends RecyclerView.Adapter<SecondBannerAdapter.ViewHolder>{

    private SecondBannerBean secondBannerBean;
    private ListView listView;

    public void setSecondBannerBean(SecondBannerBean secondBannerBean) {
        this.secondBannerBean = secondBannerBean;
    }

    @Override
    public SecondBannerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homepage_selected_secondbanner_view, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SecondBannerAdapter.ViewHolder holder, int position) {

        String s = secondBannerBean.getData().getSecondary_banners().get(position).getImage_url();

        Glide.with(MyApp.getmContext())
                .load(s)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return secondBannerBean.getData().getSecondary_banners().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.homepage_selected_secondbanner_img);

        }
    }
}

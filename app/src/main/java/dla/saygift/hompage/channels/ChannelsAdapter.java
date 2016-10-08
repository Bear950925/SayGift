package dla.saygift.hompage.channels;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import dla.saygift.MyApp;
import dla.saygift.R;

/**
 * Created by dllo on 16/10/8.
 */
public class ChannelsAdapter extends RecyclerView.Adapter<ChannelsAdapter.ViewHolder>{

    private Context context;
    private ChannelsSelectedBean channelsSelectedBean;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setChannelsSelectedBean(ChannelsSelectedBean channelsSelectedBean) {
        this.channelsSelectedBean = channelsSelectedBean;
    }

    @Override
    public ChannelsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.homepage_another_channels, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChannelsAdapter.ViewHolder holder, int position) {
        String authorImgUrl = channelsSelectedBean.getHomepage_another_channels_author_avatar_url().get(position);
        setImgAndText(null, null, holder.homepage_another_channels_author_img_url, authorImgUrl);

        String channelsImgUrl = channelsSelectedBean.getHomepage_another_channels_Cover_img_url().get(position);
        setImgAndText(null, null, holder.homepage_another_channels_img_url, channelsImgUrl);

        setImgAndText(holder.homepage_another_channels_columns_category, channelsSelectedBean.getHomepage_another_channels_columns_category().get(position), null, null);
        setImgAndText(holder.homepage_another_channels_columns_title, channelsSelectedBean.getHomepage_another_channels_columns_title().get(position), null, null);
        setImgAndText(holder.homepage_another_channels_title, channelsSelectedBean.getHomepage_another_channels_title().get(position), null, null);
        setImgAndText(holder.homepage_another_channels_author_nickname, channelsSelectedBean.getHomepage_another_channels_author_nickname().get(position), null, null);
        setImgAndText(holder.homepage_another_channels_like_counts_tv, channelsSelectedBean.getHomepage_another_channels_like_counts_tv().get(position), null, null);
    }

    public void setImgAndText(TextView textView, String tv, ImageView imageView, String imgUrl) {

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
        return channelsSelectedBean.getHomepage_another_channels_author_nickname().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView homepage_another_channels_columns_category;
        private TextView homepage_another_channels_columns_title;
        private ImageView homepage_another_channels_author_img_url;
        private TextView homepage_another_channels_author_nickname;
        private ImageView homepage_another_channels_img_url;
        private TextView homepage_another_channels_title;
        private TextView homepage_another_channels_like_counts_tv;

        public ViewHolder(View view) {
            super(view);

            homepage_another_channels_columns_category =
                    (TextView) view.findViewById(R.id.homepage_another_channels_columns_category);
            homepage_another_channels_columns_title =
                    (TextView) view.findViewById(R.id.homepage_another_channels_columns_title);
            homepage_another_channels_author_img_url =
                    (ImageView) view.findViewById(R.id.homepage_another_channels_author_avatar);
            homepage_another_channels_author_nickname =
                    (TextView) view.findViewById(R.id.homepage_another_channels_author_nickname);
            homepage_another_channels_img_url =
                    (ImageView) view.findViewById(R.id.homepage_another_channels_img);
            homepage_another_channels_title =
                    (TextView) view.findViewById(R.id.homepage_another_channels_title);
            homepage_another_channels_like_counts_tv =
                    (TextView) view.findViewById(R.id.homepage_another_channels_like_counts_tv);


        }
    }
}

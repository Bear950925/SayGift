package dla.saygift.listpage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import dla.saygift.volleysingle.MyApp;
import dla.saygift.R;

/**
 * Created by dllo on 16/10/11.
 */
public class ContentFragmentAdapter extends RecyclerView.Adapter {

    private GiftBean giftBean;
    private Context context = null;

    public void setGiftBean(GiftBean giftBean) {
        this.giftBean = giftBean;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;

        if (context == null) {
            context = parent.getContext();
        }

        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listpage_content_im, parent, false);

                viewHolder = new MyViewHolder(view);
                break;
            default:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.listpage_content_in, parent, false);

                viewHolder = new MyViewHolder2(view2);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        switch (position) {
            case 0:
                MyViewHolder myViewHolder = (MyViewHolder) holder;
                Glide.with(MyApp.getmContext())
                        .load(giftBean.getData().getCover_webp())
                        .placeholder(R.mipmap.ic_action_compact_favourite_normal)
                        .into(myViewHolder.content_image);

                Log.d("ContentFragmentAdapter", giftBean.getData().getCover_webp());

                break;
            default:

                MyViewHolder2 myViewHolder2 = (MyViewHolder2) holder;

                Glide.with(MyApp.getmContext())
                        .load(giftBean.getData().getItems().get(position - 1).getCover_image_url())
                        .into(myViewHolder2.content_img);

                myViewHolder2.content_des.setText(giftBean.getData().getItems().get(position).getShort_description());
                myViewHolder2.content_name.setText(giftBean.getData().getItems().get(position).getName());
                myViewHolder2.content_price.setText("¥ " + giftBean.getData().getItems().get(position).getPrice());

                break;
        }

    }

    @Override
    public int getItemCount() {
        return giftBean.getData().getItems().size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        private final TextView content_price;
        private final TextView content_name;
        private final TextView content_des;
        private final ImageView content_img;

        public MyViewHolder2(View itemView) {
            super(itemView);

            content_img = (ImageView) itemView.findViewById(R.id.listpage_content_in_img);
            content_des = (TextView) itemView.findViewById(R.id.listpage_content_description);
            content_name = (TextView) itemView.findViewById(R.id.listpage_content_name);
            content_price = (TextView) itemView.findViewById(R.id.listpage_content_price);

        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView content_image;

        public MyViewHolder(View itemView) {
            super(itemView);

            content_image = (ImageView) itemView.findViewById(R.id.listpage_content_img);

        }
    }

}

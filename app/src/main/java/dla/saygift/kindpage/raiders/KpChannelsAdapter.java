package dla.saygift.kindpage.raiders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import dla.saygift.volleysingle.MyApp;
import dla.saygift.R;

/**
 * Created by dllo on 16/10/13.
 */
public class KpChannelsAdapter extends RecyclerView.Adapter<KpChannelsAdapter.MyViewHolder>{

    private int positions;

    public void setPositions(int positions) {
        this.positions = positions;
    }

    private ChannelsBea channelsBea;

    public void setChannelsBea(ChannelsBea channelsBea) {
        this.channelsBea = channelsBea;
    }

    @Override
    public KpChannelsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindpage_r_cha_channels, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(KpChannelsAdapter.MyViewHolder holder, int position) {

        String img_url = channelsBea.getData().getChannel_groups().get(positions).getChannels().get(position).getCover_image_url();
        Glide.with(MyApp.getmContext())
                .load(img_url)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView =  (ImageView) itemView.findViewById(R.id.kindpage_r_cha_cha_img);

        }
    }
}

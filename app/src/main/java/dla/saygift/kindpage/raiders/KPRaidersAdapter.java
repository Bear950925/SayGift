package dla.saygift.kindpage.raiders;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dla.saygift.R;
import dla.saygift.hompage.channels.ChannelsAdapter;

/**
 * Created by dllo on 16/10/13.
 */
public class KPRaidersAdapter extends RecyclerView.Adapter{

    private SectionBean sectionBean;
    private ChannelsBea channelsBea;

    public void setChannelsBea(ChannelsBea channelsBea) {
        this.channelsBea = channelsBea;
    }

    private Context context;

    public void setSectionBean(SectionBean sectionBean) {
        this.sectionBean = sectionBean;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = null;
        context = parent.getContext();

        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindpage_r_section, parent, false);
                holder = new SectionViewHolder(view);
                break;
            default:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.kindpage_r_channels, parent, false);
                holder = new ChannelsViewHolder(view1);
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (position) {
            case 0:

                SectionViewHolder viewHolder = (SectionViewHolder) holder;
                SectionAdapter sectionAdapter = new SectionAdapter();
                sectionAdapter.setSectionBean(sectionBean);

                GridLayoutManager manager = new GridLayoutManager(context, 3);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);

                viewHolder.recyclerView.setLayoutManager(manager);
                viewHolder.recyclerView.setAdapter(sectionAdapter);


                break;
            default:

                ChannelsViewHolder channelsViewHolder = (ChannelsViewHolder) holder;
                KpChannelsAdapter kpChannelsAdapter = new KpChannelsAdapter();
                kpChannelsAdapter.setChannelsBea(channelsBea);
                kpChannelsAdapter.setPositions(position - 1);

                GridLayoutManager manager1 = new GridLayoutManager(context, 2);

                channelsViewHolder.recyclerView.setLayoutManager(manager1);
                channelsViewHolder.recyclerView.setAdapter(kpChannelsAdapter);

                break;
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    private class SectionViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;

        public SectionViewHolder(View view) {
            super(view);
            recyclerView = (RecyclerView) view.findViewById(R.id.kindpage_r_section_rv);
        }
    }

    private class ChannelsViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;

        public ChannelsViewHolder(View itemView) {
            super(itemView);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.kindpage_r_channels_rv);

        }
    }
}

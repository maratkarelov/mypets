package test.zimad.mypets.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.zimad.mypets.R;
import test.zimad.mypets.data.PetInfo;


public class PetsAdapter extends RecyclerView.Adapter<PetsAdapter.ViewHolder> {

    private ArrayList<PetInfo> petInfos;
    private ItemClickCallback<PetInfo> itemClickCallback;

    public PetsAdapter(ItemClickCallback<PetInfo> listener) {
        itemClickCallback = listener;
    }

    public void setPetInfos(ArrayList<PetInfo> list) {
        this.petInfos = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pets_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PetInfo petInfo = petInfos.get(position);
        holder.tvId.setText(String.valueOf(position + 1));
        holder.tvName.setText(petInfos.get(position).getTitle());
        Picasso.get()
                .load(petInfos.get(position).getUrl())
                .into(holder.img);

        holder.itemView.setOnClickListener(v -> {
            if(null != itemClickCallback) {
                itemClickCallback.OnItemClick(petInfo, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return petInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.tv_id)
        TextView tvId;
        @BindView(R.id.tv_name)
        TextView tvName;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}

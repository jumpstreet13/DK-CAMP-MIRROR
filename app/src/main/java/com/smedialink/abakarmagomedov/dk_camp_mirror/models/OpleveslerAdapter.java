package com.smedialink.abakarmagomedov.dk_camp_mirror.models;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.Oplevelser.OplevelserFirstView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpleveslerAdapter extends RecyclerView.Adapter<OpleveslerAdapter.OpleveslerActivityHolder> {

    private List<Discount> listItems;
    private OplevelserFirstView mOpleListener;

    public OpleveslerAdapter(List<Discount> listItems, @NonNull OplevelserFirstView opleListener) {
        this.listItems = listItems;
        mOpleListener = opleListener;
    }

    @Override
    public OpleveslerActivityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.oplevesler_list, parent, false);
        return new OpleveslerActivityHolder(view);
    }

    @Override
    public void onBindViewHolder(OpleveslerActivityHolder holder, int position) {
        Discount item = listItems.get(position);
        holder.bindView(item, mOpleListener);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    static class OpleveslerActivityHolder extends RecyclerView.ViewHolder {
        @Inject Home mHome;

        @BindView(R.id.bigTextViewInActivityOpleveslerSecond) TextView bigText;
        @BindView(R.id.smallTextViewInActivityOpleveslerSecond) TextView smallText;
        @BindView(R.id.image_oplevesler_activity) RoundedImageView mRoundedImageView;
        private Discount mItem;
        private OplevelserFirstView mOpleListener;

        @OnClick(R.id.linelayInOpleveslerList)
        void onImageClick() {
            mOpleListener.onItemClick(mItem);
            //mHome.setFocusedItem(mItem);
        }

        OpleveslerActivityHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindView(Discount item, @NonNull OplevelserFirstView opleListener) {
            mOpleListener = opleListener;
            bigText.setText(item.getTitle());
            smallText.setText(item.getDetails().substring(0, 83));
            Glide.with(mRoundedImageView.getContext())
                    .load(item.getImageUrl())
                    .into(mRoundedImageView);
            mItem = item;
        }
    }

}



package com.smedialink.abakarmagomedov.dk_camp_mirror.models;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.OplevelserActivityFirst;
import com.smedialink.abakarmagomedov.dk_camp_mirror.OplevelserFirstView;
import com.smedialink.abakarmagomedov.dk_camp_mirror.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpleveslerAdapter extends RecyclerView.Adapter<OpleveslerAdapter.OpleveslerActivityHolder> {

    private List<OpleveslerItem> listItems;
    private OplevelserFirstView mOpleListener;


    public OpleveslerAdapter(List<OpleveslerItem> listItems, @NonNull OplevelserFirstView opleListener){
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
        OpleveslerItem item = listItems.get(position);
        holder.bindView(item, mOpleListener);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    static class OpleveslerActivityHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.bigTextViewInActivityOpleveslerSecond) TextView bigText;
        @BindView(R.id.smallTextViewInActivityOpleveslerSecond) TextView smallText;
        @BindView(R.id.image_oplevesler_activity) RoundedImageView mRoundedImageView;
        private OpleveslerItem mItem;
        private OplevelserFirstView mOpleListener;

        @OnClick(R.id.linelayInOpleveslerList)
        void onImageClick(){
            mOpleListener.invoke();
            mItem.setFocused(true);
        }

        OpleveslerActivityHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindView(OpleveslerItem item, @NonNull OplevelserFirstView opleListener){
            mOpleListener = opleListener;
            bigText.setText(item.getBigText());
            smallText.setText(item.getSmallText());
            mRoundedImageView.setImageResource(item.getImage());
            mItem = item;
        }
    }



}



package com.example.weiqiliu.materialdesign;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter  extends RecyclerView.Adapter<ItemAdapter.MasonryView> {

    private ArrayList<String> items;

    public ItemAdapter(ArrayList<String> items) {
        this.items=items;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_card, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
//        masonryView.imageView.setImageResource(products.get(position).getImg());
//        masonryView.textView.setText(items.get(position));
//        int item=position % 2;
//        if(item==0){
//            masonryView.textView.setHeight(100);
//        }else if(item==1){
//            masonryView.textView.setHeight(220);
//        }else if(item==2){
//            masonryView.textView.setHeight(100);
//            masonryView.textView.setWidth(400);
//        }
//        masonryView.textView.setHeight(100*((position % 2)+1));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MasonryView extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView){
            super(itemView);
//            imageView= (ImageView) itemView.findViewById(R.id.masonry_item_img );
//            textView= (TextView) itemView.findViewById(R.id.masonry_item_title);
        }

    }
}

package com.app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.model.Products_Pojo;
import com.app.wiki.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder>
{
    private ArrayList<Products_Pojo> products_arrayList;
    private LayoutInflater layoutInflater;
    public Context context_adp;


    public ProductsAdapter(Context context, ArrayList<Products_Pojo> products_arrayList)
    {
        /*
         * RecyclerViewAdapter Constructor to Initialize Data which we get from RecyclerViewFragment
         **/
        context_adp = context;
        layoutInflater = LayoutInflater.from(context);
        this.products_arrayList = products_arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        /*
         * LayoutInflater is used to Inflate the view
         * from fragment_listview_adapter
         * for showing data in RecyclerView
         **/

        View view = layoutInflater.inflate(R.layout.product_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductsAdapter.MyViewHolder holder, int position)
    {
        /*
         * onBindViewHolder is used to Set all the respective data
         * to Textview or Imagview form worldpopulation_pojoArrayList
         * ArrayList Object.
         **/

        if (!TextUtils.isEmpty(products_arrayList.get(position).getTitle()))
        {

            Log.d("rahuladapter","position : "+position+" title: "+products_arrayList.get(position).getTitle());
            holder.title.setText(products_arrayList.get(position).getTitle());
//           String des = products_arrayList.get(position).getDesc().replaceAll("[-\\[\\]^/,'*:.!><~@#$%+=?|\"\\\\()]+", "");
            holder.desc.setText(products_arrayList.get(position).getDesc());
            holder.id.setText(products_arrayList.get(position).getId());
            if(products_arrayList.get(position).getImage().length() == 0)
            {
                holder.image_layout.setVisibility(View.GONE);
            }
            else
                {

                Picasso.with(context_adp).load(products_arrayList.get(position).getImage()).resize(150, 150)
                        .into(holder.image);
//                    holder.loader.setVisibility(View.GONE);
//                Picasso.with(context_adp).load((products_arrayList.get(position).getImage())).into(holder.image);
            }
        }
    }

    @Override
    public int getItemCount()
    {
        /*
         * getItemCount is used to get the size of respective worldpopulation_pojoArrayList ArrayList
         **/

        return products_arrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,desc,id;
         ImageView image;
         ProgressBar loader;
         RelativeLayout image_layout;
        /**
         * MyViewHolder is used to Initializing the view.
         **/

        MyViewHolder(View itemView)
        {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            id = itemView.findViewById(R.id.id);
            loader = itemView.findViewById(R.id.loader);
            image_layout = itemView.findViewById(R.id.image_layout);
            itemView.setTag(itemView);
        }
    }
}

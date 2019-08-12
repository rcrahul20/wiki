package com.app.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.model.Products_Pojo;
import com.app.wiki.R;
import java.util.ArrayList;



public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder>
{
    private ArrayList<Products_Pojo> products_arrayList;
    private LayoutInflater layoutInflater;


    public ProductsAdapter(Context context, ArrayList<Products_Pojo> products_arrayList)
    {
        /*
         * RecyclerViewAdapter Constructor to Initialize Data which we get from RecyclerViewFragment
         **/

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


            holder.title.setText(products_arrayList.get(position).getTitle());
           String des = products_arrayList.get(position).getDesc().replaceAll("[-\\[\\]^/,'*:.!><~@#$%+=?|\"\\\\()]+", "");
            holder.desc.setText(des);
            holder.id.setText(products_arrayList.get(position).getId());
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

        /**
         * MyViewHolder is used to Initializing the view.
         **/

        MyViewHolder(View itemView)
        {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);
            id = itemView.findViewById(R.id.id);
            itemView.setTag(itemView);
        }
    }
}

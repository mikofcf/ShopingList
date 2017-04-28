package com.milos.ftn.shopinglist.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;

import com.milos.ftn.shopinglist.Activities.ArticleListActivity;
import com.milos.ftn.shopinglist.Model.ShoppingList;
import com.milos.ftn.shopinglist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Milos on 4/27/2017.
 */

public class ShoppingListAdapter extends BaseAdapter {
    private List<ShoppingList> shoppingLists = new ArrayList<>();

    private final LayoutInflater layoutInflater;

        private final Context context;

    public ShoppingListAdapter(Context context, List<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return shoppingLists.size();
    }

    @Override
    public Object getItem(int position) {
        return shoppingLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ShoppingListAdapter.ViewHolder viewHolder;

        if (convertView == null) {
            // create a new view holder since we don't have a view to reuse
            viewHolder = new ShoppingListAdapter.ViewHolder();

            // inflate view item
            convertView = layoutInflater.inflate(R.layout.view_shopping_list, parent, false);

            // store the views in a view holder for later reuse
            //viewHolder.done = (CheckBox) convertView.findViewById(R.id.done);
            viewHolder.shopingList = (CheckedTextView) convertView.findViewById(R.id.shoppingList);
            // viewHolder.ammount = (TextView) convertView.findViewById(R.id.ammount);


            // save view holder for later reuse
            convertView.setTag(viewHolder);
        } else {
            // we already have a view holder
            viewHolder = (ShoppingListAdapter.ViewHolder) convertView.getTag();
        }

        // get item
        final ShoppingList shopingList = (ShoppingList) getItem(position);

        // populate view item with task's data
        viewHolder.shopingList.setText(shopingList.getName());
        viewHolder.shopingList.setCheckMarkDrawable(R.drawable.ic_check);



        viewHolder.shopingList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ShoppingList currentShoppingList = shoppingLists.get(position);

                // save the current state to task, needed because of cell reuse
                shoppingLists.set(position,currentShoppingList);
                Intent intent = new Intent(v.getContext(), ArticleListActivity.class);
                intent.putExtra("numberOfLists",getCount());
                context.startActivity(intent);

            }
        });



        return convertView;
    }

    private static class ViewHolder {

        private CheckedTextView shopingList;

    }

    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }

    public void setShoppingLists(List<ShoppingList> shoppingLists) {
        this.shoppingLists = shoppingLists;
    }
}

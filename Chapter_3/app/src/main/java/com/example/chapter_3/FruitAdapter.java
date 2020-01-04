package com.example.chapter_3;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import static com.example.chapter_3.MainActivity.adapter;
import static com.example.chapter_3.R.menu.menu;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private List<Fruit> mFruitList;
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener=null;
    int sum;
    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        TextView fruitNomber;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view){
            super(view);
            fruitView = view;
            fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            fruitName = (TextView)view.findViewById(R.id.fruit_name);
            fruitNomber = (TextView)view.findViewById(R.id.fruit_nomber);
        }
    }
    public FruitAdapter(List<Fruit> fruitList){
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final int position = holder.getAdapterPosition();
                sum = position;
                final Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked name is "+fruit.getName(),Toast.LENGTH_LONG).show();
                /*Snackbar.make(view,"是否删除该水果？",Snackbar.LENGTH_LONG).setAction("删除",new View.OnClickListener(){
                    @Override
                    public void onClick(View view1){
                        adapter.deleteFruit(position,adapter);
                        sum = sum - 1;
                    }
                }).addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        if(sum  != position){
                            Toast.makeText(view.getContext(), "已删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(view.getContext(), "未删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(view.getContext(),FruitAdapter.class);
                        MainActivity.initFruits();
                    }
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        //Toast.makeText(view.getContext(), "未删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                    }
                }).show();*/
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final int position = holder.getAdapterPosition();
                sum = position;
                final Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked image is "+fruit.getName(),Toast.LENGTH_LONG).show();
                /*Snackbar.make(view,"是否删除该水果？",Snackbar.LENGTH_LONG).setAction("删除",new View.OnClickListener(){
                    @Override
                    public void onClick(View view1){
                        adapter.deleteFruit(position,adapter);
                        sum = sum - 1;
                    }
                }).addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        if(sum  != position){
                            Toast.makeText(view.getContext(), "已删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(view.getContext(), "未删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(view.getContext(),FruitAdapter.class);
                        MainActivity.initFruits();
                    }
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        //Toast.makeText(view.getContext(), "未删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                    }
                }).show();*/
            }
        });
        holder.fruitView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                final int position = holder.getAdapterPosition();
                sum = position;
                final Fruit fruit = mFruitList.get(position);
                /*Snackbar.make(view,"是否删除该水果？",Snackbar.LENGTH_LONG).setAction("删除",new View.OnClickListener(){
                    @Override
                    public void onClick(View view1){
                        adapter.deleteFruit(position,adapter);
                        sum = sum - 1;
                    }
                }).addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        if(sum  != position){
                            Toast.makeText(view.getContext(), "已删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(view.getContext(), "未删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(view.getContext(),FruitAdapter.class);
                        MainActivity.initFruits();
                    }
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        //Toast.makeText(view.getContext(), "未删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                    }
                }).show();*/
                
                PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
                popupMenu.getMenuInflater().inflate(menu, popupMenu.getMenu());              //问题语句
                popupMenu.show();
                //弹出式菜单的菜单项点击事件
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    int position = holder.getAdapterPosition();

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.add:
                                Fruit orange = new Fruit("orange", R.drawable.orange_pic);
                                mFruitList.add(position, orange);
                                notifyItemInserted(position);
                                if (position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(view.getContext(), "add orange successfully.", Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case R.id.delete:
                                mFruitList.remove(position);
                                notifyItemRemoved(position);
                                if (position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(view.getContext(), "del successfully.", Toast.LENGTH_SHORT).show();
                                }
                            case R.id.update:
                                Fruit grape = new Fruit("grape", R.drawable.grape_pic);
                                mFruitList.set(position, grape);
                                notifyItemChanged(position);
                                if (position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(view.getContext(), "change the grape successfully.", Toast.LENGTH_SHORT).show();
                                }
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + item.getItemId());
                        }
                        return false;
                    }
                });
                return false;
            }
        });
        holder.fruitImage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View v) {
                final int position = holder.getAdapterPosition();
                sum = position;
                final Fruit fruit = mFruitList.get(position);
                Snackbar.make(view,"是否删除该水果？",Snackbar.LENGTH_LONG).setAction("删除",new View.OnClickListener(){
                    @Override
                    public void onClick(View view1){
                        adapter.deleteFruit(position,adapter);
                        sum = sum - 1;
                    }
                }).addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        if(sum  != position){
                            Toast.makeText(view.getContext(), "已删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(view.getContext(), "未删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(view.getContext(),FruitAdapter.class);
                        MainActivity.initFruits();
                    }
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        //Toast.makeText(view.getContext(), "未删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                    }
                }).show();
                /*PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());            //问题语句
                popupMenu.show();
                //弹出式菜单的菜单项点击事件

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    int position = holder.getAdapterPosition();

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.add:
                                Fruit orange = new Fruit("orange", R.drawable.orange_pic);
                                mFruitList.add(position, orange);
                                notifyItemInserted(position);
                                if (position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(view.getContext(), "add orange successfully.", Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case R.id.delete:
                                mFruitList.remove(position);
                                notifyItemRemoved(position);
                                if (position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(view.getContext(), "del successfully.", Toast.LENGTH_SHORT).show();
                                }
                            case R.id.update:
                                Fruit grape = new Fruit("grape", R.drawable.grape_pic);
                                mFruitList.set(position, grape);
                                notifyItemChanged(position);
                                if (position != getItemCount()) {
                                    notifyItemRangeChanged(position, getItemCount());
                                    Toast.makeText(view.getContext(), "change the grape successfully.", Toast.LENGTH_SHORT).show();
                                }
                        }
                        return false;
                    }
                });*/
                return false;
            }
        });
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        holder.fruitNomber.setText(String.valueOf(position+1));
    }
    @Override
    public int getItemCount(){
        return mFruitList.size();
    }

    private void deleteFruit(int position,FruitAdapter adapter){
        int length = mFruitList.size();
        for (int i = 0; i < length; i++){
            if(i == position){
                mFruitList.remove(i);
                break;
            }
        }
        adapter.notifyDataSetChanged();
        //initFruits();
    }
}

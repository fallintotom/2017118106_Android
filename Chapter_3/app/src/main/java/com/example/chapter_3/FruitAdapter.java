package com.example.chapter_3;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;

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
                final Fruit fruit = mFruitList.get(position);
                final MainActivity main = new MainActivity();
                //Toast.makeText(v.getContext(),"you clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();
                Snackbar.make(view,"是否删除该水果？",Snackbar.LENGTH_SHORT).setAction("删除",new View.OnClickListener(){
                    @Override
                    public void onClick(View view1){
                        main.deleteFruit(position);
                        ///Toast.makeText(view1.getContext(),"已删除"+fruit.getName(),Toast.LENGTH_SHORT).show();
                        //main.initFruits();
                    }
                }).addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        Toast.makeText(view.getContext(), "已删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(),FruitAdapter.class);
                        main.initFruits();
                        //main.startActivity(intent);
                    }
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        //Toast.makeText(view.getContext(), "Snackbar显示", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final int position = holder.getAdapterPosition();
                final Fruit fruit = mFruitList.get(position);
                final MainActivity main = new MainActivity();
                Snackbar.make(view,"是否删除该水果？",Snackbar.LENGTH_SHORT).setAction("删除",new View.OnClickListener(){
                    @Override
                    public void onClick(View view1){
                        main.deleteFruit(position);
                        //Toast.makeText(view1.getContext(),"已删除"+fruit.getName(),Toast.LENGTH_SHORT).show();
                        //main.initFruits();
                    }
                }).addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        Toast.makeText(view.getContext(), "已删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(),FruitAdapter.class);
                        main.initFruits();
                        //main.startActivity(intent);
                    }
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        //Toast.makeText(view.getContext(), "Snackbar显示", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        holder.fruitNomber.setText(String.valueOf(position+1));
    }
    @Override
    public int getItemCount(){
        return mFruitList.size();
    }
}

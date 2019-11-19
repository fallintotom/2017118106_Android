package com.example.chapter_3;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import static com.example.chapter_3.MainActivity.adapter;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private List<Fruit> mFruitList;
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
                final Fruit fruit = mFruitList.get(position);
                /*//创建弹出式菜单对象（最低版本11）
                PopupMenu popup = new PopupMenu(v.getContext(), v);//第二个参数是绑定的那个view
                //获取菜单填充器
                MenuInflater inflater = popup.getMenuInflater();
                //填充菜单
                inflater.inflate(R.menu.menu, popup.getMenu());
                //绑定菜单项的点击事件
                popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) v.getContext());
                //显示(这一行代码不要忘记了)
                popup.show();*/
                //Toast.makeText(v.getContext(),"you clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();
                Snackbar.make(view,"是否删除该水果？",Snackbar.LENGTH_LONG).setAction("删除",new View.OnClickListener(){
                    @Override
                    public void onClick(View view1){
                        adapter.deleteFruit(position,adapter);
                        ///Toast.makeText(view1.getContext(),"已删除"+fruit.getName(),Toast.LENGTH_SHORT).show();
                        //main.initFruits();
                    }
                }).addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        Toast.makeText(view.getContext(), "未删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(),FruitAdapter.class);
                        MainActivity.initFruits();
                        //main.startActivity(intent);
                    }
                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                        //Toast.makeText(view.getContext(), "Snackbar显示", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
            /*public boolean onMenuItemClick(MenuItem item) {
                // TODO Auto-generated method stub
                switch (item.getItemId()) {
                    case R.id.add:
                        Toast.makeText(this, "添加水果", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.delete:
                        Toast.makeText(this, "删除水果", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.update:
                        Toast.makeText(this, "修改水果", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return false;
            }*/

        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final int position = holder.getAdapterPosition();
                final Fruit fruit = mFruitList.get(position);
              //  final MainActivity main = new MainActivity();
                Snackbar.make(view,"是否删除该水果？",Snackbar.LENGTH_LONG).setAction("删除",new View.OnClickListener(){
                    @Override
                    public void onClick(View view1){
                       //MainActivity.deleteFruit(position);
                        adapter.deleteFruit(position,adapter);
                        //Toast.makeText(view1.getContext(),"已删除"+fruit.getName(),Toast.LENGTH_SHORT).show();
                        //main.initFruits();
                    }
                }).addCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                        Toast.makeText(view.getContext(), "已删除"+fruit.getName(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(),FruitAdapter.class);
                        MainActivity.initFruits();
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

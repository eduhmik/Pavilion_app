package com.example.eduh_mik.pavillion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static android.support.v7.recyclerview.R.styleable.RecyclerView;

public class recycleview extends AppCompatActivity {
    private ActivitySimpleListBinding mSimpleListBinding;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        //setTitle("Simple List");
        mSimpleListBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_receipt);

        List food = Util.getFoodList(this);

        mLayoutManager = new LinearLayoutManager(this);
        mSimpleListBinding.recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SimpleListAdapter(food);
        mSimpleListBinding.recyclerView.setAdapter(mAdapter);
         }

}


public class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.SimpleViewHolder> {

    private List<Food> mFood;

    public SimpleListAdapter(List<Food> food){
        mFood = food;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        if(viewType == TYPE_ITEM)  {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_menu, parent, false);
        SimpleViewHolder holder = new SimpleViewHolder(v);
        return holder;
    }

        else{
            View v =  LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_menu, parent, false);
            SimpleViewHolder holder = new SimpleViewHolder(v);
            return holder;
        }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder; int position) {
        final Food food = mFood.get(position);
        holder.getBinding().setVariable(BR.food, food);
        holder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mFood.size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {

        private ActivitySimpleListBinding listItemBinding;

        public SimpleViewHolder(View v) {
            super(v);
            listItemBinding = DataBindingUtil.bind(v);
        }

        public ActivitySimpleListBinding getBinding(){
            return listItemBinding;
        }
    }
}

    public class SimpleViewHolder {
    }
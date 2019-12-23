package com.example.hp.instargrambarmenutest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.hp.instargrambarmenutest.R;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {
    //1. context : 제공이 된다.(OnCreateViewHolder 에서 제공이 되는데, ViewGroup 으로 제공이 된다.)
    private int layout; // 부분화면 객체를 생성자로 받는것이다.
    private ArrayList<MainData> list;

    public MainAdapter(int layout, ArrayList<MainData> list) {
        this.layout = layout;
        this.list = list;
    }


    @NonNull //viewHolder 에 있는 화면을 객체화해서 해당된 viewHolder 를 리턴한다.
    @Override //getView 와 같다.
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // 레이아웃을 인플레이터 해서 메모리에 로딩을 한다.
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);

        // 해당된 viewHolde r의 아이디를 찾는다.
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;// getView 에서의 리턴값과 같다.
    }

    @Override // 이곳에서 바인딩을 해준다. 바인딩을 해주면 이 내용이 CustomViewHolder 에 들어온다.
    public void onBindViewHolder(@NonNull final MainAdapter.CustomViewHolder customViewHolder, final int position) {
        customViewHolder.imgProfile.setImageResource(list.get(position).getImgProfile());
        customViewHolder.txtName.setText(list.get(position).getTxtName());
        customViewHolder.txtContent.setText(list.get(position).getTxtContent());

        customViewHolder.itemView.setTag(position);
        customViewHolder.magnifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String currentName = customViewHolder.txtName.getText().toString().trim();
                Toast.makeText(v.getContext(), currentName, Toast.LENGTH_SHORT).show();
            }
        });

        customViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                String name = list.get(position).getTxtName();
                list.remove(position);
                notifyItemChanged(position);
                //position 이 바뀌었으니 빨리 recyclerView 를 해라
                Toast.makeText(v.getContext(), name + "님 삭제 완료", Toast.LENGTH_SHORT).show();


                return true;
            }
        });
    }

    @Override //getCount = list 의 사이즈를 준다.
    public int getItemCount() {
        return (list != null) ? (list.size()) : (0);
        //리스트 값이 null 이 아니면 사이즈를 주고 null 이라면 0을 준다.
    }

    //아까의 getView 를 분업화, inflater 와 binding, fidViewId 를 분업화.
    //그리고 매칭은 BindViewHolder 에서 시킨다.
    //현재 HolderView 가 객체화 되면 이곳에서 findViewId를 하게 된다.
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgProfile;
        public TextView txtName;
        public TextView txtContent;
        public ImageView magnifier;

        //itemView 에 viewHolder가 객체가 된 레이아웃 인플레이터가 전달이 된 상태이다. = 주소가 전달이 된다.
        public CustomViewHolder(@NonNull View itemView) {

            super(itemView);//여기에 레이아웃 인플레이터가 전달이 된 상태이다.
            imgProfile = itemView.findViewById(R.id.imgProfile);
            txtName = itemView.findViewById(R.id.txtName);
            txtContent = itemView.findViewById(R.id.txtContent);
            magnifier = itemView.findViewById(R.id.magnifier);
        }
    }
}
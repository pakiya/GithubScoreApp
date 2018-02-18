package pankaj.githubscore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pankaj.githubscore.controller.DetailActivity;
import pankaj.githubscore.model.Item;

/**
 * Created by Pankaj on 11/20/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemArrayList) {
        this.items = itemArrayList;
        this.context = applicationContext;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_user,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        holder.title.setText(items.get(position).getLogin());
        holder.link.setText(items.get(position).getHtmlUrl());

        Picasso.with(context)
                .load(items.get(position).getAvatarUrl())
                .placeholder(R.drawable.load)
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView userImage;
        public TextView title;
        public TextView link;


        public ViewHolder(View view) {
            super(view);

            userImage = view.findViewById(R.id.image_view);
            title = view.findViewById(R.id.title_txt);
            link = view.findViewById(R.id.github_link);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        Item clickedDataItem = items.get(pos);
                        Intent intent = new Intent(v.getContext(), DetailActivity.class);
                        intent.putExtra("login", items.get(pos).getLogin());
                        intent.putExtra("html_url", items.get(pos).getHtmlUrl());
                        intent.putExtra("avatar_url", items.get(pos).getAvatarUrl());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked "+clickedDataItem.getLogin(), Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }
    }

   /* public void setFilter(ArrayList<Item> newList){

        items = new ArrayList<>();
        items.addAll(newList);
        notifyDataSetChanged();
    }*/
}

package manageme.managemeapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import static manageme.managemeapp.R.drawable.ic_hammer;


public class MyRequestsAdapter extends RecyclerView.Adapter {







    public class MyViewHolder extends RecyclerView.ViewHolder {
        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
        }

    }






    public MyRequestsAdapter(Request[] requestedData) {
        super();
        System.out.println("MyRequestsAdapter constructor was called...");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //TODO: Add real values from firebase!
        ((MyViewHolder) holder).itemTitle.setText("a title a title");
        ((MyViewHolder) holder).itemDetail.setText("details details");
        ((MyViewHolder) holder).itemImage.setImageResource(ic_hammer);
    }

    @Override
    public int getItemCount() {
        //TODO
        return 5;
    }

}

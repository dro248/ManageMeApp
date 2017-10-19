package manageme.managemeapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static manageme.managemeapp.R.drawable.ic_hammer;
import static manageme.managemeapp.R.drawable.ic_picture;


public class MyRequestsAdapter extends RecyclerView.Adapter {

    public String[] dummyTitles = new String[]{
            "Leaky Sink",
            "Mold Problem!",
            "Hole in wall",
            "I lost my key...",
            "No internet. Please fix!",
            "Our Neighbors are too loud..."
    };

    public String[] dummyDetails = new String[]{
            "Unviewed",
            "Scheduled: Nov 18",
            "Unviewed:",
            "Viewed: Sept 20",
            "Viewed: Oct 18",
            "Viewed: Oct 18"
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;
        public Button fulfillButton;
        public Button discardButton;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
            fulfillButton = (Button) itemView.findViewById(R.id.fulfillButton);
            discardButton = (Button) itemView.findViewById(R.id.discardButton);
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        //TODO: Add real values from firebase!
        ((MyViewHolder) holder).itemTitle.setText(dummyTitles[position]);
        ((MyViewHolder) holder).itemDetail.setText(dummyDetails[position]);
        ((MyViewHolder) holder).itemImage.setImageResource(ic_picture);
        ((MyViewHolder) holder).fulfillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("FULFILL from card " + position);

                // TODO: Send FULFILL signal to database

                // TODO: On Success: Remove card from list


            }
        });
        ((MyViewHolder) holder).discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("DISCARD from card " + position);

                // TODO: Send DISCARD signal to database

                // TODO: On Success: Remove card from list

            }
        });
    }

    @Override
    public int getItemCount() {
        //TODO
        return 5;
    }

}

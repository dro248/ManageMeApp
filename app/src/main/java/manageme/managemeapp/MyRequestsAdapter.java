package manageme.managemeapp;

import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static manageme.managemeapp.R.drawable.ic_picture;


public class MyRequestsAdapter extends RecyclerView.Adapter {
    private DataBank bank = DataBank.getDataBank();
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;
        public Button discardButton;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
            discardButton = (Button) itemView.findViewById(R.id.discardButton);
        }
    }

    public MyRequestsAdapter() {
        super();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((MyViewHolder) holder).itemTitle.setText(bank.getRequest(position).getTitle());
        ((MyViewHolder) holder).itemDetail.setText(bank.getRequest(position).getStatus());
        ((MyViewHolder) holder).itemImage.setImageBitmap(bank.getRequest(position).getPhoto());

        ((MyViewHolder) holder).discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(bank.getPendingScreen());
                builder
                    .setTitle("Discard Request")
                    .setMessage("Are you sure you want to discard this request?")
                    .setNegativeButton("Discard", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked Discard button
                            bank.deleteRequest(position);
                            notifyDataSetChanged();
                            Toast.makeText(bank.getPendingScreen(), "Request Discarded.", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled Discard process
                        }
                    })
                    .create()
                    .show();
            }
        });
    }

    @Override
    public int getItemCount() { return bank.length(); }


}

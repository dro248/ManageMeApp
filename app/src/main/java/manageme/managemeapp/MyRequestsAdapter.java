package manageme.managemeapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



public class MyRequestsAdapter extends RecyclerView.Adapter {







    public class MyViewHolder extends RecyclerView.ViewHolder {
//        public TextView txtViewTitle;
//        public TextView otherTxtView;
//        public ImageView imgViewIcon;
//        public IMyViewHolderClickHandlerInstanceThing mListener;

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);
//            mListener = listener;
//            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.theView);
//            otherTxtView = (TextView) itemLayoutView.findViewById(R.id.theOtherView);
//            imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.image_view);
//            imgViewIcon.setOnClickListener(this);
//            itemLayoutView.setOnClickListener(this);

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
        //TODO
        ((MyViewHolder) holder).itemTitle.setText("a title a title");
        ((MyViewHolder) holder).itemDetail.setText("details details");
    }

    @Override
    public int getItemCount() {
        //TODO
        return 3;
    }

}

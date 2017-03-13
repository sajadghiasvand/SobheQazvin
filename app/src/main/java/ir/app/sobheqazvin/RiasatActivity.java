package ir.app.sobheqazvin;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RiasatActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<RiasatModel> mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riasat);

        mRecyclerView = (RecyclerView) findViewById(R.id.riasat_recyclerview);



        mDataset = new ArrayList<>();
        // specify an adapter (see also next example)
        mAdapter = new AlbumsAdapter(this,mDataset);


        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new GridLayoutManager(this,2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);

        RiasatModel x = new RiasatModel("Sajad");
        mDataset.add(x);
        x = new RiasatModel("Hamid");
        mDataset.add(x);
        x = new RiasatModel("Morteza");
        mDataset.add(x);

        mAdapter.notifyDataSetChanged();
    }

    public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {
        private Context mContext;
        private List<RiasatModel> albumList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView title;

            public MyViewHolder(View view) {
                super(view);
                title = (TextView) view.findViewById(R.id.title);

            }
        }


        public AlbumsAdapter(Context mContext, List<RiasatModel> albumList) {
            this.mContext = mContext;
            this.albumList = albumList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.risat_list_row, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            RiasatModel album = albumList.get(position);
            holder.title.setText(album.getName());

            // loading album cover using Glide library



        }





        @Override
        public int getItemCount() {
            return albumList.size();
        }
    }

}


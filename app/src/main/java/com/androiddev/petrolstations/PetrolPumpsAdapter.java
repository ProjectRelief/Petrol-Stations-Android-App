package com.androiddev.petrolstations;

import static android.app.PendingIntent.getActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PetrolPumpsAdapter extends FirebaseRecyclerAdapter<PumpsModel, PetrolPumpsAdapter.myviewholder> {
    PumpsModel model1;

    public PetrolPumpsAdapter(@NonNull FirebaseRecyclerOptions<PumpsModel> options) {
        super(options);
//        this.firebaseRecyclerOptions = options;
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull PumpsModel model) {
//        Glide.with(holder.img.getContext()).load(model.getImg()).into(holder.img);
        holder.name.setText(model.getPumpName());
        holder.petrolcost.setText(model.getPetrol());
        holder.dieselcost.setText(model.getDiesel());
        holder.location.setText(model.getLocation());
        holder.food.setText(model.getFood());
        holder.cashless.setText(model.getCashless());
        holder.air.setText(model.getAir());
        holder.washroom.setText(model.getWashrooms());
        this.model1 = model;
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
//                        Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
//                startActivity(intent);
                Bundle bundle = new Bundle();
                bundle.putString("latKey",model.getLat());
                bundle.putString("lngKey",model.getLng());
                MapsFragment mapsFragment = new MapsFragment();
                mapsFragment.setArguments(bundle);
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame,mapsFragment,"MapsFragment").addToBackStack("MapsFragment").commit();
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());
                progressDialog.setMessage("Maps Loading...");
//                progressDialog.setTitle();
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                },2000);
            }
        });
    }



    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pumps,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView name,petrolcost,dieselcost,location,food,washroom,air,cashless;
        CardView card;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.pumpName);
            petrolcost = (TextView)itemView.findViewById(R.id.petrolcost);
            dieselcost = (TextView) itemView.findViewById(R.id.dieselcost);
            location = (TextView) itemView.findViewById(R.id.location);
            food = (TextView) itemView.findViewById(R.id.restaurantServiceTextView);
            washroom = (TextView) itemView.findViewById(R.id.washroomServiceTextView);
            air = (TextView) itemView.findViewById(R.id.airServiceTextView);
            cashless = (TextView) itemView.findViewById(R.id.paymentServiceTextView);
            card = (CardView) itemView.findViewById(R.id.card);
//            this.onNoteListener = onNoteListener;
        }
    }
}

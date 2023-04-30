package com.androiddev.petrolstations;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PetrolPumpsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PetrolPumpsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recview;
    PetrolPumpsAdapter PetrolAdapter;
    LinearLayoutManager nestedLayoutManager;
    FirebaseRecyclerOptions<PumpsModel> options;

    public PetrolPumpsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PetrolPumpsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PetrolPumpsFragment newInstance(String param1, String param2) {
        PetrolPumpsFragment fragment = new PetrolPumpsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_petrol_pumps, container, false);


        recview = (RecyclerView)view.findViewById(R.id.rec_view);
        nestedLayoutManager = new LinearLayoutManager(getActivity());
        nestedLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recview.setLayoutManager(nestedLayoutManager);
        options =
                new FirebaseRecyclerOptions.Builder<PumpsModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("PetrolBunks"), PumpsModel.class)
                        .build();
        PetrolAdapter = new PetrolPumpsAdapter(options);
        recview.setAdapter(PetrolAdapter);
        PetrolAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        PetrolAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        PetrolAdapter.stopListening();
    }

}
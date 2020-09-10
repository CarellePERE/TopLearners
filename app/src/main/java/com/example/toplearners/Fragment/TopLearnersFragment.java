package com.example.toplearners.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toplearners.R;
import com.example.toplearners.Adapter.TopLearnersRecyclerAdapter;
import com.example.toplearners.api.ApiClient;
import com.example.toplearners.model.learners;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TopLearnersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopLearnersFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TopLearnersRecyclerAdapter mTopLearnersRecyclerAdapter;
    private RecyclerView mRecyclerView;

    public TopLearnersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TopLearnersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TopLearnersFragment newInstance(String param1, String param2) {
        TopLearnersFragment fragment = new TopLearnersFragment();
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

    public void getAllusers()
    {
        Call<List<learners>> learnersList = ApiClient.getGadsApi().getAllUsers();
        learnersList.enqueue(new Callback<List<learners>>() {
            @Override
            public void onResponse(Call<List<learners>> call, Response<List<learners>> response) {
                if (response.isSuccessful())
                {
                    List<learners> learnersL = response.body();
                    mTopLearnersRecyclerAdapter.setData(learnersL);
                    mRecyclerView.setAdapter(mTopLearnersRecyclerAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<learners>> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_top_learners, container, false);
        mRecyclerView = view.findViewById(R.id.learners_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mTopLearnersRecyclerAdapter = new TopLearnersRecyclerAdapter();
        getAllusers();

        return view;

    }
}
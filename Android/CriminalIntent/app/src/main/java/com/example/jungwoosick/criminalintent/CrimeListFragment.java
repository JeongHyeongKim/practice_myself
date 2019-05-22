package com.example.jungwoosick.criminalintent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

import static android.bluetooth.BluetoothHidDeviceAppQosSettings.MAX;

public class CrimeListFragment extends Fragment {
    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";
    private static final String SAVED_DETAILTID = "detail id";
    private static final int REQUEST_CRIME = 1;
    private final String TAG = "ListFragment";

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private boolean mSubtitleVisible;
    private Callbacks mCallbacks;
    private UUID mDetailId;
    private int mLastPagerPosition = -1;

    /**
     * Required interface for hosting activities
     */
    public interface Callbacks {
        void onCrimeSelected(Crime crime);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbacks = (Callbacks) context;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);
        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        if (savedInstanceState != null) {
            mSubtitleVisible = savedInstanceState.getBoolean(SAVED_SUBTITLE_VISIBLE);
        }

        updateUI();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mDetailId != null) {
            Log.d(TAG, mDetailId.toString());
        }
        LinearLayoutManager manager = (LinearLayoutManager)mCrimeRecyclerView.getLayoutManager();
        int firstPos = manager.findFirstCompletelyVisibleItemPosition();
        int lastPos = manager.findLastCompletelyVisibleItemPosition();
        if (mLastPagerPosition >= 0 && firstPos < lastPos) {
            if (mLastPagerPosition < firstPos) {
                manager.scrollToPosition(mLastPagerPosition);
            } else if (mLastPagerPosition > lastPos) {
                manager.scrollToPosition(mLastPagerPosition);
            }
        }
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE, mSubtitleVisible);
        if (mDetailId != null) {
            outState.putString(SAVED_DETAILTID, mDetailId.toString());
        }

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_crime_list, menu);

        MenuItem subtitleItem = menu.findItem(R.id.show_subtitle);
        if (mSubtitleVisible) {
            subtitleItem.setTitle(R.string.hide_subtitle);
        } else {
            subtitleItem.setTitle(R.string.show_subtitle);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_crime:
                Crime crime = new Crime();
                mDetailId = crime.getId();
                CrimeLab.get(getActivity()).addCrime(crime);
                updateUI();
                mCallbacks.onCrimeSelected(crime);
                return true;
            case R.id.show_subtitle:
                mSubtitleVisible = !mSubtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateSubtitle() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        int crimeCount = crimeLab.getCrimes().size();
        String subtitle = getString(R.string.subtitle_format, crimeCount);
        if (!mSubtitleVisible) {
            subtitle = null;
        }
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    public void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        if (true/*mAdapter == null*/) {
            mAdapter = new CrimeAdapter(crimes);
            mCrimeRecyclerView.setAdapter(mAdapter);
        } else {
            for (int index = 0; index < crimes.size(); index++) {
                Crime oneCrime = crimes.get(index);
                if (oneCrime.isDirty()) {
                    mAdapter.notifyItemChanged(index);
                }
            }
        }
//        for (int index = 0; index < crimes.size(); index++) {
//            Crime oneCrime = crimes.get(index);
//            if (oneCrime.isDirty()) {
//                mAdapter.notifyItemChanged(index);
//            }
//        }
//        if (mAdapter == null) {
//            mAdapter = new CrimeAdapter(crimes);
//            mCrimeRecyclerView.setAdapter(mAdapter);
//        } else {
//            boolean inserted = mAdapter.getItemCount() < crimes.size();
//            mAdapter.setCrimes(crimes);
//            int itemPostion = -1;
//            if (mDetailId != null) {
//                for (int index = 0; index < crimes.size(); index++) {
//                    if (crimes.get(index).getId().equals(mDetailId)) {
//                        itemPostion = index;
//                        break;
//                    }
//                }
//            }//민기 왔다감
//            if (itemPostion >= 0) {
//                if (inserted) {
//                    mAdapter.notifyItemInserted(itemPostion);
//                } else {
//                    mAdapter.notifyItemChanged(itemPostion);
//                }
//            } else {
//                mAdapter.notifyDataSetChanged();
//            }
//        }
        updateSubtitle();
    }

    private class CrimeHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private Crime mCrime;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private ImageView mSolvedImageView;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.crime_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.crime_date);
            mSolvedImageView = (ImageView) itemView.findViewById(R.id.crime_solved);
        }
        public void bind(Crime crime) {
            Log.d(TAG, "bind: " + crime.getTitle());
            mCrime = crime;
            String title;
            if (crime.getTitle() == null) {
                title = getString(R.string.no_title);
            } else {
                title = crime.getTitle();
            }
            mTitleTextView.setText(title);
            mTitleTextView.setTextColor(crime.isSolved() ? Color.rgb(180,180,180) : Color.rgb(0,0,0));
            String dateString = Crime.getDateString(mCrime.getDate())
                    + " " + Crime.getTimeString(mCrime.getDate());
            mDateTextView.setText(dateString);
            mSolvedImageView.setVisibility(crime.isSolved() ? View.VISIBLE : View.GONE);
        }
        @Override
        public void onClick(View view) {
            mDetailId = mCrime.getId();
            CrimeLab.get(getActivity()).clearDirtyAll();
            mCallbacks.onCrimeSelected(mCrime);
        }

    }
    //민기 왔다감
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        int position = CrimePagerActivity.getCurrentPosition(data);
        Log.d(TAG, "onActivityResult: " + Integer.toString(position));

        mLastPagerPosition = position;
        if (requestCode == REQUEST_CRIME) {
            // Handle result
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {
        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(layoutInflater, parent);
        }
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bind(crime);
        }
        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
        public void setCrimes(List<Crime> crimes) {
            mCrimes = crimes;
        }
    }

}

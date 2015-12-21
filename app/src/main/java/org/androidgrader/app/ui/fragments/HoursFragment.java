package org.androidgrader.app.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.j256.ormlite.dao.Dao;
import org.androidgrader.app.R;
import org.androidgrader.app.db.DatabaseHelper;
import org.androidgrader.app.db.OrmLiteBaseFragment;
import org.androidgrader.app.db.WorkLogEntry;

import java.sql.SQLException;

public class HoursFragment extends OrmLiteBaseFragment{
    private OnFragmentInteractionListener mListener;
    private Dao<WorkLogEntry, ?> workLogEntryDAO;

    public static HoursFragment newInstance() {
        HoursFragment fragment = new HoursFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public HoursFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            workLogEntryDAO = getHelper().getDao(WorkLogEntry.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hours, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}

package org.androidgrader.app.ui.fragments;

import android.app.*;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;
import org.androidgrader.app.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GradeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GradeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GradeFragment extends Fragment {

    NumberPicker npPoints;
    NumberPicker npItems;
    NumberPicker npEntire;
    NumberPicker npHuge;
    NumberPicker npNormal;
    NumberPicker npTiny;

    TextView lblScore;

    Button btnNext;
    ImageButton btnInfo;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GradeFragment.
     */
    public static GradeFragment newInstance() {
        return new GradeFragment();
    }

    public GradeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grade, container, false);

        npPoints = (NumberPicker) view.findViewById(R.id.npPoints);
        npItems  = (NumberPicker) view.findViewById(R.id.npItems);
        npEntire = (NumberPicker) view.findViewById(R.id.npEntire);
        npHuge   = (NumberPicker) view.findViewById(R.id.npHuge);
        npNormal = (NumberPicker) view.findViewById(R.id.npNormal);
        npNormal = (NumberPicker) view.findViewById(R.id.npTiny);

        lblScore = (TextView) view.findViewById(R.id.lblScore);

        btnNext  = (Button)      view.findViewById(R.id.btnNext);
        btnInfo  = (ImageButton) view.findViewById(R.id.btnInfo);

        return view;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(Uri uri);
    }

}

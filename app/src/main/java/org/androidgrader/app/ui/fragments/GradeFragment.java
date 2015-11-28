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
import org.androidgrader.app.Submission;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GradeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GradeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GradeFragment extends Fragment {
    private Submission submission;

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
        npTiny   = (NumberPicker) view.findViewById(R.id.npTiny);

        NumberPicker[] numberPickers = {
                npPoints,
                npItems,
                npEntire,
                npHuge,
                npNormal,
                npTiny
        };


        for(NumberPicker numberPicker : numberPickers) {
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(100);
        }

        npPoints.setValue(10);
        npItems.setValue(10);

        lblScore = (TextView) view.findViewById(R.id.lblScore);

        btnNext  = (Button)      view.findViewById(R.id.btnNext);
        btnInfo  = (ImageButton) view.findViewById(R.id.btnInfo);

        submission = new Submission();

        updateScore();

        npItems.setOnValueChangedListener((picker, oldVal, newVal) -> {
            submission.setQuestions(newVal);

            updateScore();
        });

        npPoints.setOnValueChangedListener((picker, oldVal, newVal) -> {
            submission.setPoints(newVal);
            updateScore();
        });


        npEntire.setOnValueChangedListener((picker, oldVal, newVal) -> {
            submission.setEntireMistakes(newVal);
            updateScore();
        });

        npHuge.setOnValueChangedListener((picker, oldVal, newVal) -> {
            submission.setHugeMistakes(newVal);
            updateScore();
        });

        npNormal.setOnValueChangedListener((picker, oldVal, newVal) -> {

            submission.setNormalMistakes(newVal);
            updateScore();
        });

        npTiny.setOnValueChangedListener((picker, oldVal, newVal) -> {
            submission.setTinyMistakes(newVal);
            updateScore();
        });

        btnNext.setOnClickListener(v -> {
            submission.setEntireMistakes(0);
            submission.setHugeMistakes(0);
            submission.setNormalMistakes(0);
            submission.setTinyMistakes(0);

            npEntire.setValue(0);
            npHuge.setValue(0);
            npNormal.setValue(0);
            npTiny.setValue(0);

            updateScore();

        });

        return view;
    }

    private void updateScore() {
        float score = submission.grade() / npPoints.getValue();
        lblScore.setText(String.format("%.2f%%", Math.max(0, Math.min(100, score * 100))));


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

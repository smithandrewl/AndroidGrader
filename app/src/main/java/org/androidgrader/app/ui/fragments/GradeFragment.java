package org.androidgrader.app.ui.fragments;

import android.app.*;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import org.androidgrader.app.GradingKey;
import org.androidgrader.app.R;
import org.androidgrader.app.Submission;

public class GradeFragment extends Fragment {
    private Submission submission;

    private NumberPicker npPoints;
    private NumberPicker npItems;
    private NumberPicker npEntire;
    private NumberPicker npHuge;
    private NumberPicker npNormal;
    private NumberPicker npTiny;

    private TextView lblScore;

    private Button      btnNext;
    private ImageButton btnInfo;

    private OnFragmentInteractionListener mListener;

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

            numberPicker.setOnValueChangedListener((picker, oldVal, newVal) -> update());
        }

        npPoints.setValue(10);
        npItems.setValue(10);

        lblScore = (TextView) view.findViewById(R.id.lblScore);

        btnNext  = (Button)      view.findViewById(R.id.btnNext);
        btnInfo  = (ImageButton) view.findViewById(R.id.btnInfo);

        btnInfo.setOnClickListener(v -> {
            GradingKey key    = submission.getGradingKey();
            String     format = "Entire = %.2f, Huge = %.2f, Normal = %.2f, Tiny = %.2f";

            String msg = String.format(
                    format,
                    key.getEntireWorth(),
                    key.getHugeWorth(),
                    key.getNormalWorth(),
                    key.getTinyWorth()
            );

            Toast.makeText(getActivity().getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        });

        submission = new Submission();

        update();

        btnNext.setOnClickListener(v -> {
            submission.setEntireMistakes(0);
            submission.setHugeMistakes(0);
            submission.setNormalMistakes(0);
            submission.setTinyMistakes(0);

            updateView();
        });

        return view;
    }

    private void updateModel() {
        int entireMistakes = npEntire.getValue();
        int hugeMistakes   = npHuge.getValue();
        int normalMistakes = npNormal.getValue();
        int tinyMistakes   = npTiny.getValue();

        submission.setQuestions(npItems.getValue());
        submission.setPoints(npPoints.getValue());
        submission.setEntireMistakes(entireMistakes);
        submission.setHugeMistakes(hugeMistakes);
        submission.setNormalMistakes(normalMistakes);
        submission.setTinyMistakes(tinyMistakes);
    }

    private void updateView() {
        npItems.setValue(submission.getQuestions());
        npPoints.setValue(submission.getPoints());
        npEntire.setValue(submission.getEntireMistakes());
        npHuge.setValue(submission.getHugeMistakes());
        npNormal.setValue(submission.getNormalMistakes());
        npTiny.setValue(submission.getTinyMistakes());

        float score        = submission.grade() / (float) submission.getPoints();
        float clampedScore = Math.max(0, Math.min(100, score * 100));

        String percent = String.format("%.2f%%", clampedScore);
        String numeric = String.format("%.2f", submission.grade());

        String scoreText = String.format("%s / %s\n%s", numeric, submission.getPoints(), percent);
        lblScore.setText(scoreText);
    }

    private void update() {
        updateModel();
        updateView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState != null) {
            submission.setEntireMistakes(savedInstanceState.getInt("EntireMistakes"));
            submission.setHugeMistakes(savedInstanceState.getInt("HugeMistakes"));
            submission.setNormalMistakes(savedInstanceState.getInt("NormalMistakes"));
            submission.setTinyMistakes(savedInstanceState.getInt("TinyMistakes"));

            submission.setQuestions(savedInstanceState.getInt("Questions"));
            submission.setPoints(savedInstanceState.getInt("Points"));
        }

        updateView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("EntireMistakes", submission.getEntireMistakes());
        outState.putInt("HugeMistakes", submission.getHugeMistakes());
        outState.putInt("NormalMistakes", submission.getNormalMistakes());
        outState.putInt("TinyMistakes", submission.getTinyMistakes());

        outState.putInt("Questions", submission.getQuestions());
        outState.putInt("Points", submission.getPoints());


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
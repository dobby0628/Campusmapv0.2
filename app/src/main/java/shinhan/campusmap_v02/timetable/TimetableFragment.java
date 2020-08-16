package shinhan.campusmap_v02.timetable;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import shinhan.campusmap_v02.R;

public class TimetableFragment extends Fragment {

    private ArrayAdapter timetable_main_nameAdapter;
    private Spinner timetable_main_nameSpinner;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public TimetableFragment() {
        // Required empty public constructor
    }

    public static TimetableFragment newInstance(String param1, String param2) {
        TimetableFragment fragment = new TimetableFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);
        final Fragment TimetableSearchFragment = new TimetableSearchFragment();
        final Fragment TimetableNameFragment = new TimetableNameFragment();

        final Fragment TimetableFragment = new TimetableFragment();

        final FragmentTransaction transaction = getFragmentManager().beginTransaction();

        ImageView timetable_main_addBtn = (ImageView) view.findViewById(R.id.timetable_main_addBtn);

        timetable_main_addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.add(R.id.timetable_main_frame, TimetableSearchFragment).addToBackStack(null).commit();
                //mainframe에 searchfragment추가 +백스택
            }
        });

        timetable_main_nameSpinner = (Spinner)view.findViewById(R.id.timetable_main_nameSpinner);
        timetable_main_nameAdapter = ArrayAdapter.createFromResource(getContext(), R.array.name, android.R.layout.simple_spinner_item);
        timetable_main_nameAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        timetable_main_nameSpinner.setAdapter(timetable_main_nameAdapter);

        timetable_main_nameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (timetable_main_nameSpinner.getSelectedItem().equals("시간표 추가")) {
                    transaction.add(R.id.timetable_main_frame, TimetableNameFragment).addToBackStack(null).commit();


                }else if(timetable_main_nameSpinner.getSelectedItem().equals("시간표 삭제")) {
                    new AlertDialog.Builder(getContext())
                            .setMessage("시간표를 삭제하시겠습니까?")
                            .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    transaction.add(R.id.timetable_main_frame, TimetableFragment).addToBackStack(null).commit();
                                }
                            })
                            .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
}




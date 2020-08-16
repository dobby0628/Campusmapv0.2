package shinhan.campusmap_v02.timetable;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import shinhan.campusmap_v02.R;

public class TimetableAddFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable_add, container, false);

        final Fragment TimetableSearchFragment = new TimetableSearchFragment();
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();

        View timetable_add_cancelBtn = (View) view.findViewById(R.id.timetable_add_cancelBtn);

        timetable_add_cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.add(R.id.timetable_main_frame, TimetableSearchFragment).addToBackStack(null).commit();
            }
        });

        View timetable_add_addBtn = (View) view.findViewById(R.id.timetable_add_addBtn);

        timetable_add_addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.timetable_add_addBtn:
                        new AlertDialog.Builder(getContext())
                                .setMessage("추가하시겠습니까?")
                                .setPositiveButton("추가", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        transaction.add(R.id.timetable_main_frame, TimetableSearchFragment).addToBackStack(null).commit();
                                    }
                                })
                                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                    }
                                })
                                .show();
                        break;
                }
            }
        });
        return view;
    }
}



        /*Spinner timetable_add_weekSpinner = (Spinner)findViewById(R.id.timetable_add_weekSpinner);
        timetable_add_weekSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //String week = timetable_add_weekSpinner.getSelectedItem().toString();

        Spinner timetable_add_periodSpinner = (Spinner)findViewById(R.id.timetable_add_periodSpinner);
        timetable_add_periodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //String period = timetable_add_periodSpinner.getSelectedItem().toString();

         */


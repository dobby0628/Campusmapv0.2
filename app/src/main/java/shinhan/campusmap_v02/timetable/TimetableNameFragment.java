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

public class TimetableNameFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable_name, container, false);
        final Fragment TimetableFragment = new TimetableFragment();
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();


        View timetable_name_cancelBtn = (View) view.findViewById(R.id.timetable_name_cancelBtn);

        timetable_name_cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.add(R.id.timetable_main_frame, TimetableFragment).addToBackStack(null).commit();    // 새로 불러올 Fragment의 Instance를 Main으로 전달
            }
        });

        View timetable_name_addBtn = (View) view.findViewById(R.id.timetable_name_addBtn);

        timetable_name_addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.timetable_name_addBtn:
                        new AlertDialog.Builder(getContext())
                                .setMessage("추가하시겠습니까?")
                                .setPositiveButton("추가", new DialogInterface.OnClickListener() {
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
                        break;
                }
            }
        });
        return view;
    }
}

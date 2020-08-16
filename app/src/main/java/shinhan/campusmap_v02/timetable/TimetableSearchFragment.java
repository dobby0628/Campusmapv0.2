package shinhan.campusmap_v02.timetable;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import shinhan.campusmap_v02.R;

public class TimetableSearchFragment extends Fragment {

    private SearchView timetable_search_searchview;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timetable_search, container, false);

        final Fragment TimetableAddFragment = new TimetableAddFragment();
        final Fragment TimetableFragment = new TimetableFragment();
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();

        timetable_search_searchview = view.findViewById(R.id.timetable_search_searchview);
        timetable_search_searchview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        timetable_search_searchview.setIconified(false);
            }
        });

        View timetable_search_addBtn = (View) view.findViewById(R.id.timetable_search_addBtn);

        timetable_search_addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.add(R.id.timetable_main_frame, TimetableAddFragment).addToBackStack("search").commit();
                //searchframe에 addfragment추가 +백스택
            }
        });

        ImageView timetable_search_cancelBtn = (ImageView) view.findViewById(R.id.timetable_search_cancelBtn);

        timetable_search_cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.replace(R.id.timetable_main_frame, TimetableFragment).commit();
                //x버튼-> timetable_main으로 이동
            }
        });

        return view;

    }


}

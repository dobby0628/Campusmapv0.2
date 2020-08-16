package shinhan.campusmap_v02.campusmap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import shinhan.campusmap_v02.MainActivity;
import shinhan.campusmap_v02.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CampusmapBuildingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CampusmapBuildingFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private FloatingActionButton campusmap_route_btn;

    public CampusmapBuildingFragment() {
        // Required empty public constructor
    }

    public static CampusmapBuildingFragment newInstance(String param1, String param2) {
        CampusmapBuildingFragment fragment = new CampusmapBuildingFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_campusmap_building, container, false);

        campusmap_route_btn = v.findViewById(R.id.campusmap_route_btn);

        campusmap_route_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 건물 이름 보내기
                ((MainActivity)getActivity()).replaceCampusmapFragment(CampusmapRouteFragment.newInstance("a", "b"));
            }
        });

        return v;
    }
}
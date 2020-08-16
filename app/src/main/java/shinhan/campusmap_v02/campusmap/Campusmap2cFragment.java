package shinhan.campusmap_v02.campusmap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import shinhan.campusmap_v02.MainActivity;
import shinhan.campusmap_v02.R;

public class Campusmap2cFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton campusmap_2c_imagebtn;

    public Campusmap2cFragment() {
        // Required empty public constructor
    }

    public static Campusmap2cFragment newInstance(String param1, String param2) {
        Campusmap2cFragment fragment = new Campusmap2cFragment();
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
        View v = inflater.inflate(R.layout.fragment_campusmap_2c, container, false);

        campusmap_2c_imagebtn = v.findViewById(R.id.campusmap_2c_imagebtn);

        campusmap_2c_imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceCampusmapFragment(CampusmapBuildingFragment.newInstance("a", "b"));
            }
        });

        return v;
    }
}
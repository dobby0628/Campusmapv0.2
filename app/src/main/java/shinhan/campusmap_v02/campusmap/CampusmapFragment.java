package shinhan.campusmap_v02.campusmap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import shinhan.campusmap_v02.MainActivity;
import shinhan.campusmap_v02.R;

public class CampusmapFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private ImageButton campusmap_imagebutton_microphone;
    private EditText campusmap_edittext_destination;
    private ImageButton campusmap_imagebutton_search;
    private FloatingActionButton campusmap_change_btn;

    private FrameLayout campusmap_framelayout;
    private FragmentTransaction transaction;

    private Integer Clicknum = 0;

    public CampusmapFragment() {
        // Required empty public constructor
    }

    public static CampusmapFragment newInstance(String param1, String param2) {
        CampusmapFragment fragment = new CampusmapFragment();
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
        View v = inflater.inflate(R.layout.fragment_campusmap, container, false);

        campusmap_imagebutton_microphone = v.findViewById(R.id.campusmap_imagebutton_microphone);
        campusmap_edittext_destination = v.findViewById(R.id.campusmap_edittext_destination);
        campusmap_imagebutton_search = v.findViewById(R.id.campusmap_imagebutton_search);
        campusmap_framelayout = v.findViewById(R.id.campusmap_framelayout);
        campusmap_change_btn = v.findViewById(R.id.campusmap_change_btn);

        campusmap_imagebutton_microphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // stt 기능 넣기
                // 이후 말한 내용이 edittext에 들어가도록 만들기
            }
        });

        campusmap_edittext_destination.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ((MainActivity)getActivity()).replaceCampusmapFragment(CampusmapListFragment.newInstance("a", "b"));
                return false;
            }
        });

        campusmap_imagebutton_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // edittext에 입력한 텍스트 결과 campusmaplist에 나타내기
            }
        });

        campusmap_change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clicknum++;
                if(Clicknum % 2 == 0)
                    ((MainActivity)getActivity()).replaceCampusmapFragment(Campusmap1cFragment.newInstance("a", "b"));
                else
                    ((MainActivity)getActivity()).replaceCampusmapFragment(Campusmap2cFragment.newInstance("a", "b"));
            }
        });

        ((MainActivity)getActivity()).replaceCampusmapFragment(Campusmap1cFragment.newInstance("a", "b"));

        return v;
    }
}
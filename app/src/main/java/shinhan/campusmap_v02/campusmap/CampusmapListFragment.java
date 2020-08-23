package shinhan.campusmap_v02.campusmap;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import shinhan.campusmap_v02.MainActivity;
import shinhan.campusmap_v02.R;

public class CampusmapListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView campusmap_class_listview;
    String[] classname = {"신한대학교", "종합정보시스템", "사이버캠퍼스", "중앙도서관", "취창업지원처",
            "인터넷증명발급"};

    public CampusmapListFragment() {
        // Required empty public constructor
    }

    public static CampusmapListFragment newInstance(String param1, String param2) {
        CampusmapListFragment fragment = new CampusmapListFragment();
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
            Toast.makeText(getContext(), mParam1, Toast.LENGTH_SHORT).show();
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_campusmap_list, container, false);

        campusmap_class_listview = v.findViewById(R.id.campusmap_class_listview);

        ArrayAdapter CampusmapTxtAdapter = new CampusmapTxtAdapter(getContext(), classname);
        campusmap_class_listview.setAdapter(CampusmapTxtAdapter);

        campusmap_class_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent mIntent = new Intent(Intent.ACTION_VIEW);
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position ==  0) {
                    ((MainActivity)getActivity()).replaceCampusmapFragment(CampusmapDetailFragment.newInstance("a", "b"));
                }
            }
        });

        return v;
    }
}
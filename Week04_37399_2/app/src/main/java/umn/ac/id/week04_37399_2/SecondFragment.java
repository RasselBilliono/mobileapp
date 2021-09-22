package umn.ac.id.week04_37399_2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import umn.ac.id.week04_37399_2.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    FragmentSecondBinding bind;
    Bundle result;
    String dataFromFrag, getData;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bind = FragmentSecondBinding.inflate(inflater,container, false);
        return bind.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bind.btnSendToFragment01.setOnClickListener(v -> {
            result = new Bundle();
            getData = bind.sendToFrag01.getText().toString();
            result.putString("data",getData);
            getParentFragmentManager().setFragmentResult("Frag1",result);
        });
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // https://developer.android.com/guide/fragments/communicate#fragment-result
        getParentFragmentManager().setFragmentResultListener("Frag2",this,
                (requestKey, result) -> {
                    dataFromFrag = result.getString("data");
                    bind.getFromFrag01.setText(dataFromFrag);
                    bind.getFromFrag01.setVisibility(View.VISIBLE);
                    Log.d("heroism","Trigger Fragment 2 : "+ dataFromFrag);
                });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind = null;
    }
}

package umn.ac.id.week04_37399_2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import umn.ac.id.week04_37399_2.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    FragmentFirstBinding bind;
    Bundle result;
    String dataFromFrag, getData;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bind = FragmentFirstBinding.inflate(inflater, container, false);
        return bind.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bind.btnSendToFragment02.setOnClickListener(v -> {
            result = new Bundle();
            getData = bind.sendToFrag02.getText().toString();
            result.putString("data",getData);
            getParentFragmentManager().setFragmentResult("Frag2",result);
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Using Lambda expression
        // https://developer.android.com/guide/fragments/communicate#fragment-result
        getParentFragmentManager().setFragmentResultListener("Frag1", this,
                (requestKey, result) -> {
                    dataFromFrag = result.getString("data");
                    bind.getFromFrag02.setText(dataFromFrag);
                    bind.getFromFrag02.setVisibility(View.VISIBLE);
                    Log.d("heroism","Trigger Fragment 1 : "+ dataFromFrag);
                });
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        bind = null;
    }

}

package ir.app.sobheqazvin;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * Created by sajad on 12/03/2017.
 */

public class EntekhabatFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.entekhabat, container, false);
        ImageButton riasat = (ImageButton)view.findViewById(R.id.riasatbtn);
        riasat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent r = new Intent(getActivity().getApplication(),RiasatActivity.class);
                startActivity(r);
            }
        });

        return view;
    }
}

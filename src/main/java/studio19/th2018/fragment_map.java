package studio19.th2018;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;


public class fragment_map extends Fragment {

    ImageView imageView ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        getActivity().setTitle("TH 2018 | MAP");
        return inflater.inflate(R.layout.fragment_map, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("TH 2018 | MAP");
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.MapImage) ;
        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView) ;
        photoView.update();
    }

}
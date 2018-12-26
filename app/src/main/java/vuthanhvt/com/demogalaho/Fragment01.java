package vuthanhvt.com.demogalaho;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/12/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * TODO: Add a class header comment!
 */
public class Fragment01 extends Fragment implements Adapter.OnClickedListener {

    public static final String TAG = "Fragment01";
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_01, container, false);
        mRecyclerView = v.findViewById(R.id.recycler_view);
        List<String> mList = new ArrayList<>();
        mList.add("Item 01");
        mList.add("Item 02");
        mList.add("Item 03");
        mList.add("Item 04");
        mList.add("Item 05");
        mList.add("Item 06");
        mList.add("Item 07");
        mList.add("Item 08");
        mList.add("Item 09");
        mList.add("Item 10");
        mList.add("Item 11");
        mList.add("Item 12");
        mList.add("Item 13");
        mList.add("Item 14");
        mList.add("Item 15");
        mAdapter = new Adapter(mList, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        return v;
    }

    @Override
    public void onClickedListener(String name, int position) {
        Log.d(TAG, "onClickedListener: ");
        Intent intent = new Intent(getActivity(), DetailItemActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DETAIL_ITEM_NAME, name);
        bundle.putString(Constants.DETAIL_ITEM_POSITION, String.valueOf(position));
        intent.putExtra(Constants.DETAIL_ITEM_BUNDLE, bundle);
        startActivity(intent);
    }
}

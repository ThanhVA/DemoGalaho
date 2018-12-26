package vuthanhvt.com.demogalaho;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/12/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * TODO: Add a class header comment!
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<String> mList;

    private OnClickedListener mListener;

    public void setmListener(OnClickedListener mListener) {
        this.mListener = mListener;
    }

    public Adapter(List<String> mList, OnClickedListener mListener) {
        this.mList = mList;
        this.mListener = mListener;
    }

    public Adapter(List<String> mList) {
        if (mList == null) {
            this.mList = new ArrayList<>();
        } else {
            this.mList = mList;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClickedListener(mList.get(i), i);
                }
            }
        });
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String item = mList.get(i);
        viewHolder.textView.setText(item);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.expandedListItem);
        }
    }

    public interface OnClickedListener {
        void onClickedListener(String name, int position);
    }
}

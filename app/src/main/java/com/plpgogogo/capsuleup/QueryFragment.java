package com.plpgogogo.capsuleup;


import android.animation.Animator;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.plpgogogo.capsuleup.adapters.MyRecyclerViewAdapter;
import com.plpgogogo.capsuleup.database.Data;
import com.plpgogogo.capsuleup.utils.RotateUtil;
import com.plpgogogo.capsuleup.utils.TintUtil;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class QueryFragment extends Fragment implements View.OnClickListener{


    private View mView;

    private LinearLayout container;
    private CardView queryFrame, conditionFrame;

    private ImageView moreConditions, queryBtn;

    private ImageView signMoney, addMoney;
    private ImageView signType, addType;
    private ImageView signDate, addDate;
    private TextInputEditText etMoney;
    private TextView tvType, tvDate1, tvDate2;
    private RelativeLayout dateFrame;
    private LinearLayout frameDate1, frameDate2;

    private RecyclerView recyclerView;

    private float addDateY;

    public QueryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_query, container, false);

        container = (LinearLayout) mView.findViewById(R.id.container);
        queryFrame = (CardView) mView.findViewById(R.id.queryFrame);
        conditionFrame = (CardView) mView.findViewById(R.id.conditionFrame);

        moreConditions = (ImageView) mView.findViewById(R.id.moreConditions);
        queryBtn = (ImageView) mView.findViewById(R.id.queryBtn);
        signMoney = (ImageView) mView.findViewById(R.id.signMoney);
        signType = (ImageView) mView.findViewById(R.id.signType);
        signDate = (ImageView) mView.findViewById(R.id.signDate);
        addMoney = (ImageView) mView.findViewById(R.id.addMoney);
        addType = (ImageView) mView.findViewById(R.id.addType);
        addDate = (ImageView) mView.findViewById(R.id.addDate);
        addDateY = addDate.getY();
        etMoney = (TextInputEditText) mView.findViewById(R.id.etMoney);
        tvDate1 = (TextView) mView.findViewById(R.id.tvDate1);
        tvDate2 = (TextView) mView.findViewById(R.id.tvDate2);
        dateFrame = (RelativeLayout) mView.findViewById(R.id.dateFrame);
        frameDate1 = (LinearLayout) mView.findViewById(R.id.frame_date1);
        frameDate2 = (LinearLayout) mView.findViewById(R.id.frame_date2);

        recyclerView = (RecyclerView) mView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Data> datas = MainActivity.dataDao.loadAll();
        recyclerView.setAdapter(new MyRecyclerViewAdapter(getContext(), datas));


        initEvent();
        initDataFrame();

        return mView;
    }

    private void initEvent(){
        addMoney.setOnClickListener(this);
        addType.setOnClickListener(this);
        addDate.setOnClickListener(this);
        moreConditions.setOnClickListener(this);
        queryBtn.setOnClickListener(this);
    }

    private void initDataFrame(){
        LayoutTransition layoutTransition = new LayoutTransition();
        layoutTransition.setDuration(300);
        layoutTransition.addTransitionListener(new LayoutTransition.TransitionListener() {
            @Override
            public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                switch (transitionType){
                    case LayoutTransition.APPEARING:
                        RotateUtil.changeRotation(addDate, RotateUtil.ROTATE_TO_LIGHT_WITH_TRANSITION, frameDate1.getHeight());
                        break;
                    case LayoutTransition.DISAPPEARING:
                        RotateUtil.changeRotation(addDate, RotateUtil.ROTATE_TO_DARK_WITH_TRANSITION, frameDate2.getHeight());
                        break;
                }
            }

            @Override
            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {

            }
        });
        dateFrame.setLayoutTransition(layoutTransition);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.moreConditions:
                conditionFrame.setVisibility(conditionFrame.getVisibility() == View.VISIBLE? View.GONE: View.VISIBLE);
                break;
            case R.id.addMoney:
                if(v.getRotation() == 0f){
                    RotateUtil.changeRotation((ImageView) v, RotateUtil.ROTATE_TO_LIGHT, 0);
                }else{
                    RotateUtil.changeRotation((ImageView) v, RotateUtil.ROTATE_TO_DARK, 0);
                }
                break;
            case R.id.addType:
                if(v.getRotation() == 0f){
                    RotateUtil.changeRotation((ImageView) v, RotateUtil.ROTATE_TO_LIGHT, 0);
                }else{
                    RotateUtil.changeRotation((ImageView) v, RotateUtil.ROTATE_TO_DARK, 0);
                }
                break;
            case R.id.addDate:
                if(v.getRotation() == 0f){
                    RotateUtil.changeRotation((ImageView) v, RotateUtil.ROTATE_TO_LIGHT_WITH_TRANSITION, frameDate1.getHeight());
                    frameDate2.setVisibility(View.VISIBLE);
                }else{
                    frameDate2.setVisibility(View.GONE);
                    RotateUtil.changeRotation((ImageView) v, RotateUtil.ROTATE_TO_DARK_WITH_TRANSITION, addDateY);
                }
                break;
        }
    }
}

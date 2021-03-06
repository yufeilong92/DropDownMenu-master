package com.yyy.djk.dropdownmenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;

import java.util.List;


/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: LawerApp
 * @Package com.lawyee.apppublic.adapter
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/5/22 14:59
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */


public class JaaidOrgRlvAdapter extends BaseRecyclerAdapter<JaaidOrgRlvAdapter.ViewHolder> implements View.OnClickListener {


    private List<JaaidOrgVO> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public JaaidOrgRlvAdapter(List<JaaidOrgVO> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    private OnRecyclerViewItemClickListener itemClickListener = null;

    @Override
    public void onClick(View v) {
        if (itemClickListener != null) {
            itemClickListener.ItemClickListenet(v, (JaaidOrgVO) v.getTag());
        }
    }

    public interface OnRecyclerViewItemClickListener {
        void ItemClickListenet(View view, JaaidOrgVO vo);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = mInflater.inflate(R.layout.item_orgcontent, null);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, boolean isItem) {
        JaaidOrgVO vo = mData.get(position);
        holder.mTvOrgTitle.setText(vo.getName());
        holder.mTvOrgAddress.setText(vo.getAddress());
        holder.mTvOrgPhone.setText(vo.getTelephone());
        holder.itemView.setTag(mData.get(position));
    }


    @Override
    public int getAdapterItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTvOrgTitle;
        public TextView mTvOrgPhone;
        public TextView mTvOrgAddress;
        public ViewHolder(View itemView) {
            super(itemView);
            this.mTvOrgTitle = (TextView) itemView.findViewById(R.id.tv_org_title);
            this.mTvOrgPhone = (TextView) itemView.findViewById(R.id.tv_org_phone);
            this.mTvOrgAddress = (TextView) itemView.findViewById(R.id.tv_org_address);
        }
    }
}

package com.example.snackapp.adaptor;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.snackapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

//点菜左边适配器
public class SnackLeftAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public SnackLeftAdapter(List<String> types) {
        super(R.layout.item_snack_left, types);
    }

    /*= 设置item数据
     */
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, String s) {
        // 第一个item默认选中状态
        baseViewHolder.setText(R.id.snackLeftType, s);
    }
}

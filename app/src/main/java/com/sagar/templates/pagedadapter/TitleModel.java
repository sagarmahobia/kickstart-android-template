package com.sagar.templates.pagedadapter;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class TitleModel extends BaseObservable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

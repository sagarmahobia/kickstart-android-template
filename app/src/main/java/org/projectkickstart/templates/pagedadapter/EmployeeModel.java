package org.projectkickstart.templates.pagedadapter;

import androidx.databinding.BaseObservable;

public class EmployeeModel extends BaseObservable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

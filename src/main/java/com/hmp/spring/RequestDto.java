package com.hmp.spring;

import java.io.Serializable;
import java.util.List;

public class RequestDto implements Serializable {
    private List<Integer> ids;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    private Boolean selected;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

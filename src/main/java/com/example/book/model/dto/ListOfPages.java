package com.example.book.model.dto;

import java.util.ArrayList;
import java.util.List;

public class ListOfPages {
    List<Long> list = new ArrayList<>();

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }
}

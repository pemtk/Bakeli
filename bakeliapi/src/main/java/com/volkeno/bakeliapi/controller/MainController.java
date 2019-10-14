package com.volkeno.bakeliapi.controller;

import com.volkeno.bakeliapi.view.BakeliViewInterface;
import com.volkeno.bakeliapi.view.MainActivity;

/**
 * Created by Prince Eros Michel TOLA KOGADOU on .
 */
public class MainController {

    private BakeliViewInterface view;
    private DataCallController call;

    public MainController(BakeliViewInterface view, DataCallController call) {
        this.view = view;
        this.call = call;
        getUsersFromDataSource();
    }

    public void getUsersFromDataSource(){
        call.getBakeli(view);
    }
}

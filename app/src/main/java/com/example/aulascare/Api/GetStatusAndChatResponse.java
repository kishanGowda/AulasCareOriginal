package com.example.aulascare.Api;

import java.util.ArrayList;

public class GetStatusAndChatResponse {
    public int unreadMessages;
    public int page;
    public int limit;
    public ArrayList<Object> items;
    public ArrayList<OnlyOpen> onlyOpen;
    public ArrayList<OnlyClose> onlyClose;
    public ArrayList<Standard> standards;
    public boolean disableLoadEarlier;

}




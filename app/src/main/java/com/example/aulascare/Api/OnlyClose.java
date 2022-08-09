package com.example.aulascare.Api;

//public class GetStatusAndChatResponse {
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class OnlyClose {
    public int userId;
    public String message;
    public String createdAt;
    public String user_name;
    public String user_role;
    public String user_image;
    public int standardId;
    public String type;
    public String chat_createdAt;
    public String unreadMessage;
    public String closed;
}

package com.example.androidcore_paging;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *  Class to get Data from API.
 */
public class StackApiResponse {

    // If you wish to rename the object to any other name.
    @SerializedName("items")
    // List<> is use because per items there's multiple items.
    public List<Items> myItems;

    public Boolean has_more;
    public int quota_max;
    public int quota_remaining;

}


class Items{

    // Since, per item there is only 1 owner.
    public Owner owner;

    public boolean is_accepted;
    public int score;
    public long last_activity_date;
    public long last_edit_date;
    public long creation_date;
    public long answer_id;
    public long question_id;

}

class Owner{

    public int reputation;
    public long user_id;
    public String user_type;
    public String profile_image;
    public String display_name;
    public String link;

}


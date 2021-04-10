package com.example.myntraapp;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class PrefConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public PrefConfig(Context context)
    {
        this.context=context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file),Context.MODE_PRIVATE);
    }

    public void writeCommentStatus(boolean status)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.pref_see_comments),status);
        editor.commit();
    }

    public boolean readCommentStatus()
    {
        return sharedPreferences.getBoolean(context.getString(R.string.pref_see_comments),false);
    }

    public void writeComment(String comment)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_comment),comment);
        editor.commit();
    }

    public String readComment()
    {
        return sharedPreferences.getString(context.getString(R.string.pref_comment),"Comment");
    }

    public void writeName(String user)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_user),user);
        editor.commit();
    }

    public String readName()
    {
        return sharedPreferences.getString(context.getString(R.string.pref_user),"User");
    }

    public void displayToast(String msg)
    {
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
}

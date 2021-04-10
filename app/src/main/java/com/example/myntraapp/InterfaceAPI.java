package com.example.myntraapp;
 import retrofit2.Call;
 import retrofit2.http.GET;
 import retrofit2.http.Header;
 import retrofit2.http.POST;
 import retrofit2.http.Query;

public interface InterfaceAPI {
    @GET("send_comment.php")
     Call<User>SendComments(@Query("user") String user, @Query("product")String product,@Query("comment") String comment,@Query("vote") String vote);

    @GET("see_comments.php")
     Call<User>SeeComments(@Query("product")String product);
}

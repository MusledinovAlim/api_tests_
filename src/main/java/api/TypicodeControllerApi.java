package api;

import java.util.List;

import io.qameta.allure.Description;
import model.dto.CommentDto;
import model.dto.PostDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;


public interface TypicodeControllerApi {

    @GET("/posts")
    @Headers({"Accept: */*"})
    @Description("[GET]/posts - Получение сообщений")
    Call<List<PostDto>> getAllPosts();

    @GET("/posts/1")
    @Headers({"Accept: */*"})
    @Description("[GET]/posts/1 - Получение первого сообщения")
    Call<PostDto> getPosts1();

    @GET("/posts/1/comments")
    @Headers({"Accept: */*"})
    @Description("[GET]/posts/1/comments - Получение списка комментариев к первому сообщению")
    Call<List<CommentDto>> getAllCommentsPost1();

    @GET("/comments")
    @Headers({"Accept: */*"})
    @Description("[GET]/comments - Получение списка комментариев к сообщению")
    Call<List<CommentDto>> getAllCommentsPost(@Query("postId") Object postId);

    @POST("/posts")
    @Headers({"Content-Type: application/json", "Accept: */*"})
    @Description("[POST]/posts - Создание нового сообщения")
    Call<PostDto> addNewPost(@Body Object object);

    @PUT("/posts/1")
    @Headers({"Content-Type: application/json", "Accept: */*"})
    @Description("[PUT]/posts/1 - Обновление сообщения")
    Call<PostDto> updatePost(@Body Object object);

    @PATCH("/posts/1")
    @Headers({"Content-Type: application/json", "Accept: */*"})
    @Description("[PATCH]/posts/1 - Изменение сообщения")
    Call<PostDto> patchingPost(@Body Object object);

    @DELETE("/posts/1")
    @Description("[DELETE]/posts/1 - Удаление первого сообщения")
    Call<Object> deletePost1();
}

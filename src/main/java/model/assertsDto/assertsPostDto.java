package model.assertsDto;

import java.util.List;

import io.qameta.allure.Step;
import model.dto.PostDto;
import retrofit2.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class assertsPostDto {

    @Step("Проверка, что поля всех PostDto(в response body) не пустые")
    public static void assertNotNullFieldsPostsDto(Response<List<PostDto>> response) {
        List<PostDto> body = response.body();
        assert body != null;
        body.forEach((post) -> assertNotNull(post.getUserId(), "Поле UserId = null"));
        body.forEach((post) -> assertNotNull(post.getId(), "Поле Id = null"));
        body.forEach((post) -> assertNotNull(post.getTitle(), "Поле Title = null"));
        body.forEach((post) -> assertNotNull(post.getBody(), "Поле Body = null"));
    }

    @Step("Проверка, что поля PostDto(в response body) не пустые")
    public static void assertNotNullFieldsPostDto(Response<PostDto> response) {
        PostDto body = response.body();
        assert body != null;
        assertNotNull(body.getUserId(), "Поле UserId = null");
        assertNotNull(body.getId(), "Поле Id = null");
        assertNotNull(body.getTitle(), "Поле Title = null");
        assertNotNull(body.getBody(), "Поле Body = null");
    }

    @Step("Проверка,что поля объекта PostDto(в response body) соответствуют отправленным")
    public static void assertValueFieldsPostDto(Response<PostDto> response, PostDto requestBody) {
        PostDto body = response.body();
        assert body != null;
        assertEquals(requestBody.getUserId(), body.getUserId(), "Поле UserId = " + body.getUserId() + ",а ожидали " + requestBody.getUserId());
        assertNotNull(body.getId(), "Поле Title = null");
        assertEquals(requestBody.getTitle(), body.getTitle(), "Поле Title = " + body.getTitle() + ",а ожидали " + requestBody.getTitle());
        assertEquals(requestBody.getBody(), body.getBody(), "Поле Body = " + body.getBody() + ",а ожидали " + requestBody.getBody());
    }

    @Step("Проверка, что поле '{fieldName}' содержит '{value}' в PostDto(в response body)")
    public static void assertValueFieldInPostDto(Response<PostDto> response, String fieldName, String value) {
        PostDto body = response.body();
        assert body != null;
        switch (fieldName) {
            case "userId":
                assertEquals(value, body.getUserId(), "Поле UserId = " + body.getUserId() + ",а ожидали " + value);
                break;
            case "id":
                assertEquals(value, body.getId(), "Поле Id = " + body.getId() + ",а ожидали " + value);
                break;
            case "title":
                assertEquals(value, body.getTitle(), "Поле Title = " + body.getTitle() + ",а ожидали " + value);
                break;
            case "body":
                assertEquals(value, body.getBody(), "Поле ody = " + body.getBody() + ",а ожидали " + value);
                break;
        }
    }
}

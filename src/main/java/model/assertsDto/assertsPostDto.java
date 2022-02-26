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
        body.forEach((post) -> assertNotNull(post.getUserId()));
        body.forEach((post) -> assertNotNull(post.getId()));
        body.forEach((post) -> assertNotNull(post.getTitle()));
        body.forEach((post) -> assertNotNull(post.getBody()));
    }

    @Step("Проверка, что поля PostDto(в response body) не пустые")
    public static void assertNotNullFieldsPostDto(Response<PostDto> response) {
        PostDto body = response.body();
        assert body != null;
        assertNotNull(body.getUserId());
        assertNotNull(body.getId());
        assertNotNull(body.getTitle());
        assertNotNull(body.getBody());
    }

    @Step("Проверка,что поля объекта PostDto(в response body) соответствуют отправленным")
    public static void assertValueFieldsPostDto(Response<PostDto> response, PostDto requestBody) {
        PostDto body = response.body();
        assert body != null;
        assertEquals(requestBody.getUserId(), body.getUserId());
        assertNotNull(body.getId());
        assertEquals(requestBody.getTitle(), body.getTitle());
        assertEquals(requestBody.getBody(), body.getBody());
    }

    @Step("Проверка, что поле '{fieldName}' содержит '{value}' в PostDto(в response body)")
    public static void assertValueFieldInPostDto(Response<PostDto> response, String fieldName, String value) {
        PostDto body = response.body();
        assert body != null;
        switch (fieldName) {
            case "userId":
                assertEquals(value, body.getUserId());
                break;
            case "id":
                assertEquals(value, body.getId());
                break;
            case "title":
                assertEquals(value, body.getTitle());
                break;
            case "body":
                assertEquals(value, body.getBody());
                break;
        }
    }
}

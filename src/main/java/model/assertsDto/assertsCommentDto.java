package model.assertsDto;

import java.util.List;

import io.qameta.allure.Step;
import model.dto.CommentDto;
import retrofit2.Response;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class assertsCommentDto {

    @Step("Проверка,что поля объектов CommentDto(в response body) не пустые")
    public static void assertNotNullFieldsCommentDto(Response<List<CommentDto>> response) {
        List<CommentDto> body = response.body();
        assert body != null;
        body.forEach((post) -> assertNotNull(post.getPostId(), "Поле PostId = null"));
        body.forEach((post) -> assertNotNull(post.getId(), "Поле Id = null"));
        body.forEach((post) -> assertNotNull(post.getName(), "Поле Name = null"));
        body.forEach((post) -> assertNotNull(post.getEmail(), "Поле mail = null"));
        body.forEach((post) -> assertNotNull(post.getBody(), "Поле Body = null"));
    }
}

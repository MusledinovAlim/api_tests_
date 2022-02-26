import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.dto.ObjectDto;
import model.dto.PostDto;
import retrofit2.Response;

import static model.assertsDto.assertsCommentDto.assertNotNullFieldsCommentDto;
import static model.assertsDto.assertsPostDto.assertNotNullFieldsPostDto;
import static model.assertsDto.assertsPostDto.assertNotNullFieldsPostsDto;
import static model.assertsDto.assertsPostDto.assertValueFieldInPostDto;
import static model.assertsDto.assertsPostDto.assertValueFieldsPostDto;
import static model.generator.CommentDtoGenerator.genPostDto;
import static model.generator.CommentDtoGenerator.genPostDtoNotId;

public class TypicodeTests extends BaseTest {

    @Test
    @DisplayName("[GET]/posts - Получить список сообщений.Позитив")
    public void getAllPosts() throws IOException {
        Response response = getResponse(BaseTest.TYPICODE.getAllPosts());
        assertStatusCode(response, 200);
        assertNotNullHeaders(response);
        assertNotNullFieldsPostsDto(response);
    }

    @Test
    @DisplayName("[GET]/posts/1 - Получить первое сообщение.Позитив")
    public void getPosts1() throws IOException {
        Response response = getResponse(BaseTest.TYPICODE.getPosts1());
        assertStatusCode(response, 200);
        assertNotNullHeaders(response);
        assertNotNullFieldsPostDto(response);
    }

    @Test
    @DisplayName("[GET]/posts/1/comments - Получить список комментариев к первому сообщению.Позитив")
    public void getAllCommentsPost1() throws IOException {
        Response response = getResponse(BaseTest.TYPICODE.getAllCommentsPost1());
        assertStatusCode(response, 200);
        assertNotNullHeaders(response);
        assertNotNullFieldsCommentDto(response);
    }

    @Test
    @DisplayName("[GET]/comments - Получить список комментариев к сообщению.Позитив(передан postId)")
    public void getAllCommentsPost() throws IOException {
        Response response = getResponse(BaseTest.TYPICODE.getAllCommentsPost(1));
        assertStatusCode(response, 200);
        assertNotNullHeaders(response);
        assertNotNullFieldsCommentDto(response);
    }

    @Test
    @DisplayName("[POST]/posts - Создание нового сообщения.Позитив")
    public void addNewPost() throws IOException {
        PostDto requestBody = genPostDtoNotId();
        Response response = getResponse(BaseTest.TYPICODE.addNewPost(requestBody));
        assertStatusCode(response, 201);
        assertNotNullHeaders(response);
        assertValueFieldsPostDto(response, requestBody);
    }

    @Test
    @DisplayName("[POST]/posts - Создание нового сообщения.Негатив(передан невалидный body)")
    public void addNewPostNeg() throws IOException {
        Response response = getResponse(BaseTest.TYPICODE.addNewPost(false));
        assertNotNullHeaders(response);
        assertStatusCode(response, 500);
    }

    @Test
    @DisplayName("[PUT]/posts/1 - Обновление сообщения.Позитив")
    public void updatePost() throws IOException {
        PostDto requestBody = genPostDto();
        Response response = getResponse(BaseTest.TYPICODE.updatePost(requestBody));
        assertStatusCode(response, 200);
        assertNotNullHeaders(response);
        assertValueFieldsPostDto(response, requestBody);
    }

    @Test
    @DisplayName("[PATCH]/posts/1 - Изменение первого сообщения.Позитив")
    public void patchingPost() throws IOException {
        ObjectDto requestBody = new ObjectDto().setTitle("New test title");
        Response response = getResponse(BaseTest.TYPICODE.patchingPost(requestBody));
        assertStatusCode(response, 200);
        assertNotNullHeaders(response);
        assertNotNullFieldsPostDto(response);
        assertValueFieldInPostDto(response, "title", requestBody.getTitle());
    }

    @Test
    @DisplayName("[DELETE]/posts/1 - Удаление первого сообщения.Позитив")
    public void deletePost1() throws IOException {
        Response response = getResponse(BaseTest.TYPICODE.deletePost1());
        assertNotNullHeaders(response);
        assertStatusCode(response, 200);
    }
}

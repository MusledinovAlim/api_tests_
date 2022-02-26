package model.generator;



import model.dto.PostDto;

public class CommentDtoGenerator {

    public static PostDto genPostDtoNotId() {
        return new PostDto()
                .setUserId(1)
                .setTitle("testTitle")
                .setBody("testBody ");
    }

    public static PostDto genPostDto() {
        return new PostDto()
                .setUserId(1)
                .setId(1)
                .setTitle("testTitle")
                .setBody("testBody");
    }
}

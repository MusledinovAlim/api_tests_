package model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class CommentDto {
    private Integer postId;
    private Integer id;
    private String name;
    private String email;
    private String body;
}

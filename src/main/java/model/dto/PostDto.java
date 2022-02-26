package model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class PostDto {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}

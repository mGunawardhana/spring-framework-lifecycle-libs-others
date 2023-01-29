package lk.ijse.spring.util;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class ResponseUtil {
    private String state;
    private String message;
    private Object data;
}

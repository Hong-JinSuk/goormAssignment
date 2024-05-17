package TriCount.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Member {

    private Long id;

    @NotEmpty
    private String loginId;
    private String name;
    private String password;

    public Member() {
    }

}

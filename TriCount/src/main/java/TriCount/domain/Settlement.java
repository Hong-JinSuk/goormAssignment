package TriCount.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Settlement {

    private Long id;

    @NotEmpty
    private String name;
    private List<Member> joinMember = new ArrayList<>();

    public Settlement() {
    }

}

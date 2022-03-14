package org.enset.jpaenset.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name="DESCRIPTION")
    private String desc;
    private String rolename;
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    private List<UserC> users= new ArrayList<>();
}

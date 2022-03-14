package org.enset.jpaenset.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="USERS")
public class UserC {
    @Id
    private String userId;
    @Column(name = "",unique = true,length = 20)
    private String username ;
    private String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Role> roles=new ArrayList<>();

}

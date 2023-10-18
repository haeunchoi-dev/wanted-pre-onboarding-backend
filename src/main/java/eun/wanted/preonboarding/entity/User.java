package eun.wanted.preonboarding.entity;

import eun.wanted.preonboarding.entity.common.DateField;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Table(name = "users"
)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User  extends DateField {
    @Id
    @UuidGenerator
    private UUID id;

    private String name;
    private String password;
}

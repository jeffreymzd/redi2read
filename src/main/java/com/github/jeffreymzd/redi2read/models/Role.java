package com.github.jeffreymzd.redi2read.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

/**
 * Created by jeffreymzd on 4/13/21
 */
@Builder
@Data // adds @ToString, @EqualsAndHashCode, @Getter/@Setter, and a @RequiredArgsConstructor
@RedisHash // to map an instance of Role to a Redis Hash
public class Role {
    @Id
    private String id;
    @Indexed
    private String name;
}

package br.com.dazo.springredis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@RedisHash("UserEntity")
public class UserEntity implements Serializable {

    @Id
    private Long id;

    private String name;

    private BigDecimal salary;

}

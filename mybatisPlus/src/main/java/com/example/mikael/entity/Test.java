package com.example.mikael.entity;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;
import sun.util.resources.ga.LocaleNames_ga;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * test
 *
 * @author
 */


@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Test implements Serializable {
    @TableId
    private Long id;

    private String name;

    private Date time;

    private static final long serialVersionUID = 1L;

    public Test(String name) {
        this.name = name;
    }
}
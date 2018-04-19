package com.wangpu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * Created by Kenvin on 2017/10/15.
 */
@Getter
@Setter
@NoArgsConstructor
public class Demo3 {
    @Length(min = 5, max = 17, message = "length长度在[5,17]之间")
    private String extField;
}

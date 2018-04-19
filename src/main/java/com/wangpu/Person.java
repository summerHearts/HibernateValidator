package com.wangpu;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

/**
 * Created by Kenvin on 2017/10/15.
 */
@Data
@NoArgsConstructor

public class Person {
    @NotBlank
    @Range(min = 1,max = Integer.MAX_VALUE,message = "必须大于0",groups = {GroupA.class})
    /**用户id*/
    private Integer userId;
    @NotBlank
    @Length(min = 4,max = 20,message = "必须在[4,20]",groups = {GroupB.class})
    /**用户名*/
    private String userName;
    @NotBlank
    @Range(min = 0,max = 100,message = "年龄必须在[0,100]",groups={XMLStreamReaderFactory.Default.class})
    /**年龄*/
    private Integer age;
    @Range(min = 0,max = 2,message = "性别必须在[0,2]",groups = {GroupB.class})
    /**性别 0：未知；1：男；2：女*/
    private Integer sex;
}

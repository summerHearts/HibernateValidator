package com.wangpu;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Kenvin on 2017/10/15.
 */

/**
 * 六、常见的注解
 Bean Validation 中内置的 constraint
 @Null   被注释的元素必须为 null
 @NotNull    被注释的元素必须不为 null
 @AssertTrue     被注释的元素必须为 true
 @AssertFalse    被注释的元素必须为 false
 @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
 @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 @Past   被注释的元素必须是一个过去的日期
 @Future     被注释的元素必须是一个将来的日期
 @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
 Hibernate Validator 附加的 constraint
 @NotBlank(message =)   验证字符串非null，且长度必须大于0
 @Email  被注释的元素必须是电子邮箱地址
 @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
 @NotEmpty   被注释的字符串的必须非空
 @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
 */

@RestController
@RequestMapping("/course")
@Validated
public class DemoController {


    @Autowired
    private Validator validator;


    @RequestMapping("/demo1")
    public String demo1(@RequestBody @Valid DemoModel demo, BindingResult result){
        if(result.hasErrors()){
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return result.toString();
        }else {
            return "是否打开老师";
        }
    }


    @RequestMapping(value = "/demo3", method = RequestMethod.GET)
    public void demo3(@Range(min = 1, max = 9, message = "年级只能从1-9")@RequestParam(name = "grade", required = true) int grade,@Min(value = 1, message = "班级最小只能1")
    @Max(value = 99, message = "班级最大只能99") @RequestParam(name = "classroom", required = true) int classroom) {
        System.out.println(grade + "," + classroom);
    }

    @RequestMapping(value = "/demo2",method = RequestMethod.GET)
    public String demo3(){
        Demo2 demo2 = new Demo2();
        demo2.setAge("111");
        demo2.setHigh(150);
        demo2.setLength("ABCDE");
        demo2.setList(new ArrayList<String>(){{add("111");add("222");add("333");}});
        Set<ConstraintViolation<Demo2>> violationSet = validator.validate(demo2);
        for (ConstraintViolation<Demo2> model : violationSet) {
            System.out.println(model.getMessage());

        }
        return demo2.toString();
    }


    @RequestMapping("/demo4")
    public void demo4(){
        Demo2 demo2 = new Demo2();
        demo2.setAge("111");
        demo2.setHigh(150);
        demo2.setLength("ABCDE");
        demo2.setList(new ArrayList<String>(){{add("111");add("222");add("333");}});

        Demo3 demo3 = new Demo3();
        demo3.setExtField("23232323");
        demo2.setDemo3(demo3);
        Set<ConstraintViolation<Demo2>> violationSet = validator.validate(demo2);
        for (ConstraintViolation<Demo2> model : violationSet) {
            System.out.println(model.getMessage());
        }
    }


    @RequestMapping("/demo5")
    public void demo5(){
        Person p = new Person();
        /**GroupA验证不通过*/
//        p.setUserId(-12);
        /**GroupA验证通过*/
        p.setUserId(12);
        p.setUserName("a");
        p.setAge(110);
        p.setSex(5);
        Set<ConstraintViolation<Person>> validate = validator.validate(p, GroupA.class, GroupB.class);
        for (ConstraintViolation<Person> item : validate) {
            System.out.println(item);
        }
    }

    @RequestMapping("/demo7")
    public void demo7(){
        Person p = new Person();
        /**GroupA验证不通过*/
        //p.setUserId(-12);
        /**GroupA验证通过*/
        p.setUserId(12);
        p.setUserName("a");
        p.setAge(110);
        p.setSex(5);
        Set<ConstraintViolation<Person>> validate = validator.validate(p, GroupOrder.class);
        for (ConstraintViolation<Person> item : validate) {
            System.out.println(item);
        }
    }


    @RequestMapping("/demo8")
    public void demo8(@Validated({GroupOrder.class}) Person p, BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error);
            }
        }
    }

    @RequestMapping("/demo9")
    public void demo9(){
        Demo demo = new Demo();
        demo.setUserName("userName");
        Set<ConstraintViolation<Demo>> validate = validator.validate(demo);
        for (ConstraintViolation<Demo> dem : validate) {
            System.out.println(dem.getMessage());
        }
    }

}

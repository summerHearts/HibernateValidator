一、参数校验
 在开发中经常需要写一些字段校验的代码，比如字段非空，字段长度限制，邮箱格式验证等等，写这些与业务逻辑关系不大的代码个人感觉有两个麻烦：

验证代码繁琐，重复劳动
方法内代码显得冗长
每次要看哪些参数验证是否完整，需要去翻阅验证逻辑代码
hibernate validator（官方文档）提供了一套比较完善、便捷的验证实现方式。

spring-boot-starter-web包里面有hibernate-validator包，不需要引用hibernate validator依赖。
常见的注解
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

//大于0.01，不包含0.01
@NotNull
@DecimalMin(value = "0.01", inclusive = false)
private Integer greaterThan;

//大于等于0.01
@NotNull
@DecimalMin(value = "0.01", inclusive = true)
private BigDecimal greatOrEqualThan;

@Length(min = 1, max = 20, message = "message不能为空")
//不能将Length错用成Range
//@Range(min = 1, max = 20, message = "message不能为空")
private String message;

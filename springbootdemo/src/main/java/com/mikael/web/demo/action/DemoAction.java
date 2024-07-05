package com.mikael.web.demo.action;


import com.mikael.utils.respon.CodeEnum;
import com.mikael.utils.respon.ServiceResult;
import com.mikael.web.demo.domain.Admin;
import com.mikael.web.demo.service.methodService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoAction {


    @Resource(name = "adminServiceImpl")
    private com.mikael.web.demo.service.adminService adminService;

    @RequestMapping(value = "/selectAdmin", method = RequestMethod.GET)
    public List<Admin> selectAdmin() {
        List<Admin> map = adminService.selectAdmin();
        return map;
    }

    @RequestMapping(value = "/selectAdmin1", method = RequestMethod.GET)
    public List<Admin> selectAdmi1n(@RequestBody @Validated Admin admin) {
        List<Admin> map = adminService.selectAdmin();
        return map;
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public void errorTest() throws Exception {
        System.out.println("========");
        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
        Exception exception = new Exception("错误异常科技");
        String s = MDC.get(UUID.randomUUID().toString());
        log.error("错误码{},数据校验异常：{}，异常类型：{}", s, CodeEnum.ERROR.getCode(), exception.getMessage(), exception.getCause(), exception);

        throw new Exception();
    }

    @RequestMapping(value = "/advice01", method = RequestMethod.GET)
    public ServiceResult advice01(@RequestBody Admin admin) {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        hashMap.size();
        hashMap.put("s", "s");
        return new ServiceResult(200, "success", null);
    }

    //策略模式
    @Autowired(required = false)
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/method", method = RequestMethod.GET)
    public ServiceResult method() {
        methodService bean = applicationContext.getBean("Wx", methodService.class);
        System.out.println(bean.pay());
        return new ServiceResult(200, bean.pay(), null);
    }


    public static void main(String[] args) {
        //不实施该方案
        //初始化为123147 以后可能有年份也可能没有
        String c = "847622782405790831";
        String num = "123456";
        String year = "2024";
        String key = c.substring(c.length() - 4);
        System.out.println(key);
        BigDecimal key_bigDecimal = new BigDecimal(key);
        BigDecimal bigDecimal = new BigDecimal(num);
        String s = bigDecimal.add(key_bigDecimal).add(new BigDecimal(year)).toString();
        System.out.println(s);
        JacksonJsonParser jacksonJsonParser = new JacksonJsonParser();
        String json="{\"code\":200,\"message\":\"success\",\"traceId\":\"338267ed-b95d-4445-8aa3-124b37bc19f6\",\"data\":{\"list\":[{\"articleId\":135576948,\"title\":\"记csv、parquet数据预览一个bug的解决\",\"description\":\"工作中遇到通过sparksession解析csv、parquet文件并预览top100的需求。\",\"url\":\"https://blog.csdn.net/qq_16127313/article/details/135576948\",\"type\":1,\"top\":false,\"forcePlan\":false,\"viewCount\":1206,\"commentCount\":0,\"editUrl\":\"https://editor.csdn.net/md?articleId=135576948\",\"postTime\":\"2024-01-13 23:22:17\",\"diggCount\":20,\"formatTime\":\"2024.01.13\",\"picList\":[\"https://img-blog.csdnimg.cn/direct/02ca1a8caa824fd38996545d092792c9.jpeg\"],\"collectCount\":15},{\"articleId\":135506426,\"title\":\"基于jackson封装的json字符串与javaBean对象转换工具\",\"description\":\"带有API接口交互的web项目开发过程中，json字符串与javaBean对象之间的相互转换是比较常见的需求，基于jackson ObjectMapper 实现的工具类较好的满足了此需求。\",\"url\":\"https://blog.csdn.net/qq_16127313/article/details/135506426\",\"type\":1,\"top\":false,\"forcePlan\":false,\"viewCount\":868,\"commentCount\":0,\"editUrl\":\"https://editor.csdn.net/md?articleId=135506426\",\"postTime\":\"2024-01-10 17:48:42\",\"diggCount\":8,\"formatTime\":\"2024.01.10\",\"picList\":[\"https://img-blog.csdnimg.cn/direct/dee917c9ca45448f902b433f8210ca43.png\"],\"collectCount\":9},{\"articleId\":135481476,\"title\":\"基于Jackson封装的JSON、Properties、XML、YAML 相互转换的通用方法\",\"description\":\"我们在yaml转换成JSON、MAP、Properties通过引入实现了JSON、Properties、XML、YAML文件的相互转换，具体封装的类、方法如下：上面的实现，定义了多个类、多个方法，使用不太方便，迫切需要精简逻辑。\",\"url\":\"https://blog.csdn.net/qq_16127313/article/details/135481476\",\"type\":1,\"top\":false,\"forcePlan\":false,\"viewCount\":1692,\"commentCount\":0,\"editUrl\":\"https://editor.csdn.net/md?articleId=135481476\",\"postTime\":\"2024-01-09 17:43:30\",\"diggCount\":31,\"formatTime\":\"2024.01.09\",\"picList\":[\"https://img-blog.csdnimg.cn/direct/3f266e9d43b44592aa0e0c9417dada6f.png\"],\"collectCount\":17},{\"articleId\":135469157,\"title\":\"java解析json复杂数据的第三种思路\",\"description\":\"接上篇java解析json复杂数据的两种思路我们已经通过解析返回json字符串得到数据,现在改变思路,通过按照如下流程获取:fill:#333;color:#333;color:#333;fill:none;接口API获取JSONJSON转XMLdom4j使用XPath解析xml。\",\"url\":\"https://blog.csdn.net/qq_16127313/article/details/135469157\",\"type\":1,\"top\":false,\"forcePlan\":false,\"viewCount\":1498,\"commentCount\":0,\"editUrl\":\"https://editor.csdn.net/md?articleId=135469157\",\"postTime\":\"2024-01-09 08:34:07\",\"diggCount\":18,\"formatTime\":\"2024.01.09\",\"picList\":[\"https://img-blog.csdnimg.cn/direct/ccd618b9e5194ed9a2f5848a8f3b8734.png\"],\"collectCount\":19},{\"articleId\":135418954,\"title\":\"java解析json复杂数据的两种思路\",\"description\":\"萌新小明最近新开了CSDN博客，蠢蠢欲动，迫不及待的发表了几篇工作中积累下来的解决问题的涂鸦之作，看着访问量慢慢涨起来，心中暗暗窃喜。现在小明想每天23点记录一下每篇文章的访问量。。。\",\"url\":\"https://blog.csdn.net/qq_16127313/article/details/135418954\",\"type\":1,\"top\":false,\"forcePlan\":false,\"viewCount\":1605,\"commentCount\":0,\"editUrl\":\"https://editor.csdn.net/md?articleId=135418954\",\"postTime\":\"2024-01-06 14:11:40\",\"diggCount\":18,\"formatTime\":\"2024.01.06\",\"picList\":[\"https://img-blog.csdnimg.cn/direct/a409a0f4555c459fa05c00fd9ee0ea8c.png\"],\"collectCount\":25}],\"total\":76}}\n";
        Map<String, Object> stringObjectMap = jacksonJsonParser.parseMap(json);

        String a = "{name:hua}";

        try {
            throw new Exception("错误了！！！1");
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(HttpStatus.LOCKED.value() + "==" + HttpStatus.LOCKED.getReasonPhrase());

    }

}

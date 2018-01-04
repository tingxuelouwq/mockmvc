package com.kevin.junit;

import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JunitTest {

    /**
     * 判断字符串s中是否含有子字符串"developer"或"Works"中的一个
     */
    @Test
    public void testContainsSubString() {
        String s = "developerWorks";
        // Junit 4.4之前
        assertTrue(s.contains("developer") ||s.contains("Works"));
        // Junit 4.4之后
        assertThat(s, anyOf(containsString("developer"), containsString("Works")));
    }

    /**
     * Mathcer匹配符的联合使用
     */
    @Test
    public void testMatcher() {
        String s = "developerWorks";
        // 联合匹配符not和equalTo表示"不等于"
        assertThat(s, not(equalTo("developer")));
        // 联合匹配符not和containsString表示"不包含子字符串"
        assertThat(s, not(containsString("Works")));
        // 联合匹配符anyOf和containsString表示"包含任何一个子字符串"
        assertThat(s, anyOf(containsString("developer"), containsString("Works")));
    }

    /**
     * assertThat使用案例
     */
    @Test
    public void testAssertThat() {
        int testedNumber = 0;
        double testedDouble = 0.0;
        String testedString = "";
        Map<String, String> map = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();

        // 一般匹配符

        // allOf匹配符表示如果接下来的所有条件都成立，则测试通过，相当于&&
        assertThat(testedNumber, allOf(greaterThan(8), lessThan(16)));
        // anyOf匹配符表示如果接下来的所有条件只要有一个成立，则测试通过，相当于||
        assertThat(testedNumber, anyOf(greaterThan(16), lessThan(8)));
        // anything匹配符表示无论什么条件，永远为true
        assertThat(testedNumber, anything());
        // is匹配符表示如果待测的object等于后面给出的object，则测试通过
        assertThat(testedString, is("developerWorks"));
        // not匹配符和is匹配符正好相反，表示如果待测的object不等于后面给出的object，则测试通过
        assertThat(testedString, not("developerWorks"));

        // 字符串相关匹配符

        // containsString匹配符表示如果待测字符串包含指定字符串，则测试通过
        assertThat(testedString, containsString("developerWorks"));
        // endsWith匹配符表示如果待测字符串以指定字符串结尾，则测试通过
        assertThat(testedString, endsWith("developerWorks"));
        // startsWith匹配符表示如果待测字符串以指定字符串开始，则测试通过
        assertThat(testedString, startsWith("developerWork"));
        // equalTo匹配符表示如果待测值与指定值相等，则测试通过
        assertThat(testedString, equalTo("developerWorks"));
        // equalToIgnoringCase匹配符表示如果待测字符串与指定字符串在忽略大小写的情况下相等，则测试通过
        assertThat(testedString, equalToIgnoringCase("developerWorks"));
        // equalToIgnoringWhiteSpace匹配符表示如果待测字符串与指定字符串在忽略首尾任意个空格的情况下相等，则测试通过
        assertThat(testedString, equalToIgnoringWhiteSpace("developerWorks"));

        // 数值相关匹配符

        // closeTo匹配符表示如果待测浮点数在指定容错范围内，则测试通过
        assertThat(testedDouble, closeTo(20, 0.5));
        // greaterThan匹配符表示如果待测数值大于指定数值，则测试通过
        assertThat(testedDouble, greaterThan(16.0));
        // lessThan匹配符表示如果待测数值小于指定数值，则测试通过
        assertThat(testedDouble, lessThan(16.0));
        // greaterThanOrEqualTo匹配符表示如果待测数值大于等于指定数值，则测试通过
        assertThat(testedDouble, greaterThanOrEqualTo(16.0));
        // lessThanOrEqualTo匹配符表示如果待测数值小于等于指定数值，则测试通过
        assertThat(testedDouble, lessThanOrEqualTo(16.0));

        // collection相关匹配符
        // hasEntry匹配符表示如果待测Map对象含有指定键值对，则测试通过
        assertThat(map, hasEntry("key", "value"));
        // hasKey匹配符表示如果待测Map对象含有指定键值，则测试通过
        assertThat(map, hasKey("key"));
        // hasKey匹配符表示如果待测Map对象含有指定值，则测试通过
        assertThat(map, hasValue("value"));
        // hasItem匹配符表示如果待测Iterable对象含有指定元素，则测试通过
        assertThat(list, hasItem("item"));
    }

    /**
     * 假设机制
     */
    @Test
    public void filenameIncludeString() {
        String fileName = "";

        // 如果文件分隔符不是'/'，则不执行assertThat断言测试，直接跳过该测试用例
        assumeThat(File.separatorChar, is('/'));
        // 判断文件名是否含有字符串"developerWorks"
        assertThat(fileName, containsString("developerWorks"));
    }


}

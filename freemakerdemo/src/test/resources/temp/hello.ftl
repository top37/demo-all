package ${classPath};
<#-- 原来我是个注释 -->
public class ${className} {

    public static void main(String[] args) {
        <#if false>
        System.out.println("${helloWorld}");
        <#else>
        System.out.println("${helloWorld} 0");
        </#if>
    }

}

<#-- 与configuration.setDirectoryForTemplateLoading（path） 中的“path”有关 -->
<#include "/copyright_footer.html">
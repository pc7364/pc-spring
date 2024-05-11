package cn.pc.springframework.core.io;

import cn.hutool.core.lang.Assert;
import cn.pc.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/10 下午4:51
 */
public class ClassPathResource implements Resource{

    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path , (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path , "path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();
    }

    /**
     * 这一部分的实现是用于通过 ClassLoader 读取ClassPath 下的文件信息，具体的读取过程主要是：classLoader.getResourceAsStream(path)
     * @return
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(path);
        if (resourceAsStream == null){
            throw new FileNotFoundException(path + " not found");
        }
        return resourceAsStream;
    }
}

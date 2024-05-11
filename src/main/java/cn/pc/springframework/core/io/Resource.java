package cn.pc.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/10 下午4:52
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}

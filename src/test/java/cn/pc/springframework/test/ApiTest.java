package cn.pc.springframework.test;

import cn.pc.springframework.aop.AdvisedSupport;
import cn.pc.springframework.aop.TargetSource;
import cn.pc.springframework.aop.aspectj.AspectJExpressionPointcut;
import cn.pc.springframework.aop.framework.Cglib2AopProxy;
import cn.pc.springframework.aop.framework.JdkDynamicAopProxy;
import cn.pc.springframework.context.support.ClassPathXmlApplicationContext;
import cn.pc.springframework.test.bean.IUserService;
import cn.pc.springframework.test.bean.UserService;
import cn.pc.springframework.test.bean.UserServiceInterceptor;
import cn.pc.springframework.test.event.CustomEvent;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Desc
 * @Author pc
 * @Date 2024/5/9 17:14
 */
public class ApiTest {

    // 01-测试
//    @Test
//    public void test_BeanFactory(){
//        // 1.初始化 BeanFactory
//        BeanFactory beanFactory = new BeanFactory();
//
//        // 2.注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        // 3.获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();
//    }

//    /**
//     * test-02
//     */
//    @Test
//    public void test_BeanFactory(){
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2.注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        // 3.获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();
//
//        UserService userService2 = (UserService) beanFactory.getBean("userService");
//        userService.queryUserInfo();
//
//        System.out.println(userService == userService2);
//    }
//
//
//    /**
//     * test-03
//     */
//    @Test
//    public void test_BeanFactory03(){
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2.注入bean
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//
//        UserService userService2 = (UserService) beanFactory.getBean("userService");
//        userService2.queryUserInfo();
//
//        // 3.获取bean
//        UserService userService = (UserService) beanFactory.getBean("userService" , "pc");
//        userService.queryUserInfo();
//
//        System.out.println(userService == userService2);
//        System.out.println();
//    }
//
//
//    /**
//     * test-04
//     */
//    @Test
//    public void test_BeanFactory04(){
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2.注入bean
//        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
//        // 3 userService 设置属性
//        PropertyValues propertyValues = new PropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("uId" , "10001"));
//        propertyValues.addPropertyValue(new PropertyValue("userDao" , new BeanReference("userDao")));
//
//        BeanDefinition beanDefinition = new BeanDefinition(UserService.class , propertyValues);
//        beanFactory.registerBeanDefinition("userService", beanDefinition);
//
//        // 4.获取bean
//        UserService userService2 = (UserService) beanFactory.getBean("userService");
//        userService2.queryUserInfo();
//
//        System.out.println(userService2);
//    }


//    private DefaultResourceLoader resourceLoader;
//
//    @Before
//    public void init(){
//        resourceLoader = new DefaultResourceLoader();
//    }
//    @Test
//    public void test_classpath() throws IOException {
//        Resource resource = resourceLoader.getResource("classpath:important.properties");
//        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
//        System.out.println(content);
//    }
//
//    @Test
//    public void test_file() throws IOException {
//        Resource resource = resourceLoader.getResource("src/test/resources/important.properties");
//        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
//        System.out.println(content);
//    }
//
//    @Test
//    public void test_url() throws IOException {
//        Resource resource = resourceLoader.getResource("https://github.com/fuzhengwei/small-spring/important.properties");
//        InputStream inputStream = resource.getInputStream();
//        String content = IoUtil.readUtf8(inputStream);
//        System.out.println(content);
//    }
//
//    @Test
//    public void test_xml(){
//        // 1.初始化Bean
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        //2. 读取配置文件
//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
//        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");
//        //3. 获取getBean方法
//        UserService userService = beanFactory.getBean("userService", UserService.class);
//
//        userService.queryUserInfo();
//    }

//    @Test
//    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
//        // 1.初始化 BeanFactory
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//
//        // 2. 读取配置文件&注册Bean
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        reader.loadBeanDefinitions("classpath:spring.xml");
//
//        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
//        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
//        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
//
//        // 4. Bean实例化之后，修改 Bean 属性信息
//        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
//        beanFactory.addBeanPostProcessor(beanPostProcessor);
//
//        // 5. 获取Bean对象调用方法
//        UserService userService = beanFactory.getBean("userService", UserService.class);
//        userService.queryUserInfo();
//        System.out.println(userService);
//    }
//
//
//    @Test
//    public void testXml(){
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
//        // 2. 获取Bean对象调用方法
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        userService.queryUserInfo();
//        System.out.println(userService);
//
//    }

//    @Test
//    public void testXml(){
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        applicationContext.registerShutDownHook();
//        // 2. 获取Bean对象调用方法
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        userService.queryUserInfo();
//        System.out.println(userService);
//        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
//        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
//    }

    @Test
    public void test_prototype() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutDownHook();
        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));

    }


//    @Test
//    public void test_factory_bean() {
//        // 1.初始化 BeanFactory
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        applicationContext.registerShutDownHook();
//
//        // 2. 调用代理方法
//        UserService userService = applicationContext.getBean("userService", UserService.class);
//        System.out.println("测试结果：" + userService.queryUserInfo());
//        System.out.println("测试结果：" + userService.queryUserInfo());
//        System.out.println("测试结果：" + userService.queryUserInfo());
//        UserService userService1 = applicationContext.getBean("userService", UserService.class);
//        System.out.println(userService1 == userService);
//    }

    @Test
    public void test_event(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutDownHook();
    }


//    /**
//     * 匹配验证
//     * @throws NoSuchMethodException
//     */
//    @Test
//    public void test_aop() throws NoSuchMethodException {
//        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* cn.pc.springframework.test.bean.UserService.*(..))");
//        Class<UserService> clazz = UserService.class;
//        Method method = clazz.getDeclaredMethod("queryUserInfo");
//
//        System.out.println(pointcut.matches(clazz));
//        System.out.println(pointcut.matches(method, clazz));
//        // true、true
//    }
//
//
//    @Test
//    public void test_dynamic(){
//        // 目标对象
//        IUserService userService = new UserService();
//        // 组装代理信息
//        AdvisedSupport advisedSupport = new AdvisedSupport();
//        advisedSupport.setTargetSource(new TargetSource(userService));
//        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
//        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.pc.springframework.test.bean.IUserService.*(..))"));
//
//        // 代理对象(JdkDynamicAopProxy)
//        IUserService proxyJdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
//        System.out.println("测试结果：" + proxyJdk.queryUserInfo());
//
//        // 代理对象(Cglib2AopProxy)
//        IUserService proxyCglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
//        // 测试调用
//        System.out.println("测试结果：" + proxyCglib.register("花花"));
//    }

//    @Test
//    public void test_aop() {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
//        IUserService userService = applicationContext.getBean("userService", IUserService.class);
//        System.out.println("测试结果：" + userService.queryUserInfo());
//    }
//
//    @Test
//    public void test_scan() {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
//        IUserService userService = applicationContext.getBean("userService", IUserService.class);
//        System.out.println("测试结果：" + userService.queryUserInfo());
//    }
//
//    @Test
//    public void test_property() {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
//        IUserService userService = applicationContext.getBean("userService", IUserService.class);
//        System.out.println("测试结果：" + userService);
//    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}

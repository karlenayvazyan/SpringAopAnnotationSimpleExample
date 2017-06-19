import am.ak.AppConfig;
import am.ak.model.Pojo;
import am.ak.model.SimplePojo;
import am.ak.model.User;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;

/**
 * Created by karlen on 6/11/17.
 */
public class AopPointCatTest {

    @Test
    public void testPointcat() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        User bean = applicationContext.getBean(User.class);
        bean.setName("lak");
        bean.getName();
    }

    @Test(expected = RuntimeException.class)
    public void testPointcatAfterTuntime() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        User bean = applicationContext.getBean(User.class);
        bean.throwException();
    }

    @Test(expected = RuntimeException.class)
    public void testPointcatAfterThrowing() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        User bean = applicationContext.getBean(User.class);
        bean.throwException();
    }

    @Test
    public void testPointcatAfter() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        User bean = applicationContext.getBean(User.class);
        bean.setName("lak");
        System.out.println(bean.getName());
    }

    @Test
    public void testAopProxy() {

        ProxyFactory proxyFactory = new ProxyFactory(new SimplePojo());
        proxyFactory.addInterface(Pojo.class);
        Pojo pojo = (Pojo) proxyFactory.getProxy();

        pojo.foo();
    }

    @Test
    public void showAllFoldersInWhichDontContainGit() {
        File file = new File("/home/karlen/IdeaProjects");
        int i = 1;
        for (File projects : file.listFiles()) {
            if (projects.exists() && projects.isDirectory()) {
                System.out.println(i++ + ", " + projects.getName());
                for (File folder : projects.listFiles()) {
                    String name = folder.getName();
                    if (name.equals(".git")) {
                        System.out.print("\t");
                        System.out.println(name);
                    }
                }
            }
        }
    }
}

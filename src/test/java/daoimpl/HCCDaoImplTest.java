package daoimpl;

import config.BeanConfiguration;
import controller.MainController;
import dao.HCCDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.HCC;

import java.util.List;

public class HCCDaoImplTest {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
    HCCDao hccDao = ctx.getBean(HCCDaoImpl.class);

    @Test
    void testSetHCC() {
        HCC hcc = new HCC();
        hcc.setIndex(222);
        hcc.setCode("DemoCode");
        hcc.setDescription("DemoDescription");
        hcc.setChildren("DemoChildren");
        hcc.setRaf(0.89);
        Assertions.assertEquals(1,hccDao.setHCC(hcc));
    }

    @Test
    void getHCC() {
        HCC hcc = hccDao.getHCC(272);
        Assertions.assertEquals(String.valueOf(158), hcc.getCode());
        Assertions.assertEquals("Pressure Ulcer of Skin with Full Thickness Skin Loss", hcc.getDescription());
        Assertions.assertEquals(1.069, hcc.getRaf());
    }

    @Test
    void getAllHCC() {
        List<HCC> list = hccDao.getAllHCC();
        Assertions.assertEquals(86, list.size() );
    }

    @Test
    void deleteHCC() {
        hccDao.deleteHCC(222);
        List<HCC> list = hccDao.getAllHCC();
        Assertions.assertEquals(86, list.size() );
    }

}

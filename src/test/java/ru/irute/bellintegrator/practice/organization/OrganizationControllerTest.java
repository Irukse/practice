package ru.irute.bellintegrator.practice.organization;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.irute.bellintegrator.practice.organization.controller.OrganizationController;
import ru.irute.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;
import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;



@Transactional
@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
@AutoConfigureMockMvc
public class OrganizationControllerTest {

    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private OrganizationController organizationController;


    @Test
    public void test() {

        OrganizationDto organizationDto = new OrganizationDto();
        organizationDto.setName("Газпром'");
        organizationDto.setFullName("ООО ГазПромВладивосток");
        organizationDto.setInn(11112222);
        organizationDto.setKpp(22221111);
        organizationDto.setAddress("ул.Циолковского, д.21");
        organizationDto.setPhone("89213332113");
        organizationDto.setActive(true);
        organizationDto.setVersion(0);

        organizationController.save(organizationDto);
        Assert.assertNotNull(organizationDao);
      //  Assert.assertFalse(organizationDto.isEmpty());
     //   Assert.assertEquals(1, organizationDto.size());

        organizationController.getList(organizationDto);
    }
}

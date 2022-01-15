package ru.irute.bellintegrator.practice.office;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.irute.bellintegrator.practice.offise.controller.OfficeController;
import ru.irute.bellintegrator.practice.offise.dao.OfficeDao;
import ru.irute.bellintegrator.practice.offise.dto.OfficeDto;
import ru.irute.bellintegrator.practice.organization.controller.OrganizationController;
import ru.irute.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.irute.bellintegrator.practice.organization.dto.OrganizationDto;

@Transactional
@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
@AutoConfigureMockMvc
public class OfficeControllerTest {
    @Autowired
    private OfficeDao officeDao;
    @Autowired
    private OrganizationController organizationController;
    @Autowired
    private OfficeController officeController;

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

    //    INSERT INTO Office (id, org_id, name, address, phone, is_active, version) VALUES
        //    (1, 1, 'Main office Gazprom', 'ул.Ленина, д.6', '8-925-906-32-12', true, 0 );
        OfficeDto officeDto = new OfficeDto();
     //   officeDto.setId(1L);
        officeDto.setOrgId(1L);
        officeDto.setName("Main office Gazprom");
        officeDto.setAddress("ул.Циолковского, д.21");
        officeDto.setPhone("89213332113");
        officeDto.setActive(true);
        officeDto.setVersion(0);

        officeController.save(officeDto);
        Assert.assertNotNull(officeDao);
        //  Assert.assertFalse(organizationDto.isEmpty());
        //   Assert.assertEquals(1, organizationDto.size());


    }
}

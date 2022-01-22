package ru.irute.bellintegrator.practice.empioyee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.transaction.annotation.Transactional;
import ru.irute.bellintegrator.practice.country.entity.CountryEntity;
import ru.irute.bellintegrator.practice.docEmployee.dao.DocEmployeeDao;
import ru.irute.bellintegrator.practice.employee.dao.EmployeeDao;
import ru.irute.bellintegrator.practice.employee.dto.EmployeeDto;
import ru.irute.bellintegrator.practice.employee.entity.EmployeeEntity;
import ru.irute.bellintegrator.practice.offise.dao.OfficeDao;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;
import ru.irute.bellintegrator.practice.organization.entity.OrganizationEntity;
import ru.irute.bellintegrator.practice.typeDocument.dao.TypeDocumentDao;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
@Transactional
@DirtiesContext
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT )
@AutoConfigureMockMvc
public class EmployeeServiceImplTest {

    private EmployeeEntity user;
    private List<EmployeeEntity> users;
    private EmployeeDto userListView;
    private List<EmployeeDto> listViews;
    private OfficeEntity office;
    private CountryEntity country;
    private OrganizationEntity organization;
    private List<OfficeEntity> officeList;

    @MockBean
    private EmployeeDao userDao;

    @Autowired
    private DocEmployeeDao docDao;

    @Autowired
    private TypeDocumentDao docTypeDao;

    @Autowired
    private OfficeDao officeDao;

    @Before
    public void setUp() throws Exception {
        country = new CountryEntity("РФ", "643");

        organization = new OrganizationEntity( 1L, "Tinkoff",
                "Tinkoffbank", 771014067, 773401001,
                "Москваезд", "", true, 0);
        office = new OfficeEntity(1L, "Main office Gazprom", "ул.Ленина, д.6", "89259063212", true, 0, organization);
        officeList = new ArrayList<>();

        officeList.add(office);

        user = new EmployeeEntity(1L, "Юзер",
                "Фамилия", "Отчество",
                "1", "", true, 0, office, country);

        users = new ArrayList<>();
        users.add(user);

        userListView = new EmployeeDto();

        userListView.id = 1L;
        userListView.officeId = office.getId();
        userListView.firstName = "user";
        userListView.secondName = "sname";
        userListView.lastName = "midname";
        userListView.position = "";
        userListView.docCode = "21";
        userListView.citizenshipCode = "643";

        listViews = new ArrayList<>();
        listViews.add(userListView);
    }


    @Test()
    public void save() {
        userDao.save(user);
        Assert.assertNotNull(userDao);

    }

}
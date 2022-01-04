package ru.irute.bellintegrator.practice.employee.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import ru.irute.bellintegrator.practice.offise.entity.OfficeEntity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntityDto {
    private Long id;

}

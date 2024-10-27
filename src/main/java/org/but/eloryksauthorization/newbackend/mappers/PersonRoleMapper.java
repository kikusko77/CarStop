package org.but.eloryksauthorization.newbackend.mappers;
import org.but.eloryksauthorization.newbackend.api.PersonRoleDTO;
import org.but.eloryksauthorization.newbackend.data.entity.PersonRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonRoleMapper {

    @Mapping(source = "role.idRole", target = "idRole")
    @Mapping(source = "startedAt", target = "startedAt")
    @Mapping(source = "endedAt", target = "endedAt")
    @Mapping(source = "expirationDate", target = "expirationDate")
    PersonRoleDTO personRoleToPersonRoleDTO(PersonRole personRole);

    PersonRole personRoleDTOToPersonRole(PersonRoleDTO personRoleDTO);

    List<PersonRoleDTO> toDTOList(List<PersonRole> entities);

    List<PersonRole> toEntityList(List<PersonRoleDTO> dtos);
}

package org.but.eloryksauthorization.newbackend.mappers;

import org.but.eloryksauthorization.newbackend.api.RoleDTO;
import org.but.eloryksauthorization.newbackend.data.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleToRoleDTO(Role role);

    Role roleDTOToRole(RoleDTO roleDTO);

    void updateEntityFromDTO(RoleDTO dto, @MappingTarget Role entity);

    List<RoleDTO> toDTOList(List<Role> entities);

    List<Role> toEntityList(List<RoleDTO> dtos);

}
